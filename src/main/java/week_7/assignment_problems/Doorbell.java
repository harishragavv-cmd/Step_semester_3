package week_7.assignment_problems;

public class Doorbell implements Ringable {
    private final String location;

    public Doorbell(String location) {
        if (location == null || location.trim().isEmpty()) {
            throw new IllegalArgumentException("location cannot be blank");
        }
        this.location = location;
    }

    @Override
    public String ring() {
        return "Doorbell ringing at " + location;
    }
}