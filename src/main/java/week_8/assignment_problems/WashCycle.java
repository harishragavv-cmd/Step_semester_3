package week_8.assignment_problems;

public class WashCycle {
    private final LaundryStudent student;
    private final WashingMachine machine;
    private final WashType washType;

    public WashCycle(LaundryStudent student, WashingMachine machine, WashType washType) {
        if (student == null || machine == null || washType == null) {
            throw new IllegalArgumentException("Student, machine and wash type are required");
        }
        this.student = student;
        this.machine = machine;
        this.washType = washType;
    }

    public LaundryStudent getStudent() { return student; }
    public WashingMachine getMachine() { return machine; }
    public WashType getWashType() { return washType; }
}