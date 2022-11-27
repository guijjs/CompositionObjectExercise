package entities;
import entities.Department;
import entities.HourContract;
import entities.enums.WorkerLevel;
import java.util.List;
import java.util.ArrayList;
public class Worker{
  private String name;
  private WorkerLevel level;
  private Double baseSalary;

  private Department department;
  private List <HourContract> contracts = new ArrayList<>();
  public Worker(String name, String levelTrabalhador, Double baseSalary, Department department){
    this.name = name;
    this.level = level;
    this.baseSalary = baseSalary;
  };
  public Worker(String name, Double baseSalary, Department department){
    this.name = name;
    this.baseSalary = baseSalary;
  };
  
  public void addContract(HourContract contract){
    this.contracts.add(contract);
  };
  public void removeContract(HourContract contract){
    this.contracts.remove(contract);
  }

  public Double income(Integer year, Integer month){
    Double salarySum = baseSalary;
    for(HourContract conc : contracts){
      if(conc.getData().getMonthValue() == month && conc.getData().getYear() == year){
        salarySum += conc.totalValue();
      };
    };

    return salarySum;
  }

}
