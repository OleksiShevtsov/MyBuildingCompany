package laba.solvd.persons;

public enum Speciality {
    DRIVER("driver"),
    WORKER("worker"),
    TASKMASTER("taskmaster"),
    SECURITY_GUARD("securityGuard"),
    DIRECTOR("director"),
    COUNTER("counter");

    private final String speciality;

    Speciality(String speciality) {
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return speciality;
    }
}
