package week_10.class_problems;

public class ECarPass extends CampusVehicle implements Chargeable {
    public ECarPass(String passNumber, String ownerName) { super(passNumber, ownerName); }
    @Override public String getType() { return "ECar"; }
    @Override public int getYearlyPassFee() { return 1000; }
    @Override public String bookChargingBay() {
        return getPassNumber() + " charging bay allotted";
    }
}