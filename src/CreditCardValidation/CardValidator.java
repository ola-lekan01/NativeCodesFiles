package CreditCardValidation;

public class CardValidator {

    /** Return true if the card number is valid */
    public static boolean isValid(long number){
        boolean isValid = (sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0 && cardChecker(number);
        if (isValid) return true;
        else throw new CardTypeException("Invalid Card Details");
    }
    /** Get the result from Step 2 */
    public static int sumOfDoubleEvenPlace(long number){
        int evenTotal = 0;
        String cardNumber = String.valueOf(number);

        for (int i = cardNumber.length() - 2; i >= 0 ; i-=2) {
            char evenChar = cardNumber.charAt(i);
            int evenProduct = convertString(evenChar) * 2;
            evenTotal += getDigit(evenProduct);
        }
        return evenTotal;
    }
    /** Return this number if it is a single digit, otherwise,
     * return the sum of the two digits */
    public static int getDigit(int number){
        int digitTotal;
        int decimalValue = number / 10;
        int modulusValue = number % 10;
        if(number > 9) digitTotal = decimalValue + modulusValue;
        else digitTotal = number;

        return digitTotal;
    }

    public static int convertString(char character){
        return Integer.parseInt(String.valueOf(character));
    }

    /** Return sum of odd-place digits in number */
    public static int sumOfOddPlace(long number){
        int oddTotal = 0;
        String cardNumber = String.valueOf(number);
        for (int i = cardNumber.length() - 1; i >= 0 ; i-=2) {
            char evenChar = cardNumber.charAt(i);
            int evenProduct = convertString(evenChar);
            oddTotal += getDigit(evenProduct);
        }
        return oddTotal;
    }

    public static boolean cardType(long number){
        int size = getSize(number);
        int prefix = getPrefix(number);
        if(prefix == 4 && (size == 13 || size == 16)) return true;
        else if (prefix == 5 && (size == 13 || size == 16)) return true;
        else if (prefix == 6 && (size == 13 || size == 16)) return true;
        else if (prefix == 3 && (size == 13 || size == 16)) return true;
        else throw new CardTypeException("Invalid Card Details");
    }

    public static int getSize(long number){
        String cardNumber = String.valueOf(number);
        return cardNumber.length();
    }
    public static int getPrefix(long number){
        String cardNumber = String.valueOf(number);
        char character = cardNumber.charAt(0);
        return convertString(character);
    }

    public static boolean cardChecker(long number){
        return cardType(number);
    }
}
