package week_8.assignment_problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NoticeStudent {
    private final String name;
    private final String department;
    private final List<NotificationChannel> preferredChannels = new ArrayList<>();

    public NoticeStudent(String name, String department,
                         NotificationChannel... preferredChannels) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be blank");
        }
        if (department == null || department.trim().isEmpty()) {
            throw new IllegalArgumentException("Department cannot be blank");
        }
        if (preferredChannels == null || preferredChannels.length == 0) {
            throw new IllegalArgumentException("At least one preferred channel is required");
        }

        this.name = name;
        this.department = department;

        for (NotificationChannel channel : preferredChannels) {
            addPreferredChannel(channel);
        }
    }

    public String getName() { return name; }
    public String getDepartment() { return department; }

    public void addPreferredChannel(NotificationChannel channel) {
        if (channel == null) {
            throw new IllegalArgumentException("Notification channel cannot be null");
        }
        preferredChannels.add(channel);
    }

    public List<NotificationChannel> getPreferredChannels() {
        return Collections.unmodifiableList(new ArrayList<>(preferredChannels));
    }
}