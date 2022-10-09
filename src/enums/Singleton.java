package enums;

import model.*;
import service.Transaction;

import java.util.*;

public enum Singleton {
    INSTANCE;
    private Map<Integer, Category> categories;
    private Map<Integer, Cashier> cashiers;

    private List<Product> products;

    private Map<String, Customer> customers;
    private List<Discount> discounts;

    private final Transaction transaction = new Transaction();

    public Transaction getTransaction() {
        return transaction;
    }

    private final Scanner scanner = new Scanner(System.in);

    public Scanner getScanner() {
        return scanner;
    }

    public Map<Integer, Category> getCategories() {
        return categories;
    }

    public void setCategories(Map<Integer, Category> categories) {
        this.categories = categories;
    }

    public Map<Integer, Cashier> getCashiers() {
        return cashiers;
    }

    public void setCashiers(Map<Integer, Cashier> cashiers) {
        this.cashiers = cashiers;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Map<String, Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Map<String, Customer> customers) {
        this.customers = customers;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<Discount> discounts) {
        this.discounts = discounts;
    }

    Singleton() {
        Map<Integer, Category> categoryHashMap = new HashMap<>();
        categoryHashMap.put(1, new Category("Молочные продукты"));
        categoryHashMap.put(2, new Category("Фрукты и овощи"));
        categoryHashMap.put(3, new Category("Оружие"));
        this.categories = categoryHashMap;

        ArrayList<Product> productArrayList = new ArrayList<>();

        productArrayList.add(new Product("Молоко", 87, Measure.L, categories.get(1), 1));
        productArrayList.add(new Product("Творог", 125, Measure.KG, categories.get(1), 2));
        productArrayList.add(new Product("Кефир", 104, Measure.L, categories.get(1), 3));

        productArrayList.add(new Product("Огурцы", 57, Measure.KG, categories.get(2), 1));
        productArrayList.add(new Product("Яблоки", 89, Measure.KG, categories.get(2), 2));
        productArrayList.add(new Product("Лук", 56, Measure.KG, categories.get(2), 3));

        productArrayList.add(new Product("Ядерная бомба", 120000000, Measure.PIECE, categories.get(3), 1));
        productArrayList.add(new Product("Вонючие носки", 100, Measure.PIECE, categories.get(3), 2));
        productArrayList.add(new Product("Цианистый калий", 1000, Measure.G, categories.get(3), 3));

        this.products = productArrayList;

        Map<String, Customer> customerList = new HashMap<>();
        Customer customer0 = new Customer(0, 0, "adam", "qwerty");
        Customer customer = new Customer(1, 50, "adam1", "qwerty");
        Customer customer1= new Customer(2, 80, "adam3", "qwerty");
        Customer customer2 = new Customer(3, 120, "adam4", "qwerty");

        customerList.put(customer0.getLogin(), customer0);
        customerList.put(customer.getLogin(), customer);
        customerList.put(customer1.getLogin(), customer1);
        customerList.put(customer2.getLogin(), customer2);

        this.customers = customerList;

        List<Discount> discountList = new ArrayList<>();

        //скидка на 1 продукт или на всю категорию
        discountList.add(new Discount(categories.get(1), products.get(1), 10));
        discountList.add(new Discount(categories.get(3), 20));
        this.discounts = discountList;

        Map<Integer, Cashier> cashierHashMap = new HashMap<>();
        Cashier cashier = new Cashier("Bob Dolson", "dolson2000", "dolson123", 1);
        Cashier cashier1 = new Cashier("Clare Monroe", "claresidney", "password", 2);
        cashierHashMap.put(cashier.getId(), cashier);
        cashierHashMap.put(cashier1.getId(), cashier1);
        this.cashiers = cashierHashMap;

    }
}
