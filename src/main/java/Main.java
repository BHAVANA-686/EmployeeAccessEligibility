import java.util.Scanner;

public class Main {


public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    EmployeeAccessService service = new EmployeeAccessService();

    try {
        System.out.print("Enter number of employees: ");
        int numberOfEmployees = Integer.parseInt(scanner.nextLine());

        if (numberOfEmployees <= 0) {
            throw new IllegalArgumentException(
                "Number of employees must be greater than 0"
            );
        }

        for (int i = 1; i <= numberOfEmployees; i++) {

            System.out.println("\n========== Employee " + i + " ==========");

            System.out.print("Enter Employee ID: ");
            String employeeId = scanner.nextLine();

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Age: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Department: ");
            String department = scanner.nextLine();

            System.out.print("Enter Employment Type (Active/Inactive): ");
            String employmentType = scanner.nextLine();

            System.out.print("Enter Security Clearance Level (1-5): ");
            int clearanceLevel = Integer.parseInt(scanner.nextLine());

            System.out.print("Is Employee ID Valid? (true/false): ");
            boolean idValid = Boolean.parseBoolean(scanner.nextLine());

            System.out.print("Enter Requested Access Level (1-5): ");
            int requestedAccessLevel = Integer.parseInt(scanner.nextLine());

            Employee employee = new Employee(
                employeeId,
                name,
                age,
                department,
                employmentType,
                clearanceLevel,
                idValid
            );

            String result = service.checkEligibility(
                employee,
                requestedAccessLevel
            );

            System.out.println("\n----- Result -----");
            System.out.println("Employee: " + name);
            System.out.println("Status: " + result);
        }

    } catch (NumberFormatException e) {

        System.out.println(
            "\nInvalid input: Please enter numbers in the correct format."
        );

    } catch (IllegalArgumentException e) {

        System.out.println(
            "\nInput validation error: " + e.getMessage()
        );

    } finally {

        scanner.close();
    }
}


}
