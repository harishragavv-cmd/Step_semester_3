package week_8.assignment_problems;

public class EmailChannel implements NotificationChannel {
    @Override
    public String getChannelName() {
        return "Email";
    }

    @Override
    public String send(String studentName, String message) {
        return "[Email → " + studentName + "] " + message + ".";
    }
}