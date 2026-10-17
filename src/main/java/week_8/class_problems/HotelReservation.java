package week_8.class_problems;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HotelReservation {
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("MMM d");

    private final HotelCustomer customer;
    private final HotelRoom room;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final LocalDateTime cancellationDeadline;
    private final double price;
    private boolean cancelled;

    HotelReservation(HotelCustomer customer, HotelRoom room,
                     LocalDate startDate, LocalDate endDate) {
        this.customer = customer;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cancellationDeadline = startDate.minusDays(1).atStartOfDay();
        long nights = java.time.temporal.ChronoUnit.DAYS.between(startDate, endDate);
        this.price = room.calculatePrice(nights);
    }

    public HotelCustomer getCustomer() { return customer; }
    public HotelRoom getRoom() { return room; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public boolean isActive() { return !cancelled; }
    public double getPrice() { return price; }
    public LocalDateTime getCancellationDeadline() { return cancellationDeadline; }

    public String cancel(LocalDateTime requestedAt) {
        if (cancelled) {
            return "Reservation has already been cancelled.";
        }
        if (requestedAt == null || !requestedAt.isBefore(cancellationDeadline)) {
            return "Cancellation denied: the cancellation deadline has passed.";
        }
        cancelled = true;
        return "Reservation for " + customer.getName() + ", " + room.getCategory() + " "
                + room.getRoomId() + " (" + formatDates() + ") cancelled successfully.";
    }

    public String formatDates() {
        return DATE_FORMAT.format(startDate) + "-" + DATE_FORMAT.format(endDate);
    }
}