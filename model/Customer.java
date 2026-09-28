package model;

public class Customer extends Person {

    private int loyaltyPoints;
    private String membershipType;

    public Customer() {

        super();

        this.loyaltyPoints = 0;
        this.membershipType = "Regular";
    }

    public Customer(
            int id,
            String name,
            String phone,
            int loyaltyPoints,
            String membershipType) {

        super(id, name, phone);

        this.loyaltyPoints = loyaltyPoints;
        this.membershipType = membershipType;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(
            String membershipType) {

        this.membershipType = membershipType;
    }

    @Override
    public void displayRole() {

        System.out.println("Role: Customer");
    }

    @Override
    public String toString() {

        return super.toString()
                + String.format(
                " | Loyalty Points: %d | Membership: %s",
                loyaltyPoints,
                membershipType
        );
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Customer)) {
            return false;
        }

        Customer other = (Customer) obj;

        return this.getId() == other.getId();
    }
}