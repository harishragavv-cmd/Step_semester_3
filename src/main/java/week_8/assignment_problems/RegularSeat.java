package week_8.assignment_problems;

public class RegularSeat extends Seat {
    public RegularSeat(String seatId) {
        super(seatId);
    }

    @Override
    public double getPrice() {
        return 150.0;
    }

    @Override
    public String getCategory() {
        return "Regular";
    }
}