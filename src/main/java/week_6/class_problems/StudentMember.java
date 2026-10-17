package week_6.class_problems;

public class StudentMember extends LibraryMember {
    private final String course;

    public StudentMember(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        if (course == null || course.trim().isEmpty()) {
            throw new IllegalArgumentException("course cannot be blank");
        }
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    @Override
    public void borrowBook() {
        super.borrowBook();
    }

    @Override
    protected void chargeFine(int amount) {
        super.chargeFine(amount / 2);
    }

    @Override
    public String displayInfo() {
        return "Student Member | Course: " + course
                + " | Books Borrowed: " + getBooksBorrowed();
    }
}