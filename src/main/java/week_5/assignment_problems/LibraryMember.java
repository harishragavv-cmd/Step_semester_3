package week_5.assignment_problems;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LibraryMember {
    // Problem 1: field visibility is chosen according to the stated access rules.
    private String membershipPin;
    String branchCode;
    protected double finesOwed;
    public String displayName;

    // Problem 4: JavaBean properties.
    private String membershipId;
    private boolean membershipIdSet;
    private String name;
    private boolean premiumMember;
    private String securityAnswerHash; // No getter is provided.

    public LibraryMember() {
        membershipId = null;
        membershipIdSet = false;
        name = "";
        premiumMember = false;
    }

    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String id) {
        if (!membershipIdSet) {
            membershipId = id;
            membershipIdSet = true;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.displayName = name;
    }

    public boolean isPremiumMember() {
        return premiumMember;
    }

    public void setPremiumMember(boolean premium) {
        this.premiumMember = premium;
    }

    public void setSecurityAnswer(String answer) {
        if (answer == null) {
            securityAnswerHash = null;
            return;
        }

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = digest.digest(answer.getBytes(StandardCharsets.UTF_8));
            StringBuilder hash = new StringBuilder();

            for (byte value : bytes) {
                hash.append(String.format("%02x", value & 0xff));
            }
            securityAnswerHash = hash.toString();
        } catch (NoSuchAlgorithmException ex) {
            throw new IllegalStateException("SHA-256 is not available", ex);
        }
    }

    // displayName is public as required; these JavaBean methods are also available.
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
        this.name = displayName;
    }
}