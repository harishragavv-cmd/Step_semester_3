package week_8.assignment_problems;

public class HostelLaundryQueue {
    public static void main(String[] args) {
        LaundryStudent asha = new LaundryStudent("Asha");
        LaundryStudent ravi = new LaundryStudent("Ravi");
        LaundryStudent neha = new LaundryStudent("Neha");

        WashingMachine m1 = new WashingMachine("M1");
        WashingMachine m2 = new WashingMachine("M2");

        System.out.println(m1.startWash(asha, new QuickWash()));
        System.out.println(m1.startWash(ravi, new HeavyWash()));
        System.out.println(m2.startWash(ravi, new HeavyWash()));
        System.out.println(m1.completeWash());
        System.out.println(m1.startWash(neha, new NormalWash()));
    }
}