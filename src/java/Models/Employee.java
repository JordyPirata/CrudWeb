package Models;

public class Employee {
    private int employeeId;
    private int assingmentId;
    private String name;
    private String nomina;
    public Employee(){

    }
    public Employee(int EmployeeId, int AssingmentId, String Name, String Nomina){
        this.employeeId = EmployeeId;
        this.assingmentId = AssingmentId;
        this.name = Name;
        this.nomina = Nomina;
    }
    public void setEmployeeId(int employeeId) {this.employeeId = employeeId;}
    public int getEmployeeId() {return employeeId;}
    public void setAssingmentId(int assingmentId) {this.assingmentId = assingmentId;}
    public int getAssingmentId() {return assingmentId;}
    public void setName(String name) {this.name = name;}
    public String getName() {return name;}
    public void setNomina(String nomina) {this.nomina = nomina;}
    public String getNomina() {return nomina;}
}