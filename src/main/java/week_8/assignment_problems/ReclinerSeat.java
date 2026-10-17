package week_8.assignment_problems;

public class ReclinerSeat extends Seat {
    public ReclinerSeat(String seatId) {
        super(seatId);
    }

    @Override
    public double getPrice() {
        return 400.0;
    }

    @Override
    public String getCategory() {
        return "Recliner";
    }
}