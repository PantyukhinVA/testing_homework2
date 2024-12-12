package Exceptions;

import java.io.IOException;

public class NoMoneyException extends IOException {
    public NoMoneyException() {
        super("На счету не достаточно средств!");
    }
}

