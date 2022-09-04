package model;

import enums.Measure;

public class Product {
    private int id;
    private String name;
    private double price;
    private Measure measure;
    private Category category;

    public Product(String name, double price, Measure measure, Category category, int id) {
        this.name = name;
        this.price = price;
        this.measure = measure;
        this.category = category;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Категория продукта: " + category.getName() +"\n"+
                "id продукта: " + id +"\n"+
                "Название продукта:" + name + "\n" +
                "Цена: " + price +"\n";
    }
}
