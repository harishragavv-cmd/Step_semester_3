package week_8.class_problems;

import java.time.LocalDate;

public class LeaveRequestWorkflow {
    public static void main(String[] args) {
        LeaveEmployee john = new FullTimeEmployee("John");
        LeaveEmployee jane = new PartTimeEmployee("Jane");

        LeaveRequest johnRequest = john.submitLeave(
                LocalDate.of(2027, 1, 1), LocalDate.of(2027, 1, 5));
        LeaveRequest janeRequest = jane.submitLeave(
                LocalDate.of(2027, 2, 10), LocalDate.of(2027, 2, 11));

        System.out.println(johnRequest.review("Alice", true));
        System.out.println(janeRequest.review("Bob", false));
        System.out.println(johnRequest.attemptStatusChange(LeaveStatus.PENDING));
    }
}