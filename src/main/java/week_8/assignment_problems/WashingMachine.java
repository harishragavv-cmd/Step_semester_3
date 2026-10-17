package week_8.assignment_problems;

import java.util.Locale;

public class WashingMachine {
    private final String machineId;
    private WashCycle currentCycle; // Private: outside code cannot set machine status.

    public WashingMachine(String machineId) {
        if (machineId == null || machineId.trim().isEmpty()) {
            throw new IllegalArgumentException("machineId cannot be blank");
        }
        this.machineId = machineId;
    }

    public String getMachineId() {
        return machineId;
    }

    public boolean isFree() {
        return currentCycle == null;
    }

    public String startWash(LaundryStudent student, WashType washType) {
        if (!isFree()) {
            return "Machine " + machineId + " is currently busy.";
        }

        currentCycle = new WashCycle(student, this, washType);
        return washType.getName() + " wash started on " + machineId + " for "
                + student.getName() + " (" + washType.getDurationMinutes()
                + " min). Charge: "
                + String.format(Locale.US, "₹%.2f", washType.getCharge()) + ".";
    }

    public String completeWash() {
        if (isFree()) {
            return "Machine " + machineId + " has no active wash.";
        }

        currentCycle = null;
        return machineId + " cycle completed. " + machineId + " is now free.";
    }

    public WashCycle getCurrentCycle() {
        return currentCycle;
    }
}