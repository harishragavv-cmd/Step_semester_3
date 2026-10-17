package week_8.class_problems;

public class StandardHotelRoom extends HotelRoom {
    public StandardHotelRoom(String roomId) { super(roomId); }
    @Override public double calculatePrice(long nights) {
        if (nights <= 0) throw new IllegalArgumentException("Nights must be positive");
        return nights * 100.0;
    }
    @Override public String getCategory() { return "Standard Room"; }
}