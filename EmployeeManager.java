import java.io.*;
import java.util.ArrayList;
import java.util.List;

class EmployeeManager implements EmployeeOperations {
    private List<Employee> employeeList;
    private final String FILE_NAME = "employees.data";

    public EmployeeManager() {
        employeeList = new ArrayList<>();
        loadFromFile();
    }

    @Override
    public void addEmployee(Employee emp) {
        employeeList.add(emp);
        System.out.println("✅ Employee added successfully!");
        saveToFile();
    }

    @Override
    public void updateEmployee(int id, String name, String department, double salary) {
        Employee emp = searchById(id);
        if (emp != null) {
            emp.setName(name);
            emp.setDepartment(department);
            emp.setSalary(salary);
            System.out.println("✅ Employee updated successfully!");
            saveToFile();
        } else {
            System.out.println("⚠️ Employee not found.");
        }
    }

    @Override
    public void deleteEmployee(int id) {
        Employee emp = searchById(id);
        if (emp != null) {
            employeeList.remove(emp);
            System.out.println("✅ Employee deleted successfully!");
            saveToFile();
        } else {
            System.out.println("⚠️ Employee not found.");
        }
    }

    @Override
    public Employee searchById(int id) {
        for (Employee emp : employeeList) {
            if (emp.getId() == id)
                return emp;
        }
        return null;
    }

    @Override
    public List<Employee> searchByName(String name) {
        List<Employee> result = new ArrayList<>();
        for (Employee emp : employeeList) {
            if (emp.getName().equalsIgnoreCase(name))
                result.add(emp);
        }
        return result;
    }

    @Override
    public void displayAll() {
        if (employeeList.isEmpty()) {
            System.out.println("⚠️ No employees found.");
            return;
        }
        System.out.println("\n📋 Employee List:");
        for (Employee emp : employeeList)
            System.out.println(emp);
    }

    @Override
    public void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employeeList);
        } catch (IOException e) {
            System.out.println("❌ Error saving data: " + e.getMessage());
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            employeeList = (List<Employee>) ois.readObject();
        } catch (Exception e) {
            System.out.println("⚠️ Error loading data: " + e.getMessage());
        }
    }
}
