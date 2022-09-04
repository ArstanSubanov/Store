package model;

public class Detail {
    Product product;
    Discount discount;

    private int amount;

    public Detail(Product product, Discount discount, int amount) {
        this.product = product;
        this.discount = discount;
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
