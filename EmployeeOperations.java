import java.util.List;

interface EmployeeOperations {
    void addEmployee(Employee emp);
    void updateEmployee(int id, String name, String department, double salary);
    void deleteEmployee(int id);
    Employee searchById(int id);
    List<Employee> searchByName(String name);
    void displayAll();
    void saveToFile();
    void loadFromFile();
}