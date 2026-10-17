package week_6.class_problems;

import java.util.Arrays;

public class LibraryMember {
    private static int membersEnrolled = 0;

    private final String memberId;
    private final int borrowLimit;
    private int booksBorrowed;
    private final int[] fineHistory = new int[10];
    private int fineCount;
    private int totalFine;
    private final String[] borrowedGenres;

    // Final so the assigned number cannot be changed after construction.
    public final String memberNumber;

    public LibraryMember(String memberId, int borrowLimit) {
        this(memberId, borrowLimit, true);
    }

    // Constructor used by the Week 6 nightly-audit problem.
    public LibraryMember(int borrowLimit) {
        this("AUTO", borrowLimit, false);
    }

    private LibraryMember(String memberId, int borrowLimit, boolean validateMemberId) {
        if (borrowLimit <= 0) {
            throw new IllegalArgumentException("borrowLimit must be positive");
        }

        if (validateMemberId
                && (memberId == null || memberId.trim().length() < 4)) {
            throw new IllegalArgumentException(
                    "memberId must contain at least 4 non-whitespace characters");
        }

        this.memberId = validateMemberId ? memberId : "AUTO-" + (membersEnrolled + 1);
        this.borrowLimit = borrowLimit;
        this.booksBorrowed = 0;
        this.fineCount = 0;
        this.totalFine = 0;
        this.borrowedGenres = new String[borrowLimit];

        membersEnrolled++;
        this.memberNumber = "LIB-" + (100 + membersEnrolled);
    }

    public String getMemberId() {
        return memberId;
    }

    public int getBorrowLimit() {
        return borrowLimit;
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }

    public String getMemberNumber() {
        return memberNumber;
    }

    public void borrowBook() {
        if (booksBorrowed < borrowLimit) {
            booksBorrowed++;
        }
    }

    public void borrowBook(String genre) {
        if (booksBorrowed < borrowLimit) {
            borrowedGenres[booksBorrowed] = genre;
            borrowBook();
        }
    }

    protected void chargeFine(int amount) {
        if (amount > 0 && fineCount < fineHistory.length) {
            fineHistory[fineCount] = amount;
            fineCount++;
            totalFine += amount;
        }
    }

    public int[] getFineHistory() {
        return Arrays.copyOf(fineHistory, fineCount);
    }

    public int getTotalFine() {
        return totalFine;
    }

    public String displayInfo() {
        return "General Member | Books Borrowed: " + booksBorrowed;
    }

    public static String enrollBatch(String[] memberIds, int borrowLimit) {
        int enrolled = 0;
        int rejected = 0;

        if (memberIds == null) {
            return "Enrolled: 0 | Rejected: 0";
        }

        for (String id : memberIds) {
            try {
                new LibraryMember(id, borrowLimit);
                enrolled++;
            } catch (IllegalArgumentException exception) {
                rejected++;
            }
        }

        return "Enrolled: " + enrolled + " | Rejected: " + rejected;
    }

    public static String classifyGeneration(LibraryMember member) {
        if (member instanceof HonorsStudentMember) {
            return "Multilevel descendant (3 generations deep)";
        }
        if (member instanceof FacultyMember) {
            return "Hierarchical sibling (independent branch)";
        }
        if (member instanceof StudentMember) {
            return "Single inheritance (direct descendant)";
        }
        return "Base class";
    }

    public static int getTotalBooksBorrowed(LibraryMember[] members) {
        int total = 0;

        if (members != null) {
            for (LibraryMember member : members) {
                if (member != null) {
                    total += member.getBooksBorrowed();
                }
            }
        }

        return total;
    }

    public static String batchPrint(LibraryMember[] members) {
        StringBuilder report = new StringBuilder();

        if (members == null) {
            return "";
        }

        for (LibraryMember member : members) {
            String info = member.displayInfo(); // Polymorphic call.

            if (member instanceof StudentMember) {
                StudentMember student = (StudentMember) member;
                info = info.replace("Honors Student Member", "Honors Student")
                           .replace("Student Member", "Student")
                           .replace("Books Borrowed:", "Books:");
                report.append(info)
                      .append(" [Course via downcast: ")
                      .append(student.getCourse())
                      .append("] | ");
            } else {
                info = info.replace("General Member | Books Borrowed:",
                                    "General | Books:")
                           .replace("Faculty Member", "Faculty")
                           .replace("Books Borrowed:", "Books:");
                report.append(info).append(" | ");
            }
        }

        return report.toString();
    }

    public static boolean isValidRenewalCode(String code) {
        if (code == null || code.length() != 4) {
            return false;
        }

        return code.charAt(0) == 'R'
                && Character.isDigit(code.charAt(1))
                && Character.isDigit(code.charAt(2))
                && Character.isUpperCase(code.charAt(3));
    }

    public static int getMembersEnrolled() {
        return membersEnrolled;
    }

    public static String processNightlyAudit(LibraryMember[] members) {
        int processed = 0;
        int nullSkipped = 0;
        int facultyCount = 0;
        int regularCount = 0;

        if (members != null) {
            for (LibraryMember member : members) {
                if (member == null) {
                    nullSkipped++;
                    continue;
                }

                processed++;
                if (member instanceof FacultyMember) {
                    facultyCount++;
                } else {
                    regularCount++;
                }
            }
        }

        return processed + " processed | " + nullSkipped + " null skipped | "
                + facultyCount + " faculty | " + regularCount + " regular";
    }

    public static void main(String[] args) {
        System.out.println(enrollBatch(
                new String[]{"STU1", "LB1", "STU2", " ", "STU3"}, 3));

        StudentMember student = new StudentMember("STU10", 3, "CSE");
        student.borrowBook();
        student.borrowBook();
        System.out.println(student.getBooksBorrowed());

        student.chargeFine(100);
        System.out.println(student.getTotalFine());
        int[] history = student.getFineHistory();
        history[0] = 999;
        System.out.println(Arrays.toString(student.getFineHistory()));

        HonorsStudentMember honors =
                new HonorsStudentMember("STU3", 3, "ECE", 2);
        FacultyMember faculty = new FacultyMember("FAC4", 5, "Physics");
        System.out.println(honors.displayInfo());
        System.out.println(faculty.displayInfo());
        System.out.println(classifyGeneration(honors));
        System.out.println(classifyGeneration(faculty));

        LibraryMember[] mixed = {student, honors, faculty};
        System.out.println("Total borrowed: " + getTotalBooksBorrowed(mixed));
        System.out.println(batchPrint(new LibraryMember[]{
                new LibraryMember("LB5", 3),
                new StudentMember("STU6", 3, "ECE")
        }));

        LibraryMember m1 = new LibraryMember(3);
        m1.borrowBook();
        m1.borrowBook("Fiction");
        System.out.println(m1.memberNumber);
        System.out.println("Books borrowed: " + m1.getBooksBorrowed());
        System.out.println("Members enrolled: " + getMembersEnrolled());

        System.out.println(isValidRenewalCode("R12A"));
        System.out.println(isValidRenewalCode("R1A"));
        System.out.println(isValidRenewalCode("X12A"));

        System.out.println(processNightlyAudit(new LibraryMember[]{
                new FacultyMember(5, "Physics"),
                null,
                new LibraryMember(3)
        }));
    }
}