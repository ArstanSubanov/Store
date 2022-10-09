package service;

import enums.Singleton;
import exceptions.CustomerNotFoundException;
import model.Customer;
import model.Detail;
import model.Order;
import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Transaction {
    public void buy(){
        CustomerOperations customerOperations = new CustomerOperationsImpl();
        Operation operation = new OperationImpl();
        List<Detail> details = new ArrayList<>();
        Scanner scanner = Singleton.INSTANCE.getScanner();
        System.out.println("Please, enter your login and password: ");
        String login = scanner.next();
        String password = scanner.next();
        Customer customer;
        try {
            customer = customerOperations.signIn(login, password);
            while (true){
                operation.showCategory();
                System.out.println("Choose category: ");
                int categoryId = scanner.nextInt();
                operation.showProductByCategory(categoryId);
                int productId = scanner.nextInt();
                Product product = operation.getProductByCategoryAndId(operation.getCategoryById(categoryId), productId);
                System.out.println("Enter amount pls: ");
                int amount = scanner.nextInt();
                details.add(operation.addProduct(product, amount));
                System.out.println("Хотите продолжить покупку? y/n");
                String answer = scanner.next();
                if (answer.equals("n")) break;
            }
            if (customer.getBonus() != 0){
                System.out.println("Сколько бонусов вы хотите использовать? 1 сом = 1 бонус");
                int useBonus = scanner.nextInt();
                customer.setUseBonus(useBonus);
            }
            operation.printCheck(operation.calculateOrder(new Order(details, customer)), operation.getCashier(1));
            scanner.close();
        }catch (CustomerNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
