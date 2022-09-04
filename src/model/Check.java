package model;

import java.util.List;

public class Check {
    private Order order;

    public Check(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
