package week_1.assigment_problems;

class Employee {
    private String employeeId;
    private double salary;

    public Employee(String employeeId, double salary) {
        this.employeeId = employeeId;
        this.salary = salary;
    }

    public void raiseSalary(double salary) {
        this.salary = this.salary + salary;
    }

    public void printSalary() {
        System.out.println(employeeId + " | Final Salary: Rs " + salary);
    }
}

public class M2_PayrollBatchBonusRound {
    public static void main(String[] args) {
        Employee[] employees = {
            new Employee("E-101", 40000),
            new Employee("E-102", 55000),
            new Employee("E-103", 62000),
            new Employee("E-104", 48000)
        };

        for (int i = 0; i < employees.length; i++) {
            employees[i].raiseSalary(5000);
            employees[i].printSalary();
        }
    }
}