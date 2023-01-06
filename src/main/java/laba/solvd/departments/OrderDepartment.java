package laba.solvd.departments;

import laba.solvd.buildings.*;
import laba.solvd.exceptions.InvalidKeyException;
import laba.solvd.buildings.ApartmentBuilding;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


import java.util.*;

public class OrderDepartment<T extends Estate> implements IDepartment, IOrder {
    Logger LOGGER;
    Scanner scanner;
    Estate[] availableEstates;

    public OrderDepartment() {
        scanner = new Scanner(System.in);
        availableEstates = new Estate[]{
                new ApartmentBuilding(Classification.FLAT, "Park Lane", 110000,
                        100, "Business", 6100),
                new Parking(Classification.PARKING_LOT, "4 street", 3500, 15, 50),
                new BusinessCenter(Classification.OFFICE, "Heroes ave", 35000, 74, true)
        };
        LOGGER = LogManager.getLogger(OrderDepartment.class);
    }

    @Override
    public void open() {
        int menu;
        do {
            System.out.println("\nMain menu: \n1 - to order, 2 - print report 0 - exit");
            System.out.print("Make your choice: ");
            menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    makeOrder();
                    break;
                case 2:
                    printReport();
                    break;
                case 0:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Error");
            }
        } while (menu != 0);
    }

    @Override
    public<T> void printReport() {
        for (Estate e : availableEstates) {
            System.out.println(e);
        }
    }

    public void makeOrder() {
        Map<Classification, Integer> order = new HashMap<>();
        int key;
        do {
            System.out.println("Enter: 1 - flat, 2 - office, 3 - parking lot, 0 - order is completed");
            key = scanner.nextInt();
            switch (key) {
                case 1:
                    int flatNumber;
                    do {
                        System.out.print("Enter positive amount of flats in the apartment you want to buy: ");
                        flatNumber = scanner.nextInt();
                    } while (flatNumber < 1);
                    if (order.containsKey(Classification.FLAT)) {
                        flatNumber += order.get(Classification.FLAT);
                    }
                    order.put(Classification.FLAT, flatNumber);
                    break;

                case 2:
                    int officeNumber;
                    do {
                        System.out.println("Enter positive amount of offices in the business center you want to buy: ");
                        officeNumber = scanner.nextInt();
                    } while (officeNumber < 1);

                    if (order.containsKey(Classification.OFFICE)) {
                        officeNumber += order.get(Classification.OFFICE);
                    }
                    order.put(Classification.OFFICE, officeNumber);

                    break;

                case 3:
                    int parkingLotsNumber;
                    do {
                        System.out.print("Enter positive amount of parking lots in the parking you want to buy: ");
                        parkingLotsNumber = scanner.nextInt();
                    } while (parkingLotsNumber < 1);

                    if (order.containsKey(Classification.PARKING_LOT)) {
                        parkingLotsNumber += order.get(Classification.PARKING_LOT);
                    }
                    order.put(Classification.PARKING_LOT, parkingLotsNumber);
                    break;

                case 0:
                    System.out.println("Order is completed.");
                    break;
                default:
                    try {
                        throw new InvalidKeyException(key);
                    } catch (InvalidKeyException e) {
                        LOGGER.info(InvalidKeyException.message);
                    }
            }
        } while (key != 0);

        List<Estate> list = prepareOrder(order);
        if (list.isEmpty()) {
            System.out.println("Order is cancelled");
        } else {
            System.out.println("Confirmed order contains:");
            double totalPrice = 0;
            for (Estate e : list) {
                totalPrice += e.getCostOfAccommodation() * e.getAmount();
                System.out.println(e);
            }
            System.out.println("Total price: " + totalPrice);
        }
    }

    public List<Estate> prepareOrder(Map<Classification, Integer> order) {
        List<Estate> list = new ArrayList<>();
        for (Map.Entry<Classification, Integer> e : order.entrySet()) {
            for (Estate availableEstate : availableEstates) {
                if (e.getKey().equals(availableEstate.getClassification())) {
                    if (e.getValue() <= availableEstate.getAmount()) {
                        Estate estate = new Estate(e.getKey(), availableEstate.getAddress(),
                                availableEstate.getCostOfAccommodation(), e.getValue());
                        list.add(estate);
                        break;
                    } else {
                        try {
                            throw new IllegalArgumentException("Not enough of " + e.getKey());
                        } catch (IllegalArgumentException i) {
                            LOGGER.info(i.getMessage());
                        }
                        return new ArrayList<>();
                    }
                }
            }
        }
        return list;
    }
}

