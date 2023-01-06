package laba.solvd.buildings;

import java.util.Objects;

public class Estate implements IEstate {
    private final Classification classification;
    private String address;
    protected int costOfAccommodation;
    protected int amount;

    public Estate(Classification classification, String address, int costOfAccommodation, int amount) {
        this.classification = classification;
        this.address = address;
        this.costOfAccommodation = costOfAccommodation;
        this.amount = amount;
    }

    public Estate(Classification classification) {
        this.classification = classification;
    }

    public Classification getClassification() {
        return classification;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCostOfAccommodation() {
        return costOfAccommodation;
    }

    public void setCostOfAccommodation(int costOfAccommodation) {
        this.costOfAccommodation = costOfAccommodation;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public void info() {
        System.out.println(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estate)) return false;
        Estate estate = (Estate) o;
        return getCostOfAccommodation() == estate.getCostOfAccommodation() && getAmount() == estate.getAmount() &&
                getClassification() == estate.getClassification() && Objects.equals(getAddress(), estate.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClassification(), getAddress(), getCostOfAccommodation(), getAmount());
    }

    @Override
    public String toString() {
        return "Estate{" +
                "classification=" + classification +
                ", address='" + address + '\'' +
                ", costOfAccommodation=" + costOfAccommodation +
                ", amount=" + amount +
                '}';
    }
}
