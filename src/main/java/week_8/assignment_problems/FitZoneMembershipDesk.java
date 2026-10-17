package week_8.assignment_problems;

public class FitZoneMembershipDesk {
    public static void main(String[] args) {
        GymMember asha = new GymMember("Asha");
        GymMember ravi = new GymMember("Ravi");

        Membership ashaMembership = asha.buyMembership(new QuarterlyPlan());
        Membership raviMembership = ravi.buyMembership(new MonthlyPlan());

        System.out.println(asha.checkIn());
        System.out.println(ashaMembership.freeze());
        System.out.println(asha.checkIn());

        System.out.println(raviMembership.expire());
        System.out.println(raviMembership.freeze());
    }
}