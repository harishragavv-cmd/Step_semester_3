package week_8.assignment_problems;

public interface NotificationChannel {
    String getChannelName();

    String send(String studentName, String message);
}