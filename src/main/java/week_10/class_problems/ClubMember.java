package week_10.class_problems;

import java.util.Objects;

public class ClubMember {
    private final String rollNumber;
    private final String name;

    public ClubMember(String rollNumber, String name) {
        if (rollNumber == null || rollNumber.trim().isEmpty()
                || name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Roll number and name are required");
        }
        this.rollNumber = rollNumber;
        this.name = name;
    }

    public String getRollNumber() { return rollNumber; }
    public String getName() { return name; }

    // Membership identity is based only on the roll number.
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof ClubMember)) return false;
        ClubMember member = (ClubMember) other;
        return rollNumber.equals(member.rollNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollNumber);
    }

    @Override
    public String toString() {
        return rollNumber + " " + name;
    }
}