package week_10.class_problems;

public class CarPass extends CampusVehicle {
    public CarPass(String passNumber, String ownerName) { super(passNumber, ownerName); }
    @Override public String getType() { return "Car"; }
    @Override public int getYearlyPassFee() { return 1000; }
}