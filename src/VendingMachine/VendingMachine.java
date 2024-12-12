package VendingMachine;

import Exceptions.NoMoneyException;
import Exceptions.ZeroBalanceException;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private final Balance balance;
    private final MenuProductions menuProductions;

    public final Map<Integer, String> menu = new HashMap<>() {
        {
            put(1, "Внести деньги на внутренний счет");
            put(2, "Выбрать напиток");
        }
    };

    public VendingMachine() {
        this.balance = new Balance();
        this.menuProductions = new MenuProductions();
    }

    public void addMoney() {
        balance.addMoney();
    }

    public Product selectProduct() {
        return menuProductions.selectProduct();
    }

    public void displayMenu() {
        balance.printBalance();
        printMenu();
    }

    public void displayProductions() throws ZeroBalanceException {
        if (balance.getBalance() == 0) {
            throw new ZeroBalanceException();
        }

        balance.printBalance();
        menuProductions.printMenuProductions();
    }

    public void printMenu() {
        menu.forEach((key, value) -> {
                    System.out.println(key + " - " + value);
                }
        );

        System.out.print("Выберите пункт меню:");
    }

    public void buyProduct(Product product) throws NoMoneyException {
        balance.removeMoney(product);
    }
}
