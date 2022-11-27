package entities;
public class Department{
  private String departamento;
  public Department(){};
  public Department(String departamento){
    this.departamento = departamento;
  };
  public String getDepartamento(){
    return this.departamento;
  }
  public void setDepartamento(String departamento){
    this.departamento = departamento;
  }
}
