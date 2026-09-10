import java.util.ArrayList;
import java.util.List;

public class EmployeeAccessService {


private static final String[] AUTHORIZED_DEPARTMENTS = {
    "IT", "HR", "Finance", "Administration"
};

public String checkEligibility(Employee employee, int requestedAccessLevel) {

    validateInput(employee, requestedAccessLevel);

    List<String> reasons = new ArrayList<>();

    // Rule 1: Age
    if (employee.getAge() < 21) {
        reasons.add("Employee must be at least 21 years old");
    }

    // Rule 2: Authorized department
    if (!isAuthorizedDepartment(employee.getDepartment())) {
        reasons.add("Employee department is not authorized");
    }

    // Rule 3: Active employment
    if (!employee.getEmploymentType().equalsIgnoreCase("Active")) {
        reasons.add("Employee does not have active employment status");
    }

    // Rule 4: Valid employee ID
    if (!employee.isIdValid()) {
        reasons.add("Employee ID is invalid");
    }

    // Basic eligibility failures
    if (!reasons.isEmpty()) {
        return "Not Eligible: " + String.join("; ", reasons);
    }

    // Rule 5: Security clearance
    if (requestedAccessLevel > employee.getSecurityClearanceLevel()) {
        return "Conditionally Eligible: Security clearance is insufficient for the requested access level";
    }

    return "Eligible";
}

private boolean isAuthorizedDepartment(String department) {

    for (String authorizedDepartment : AUTHORIZED_DEPARTMENTS) {
        if (authorizedDepartment.equalsIgnoreCase(department)) {
            return true;
        }
    }

    return false;
}

private void validateInput(Employee employee, int requestedAccessLevel) {

    if (employee == null) {
        throw new IllegalArgumentException("Employee details cannot be null");
    }

    if (employee.getEmployeeId() == null ||
        employee.getEmployeeId().trim().isEmpty()) {
        throw new IllegalArgumentException("Employee ID cannot be empty");
    }

    if (employee.getName() == null ||
        employee.getName().trim().isEmpty()) {
        throw new IllegalArgumentException("Employee name cannot be empty");
    }

    if (employee.getAge() < 0) {
        throw new IllegalArgumentException("Age cannot be negative");
    }

    if (employee.getDepartment() == null ||
        employee.getDepartment().trim().isEmpty()) {
        throw new IllegalArgumentException("Department cannot be empty");
    }

    if (employee.getEmploymentType() == null ||
        employee.getEmploymentType().trim().isEmpty()) {
        throw new IllegalArgumentException("Employment type cannot be empty");
    }

    if (employee.getSecurityClearanceLevel() < 1 ||
        employee.getSecurityClearanceLevel() > 5) {
        throw new IllegalArgumentException(
            "Security clearance level must be between 1 and 5"
        );
    }

    if (requestedAccessLevel < 1 || requestedAccessLevel > 5) {
        throw new IllegalArgumentException(
            "Requested access level must be between 1 and 5"
        );
    }
}


}
