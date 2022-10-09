package service;

import model.*;

import java.util.List;

public interface Operation {

    Cashier getCashier(int id);
    void showCategory();

    void showProductByCategory(int categoryId);

    Detail addProduct(Product product, int amount);

    Order calculateOrder(Order order);

    void printCheck(Order order, Cashier cashier);
    Product getProductByCategoryAndId(Category category, int id);

    Category getCategoryById(int categoryId);

}
