package model;

import enums.Measure;

public class Product {
    private int id;
    private String name;
    private double price;
    private int amount;
    private Measure measure;
    private Category category;

    public Product(String name, double price, int amount, Measure measure, Category category) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.measure = measure;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Категория продукта: " + category.getName() +"\n"+
                "id продукта: " + id +"\n"+
                "Название продукта:" + name + "\n" +
                "Цена: " + price +"\n"+
                "Объём :" + amount +
                " " + measure.getName() +"\n";
    }
}
