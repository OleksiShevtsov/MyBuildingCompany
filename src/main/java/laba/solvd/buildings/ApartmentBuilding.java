package laba.solvd.buildings;

import java.util.Objects;

public class ApartmentBuilding<T> extends Estate {
    private String type;
    private double livingSpace;

    public ApartmentBuilding(Classification classification, String address, int costOfAccommodation, int amount, String type, double livingSpace) {
        super(classification, address, costOfAccommodation, amount);
        this.type = type;
        this.livingSpace = livingSpace;
    }

    public ApartmentBuilding(Classification classification, String address, int costOfAccommodation, int amount) {
        super(classification, address, costOfAccommodation, amount);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getLivingSpace() {
        return livingSpace;
    }

    public void setLivingSpace(double livingSpace) {
        this.livingSpace = livingSpace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ApartmentBuilding)) return false;
        ApartmentBuilding that = (ApartmentBuilding) o;
        return getAmount() == that.getAmount() && Double.compare(that.getLivingSpace(), getLivingSpace()) == 0 &&
                Objects.equals(getType(), that.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getAmount(), getLivingSpace());
    }

    @Override
    public void info() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return super.toString() +
                "ApartmentBuilding{" +
                "type='" + type + '\'' +
                ", bedroomsAmount=" + amount +
                ", livingSpace=" + livingSpace +
                '}';
    }
}
