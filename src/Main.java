import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;
import java.util.Scanner;
import java.util.Locale;
import java.util.Arrays;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Main{
  public static void main(String[] args){
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    
    System.out.print("POR FAVOR, DIGITE O DEPARTAMENTO DO EMPREGADO: ");
    Department departamento = new Department(sc.nextLine());
    
    System.out.println("AGORA, VAMOS INCLUIR OS DADOS DO TRABALHADOR...");
    System.out.print("NOME DO TRABALHADOR: ");
    String nome = sc.nextLine();
    System.out.println("A SEGUIR TEMOS AS SEGUINTES SENIORIDADES, ESCOLHA UMA PARA O TRABALHADOR.");
    for(WorkerLevel level : WorkerLevel.values()){
      System.out.println(level);
    }
    System.out.print("DIGITE A SENIORIDADE DO TRABALHADOR: ");
    String levelTrabalhador = sc.nextLine().toUpperCase();
    while(Arrays.asList(WorkerLevel.values()).toString().contains(levelTrabalhador) != true){
      System.out.print("DIGITE UMA SENIORIDADE CORRETA: ");
      levelTrabalhador = sc.nextLine().toUpperCase();
    };
    System.out.print("POR FAVOR, DIGITE O SALÁRIO BASE DO TRABALHADOR: ");
    Double baseSalary = sc.nextDouble();

    System.out.print("QUANTOS CONTRATOS QUE ESSSE TRABALHADOR POSSUI: ");
    Integer numContracts = sc.nextInt();

    Worker trabalhador = new Worker(nome, levelTrabalhador, baseSalary, departamento);
    sc.nextLine();
    for(int i = 0; i<numContracts; i++){
      String data;
      Double valuePerHour;
      Integer hours;
      System.out.print("DIGITE UMA DATA NO: dd/MM/aaaa: ");
      data = sc.nextLine();
      System.out.print("DIGITE O VALOR DA SUA HORA: ");
      valuePerHour = sc.nextDouble();
      System.out.print("DIGITE QUANTAS HORAS FORAM TRABALHADAS: ");
      hours = sc.nextInt();
      sc.nextLine();
      trabalhador.addContract(new HourContract(data, valuePerHour, hours));
    };
    System.out.print("ENTRE COM O MÊS E ANO(MM/yyyy) QUE QUEIRA VER OS RENDIMENTOS: ");
    String dataIncome = "01/"+sc.nextLine();
    Integer ano = LocalDate.parse(dataIncome, DateTimeFormatter.ofPattern("dd/MM/yyyy")).getYear();
    Integer mes = LocalDate.parse(dataIncome, DateTimeFormatter.ofPattern("dd/MM/yyyy")).getMonthValue();
  
    System.out.printf("\nNOME: %s", nome);
    System.out.printf("\nDERPARTAMENTO: %s", departamento.getDepartamento());
    System.out.printf("\nCOM BASE NO ANO/MÊS: %d/%d. SEU RENDIMENTO FOI: R$%.2f\n", mes, ano, trabalhador.income(ano, mes));

    sc.close();
  }
}
