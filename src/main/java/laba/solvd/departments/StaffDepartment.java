package laba.solvd.departments;

import laba.solvd.persons.Countable;
import laba.solvd.persons.Employee;
import laba.solvd.persons.Speciality;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class StaffDepartment implements IDepartment, Countable {
    Scanner scanner;
    LinkedList<Employee> employees;
    Logger LOGGER;

    public StaffDepartment() {
        scanner = new Scanner(System.in);
        employees = new LinkedList<>();
        employees.add(new Employee(1, "Lucke", "Smith", 34, Speciality.DRIVER,
                10, 5000));
        employees.add(new Employee(2, "Kelly", "Silent", 25, Speciality.WORKER,
                3, 6000));
        employees.add(new Employee(3, "John", "Wills", 54, Speciality.TASKMASTER,
                10, 10000));
        employees.add(new Employee(4, "Will", "Harvort", 36, Speciality.SECURITY_GUARD,
                15, 12000));
        employees.add(new Employee(5, "Jeffry", "Owen", 56, Speciality.DIRECTOR,
                33, 20000));
        employees.add(new Employee(6, "Kate", "Jones", 30, Speciality.COUNTER, 5,
                11000));
        LOGGER = LogManager.getLogger(StaffDepartment.class);

    }


    @Override
    public void open() {
        int option;
        do {
            System.out.println("\nSelect an option: \n 1 - add new employee, 2 - remove employee, 3 - print employees, " +
                    "4 - count employee income, 5 - display employee with max salary, " +
                    "6 - sort employees by salary, 0 - exit");
            System.out.print("Make your choice: ");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    addNewEmployee();
                    break;
                case 2:
                    removeEmployee();
                    break;
                case 3:
                    printReport();
                    break;
                case 4:
                    System.out.print("Enter id of employee: ");
                    int id = scanner.nextInt();
                    double income = countIncome(id);
                    if (income == -1) {
                        System.out.println("There is not employee with such id");
                    } else {
                        System.out.println("Income = " + income);
                    }
                    break;
                case 5:
                    maxSalary();
                    break;
                case 6:
                    sortedBySalary();
                    break;
                case 0:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Error");
            }
        } while (option != 0);
    }

    private void addNewEmployee() {
        int id = employees.getLast().getId() + 1;
        scanner.nextLine();
        System.out.println("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter speciality: ");
        String speciality = scanner.nextLine();
        Speciality s = Speciality.valueOf(speciality.toUpperCase());
        System.out.println("Enter years of experience: ");
        int experience = scanner.nextInt();
        System.out.println("Enter employee's salary: ");
        double salary = scanner.nextDouble();
        employees.add(new Employee(id, firstName, lastName, age, s, experience, salary));
    }

    private void removeEmployee() {
        System.out.println("Enter ID of employee: ");
        int id = scanner.nextInt();

        for (Employee e : employees) {
            if (id == e.getId()) {
                employees.remove(e);
                break;
            }
        }

    }

    @Override
    public <T> void printReport() {
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    @Override
    public double countIncome(int id) {
        double income = 0;
        for (int i = 0; i < employees.size(); i++) {
            if (id == employees.get(i).getId()) {
                if (employees.get(i).getYearsOfExperience() < 11) {
                    income = (employees.get(i).getSalary() + (employees.get(i).getSalary() * 0.15)) -
                            (employees.get(i).getSalary() * TAX);
                } else if (employees.get(i).getYearsOfExperience() > 10 && employees.get(i).getYearsOfExperience() < 21) {
                    income = (employees.get(i).getSalary() + (employees.get(i).getSalary() * 0.25)) -
                            (employees.get(i).getSalary() * TAX);
                } else {
                    income = (employees.get(i).getSalary() + (employees.get(i).getSalary() * 0.4)) -
                            (employees.get(i).getSalary() * TAX);
                }
            }
        }
        return income;
    }

    public void maxSalary() {
        employees.stream().max(Comparator.comparing(Employee::getSalary)).ifPresent(System.out::println);
    }

    public void sortedBySalary() {
        List<Employee> sortedEmployees = employees.stream().
                sorted(Comparator.comparing(Employee::getSalary)).
                collect(Collectors.toList());
        sortedEmployees.forEach(System.out::println);
    }
}
