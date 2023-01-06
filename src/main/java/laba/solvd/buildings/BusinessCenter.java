package laba.solvd.buildings;

import java.util.Objects;

public class BusinessCenter extends Estate {
    private boolean isParkingPresent;

    public BusinessCenter(Classification classification, String address, int costOfAccommodation, int amount, boolean isParkingPresrnt) {
        super(classification, address, costOfAccommodation, amount);
        this.isParkingPresent = isParkingPresrnt;
    }

    public BusinessCenter(Classification classification, String address, int costOfAccommodation, int amount) {
        super(classification, address, costOfAccommodation, amount);
    }

    public boolean isParkingPresent() {
        return isParkingPresent;
    }

    public void setParkingPresent(boolean parkingPresent) {
        isParkingPresent = parkingPresent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BusinessCenter)) return false;
        if (!super.equals(o)) return false;
        BusinessCenter that = (BusinessCenter) o;
        return getAmount() == that.getAmount() && isParkingPresent() == that.isParkingPresent();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getAmount(), isParkingPresent());
    }

    @Override
    public String toString() {
        return super.toString() +
                "BusinessCenter{" +
                "officesNumber=" + amount +
                ", isParkingPresrnt=" + isParkingPresent +
                '}';
    }

    @Override
    public void info() {
        System.out.println(this);
    }
}
