package Common;

import java.util.Scanner;

public class Input {
    private static final Scanner input = new Scanner(System.in);

    private Input() {

    }

    public static Scanner getInput() {
        return input;
    }

    public static void close() {
        input.close();
    }
}
