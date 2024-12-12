package VendingMachine;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class MenuProductions {
    private final List<Product> menuProductions = new ArrayList<>() {
        {
            add(new Product("Выход", 0));
            add(new Product("Coca Cola", 10.00));
            add(new Product("Water", 5.00));
            add(new Product("Juice", 5.00));
        }
    };

    public void printMenuProductions() {
        for (int i = 1; i < menuProductions.size(); i++) {
            System.out.println(i + " - " + menuProductions.get(i));
        }
        System.out.println();
        System.out.println("0 - Выход");
    }

    public Product selectProduct() {
        int selected = 0;

        System.out.print("Выберите товар из списка: ");

        try {
            selected = Common.Input.getInput().nextInt();
        } catch (InputMismatchException ex) {
            System.out.println("Введите корректную сумму или 0 для отмены!");
            selectProduct();
        }

        return menuProductions.get(selected);
    }

    public List<Product> getMenuProductions() {
        return menuProductions;
    }
}