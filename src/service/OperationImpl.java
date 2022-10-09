package service;

import enums.Singleton;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OperationImpl implements Operation {
    Map<Integer, Category> categories = Singleton.INSTANCE.getCategories();
    Map<Integer, Cashier> cashiers = Singleton.INSTANCE.getCashiers();
    List<Product> products = Singleton.INSTANCE.getProducts();

    Map<String, Customer> customers = Singleton.INSTANCE.getCustomers();
    List<Discount> discounts = Singleton.INSTANCE.getDiscounts();

    @Override
    public Cashier getCashier(int id) {
        return cashiers.get(id);
    }

    @Override
    public void showCategory() {
        for (Map.Entry<Integer, Category> entry : categories.entrySet()) {
            System.out.println("Id: " + entry.getKey() + " категория: " + entry.getValue());
        }
        System.out.println("Выберите категорию (Нужно ввести Id категории): ");
    }

    @Override
    public void showProductByCategory(int categoryId) {
        for (Product product : products) {
            if (product.getCategory().equals(categories.get(categoryId))) {
                System.out.println(product);
            }
        }
        System.out.println("Выберите продукт (Нужно ввести Id продукта): ");

    }

    @Override
    public Detail addProduct(Product product, int amount) {
        Discount discount = null;
        for (Discount discount1 : discounts) {
            if (discount1.getCategory().equals(product.getCategory()) && discount1.getProduct() == null) {
                discount = discount1;
            } else if (discount1.getCategory().equals(product.getCategory()) && discount1.getProduct().equals(product)) {
                discount = discount1;

            }

        }
        return new Detail(product, discount, amount);
    }

    @Override
    public Order calculateOrder(Order order) {
        ArrayList<Detail> details = new ArrayList<>(order.getDetailsList());
        double price = 0;
        for (Detail detail : details) {
            if (detail.getDiscount() != null) {
                price += (detail.getProduct().getPrice() - ((detail.getProduct().getPrice() * detail.getDiscount().getDiscount()) / 100)) * detail.getAmount();
            } else price += detail.getProduct().getPrice() * detail.getAmount();
        }
        if (order.getCustomer().getId() != 0) {
            price -= order.getCustomer().isUseBonus();
            order.getCustomer().setBonus(order.getCustomer().getBonus() - order.getCustomer().isUseBonus());
        }
        order.setTotal(price);
        return order;
    }

    @Override
    public Product getProductByCategoryAndId(Category category, int id) {
        for (Product product : products) {
            if (product.getCategory().equals(category) && product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void printCheck(Order order, Cashier cashier) {
        ArrayList<Detail> details = new ArrayList<>(order.getDetailsList());
        System.out.println("Продукт  Цена  Скидка в %  Кол-во Стоимость со скидкой");

        for (Detail detail : details) {
            if (detail.getDiscount() != null) {
                System.out.println(detail.getProduct().getName() + " " + detail.getProduct().getPrice() + " " + detail.getDiscount().getDiscount() + " " + detail.getAmount() + " " + (detail.getProduct().getPrice() - ((detail.getProduct().getPrice() * detail.getDiscount().getDiscount()) / 100)) * detail.getAmount());
            } else
                System.out.println(detail.getProduct().getName() + " " + detail.getProduct().getPrice() + " 0 " + detail.getAmount() + " " + detail.getProduct().getPrice() * detail.getAmount());
        }
        if (order.getCustomer().getId() != 0) {
            System.out.println("Вы использовали " + order.getCustomer().isUseBonus() + "бонусов");
            System.out.println(order.getCustomer());
        }
        System.out.println("Итого: " + order.getTotal() + " сом");
        System.out.println("Кассир: " + cashier.getName());

    }

    @Override
    public Category getCategoryById(int categoryId) {
        return categories.get(categoryId);
    }
}
