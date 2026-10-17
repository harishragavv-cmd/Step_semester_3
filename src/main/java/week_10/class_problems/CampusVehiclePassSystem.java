package week_10.class_problems;

import java.util.HashMap;
import java.util.Map;

public class CampusVehiclePassSystem {
    private final Map<String, CampusVehicle> vehicles = new HashMap<>();

    public void register(CampusVehicle vehicle) {
        if (vehicle == null) throw new IllegalArgumentException("Vehicle is required");
        vehicles.put(vehicle.getPassNumber(), vehicle);
        System.out.println(vehicle.getPassNumber() + " (" + vehicle.getType()
                + ") pass fee " + vehicle.getYearlyPassFee());
    }

    public void charge(String passNumber) {
        CampusVehicle vehicle = vehicles.get(passNumber);
        if (vehicle instanceof Chargeable) {
            System.out.println(((Chargeable) vehicle).bookChargingBay());
        } else if (vehicle == null) {
            System.out.println(passNumber + " rejected: vehicle not found");
        } else {
            System.out.println(passNumber + " rejected: charging unsupported");
        }
    }

    public static void main(String[] args) {
        CampusVehiclePassSystem system = new CampusVehiclePassSystem();
        system.register(new BikePass("KA01", "Asha"));
        system.register(new ECarPass("KA02", "Ravi"));
        system.charge("KA02");
        system.charge("KA01");
    }
}