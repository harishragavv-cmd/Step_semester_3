package week_8.assignment_problems;

public abstract class Seat {
    private final String seatId;

    protected Seat(String seatId) {
        if (seatId == null || seatId.trim().isEmpty()) {
            throw new IllegalArgumentException("seatId cannot be blank");
        }
        this.seatId = seatId;
    }

    public String getSeatId() {
        return seatId;
    }

    public abstract double getPrice();

    public abstract String getCategory();
}