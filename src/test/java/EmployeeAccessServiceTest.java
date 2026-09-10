import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeAccessServiceTest {


private final EmployeeAccessService service =
        new EmployeeAccessService();

// 1. Normal scenario - Eligible employee
@Test
public void testEligibleEmployee() {

    Employee employee = new Employee(
            "EMP001",
            "Ravi",
            25,
            "IT",
            "Active",
            4,
            true
    );

    String result = service.checkEligibility(employee, 3);

    assertEquals("Eligible", result);
}

// 2. Boundary scenario - Age exactly 21
@Test
public void testMinimumAgeBoundary() {

    Employee employee = new Employee(
            "EMP002",
            "Priya",
            21,
            "HR",
            "Active",
            3,
            true
    );

    String result = service.checkEligibility(employee, 2);

    assertEquals("Eligible", result);
}

// 3. Boundary scenario - Age below 21
@Test
public void testBelowMinimumAge() {

    Employee employee = new Employee(
            "EMP003",
            "Arun",
            20,
            "Finance",
            "Active",
            3,
            true
    );

    String result = service.checkEligibility(employee, 2);

    assertTrue(result.startsWith("Not Eligible"));
    assertTrue(result.contains("at least 21"));
}

// 4. Unauthorized department
@Test
public void testUnauthorizedDepartment() {

    Employee employee = new Employee(
            "EMP004",
            "Kiran",
            30,
            "Sales",
            "Active",
            4,
            true
    );

    String result = service.checkEligibility(employee, 3);

    assertTrue(result.startsWith("Not Eligible"));
    assertTrue(result.contains("department is not authorized"));
}

// 5. Inactive employee
@Test
public void testInactiveEmployee() {

    Employee employee = new Employee(
            "EMP005",
            "Meena",
            28,
            "IT",
            "Inactive",
            4,
            true
    );

    String result = service.checkEligibility(employee, 3);

    assertTrue(result.startsWith("Not Eligible"));
    assertTrue(result.contains("active employment"));
}

// 6. Invalid employee ID
@Test
public void testInvalidEmployeeId() {

    Employee employee = new Employee(
            "EMP006",
            "Vijay",
            28,
            "Finance",
            "Active",
            4,
            false
    );

    String result = service.checkEligibility(employee, 3);

    assertTrue(result.startsWith("Not Eligible"));
    assertTrue(result.contains("Employee ID is invalid"));
}

// 7. Conditional eligibility due to low security clearance
@Test
public void testConditionalEligibility() {

    Employee employee = new Employee(
            "EMP007",
            "Anitha",
            30,
            "IT",
            "Active",
            2,
            true
    );

    String result = service.checkEligibility(employee, 4);

    assertTrue(result.startsWith("Conditionally Eligible"));
    assertTrue(result.contains("Security clearance"));
}

// 8. Exact security clearance boundary
@Test
public void testSecurityClearanceBoundary() {

    Employee employee = new Employee(
            "EMP008",
            "Suresh",
            35,
            "Administration",
            "Active",
            3,
            true
    );

    String result = service.checkEligibility(employee, 3);

    assertEquals("Eligible", result);
}

// 9. Multiple failure scenario
@Test
public void testMultipleFailures() {

    Employee employee = new Employee(
            "EMP009",
            "Rahul",
            19,
            "Sales",
            "Inactive",
            2,
            false
    );

    String result = service.checkEligibility(employee, 4);

    assertTrue(result.startsWith("Not Eligible"));

    // Check that ALL applicable reasons are displayed
    assertTrue(result.contains("at least 21"));
    assertTrue(result.contains("department is not authorized"));
    assertTrue(result.contains("active employment"));
    assertTrue(result.contains("Employee ID is invalid"));
}

// 10. Invalid age input
@Test(expected = IllegalArgumentException.class)
public void testNegativeAge() {

    Employee employee = new Employee(
            "EMP010",
            "Kavya",
            -5,
            "IT",
            "Active",
            3,
            true
    );

    service.checkEligibility(employee, 2);
}

// 11. Invalid security clearance
@Test(expected = IllegalArgumentException.class)
public void testInvalidSecurityClearance() {

    Employee employee = new Employee(
            "EMP011",
            "Manoj",
            30,
            "IT",
            "Active",
            6,
            true
    );

    service.checkEligibility(employee, 3);
}

// 12. Invalid requested access level
@Test(expected = IllegalArgumentException.class)
public void testInvalidRequestedAccessLevel() {

    Employee employee = new Employee(
            "EMP012",
            "Divya",
            30,
            "HR",
            "Active",
            3,
            true
    );

    service.checkEligibility(employee, 6);
}

// 13. Null employee validation
@Test(expected = IllegalArgumentException.class)
public void testNullEmployee() {

    service.checkEligibility(null, 3);
}


}
