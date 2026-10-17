package week_10.class_problems;

public class PartTimeStaff extends Staff {
    private final double hours;
    private final double hourlyRate;

    public PartTimeStaff(String name, double hours, double hourlyRate) {
        super(name);
        if (hours < 0 || hourlyRate < 0) {
            throw new IllegalArgumentException("Hours and hourly rate cannot be negative");
        }
        this.hours = hours;
        this.hourlyRate = hourlyRate;
    }

    @Override public String getType() { return "PartTime"; }
    @Override public double calculatePay() { return hours * hourlyRate; }
}