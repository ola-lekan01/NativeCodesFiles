package Diary.Exceptions;

public class InvalidIDErrorException extends RuntimeException{
    public InvalidIDErrorException(String message) {
        super(message);
    }
}
