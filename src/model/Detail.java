package model;

public class Detail {
    Product product;
    Discount discount;

    public Detail(Product product, Discount discount) {
        this.product = product;
        this.discount = discount;
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
}
