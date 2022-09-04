package model;

import enums.Measure;

import java.util.Objects;

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
        return   "id продукта: " + id +". "+
                "Название продукта:" + name + ". " +
                "Цена: " + price +"сом";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Double.compare(product.price, price) == 0 && Objects.equals(name, product.name) && measure == product.measure && Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, measure, category);
    }
}
