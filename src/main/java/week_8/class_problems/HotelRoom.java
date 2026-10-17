package week_8.class_problems;

public abstract class HotelRoom {
    private final String roomId;

    protected HotelRoom(String roomId) {
        if (roomId == null || roomId.trim().isEmpty()) {
            throw new IllegalArgumentException("Room ID cannot be blank");
        }
        this.roomId = roomId;
    }

    public String getRoomId() { return roomId; }
    public abstract double calculatePrice(long nights);
    public abstract String getCategory();
}