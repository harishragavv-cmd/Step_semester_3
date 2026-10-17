package week_8.class_problems;

import java.util.Locale;

public class Rental {
    private final Vehicle vehicle;
    private final RentalCustomer customer;
    private final int days;
    private final double charge;
    private boolean returned;

    Rental(Vehicle vehicle, RentalCustomer customer, int days) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.days = days;
        this.charge = vehicle.calculateRentalCharge(days);
    }

    public Vehicle getVehicle() { return vehicle; }
    public RentalCustomer getCustomer() { return customer; }
    public int getDays() { return days; }
    public double getCharge() { return charge; }
    public boolean isActive() { return !returned; }

    public String formattedCharge() {
        return String.format(Locale.US, "$%.2f", charge);
    }

    public String returnVehicle(RentalCustomer requester) {
        if (requester != customer) {
            return "Return denied: this rental belongs to " + customer.getName() + ".";
        }
        if (returned || !vehicle.releaseRental(this)) {
            return vehicle.getVehicleId() + " has no active rental for this customer.";
        }
        returned = true;
        return vehicle.getVehicleId() + " returned by " + customer.getName() + ".";
    }
}