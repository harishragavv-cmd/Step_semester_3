package week_8.assignment_problems;

public class CampusNoticeBroadcaster {
    public static void main(String[] args) {
        NoticeBoard board = new NoticeBoard();

        board.registerStudent(new NoticeStudent(
                "Asha", "CSE", new EmailChannel(), new AppChannel()));
        board.registerStudent(new NoticeStudent(
                "Ravi", "ECE", new SmsChannel()));

        board.postNotice("Lab Closed Tomorrow", "CSE");
        board.postNotice("Fee Deadline Extended", "CSE", "ECE");
        board.postNotice("Sports Day");
    }
}