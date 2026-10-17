package week_8.class_problems;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class HotelBookingSystemDemo {
    public static void main(String[] args) {
        HotelBookingSystem hotel = new HotelBookingSystem();
        hotel.addRoom(new StandardHotelRoom("101"));
        hotel.addRoom(new DeluxeHotelRoom("201"));
        hotel.addRoom(new SuiteHotelRoom("301"));

        HotelCustomer customerA = new HotelCustomer("Customer A");
        HotelCustomer customerB = new HotelCustomer("Customer B");
        HotelCustomer customerC = new HotelCustomer("Customer C");

        LocalDate jan1 = LocalDate.of(2027, 1, 1);
        LocalDate jan5 = LocalDate.of(2027, 1, 5);
        LocalDate jan3 = LocalDate.of(2027, 1, 3);
        LocalDate jan7 = LocalDate.of(2027, 1, 7);

        hotel.checkAvailability("101", jan1, jan5);
        HotelReservation reservationA = hotel.reserve(customerA, "101", jan1, jan5);
        hotel.reserve(customerB, "101", jan3, jan7);

        if (reservationA != null) {
            System.out.println(reservationA.cancel(LocalDateTime.of(2026, 12, 20, 12, 0)));
        }

        hotel.reserve(customerC, "201",
                LocalDate.of(2027, 2, 10), LocalDate.of(2027, 2, 12));
    }
}