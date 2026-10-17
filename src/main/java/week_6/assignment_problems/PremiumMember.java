package week_6.assignment_problems;

public class PremiumMember extends GymMember {
    private final String trainerName;

    public PremiumMember(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        if (trainerName == null || trainerName.trim().isEmpty()) {
            throw new IllegalArgumentException("trainerName cannot be blank");
        }
        this.trainerName = trainerName;
    }

    // Additional constructor for uses that only need a monthly fee and trainer.
    public PremiumMember(int monthlyFee, String trainerName) {
        super(monthlyFee);
        if (trainerName == null || trainerName.trim().isEmpty()) {
            throw new IllegalArgumentException("trainerName cannot be blank");
        }
        this.trainerName = trainerName;
    }

    public String getTrainerName() {
        return trainerName;
    }

    @Override
    protected void chargeLateFee(int amount) {
        super.chargeLateFee(amount / 2);
    }

    @Override
    public String displayInfo() {
        return "Premium Member | Trainer: " + trainerName
                + " | Sessions: " + getSessionsAttended();
    }
}