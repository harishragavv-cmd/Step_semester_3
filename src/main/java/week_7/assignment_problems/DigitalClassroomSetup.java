package week_7.assignment_problems;

public class DigitalClassroomSetup {
    public static void main(String[] args) {
        Tablet tablet = new Tablet("TAB-5");

        System.out.println(tablet.operate());
        System.out.println(tablet.charge());
        System.out.println(tablet.charge(30));
    }
}