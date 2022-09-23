package CreditCardValidation;

public class CardTypeException extends RuntimeException{
    public CardTypeException(String message) {
        super(message);
    }
}
