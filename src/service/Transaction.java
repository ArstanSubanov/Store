package service;

import com.sun.org.apache.xpath.internal.operations.Or;
import enums.Measure;
import model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Transaction implements Operation{
    HashMap<Integer, Category> categories;
    HashMap<Integer, Cashier> cashiers;
    List<Product> products;

    HashMap<Integer, Customer> customers;
    List<Discount> discounts;

    @Override
    public Customer getCustomer(int id) {
        return customers.get(id);
    }

    @Override
    public Cashier getCashier(int id) {
        return cashiers.get(id);
    }

    @Override
    public void createData() {
        HashMap<Integer, Category> categoryHashMap = new HashMap<>();
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

        HashMap<Integer, Customer> customerList = new HashMap<>();
        Customer customer0 = new Customer(0, 0);
        Customer customer = new Customer(1, 50);
        Customer customer1= new Customer(2, 80);
        Customer customer2 = new Customer(3, 120);

        customerList.put(customer0.getId(), customer0);
        customerList.put(customer.getId(), customer);
        customerList.put(customer1.getId(), customer1);
        customerList.put(customer2.getId(), customer2);

        this.customers = customerList;

        List<Discount> discountList = new ArrayList<>();

        //скидка на 1 продукт или на всю категорию
        discountList.add(new Discount(categories.get(1), getProductByCategoryAndId(categories.get(1), 1), 10));
        discountList.add(new Discount(categories.get(3), 20));
        this.discounts = discountList;

        HashMap<Integer, Cashier> cashierHashMap = new HashMap<>();
        Cashier cashier = new Cashier("Bob Dolson", "dolson2000", "dolson123", 1);
        Cashier cashier1 = new Cashier("Clare Monroe", "claresidney", "password", 2);
        cashierHashMap.put(cashier.getId(), cashier);
        cashierHashMap.put(cashier1.getId(), cashier1);
        this.cashiers = cashierHashMap;


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

    @Override
    public Detail addProduct(Product product, int amount) {
        Discount discount = null;
        for (Discount discount1: discounts){
            if (discount1.getCategory().equals(product.getCategory()) && discount1.getProduct() == null){
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
        for (Detail detail: details){
            if (detail.getDiscount()!=null){
                price += (detail.getProduct().getPrice() - ((detail.getProduct().getPrice() * detail.getDiscount().getDiscount()) / 100)) * detail.getAmount();
            }else price += detail.getProduct().getPrice() * detail.getAmount();
        }
        if (order.getCustomer().getId() != 0){
            price -= order.getCustomer().isUseBonus();
            order.getCustomer().setBonus(order.getCustomer().getBonus() - order.getCustomer().isUseBonus());
        }
        order.setTotal(price);
        return order;
    }

    public Product getProductByCategoryAndId(Category category, int id){
        for (Product product: products){
            if (product.getCategory().equals(category) && product.getId() == id){
                return product;
            }
        }
        return null;
    }

    @Override
    public void printCheck(Order order, Cashier cashier) {
        ArrayList<Detail> details = new ArrayList<>(order.getDetailsList());
        System.out.println("Продукт  Цена  Скидка в %  Кол-во Стоимость со скидкой");

        for (Detail detail: details){
            if (detail.getDiscount()!=null){
                System.out.println(detail.getProduct().getName()+" "+detail.getProduct().getPrice()+" "+detail.getDiscount().getDiscount()+ " "+detail.getAmount()+" "+(detail.getProduct().getPrice() - ((detail.getProduct().getPrice() * detail.getDiscount().getDiscount()) / 100)) * detail.getAmount());
            }else System.out.println(detail.getProduct().getName()+" "+detail.getProduct().getPrice()+" 0 "+detail.getAmount()+" "+detail.getProduct().getPrice()*detail.getAmount());
        }
        if (order.getCustomer().getId()!=0){
            System.out.println("Вы использовали "+order.getCustomer().isUseBonus()+ "бонусов");
            System.out.println(order.getCustomer());
        }
        System.out.println("Итого: "+ order.getTotal()+" сом");
        System.out.println("Кассир: "+ cashier.getName());

    }

    public Category getCategoryById(int categoryId){
        return categories.get(categoryId);
    }
}
