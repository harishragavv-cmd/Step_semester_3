package week_8.assignment_problems;

public class PremiumSeat extends Seat {
    public PremiumSeat(String seatId) {
        super(seatId);
    }

    @Override
    public double getPrice() {
        return 250.0;
    }

    @Override
    public String getCategory() {
        return "Premium";
    }
}