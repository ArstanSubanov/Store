package model;
import java.util.List;

public class Order {
    private List<Detail> detailsList;
    private Customer customer;

    private double total;

    public Order(List<Detail> detailsList, Customer customer) {
        this.detailsList = detailsList;
        this.customer = customer;
    }

    public void setDetailsList(List<Detail> detailsList) {
        this.detailsList = detailsList;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<Detail> getDetailsList() {
        return detailsList;
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
