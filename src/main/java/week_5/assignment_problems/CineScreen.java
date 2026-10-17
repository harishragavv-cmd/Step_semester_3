package week_5.assignment_problems;

public class CineScreen {
    private final int seatsTotal;
    private int seatsAvailable;

    public CineScreen(int seatsTotal) {
        if (seatsTotal <= 0 || seatsTotal > 300) {
            throw new IllegalArgumentException("seatsTotal must be between 1 and 300");
        }

        this.seatsTotal = seatsTotal;
        this.seatsAvailable = seatsTotal;
    }

    public void bookSeat() {
        if (seatsAvailable > 0) {
            seatsAvailable--;
        }
    }

    public void cancelBooking() {
        if (seatsAvailable < seatsTotal) {
            seatsAvailable++;
        }
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public static void main(String[] args) {
        CineScreen screen = new CineScreen(2);

        screen.bookSeat();
        screen.bookSeat();
        screen.bookSeat();
        System.out.println("After bookings: " + screen.getSeatsAvailable());

        screen.cancelBooking();
        screen.cancelBooking();
        screen.cancelBooking();
        System.out.println("After cancellations: " + screen.getSeatsAvailable());
    }
}