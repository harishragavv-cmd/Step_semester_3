package week_6.assignment_problems;

public class EliteMember extends PremiumMember {
    private final String lockerNumber;

    public EliteMember(String memberId, int monthlyFee,
                       String trainerName, String lockerNumber) {
        super(memberId, monthlyFee, trainerName);
        if (lockerNumber == null || lockerNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("lockerNumber cannot be blank");
        }
        this.lockerNumber = lockerNumber;
    }

    public String getLockerNumber() {
        return lockerNumber;
    }

    @Override
    public String displayInfo() {
        return "Elite Member | Trainer: " + getTrainerName()
                + " | Locker: " + lockerNumber
                + " | Sessions: " + getSessionsAttended();
    }
}