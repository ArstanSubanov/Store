package service;

import model.*;

import java.util.List;

public interface Operation {

    Customer getCustomer(int id);

    Cashier getCashier(int id);

    void createData();

    void showCategory();

    void showProductByCategory(int categoryId);

    Detail addProduct(Product product, int amount);

    Order calculateOrder(Order order);

    void printCheck(Order order, Cashier cashier);

}
