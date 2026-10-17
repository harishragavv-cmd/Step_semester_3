package week_8.assignment_problems;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class Show {
    private static final int MAX_SEATS_PER_BOOKING = 6;

    private final String showTime;
    private final Map<String, Seat> seatCatalog = new LinkedHashMap<>();
    private final Map<String, Booking> reservedSeats = new LinkedHashMap<>();
    private final List<Booking> bookings = new ArrayList<>();
    private boolean started;

    public Show(String showTime, Seat[] seats) {
        if (showTime == null || showTime.trim().isEmpty() || seats == null) {
            throw new IllegalArgumentException("Show time and seat list are required");
        }

        this.showTime = showTime;
        this.started = false;

        for (Seat seat : seats) {
            if (seat == null) {
                throw new IllegalArgumentException("Seat list cannot contain null");
            }
            if (seatCatalog.putIfAbsent(seat.getSeatId(), seat) != null) {
                throw new IllegalArgumentException("Duplicate seat ID: " + seat.getSeatId());
            }
        }
    }

    public String getShowTime() {
        return showTime;
    }

    public boolean isStarted() {
        return started;
    }

    public void startShow() {
        started = true;
    }

    public Booking book(TicketCustomer customer, String... seatIds) {
        if (customer == null || seatIds == null || seatIds.length == 0
                || seatIds.length > MAX_SEATS_PER_BOOKING) {
            System.out.println("Booking rejected: select between 1 and 6 seats.");
            return null;
        }

        List<Seat> selectedSeats = new ArrayList<>();
        Set<String> selectedIds = new HashSet<>();

        // Validate every seat before reserving any, so booking is all-or-nothing.
        for (String id : seatIds) {
            if (id == null || !seatCatalog.containsKey(id)) {
                System.out.println("Seat " + id + " does not exist for this show.");
                return null;
            }
            if (!selectedIds.add(id)) {
                System.out.println("Seat " + id + " was selected more than once.");
                return null;
            }
            if (reservedSeats.containsKey(id)) {
                System.out.println("Seat " + id + " is already booked for this show.");
                return null;
            }
            selectedSeats.add(seatCatalog.get(id));
        }

        Booking booking = new Booking(customer, this, selectedSeats);
        bookings.add(booking);
        for (Seat seat : selectedSeats) {
            reservedSeats.put(seat.getSeatId(), booking);
        }

        System.out.println("Booking confirmed for " + customer.getName() + ": "
                + String.join(", ", selectedIdsInOrder(selectedSeats))
                + ". Total: " + String.format(Locale.US, "₹%.2f", booking.getTotal()) + ".");
        return booking;
    }

    private List<String> selectedIdsInOrder(List<Seat> seats) {
        List<String> ids = new ArrayList<>();
        for (Seat seat : seats) {
            ids.add(seat.getSeatId());
        }
        return ids;
    }

    String cancelBooking(Booking booking) {
        if (booking == null || booking.getShow() != this || booking.isCancelled()
                || !bookings.contains(booking)) {
            return "Cannot cancel: booking is not active.";
        }
        if (started) {
            return "Cannot cancel: the show has already started.";
        }

        List<String> released = new ArrayList<>();
        for (Seat seat : booking.getSeats()) {
            reservedSeats.remove(seat.getSeatId());
            released.add(seat.getSeatId());
        }
        booking.markCancelled();

        return booking.getCustomer().getName() + "'s booking cancelled. Seats "
                + String.join(", ", released) + " released.";
    }

    public boolean isSeatAvailable(String seatId) {
        return seatCatalog.containsKey(seatId) && !reservedSeats.containsKey(seatId);
    }
}