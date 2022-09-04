package model;

import java.util.List;

public class Check {
    private Order order;
    private Cashier cashier;

    public Check(Order order, Cashier cashier) {
        this.order = order; this.cashier = cashier;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }
}
