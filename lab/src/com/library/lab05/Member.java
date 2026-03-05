package com.library.lab05;

public class Member {
    private String memberId;
    private String memberName;
    private int borrowedCount;
    private MembershipStrategy membershipStrategy;



    public Member(String memberId, String memberName, MembershipStrategy membershipStrategy) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.membershipStrategy = membershipStrategy;
        this.borrowedCount = 0;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String name) {
        this.memberName = memberName;
    }

    public MembershipStrategy getMembershipStrategy() {
        return membershipStrategy;
    }

    public void setMembershipStrategy(MembershipStrategy membershipStrategy) {
        this.membershipStrategy = membershipStrategy;
    }

    public int getBorrowedCount() {
        return borrowedCount;
    }

    public void setBorrowedCount(int borrowedCount) {
        this.borrowedCount = borrowedCount;
    }


    public double calculateLateFee (double baseFee) {
        return membershipStrategy.applyLateFeeDiscount(baseFee);
    }

    public void displayMemberInfo() {
    System.out.println("\n--- MEMBER INFORMATION ---");
    System.out.println(" ID: " + memberId);
    System.out.println(" Name: " + memberName);
    System.out.println(" Membership Type: " + membershipStrategy.getMembershipType());
    System.out.println(" Membership Cost: " + membershipStrategy.getMembershipCost() + " Baht");
    System.out.println(" Borrow Limit: " + (membershipStrategy.hasUnlimitedBorrowing() ? "Unlimited" : membershipStrategy.getBorrowLimit()));
    System.out.println(" Currently Borrowed: " + borrowedCount);
    System.out.println(" Loan Period: " + membershipStrategy.getLoanPeriodDays() + " days");
    }

    public boolean canBorrow(LibraryItem item) {
        if (item == null) {
            return false;
        }

        int limit = membershipStrategy.getBorrowLimit();

        if (membershipStrategy.hasUnlimitedBorrowing()) {
            return true;
        }

        if (borrowedCount >= limit) {
            System.out.printf(" Member %s has reached the borrow limit (%d) for %s.\n", memberName, limit, membershipStrategy.getMembershipType());
            return false;
        }
        return true;
    }

    public void recordBorrow(LibraryItem item) {
        if (item != null) {
            int limit = membershipStrategy.getBorrowLimit();
            if (membershipStrategy.hasUnlimitedBorrowing() || borrowedCount < limit ){
                borrowedCount++;
            }
        }
    }
    public void recordReturn(LibraryItem item) {
        if (item != null && borrowedCount > 0) {
            borrowedCount--;
        }
    }


}

