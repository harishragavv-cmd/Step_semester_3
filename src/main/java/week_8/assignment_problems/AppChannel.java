package week_8.assignment_problems;

public class AppChannel implements NotificationChannel {
    @Override
    public String getChannelName() {
        return "App";
    }

    @Override
    public String send(String studentName, String message) {
        return "[App → " + studentName + "] " + message + ".";
    }
}