package week_8.class_problems;

public class SuiteHotelRoom extends HotelRoom {
    public SuiteHotelRoom(String roomId) { super(roomId); }
    @Override public double calculatePrice(long nights) {
        if (nights <= 0) throw new IllegalArgumentException("Nights must be positive");
        return nights * 300.0;
    }
    @Override public String getCategory() { return "Suite"; }
}