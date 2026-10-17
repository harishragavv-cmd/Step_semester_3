package week_6.assignment_problems;

public class GroupClassMember extends GymMember {
    private final String className;

    public GroupClassMember(String memberId, int monthlyFee, String className) {
        super(memberId, monthlyFee);
        if (className == null || className.trim().isEmpty()) {
            throw new IllegalArgumentException("className cannot be blank");
        }
        this.className = className;
    }

    // Constructor required for Problem 5.
    public GroupClassMember(int monthlyFee, String className) {
        super(monthlyFee);
        if (className == null || className.trim().isEmpty()) {
            throw new IllegalArgumentException("className cannot be blank");
        }
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    @Override
    public String displayInfo() {
        return "Group Class Member | Class: " + className
                + " | Sessions: " + getSessionsAttended();
    }
}