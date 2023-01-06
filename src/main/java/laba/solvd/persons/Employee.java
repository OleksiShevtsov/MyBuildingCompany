package laba.solvd.persons;

public class Employee extends Person {
    private int id;
    private Speciality speciality;
    private int yearsOfExperience;
    private double salary;

    public Employee(int id, String firstName, String lastName, int age, Speciality speciality, int yearsOfExperience,
                    double salary) {
        super(firstName, lastName, age);
        this.id = id;
        this.speciality = speciality;
        this.yearsOfExperience = yearsOfExperience;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id + ", " +
                super.toString() +
                ", speciality=" + speciality +
                ", yearsOfExperience=" + yearsOfExperience +
                ", salary=" + salary +
                "} " ;
    }
}
