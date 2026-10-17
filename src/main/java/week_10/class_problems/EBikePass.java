package week_10.class_problems;

public class EBikePass extends CampusVehicle implements Chargeable {
    public EBikePass(String passNumber, String ownerName) { super(passNumber, ownerName); }
    @Override public String getType() { return "E-Bike"; }
    @Override public int getYearlyPassFee() { return 300; }
    @Override public String bookChargingBay() {
        return getPassNumber() + " charging bay allotted";
    }
}