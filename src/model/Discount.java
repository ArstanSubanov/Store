package model;

public class Discount {
    private Category category;
    private Product product;
    private int discount;

    public Discount(Category category, Product product, int discount) {
        this.category = category;
        this.product = product;
        this.discount = discount;
    }

    public Discount(Category category, int discount) {
        this.category = category;
        this.discount = discount;
    }

    public Discount(Product product, int discount) {
        this.product = product;
        this.discount = discount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return  "Категория :" + category + product +
                " Скидка" + discount;
    }
}
