package model;
import java.util.List;

public class Order {
    List<Detail> detailsList;
    Cashier cashier;
    Customer customer;

    public Order(List<Detail> detailsList, Cashier cashier, Customer customer) {
        this.detailsList = detailsList;
        this.cashier = cashier;
        this.customer = customer;
    }

    public List<Detail> getDetailsList() {
        return detailsList;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        StringBuilder customersOrder = new StringBuilder();
        for (Detail detail: detailsList){
            customersOrder.append(detail.toString()).append("\n");
        }
        return customersOrder.toString();
    }
}
