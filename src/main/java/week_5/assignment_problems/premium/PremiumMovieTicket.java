package week_5.assignment_problems.premium;

import week_5.assignment_problems.MovieTicket;

public class PremiumMovieTicket extends MovieTicket {

    public PremiumMovieTicket(String seatNumber, String screenId,
                              double ticketPrice, String movieTitle) {
        super(seatNumber, screenId, ticketPrice, movieTitle);
    }

    // Allowed: access is through this subclass instance.
    public double readOwnTicketPrice() {
        return this.ticketPrice;
    }

    /*
     * A protected member from another package cannot be accessed through
     * a variable declared as the parent type MovieTicket. AccessChecker
     * models that PARENT_TYPE case without including intentionally
     * uncompilable code here.
     */
}