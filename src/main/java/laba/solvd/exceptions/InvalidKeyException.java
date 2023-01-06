package laba.solvd.exceptions;


public class InvalidKeyException extends IllegalArgumentException {
    public static String message = "There is no such available building with key - ";

    public InvalidKeyException(int key) {
        message += key;
    }
}
