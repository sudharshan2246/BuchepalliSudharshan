import java.util.*;

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();
        Scanner sc = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {
            System.out.println("\n=== EMPLOYEE MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Search by ID");
            System.out.println("5. Search by Name");
            System.out.println("6. Display All Employees");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Department: ");
                String dept = sc.nextLine();
                System.out.print("Enter Salary: ");
                double salary = sc.nextDouble();
                manager.addEmployee(new Employee(id, name, dept, salary));
            }
            else if (choice == 2) {
                System.out.print("Enter Employee ID to Update: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter New Name: ");
                String name = sc.nextLine();
                System.out.print("Enter New Department: ");
                String dept = sc.nextLine();
                System.out.print("Enter New Salary: ");
                double salary = sc.nextDouble();
                manager.updateEmployee(id, name, dept, salary);
            }
            else if (choice == 3) {
                System.out.print("Enter Employee ID to Delete: ");
                int id = sc.nextInt();
                manager.deleteEmployee(id);
            }
            else if (choice == 4) {
                System.out.print("Enter Employee ID to Search: ");
                int id = sc.nextInt();
                Employee emp = manager.searchById(id);
                if (emp != null)
                    System.out.println(emp);
                else
                    System.out.println("⚠️ Employee not found.");
            }
            else if (choice == 5) {
                System.out.print("Enter Name to Search: ");
                String name = sc.nextLine();
                List<Employee> result = manager.searchByName(name);
                if (result.isEmpty())
                    System.out.println("⚠️ No employees found with that name.");
                else
                    result.forEach(System.out::println);
            }
            else if (choice == 6) {
                manager.displayAll();
            }
            else if (choice == 0) {
                System.out.println("👋 Exiting program. Goodbye!");
            }
            else {
                System.out.println("❌ Invalid choice. Try again.");
            }
        }
        sc.close();
    }
}
