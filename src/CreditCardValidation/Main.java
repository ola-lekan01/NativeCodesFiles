package CreditCardValidation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        details();
    }
    public static void details(){
        try {

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your Card Details: ");
            long cardNumber = sc.nextLong();
            if(CardValidator.isValid(cardNumber)) System.out.println("Card Is Valid");
        }
        catch (CardTypeException exception){
            System.out.println(exception.getMessage());
            System.out.println("Please try again");
            details();
        }
    }
}
