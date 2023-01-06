package laba.solvd.buildings;

import java.util.Objects;

public class Parking extends Estate {
    private int pricePerDay;

    public Parking(Classification classification, String address, int costOfAccommodation, int amount, int pricePerDay) {
        super(classification, address, costOfAccommodation, amount);
        this.pricePerDay = pricePerDay;
    }

    public Parking(Classification classification, String address, int costOfAccommodation, int amount) {
        super(classification, address, costOfAccommodation, amount);
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Parking{" +
                "parkingLotsNumber=" + amount +
                ", pricePerDay=" + pricePerDay +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Parking)) return false;
        Parking parking = (Parking) o;
        return getAmount() == parking.getAmount() && getPricePerDay() == parking.getPricePerDay();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAmount(), getPricePerDay());
    }

    @Override
    public void info() {
        System.out.println(this);
    }
}
