\# Employee Access Eligibility System



\## Project Description



The Employee Access Eligibility System is a Java-based Maven application that determines whether employees are eligible to access organizational resources.



The system stores employee details such as:



\* Employee ID

\* Name

\* Age

\* Department

\* Employment Type

\* Security Clearance Level

\* Employee ID Validity



\## Eligibility Rules



An employee must:



1\. Be at least 21 years old.

2\. Belong to an authorized department:



&#x20;  \* IT

&#x20;  \* HR

&#x20;  \* Finance

&#x20;  \* Administration

3\. Have active employment status.

4\. Have a valid employee ID.

5\. Have sufficient security clearance for the requested access level.



\## Eligibility Classification



\### Eligible



The employee satisfies all eligibility requirements and has sufficient security clearance.



\### Conditionally Eligible



The employee satisfies the basic eligibility requirements but does not have sufficient security clearance for the requested access level.



\### Not Eligible



The employee fails one or more basic eligibility requirements.



The system displays all applicable rejection reasons instead of stopping after the first failure.



\## Exception Handling



The application validates:



\* Employee ID

\* Employee name

\* Age

\* Department

\* Employment type

\* Security clearance level

\* Requested access level

\* Number of employees



Invalid input is handled using appropriate exceptions.



\## Testing



JUnit test cases cover:



\* Normal scenarios

\* Boundary conditions

\* Unauthorized departments

\* Inactive employees

\* Invalid employee IDs

\* Conditional eligibility

\* Security clearance boundaries

\* Multiple failure scenarios

\* Invalid age

\* Invalid security clearance

\* Invalid requested access level

\* Null employee input



\## Technologies Used



\* Java 25

\* Apache Maven

\* JUnit 4.13.2

\* Git

\* GitHub



\## Maven Project Structure



&#x20;  text

EmployeeAccessEligibility/

│

├── pom.xml

├── README.md

│

└── src/

&#x20;   ├── main/

&#x20;   │   └── java/

&#x20;   │       ├── Employee.java

&#x20;   │       ├── EmployeeAccessService.java

&#x20;   │       └── Main.java

&#x20;   │

&#x20;   └── test/

&#x20;       └── java/

&#x20;           └── EmployeeAccessServiceTest.java





\## How to Run



Compile the project:



mvn compile



Run the tests:



mvn test



Run the application:



mvn exec:java -Dexec.mainClass="Main"



