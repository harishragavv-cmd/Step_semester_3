package week_5.class_problems;

import java.util.Arrays;

 /*
  * Specification note: the brief asks BookingReceipt to be final and also asks
  * GroupBookingReceipt to extend it. Java cannot satisfy both requirements:
  * a final class cannot have subclasses. This class is kept non-final so the
  * required instanceof/group-subclass behavior works; its own state is immutable.
  */
public class BookingReceipt {
    private final String bookingId;
    private final String[] seatNumbers;

    public BookingReceipt(String bookingId, String[] seatNumbers) {
        if (bookingId == null || seatNumbers == null) {
            throw new IllegalArgumentException("Booking ID and seats cannot be null");
        }
        if (seatNumbers.length > 10) {
            throw new IllegalArgumentException("A receipt can contain at most 10 seats");
        }

        this.bookingId = bookingId;
        this.seatNumbers = seatNumbers.clone();
    }

    public String getBookingId() {
        return bookingId;
    }

    public String[] getSeatNumbers() {
        return seatNumbers.clone();
    }

    public BookingReceipt withUpdatedSeat(int index, String newSeat) {
        if (index < 0 || index >= seatNumbers.length) {
            throw new IndexOutOfBoundsException("Invalid seat index: " + index);
        }
        if (newSeat == null || newSeat.trim().isEmpty()) {
            throw new IllegalArgumentException("Seat number cannot be blank");
        }

        String[] updatedSeats = seatNumbers.clone();
        updatedSeats[index] = newSeat;
        return new BookingReceipt(bookingId, updatedSeats);
    }

    public static String processNightlySettlement(BookingReceipt[] receipts) {
        int processed = 0;
        int nullSkipped = 0;
        int groupCount = 0;
        int individualCount = 0;

        if (receipts != null) {
            for (BookingReceipt receipt : receipts) {
                if (receipt == null) {
                    nullSkipped++;
                    continue;
                }

                processed++;
                if (receipt instanceof GroupBookingReceipt) {
                    groupCount++;
                } else {
                    individualCount++;
                }
            }
        }

        return processed + " processed | " + nullSkipped + " null skipped | "
                + groupCount + " group | " + individualCount + " individual";
    }

    public static void main(String[] args) {
        BookingReceipt original = new BookingReceipt(
                "CH-1001", new String[]{"A1", "A2"});

        String[] externalCopy = original.getSeatNumbers();
        externalCopy[0] = "X";

        BookingReceipt updated = original.withUpdatedSeat(1, "A3");
        System.out.println(Arrays.toString(original.getSeatNumbers()));
        System.out.println(Arrays.toString(updated.getSeatNumbers()));

        BookingReceipt[] nightlyBatch = {
            new GroupBookingReceipt("CH-2002", new String[]{"B1", "B2"}, 2),
            null,
            new BookingReceipt("CH-3003", new String[]{"C1"})
        };
        System.out.println(processNightlySettlement(nightlyBatch));
    }
}