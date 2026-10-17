package week_5.assignment_problems.premium;

import week_5.assignment_problems.LibraryMember;

public class PremiumLibraryMember extends LibraryMember {
    public PremiumLibraryMember() {
        super();
    }

    // Protected access is allowed through the subclass instance itself.
    public double getOwnFinesOwed() {
        return this.finesOwed;
    }

    /*
     * Across packages, protected access through a plain LibraryMember-typed
     * reference is not allowed by Java's compile-time access rules.
     */
}