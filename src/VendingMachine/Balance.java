package VendingMachine;

import Exceptions.NoMoneyException;

import java.util.InputMismatchException;

public class Balance {
    private double balance = 0;

    public void addMoney() {
        System.out.print("Введите сумму для пополнения баланса:");

        try {
            balance += Common.Input.getInput().nextDouble();
        } catch (InputMismatchException ex) {
            System.out.println("Введите корректную сумму или 0 для отмены!");
            addMoney();
        }
    }

    public void removeMoney(Product product) throws NoMoneyException {
        if (balance < product.getPrice()) {
            throw new NoMoneyException();
        }
        balance -= product.getPrice();
    }

    public void printBalance() {
        System.out.println("###---------------------------------------------###");

        System.out.println("\nWelcome to Vending Machine");
        System.out.println();
        System.out.println(this);
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Текущий баланс: " + balance + System.lineSeparator();
    }
}
