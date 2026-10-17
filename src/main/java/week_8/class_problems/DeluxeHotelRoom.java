package week_8.class_problems;

public class DeluxeHotelRoom extends HotelRoom {
    public DeluxeHotelRoom(String roomId) { super(roomId); }
    @Override public double calculatePrice(long nights) {
        if (nights <= 0) throw new IllegalArgumentException("Nights must be positive");
        return nights * 180.0;
    }
    @Override public String getCategory() { return "Deluxe Room"; }
}