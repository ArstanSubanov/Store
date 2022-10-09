import enums.Singleton;
import exceptions.CustomerNotFoundException;
import model.Customer;
import service.CustomerOperations;
import service.CustomerOperationsImpl;
import service.Transaction;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Transaction transaction = Singleton.INSTANCE.getTransaction();
        transaction.buy();
    }
}
