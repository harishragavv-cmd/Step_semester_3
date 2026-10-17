package week_8.class_problems;

public abstract class Vehicle {
    private final String vehicleId;
    private Rental activeRental;

    protected Vehicle(String vehicleId) {
        if (vehicleId == null || vehicleId.trim().isEmpty()) {
            throw new IllegalArgumentException("Vehicle ID cannot be blank");
        }
        this.vehicleId = vehicleId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public boolean isAvailable() {
        return activeRental == null;
    }

    public abstract double calculateRentalCharge(int days);

    public final Rental rent(RentalCustomer customer, int days) {
        if (customer == null || days <= 0 || !isAvailable()) {
            return null;
        }
        activeRental = new Rental(this, customer, days);
        return activeRental;
    }

    final boolean releaseRental(Rental rental) {
        if (activeRental != rental) {
            return false;
        }
        activeRental = null;
        return true;
    }

    public abstract String getCategory();
}