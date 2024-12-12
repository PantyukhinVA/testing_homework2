import Exceptions.NoMoneyException;
import Exceptions.ZeroBalanceException;
import VendingMachine.Product;
import VendingMachine.VendingMachine;

import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();

        int choice;

        try {
            while (true) {
                try {
                    vm.displayMenu();

                    choice = Common.Input.getInput().nextInt();

                    switch (choice) {
                        case 1:
                            vm.addMoney();
                            break;
                        case 2:
                            vm.displayProductions();
                            Product selectedProduct = vm.selectProduct();

                            if (selectedProduct.getName().equals("Выход")) {
                                continue;
                            } else {
                                vm.buyProduct(selectedProduct);
                                System.out.printf("Напиток %s успешно оплачен!%n", selectedProduct.getName());
                            }
                            break;
                        default:
                            System.out.println("Выберите пункт меню!");
                            break;
                    }
                } catch (InputMismatchException ex) {
                    System.out.println("Выберите существующий пункт меню!");
                } catch (ZeroBalanceException | NoMoneyException ex) {
                    System.out.println(ex.getMessage());
                } catch (Exception ex) {
                    System.out.println("Неизвестная ошибка!" + System.lineSeparator() + ex.getMessage());
                }

            }
        } finally {
            Common.Input.close();
        }
    }
}