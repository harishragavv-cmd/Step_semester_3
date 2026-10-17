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

    @Override
    public GroupBookingReceipt withUpdatedSeat(int index, String newSeat) {
        String[] updatedSeats = getSeatNumbers();

        if (index < 0 || index >= updatedSeats.length) {
            throw new IndexOutOfBoundsException("Invalid seat index: " + index);
        }
        if (newSeat == null || newSeat.trim().isEmpty()) {
            throw new IllegalArgumentException("Seat number cannot be blank");
        }

        updatedSeats[index] = newSeat;
        return new GroupBookingReceipt(getBookingId(), updatedSeats, groupSize);
    }
}