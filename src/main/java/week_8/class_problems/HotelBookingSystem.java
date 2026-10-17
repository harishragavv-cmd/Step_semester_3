package week_8.class_problems;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class HotelBookingSystem {
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("MMM d");
    private final Map<String, HotelRoom> rooms = new LinkedHashMap<>();
    private final List<HotelReservation> reservations = new ArrayList<>();

    public void addRoom(HotelRoom room) {
        if (room == null) throw new IllegalArgumentException("Room is required");
        if (rooms.putIfAbsent(room.getRoomId(), room) != null) {
            throw new IllegalArgumentException("Duplicate room ID: " + room.getRoomId());
        }
    }

    public boolean checkAvailability(String roomId, LocalDate start, LocalDate end) {
        HotelRoom room = rooms.get(roomId);
        boolean validDates = start != null && end != null && end.isAfter(start);
        boolean available = room != null && validDates && isAvailable(room, start, end);
        if (available) {
            System.out.println(room.getCategory() + " " + roomId + " is available from "
                    + formatDate(start) + " to " + formatDate(end) + ".");
        } else {
            System.out.println((room == null ? "Room " + roomId : room.getCategory() + " " + roomId)
                    + " is not available from " + formatDate(start) + " to " + formatDate(end) + ".");
        }
        return available;
    }

    public HotelReservation reserve(HotelCustomer customer, String roomId,
                                    LocalDate start, LocalDate end) {
        HotelRoom room = rooms.get(roomId);
        if (customer == null || room == null || start == null || end == null || !end.isAfter(start)) {
            System.out.println("Reservation rejected: customer, room and valid dates are required.");
            return null;
        }
        if (!isAvailable(room, start, end)) {
            System.out.println(room.getCategory() + " " + roomId + " is not available from "
                    + formatDate(start) + " to " + formatDate(end) + ".");
            return null;
        }

        HotelReservation reservation = new HotelReservation(customer, room, start, end);
        reservations.add(reservation);
        System.out.println("Reservation confirmed for " + customer.getName() + ", "
                + room.getCategory() + " " + roomId + " (" + reservation.formatDates()
                + "). Price: " + String.format(Locale.US, "$%.2f", reservation.getPrice()) + ".");
        return reservation;
    }

    private boolean isAvailable(HotelRoom room, LocalDate start, LocalDate end) {
        for (HotelReservation reservation : reservations) {
            if (reservation.isActive() && reservation.getRoom() == room) {
                // Checkout is exclusive: another booking may start on the checkout date.
                boolean overlaps = start.isBefore(reservation.getEndDate())
                        && end.isAfter(reservation.getStartDate());
                if (overlaps) return false;
            }
        }
        return true;
    }

    private String formatDate(LocalDate date) {
        return date == null ? "invalid date" : DATE_FORMAT.format(date);
    }
}