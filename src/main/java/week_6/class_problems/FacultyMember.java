package week_6.class_problems;

public class FacultyMember extends LibraryMember {
    private final String department;

    public FacultyMember(String memberId, int borrowLimit, String department) {
        super(memberId, borrowLimit);
        if (department == null || department.trim().isEmpty()) {
            throw new IllegalArgumentException("department cannot be blank");
        }
        this.department = department;
    }

    // Constructor required for the Week 6 nightly-audit problem.
    public FacultyMember(int borrowLimit, String department) {
        super(borrowLimit);
        if (department == null || department.trim().isEmpty()) {
            throw new IllegalArgumentException("department cannot be blank");
        }
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String displayInfo() {
        return "Faculty Member | Department: " + department
                + " | Books Borrowed: " + getBooksBorrowed();
    }
}