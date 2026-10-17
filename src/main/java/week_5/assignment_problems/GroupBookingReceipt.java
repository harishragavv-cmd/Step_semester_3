package week_5.assignment_problems;

public final class GroupBookingReceipt extends BookingReceipt {
    private final int groupSize;

    public GroupBookingReceipt(String bookingId, String[] seatNumbers, int groupSize) {
        super(bookingId, seatNumbers);

        if (groupSize <= 0) {
            throw new IllegalArgumentException("groupSize must be positive");
        }
        if (groupSize != seatNumbers.length) {
            throw new IllegalArgumentException("groupSize must match the number of seats");
        }

        this.groupSize = groupSize;
    }

    public int getGroupSize() {
        return groupSize;
    }
}