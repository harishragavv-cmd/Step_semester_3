package week_8.assignment_problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Booking {
    private final TicketCustomer customer;
    private final Show show;
    private final List<Seat> seats;
    private final double total;
    private boolean cancelled;

    Booking(TicketCustomer customer, Show show, List<Seat> seats) {
        this.customer = customer;
        this.show = show;
        this.seats = Collections.unmodifiableList(new ArrayList<>(seats));

        double sum = 0;
        for (Seat seat : seats) {
            sum += seat.getPrice();
        }
        this.total = sum;
        this.cancelled = false;
    }

    public TicketCustomer getCustomer() { return customer; }
    public Show getShow() { return show; }
    public List<Seat> getSeats() { return seats; }
    public double getTotal() { return total; }
    public boolean isCancelled() { return cancelled; }

    void markCancelled() {
        cancelled = true;
    }

    public String cancel() {
        return show.cancelBooking(this);
    }
}