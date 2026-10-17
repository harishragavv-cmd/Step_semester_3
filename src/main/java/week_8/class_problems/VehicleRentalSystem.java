package week_8.class_problems;

public class VehicleRentalSystem {
    public static void main(String[] args) {
        RentalCustomer customer1 = new RentalCustomer("Customer 1");
        RentalCustomer customer2 = new RentalCustomer("Customer 2");
        RentalCustomer customer3 = new RentalCustomer("Customer 3");

        Vehicle sedanA = new Sedan("Sedan A");
        Vehicle suvB = new SUV("SUV B");

        Rental firstRental = sedanA.rent(customer1, 3);
        if (firstRental != null) {
            System.out.println(sedanA.getVehicleId() + " rented successfully by "
                    + customer1.getName() + ". Rental charge: " + firstRental.formattedCharge() + ".");
        }

        Rental secondRental = sedanA.rent(customer2, 2);
        if (secondRental == null) {
            System.out.println(sedanA.getVehicleId() + " is currently unavailable.");
        }

        System.out.println(firstRental.returnVehicle(customer1));

        Rental suvRental = suvB.rent(customer3, 5);
        if (suvRental != null) {
            System.out.println(suvB.getVehicleId() + " rented successfully by "
                    + customer3.getName() + ". Rental charge: " + suvRental.formattedCharge() + ".");
        }
    }
}