package week_8.assignment_problems;

public class SmsChannel implements NotificationChannel {
    @Override
    public String getChannelName() {
        return "SMS";
    }

    @Override
    public String send(String studentName, String message) {
        return "[SMS → " + studentName + "] " + message + ".";
    }
}