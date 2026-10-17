package week_5.assignment_problems;

public class MovieTicket {
    private String seatNumber;
    String screenId;                 // package-private (default) access
    protected double ticketPrice;    // same package and qualifying subclasses
    public String movieTitle;        // accessible from anywhere

    public MovieTicket(String seatNumber, String screenId,
                       double ticketPrice, String movieTitle) {
        this.seatNumber = seatNumber;
        this.screenId = screenId;
        this.ticketPrice = ticketPrice;
        this.movieTitle = movieTitle;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public String summary() {
        return movieTitle + " | " + screenId + " | " + seatNumber
                + " | Rs " + ticketPrice;
    }
}