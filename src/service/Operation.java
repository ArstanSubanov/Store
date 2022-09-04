package service;

import model.Cashier;
import model.Category;
import model.Customer;

import java.util.List;

public interface Operation {

    Customer getCustomer(int id);

    Cashier getCashier(int id);

    void createData();

    void showCategory();

    void showProductByCategory(int categoryId);

}
