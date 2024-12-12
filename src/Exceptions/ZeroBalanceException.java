package Exceptions;

import java.io.IOException;

public class ZeroBalanceException extends IOException {
    public ZeroBalanceException() {
        super("Необходимо пополнить баланс!");
    }
}
