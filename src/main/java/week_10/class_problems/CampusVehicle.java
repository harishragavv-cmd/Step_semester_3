package week_10.class_problems;

public abstract class CampusVehicle {
    private final String passNumber;
    private final String ownerName;

    protected CampusVehicle(String passNumber, String ownerName) {
        if (passNumber == null || passNumber.trim().isEmpty()
                || ownerName == null || ownerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Pass number and owner name are required");
        }
        this.passNumber = passNumber;
        this.ownerName = ownerName;
    }

    public String getPassNumber() { return passNumber; }
    public String getOwnerName() { return ownerName; }
    public abstract String getType();
    public abstract int getYearlyPassFee();
}