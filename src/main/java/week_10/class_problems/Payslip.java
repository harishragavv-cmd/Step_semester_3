package week_10.class_problems;

public class Payslip {
    private final String name;
    private final String type;
    private final double pay;

    public Payslip(Staff staff) {
        if (staff == null) throw new IllegalArgumentException("Staff member is required");
        this.name = staff.getName();
        this.type = staff.getType();
        this.pay = staff.calculatePay();
    }

    public String getName() { return name; }
    public String getType() { return type; }
    public double getPay() { return pay; }

    @Override
    public String toString() {
        if (pay == Math.rint(pay)) {
            return "Payslip[name=" + name + ", type=" + type + ", pay="
                    + String.format("%.0f", pay) + "]";
        }
        return "Payslip[name=" + name + ", type=" + type + ", pay="
                + String.format("%.2f", pay) + "]";
    }
}