package CreditValidator;

import CreditCardValidation.CardTypeException;
import CreditCardValidation.CardValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CreditValidatorTest {

    @Test
    public void testThatEvenNumbersCanBeAdded(){
        long number = 4388576018402626L;
        assertEquals(37, CardValidator.sumOfDoubleEvenPlace(number));
        }

    @Test
    public void testThatOddNumbersCanBeAdded(){
        long number = 4388576018402626L;
        assertEquals(38, CardValidator.sumOfOddPlace(number));
    }
    @Test
    public void testThatThePrefixOfTheCardIsCorrect(){
        long number = 4388576018402626L;
        assertEquals(4, CardValidator.getPrefix(number));
    }

    @Test
    public void testThatTheCardIsValidCardType(){
        long number = 4388576018402626L;
        CardValidator.getPrefix(number);
        assertTrue(CardValidator.cardType(number));
    }
    @Test
    public void testThatTheCardIsValid(){
        long number = 4388576018410707L;
        assertTrue(CardValidator.isValid(number));
    }

    @Test
    public void testThatInvalidCardThrowsException(){
        long number = 2388576018402626L;
        assertThrows(CardTypeException.class, ()->CardValidator.cardType(number));
    }

    @Test
    public void testThatCardIsValid(){
        long number = 4388576018410707L;
        assertTrue(CardValidator.cardChecker(number));
    }

}
