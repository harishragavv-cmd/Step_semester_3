package week_8.assignment_problems;

public class CampusPremiereTicketCounter {
    public static void main(String[] args) {
        Show show = new Show("7 PM", new Seat[]{
                new RegularSeat("A1"),
                new RegularSeat("A2"),
                new PremiumSeat("F5"),
                new ReclinerSeat("R1")
        });

        TicketCustomer asha = new TicketCustomer("Asha");
        TicketCustomer ravi = new TicketCustomer("Ravi");
        TicketCustomer neha = new TicketCustomer("Neha");

        Booking ashaBooking = show.book(asha, "A1", "A2", "F5");
        show.book(ravi, "A2");
        show.book(ravi, "R1");

        if (ashaBooking != null) {
            System.out.println(ashaBooking.cancel());
        }

        show.book(neha, "A2");
    }
}