package laba.solvd.exceptions;

import java.util.InputMismatchException;

public class InvalidValueException extends InputMismatchException {
    public static String message = "Your value is incorrect!";

    public InvalidValueException(int id) {
     //   message += id;
    }

    public InvalidValueException(String s) {
        super(s);
    }
}
