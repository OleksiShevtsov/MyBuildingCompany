package laba.solvd.buildings;

public enum Classification {
    FLAT("flat"),
    OFFICE("office"),
    PARKING_LOT("parkingLot");

    private final String classification;

    Classification(String classification) {
        this.classification = classification;
    }

    public String getClassification() {
        return classification;
    }
}
