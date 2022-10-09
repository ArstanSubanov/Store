package service;

import exceptions.CustomerNotFoundException;
import model.Customer;

public interface CustomerOperations {
    Customer signIn(String login, String password) throws CustomerNotFoundException;
    void addCustomer();
}
