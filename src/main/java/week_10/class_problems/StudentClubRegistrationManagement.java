package week_10.class_problems;

import java.util.HashSet;
import java.util.Set;

public class StudentClubRegistrationManagement {
    private final Set<ClubMember> members = new HashSet<>();

    public boolean addMember(String rollNumber, String name) {
        boolean added = members.add(new ClubMember(rollNumber, name));
        System.out.println(added ? "Added" : "duplicate rejected");
        return added;
    }

    public boolean contains(String rollNumber, String name) {
        // ClubMember.equals() and hashCode() use only rollNumber.
        return members.contains(new ClubMember(rollNumber, name));
    }

    public int getMemberCount() {
        return members.size();
    }

    public static void main(String[] args) {
        StudentClubRegistrationManagement club = new StudentClubRegistrationManagement();
        club.addMember("21CS01", "Asha");
        club.addMember("21CS01", "Asha");
        club.addMember("21CS02", "Ravi");

        System.out.println("member count " + club.getMemberCount());
        System.out.println("contains: " + club.contains("21CS02", "Ravi"));
        System.out.println("contains: " + club.contains("21CS03", "Priya"));
    }
}