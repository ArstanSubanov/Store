package service;

import enums.Singleton;
import exceptions.CustomerNotFoundException;
import model.Customer;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CustomerOperationsImpl implements CustomerOperations{
    @Override
    public Customer signIn(String login, String password) throws CustomerNotFoundException{
        Singleton singleton = Singleton.INSTANCE;
        Map<String, Customer> customers = singleton.getCustomers();
        Customer customer;
        if (customers.get(login)==null){
            throw new CustomerNotFoundException("This login not found");
        }else if (customers.get(login).getPassword().equals(password)){
            customer = customers.get(login);
        }else throw new CustomerNotFoundException("Failed login or password");

        return customer;


    }

    @Override
    public void addCustomer() {
        Singleton singleton = Singleton.INSTANCE;
        Map<String, Customer> customers = singleton.getCustomers();
        Scanner scanner = singleton.getScanner();
        System.out.println("Please, enter new login: ");
        String login = scanner.next();
        System.out.println("Please, enter your password: ");
        String password = scanner.next();
        int maxCustomerId = customers.values().stream().max((x,y) -> x.getId()-y.getId()).get().getId();
        if (customers.get(login)==null){
            customers.put(login, new Customer(++maxCustomerId, 0, login, password));
            singleton.setCustomers(customers);
        }else {
            System.out.println("This login found in database.");
            addCustomer();

        }

    }


}
