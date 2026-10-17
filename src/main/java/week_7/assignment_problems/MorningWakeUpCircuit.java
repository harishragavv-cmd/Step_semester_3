package week_7.assignment_problems;

public class MorningWakeUpCircuit {
    public static void ringAll(Ringable[] devices) {
        if (devices == null) {
            return;
        }

        for (Ringable device : devices) {
            if (device != null) {
                System.out.println(device.ring());
            }
        }
    }

    public static void main(String[] args) {
        AlarmClock alarm = new AlarmClock("7:00 AM");
        Doorbell doorbell = new Doorbell("Front Door");

        System.out.println(alarm.ring());
        System.out.println(doorbell.ring());
        ringAll(new Ringable[]{alarm, doorbell});
    }
}