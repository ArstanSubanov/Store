package service;

import enums.Measure;
import model.Cashier;
import model.Category;
import model.Customer;
import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Transaction implements Operation{
    HashMap<Integer, Category> categories;
    List<Product> products;

    @Override
    public Customer getCustomer(int id) {
        return null;
    }

    @Override
    public Cashier getCashier(int id) {
        return null;
    }

    @Override
    public void createData() {
        this.categories.put(1, new Category("Молочные продукты"));
        this.categories.put(2, new Category("Фрукты и овощи"));
        this.categories.put(3, new Category("Оружие"));

        this.products.add(new Product("Молоко", 87, Measure.L, categories.get(1), 1));
        this.products.add(new Product("Творог", 125, Measure.KG, categories.get(1), 2));
        this.products.add(new Product("Кефир", 104, Measure.L, categories.get(1), 3));

        this.products.add(new Product("Огурцы", 57, Measure.KG, categories.get(2), 1));
        this.products.add(new Product("Яблоки", 89, Measure.KG, categories.get(2), 2));
        this.products.add(new Product("Лук", 56, Measure.KG, categories.get(2), 3));

        this.products.add(new Product("Ядерная бомба", 120000000, Measure.PIECE, categories.get(3), 1));
        this.products.add(new Product("Вонючие носки", 100, Measure.PIECE, categories.get(3), 2));
        this.products.add(new Product("Цианистый калий", 1000, Measure.G, categories.get(3), 3));

    }

    @Override
    public void showCategory() {
        for (Map.Entry<Integer, Category> entry: categories.entrySet()){
            System.out.println("Id: "+ entry.getKey() + " категория: "+ entry.getValue());
        }
        System.out.println("Выберите категорию (Нужно ввести Id категории): ");
    }

    @Override
    public void showProductByCategory(int categoryId) {
        for (Product product: products){
            if (product.getCategory().equals(categories.get(categoryId))){
                System.out.println(product);
            }
        }
        System.out.println("Выберите продукт (Нужно ввести Id продукта): ");

    }
}
