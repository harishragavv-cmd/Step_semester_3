package week_8.assignment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NoticeBoard {
    private final List<NoticeStudent> students = new ArrayList<>();

    public void registerStudent(NoticeStudent student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        students.add(student);
    }

    public void postNotice(String title, String... targetDepartments) {
        final Notice notice;
        try {
            notice = new Notice(title, targetDepartments);
        } catch (IllegalArgumentException exception) {
            System.out.println("Cannot post notice: " + exception.getMessage() + ".");
            return;
        }

        String departmentList = notice.getTargetDepartmentList()
                .stream().collect(Collectors.joining(", "));
        System.out.println("Notice '" + notice.getTitle() + "' posted to "
                + departmentList + ".");

        for (NoticeStudent student : students) {
            if (notice.getTargetDepartments().contains(student.getDepartment())) {
                for (NotificationChannel channel : student.getPreferredChannels()) {
                    System.out.println(channel.send(student.getName(), notice.getTitle()));
                }
            }
        }
    }
}