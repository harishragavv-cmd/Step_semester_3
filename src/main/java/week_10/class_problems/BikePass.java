package week_10.class_problems;

public class BikePass extends CampusVehicle {
    public BikePass(String passNumber, String ownerName) { super(passNumber, ownerName); }
    @Override public String getType() { return "Bike"; }
    @Override public int getYearlyPassFee() { return 300; }
}