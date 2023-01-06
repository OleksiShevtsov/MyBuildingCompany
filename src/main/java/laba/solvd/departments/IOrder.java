package laba.solvd.departments;

import laba.solvd.buildings.Classification;
import laba.solvd.buildings.Estate;

import java.util.List;
import java.util.Map;

public interface IOrder {
    void makeOrder();
    List<Estate> prepareOrder(Map<Classification, Integer> order);
}
