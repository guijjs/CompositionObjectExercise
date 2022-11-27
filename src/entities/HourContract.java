package entities;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class HourContract{
  private LocalDate data;
  private Double valuePerHour;
  private Integer hours;
  public HourContract(String data, Double valuePerHour, Integer hours){
    this.data = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    this.valuePerHour = valuePerHour;
    this.hours = hours;
  };
  public LocalDate getData(){
    return this.data;
  }
  public Double valuePerHour(){
    return this.valuePerHour;
  }
  public Integer hours(){
    return this.hours;
  }

  public Double totalValue(){
    return hours*valuePerHour;
  }
}
