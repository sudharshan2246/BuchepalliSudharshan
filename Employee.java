import java.io.Serializable;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    public void setName(String name) { this.name = name; }
    public void setDepartment(String department) { this.department = department; }
    public void setSalary(double salary) { this.salary = salary; }

    @Override
    public String toString() {
        return String.format("ID: %d | Name: %s | Dept: %s | Salary: %.2f", id, name, department, salary);
    }
}