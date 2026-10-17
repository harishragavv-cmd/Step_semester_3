package week_10.class_problems;

public class PayrollRegisterSystem {
    public static void main(String[] args) {
        Staff[] staff = {
                new FullTimeStaff("Asha", 50000),
                new PartTimeStaff("Ravi", 80, 300),
                new InternStaff("Neha", 15000)
        };

        Payslip[] payslips = new Payslip[staff.length];
        double total = 0;
        int topEarnerIndex = 0;

        for (int i = 0; i < staff.length; i++) {
            payslips[i] = new Payslip(staff[i]);
            System.out.println(payslips[i]);
            total += payslips[i].getPay();

            if (payslips[i].getPay() > payslips[topEarnerIndex].getPay()) {
                topEarnerIndex = i;
            }
        }

        if (total == Math.rint(total)) {
            System.out.println("Total " + String.format("%.0f", total));
        } else {
            System.out.println("Total " + String.format("%.2f", total));
        }
        System.out.println("top earner " + payslips[topEarnerIndex].getName());
    }
}