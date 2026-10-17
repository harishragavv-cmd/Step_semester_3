package week_8.assignment_problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Notice {
    private final String title;
    private final Set<String> targetDepartments;

    public Notice(String title, String... targetDepartments) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("A notice title is required");
        }
        if (targetDepartments == null || targetDepartments.length == 0) {
            throw new IllegalArgumentException("At least one target department is required");
        }

        Set<String> departments = new LinkedHashSet<>();
        for (String department : targetDepartments) {
            if (department == null || department.trim().isEmpty()) {
                throw new IllegalArgumentException("Target departments cannot be blank");
            }
            departments.add(department);
        }
        if (departments.isEmpty()) {
            throw new IllegalArgumentException("At least one target department is required");
        }

        this.title = title;
        this.targetDepartments = Collections.unmodifiableSet(departments);
    }

    public String getTitle() { return title; }

    public Set<String> getTargetDepartments() {
        return targetDepartments;
    }

    public List<String> getTargetDepartmentList() {
        return Collections.unmodifiableList(new ArrayList<>(targetDepartments));
    }
}