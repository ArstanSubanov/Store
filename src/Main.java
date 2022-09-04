import model.Detail;
import model.Order;
import service.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Transaction transaction = new Transaction();
        List<Detail> details = new ArrayList<>();
        int customerId = 0;
        transaction.createData();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать!");
        System.out.println("Являетесь ли вы нашим зарегистрированным клиентом? [да/нет]");
        if (scanner.nextLine().equals("да")) {
            System.out.println("Введите пожалуйста свой Id клиента: ");
            customerId = scanner.nextInt();
            System.out.println(transaction.getCustomer(customerId));
            System.out.println();
        }
        boolean buyStatus = true;

        while(buyStatus){
            System.out.println("Хотите продолжить покупку[да/нет]: ");
            String status = scanner.nextLine();
            if (status.equals("нет")){
                buyStatus = false;
            } else if (status.equals("да")) {
                transaction.showCategory();
                int categoryId = scanner.nextInt();
                transaction.showProductByCategory(categoryId);
                int productId = scanner.nextInt();
                System.out.println("Введите количество продукта: ");
                int amount = scanner.nextInt();
                details.add(transaction.addProduct(transaction.getProductByCategoryAndId(transaction.getCategoryById(categoryId), productId), amount));
            }
        }
        if (transaction.getCustomer(customerId).getId()!=0){
            System.out.println("Сколько бонусов вы хотите использовать? 1 сом = 1 бонус");
            int useBonus = scanner.nextInt();
            transaction.getCustomer(customerId).setUseBonus(useBonus);
        }
        transaction.printCheck(transaction.calculateOrder(new Order(details, transaction.getCustomer(customerId))), transaction.getCashier(1));
        scanner.close();


    }
}
