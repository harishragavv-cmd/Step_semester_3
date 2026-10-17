package week_8.assignment_problems;

public class GymMember {
    private final String name;
    private Membership membership;

    public GymMember(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Member name cannot be blank");
        }
        this.name = name;
    }

    public String getName() { return name; }

    public Membership buyMembership(MembershipPlan plan) {
        if (plan == null) {
            throw new IllegalArgumentException("Membership plan is required");
        }
        membership = new Membership(this, plan);
        System.out.println(plan.getName() + " membership created for " + name
                + ". Fee: " + membership.getFormattedFee()
                + ". Status: Active.");
        return membership;
    }

    public String checkIn() {
        if (membership == null) {
            return "Check-in denied: " + name + " has no membership.";
        }
        return membership.checkIn();
    }

    public Membership getMembership() {
        return membership;
    }
}