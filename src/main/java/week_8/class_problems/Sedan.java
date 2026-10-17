package week_8.class_problems;

public class Sedan extends Vehicle {
    private static final double DAILY_RATE = 50.0;

    public Sedan(String vehicleId) {
        super(vehicleId);
    }

    @Override
    public double calculateRentalCharge(int days) {
        if (days <= 0) throw new IllegalArgumentException("Days must be positive");
        return DAILY_RATE * days;
    }

    @Override
    public String getCategory() { return "Sedan"; }
}