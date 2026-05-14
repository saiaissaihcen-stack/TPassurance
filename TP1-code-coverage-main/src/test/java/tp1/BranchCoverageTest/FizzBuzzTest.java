package tp1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FizzBuzzTest {

    @Test
    void testNIsZeroOrNegative() {
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(0));
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(-5));
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(1));
    }

    @Test
    void testFizzBuzz() {
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(15));
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(30));
    }

    @Test
    void testFizz() {
        assertEquals("Fizz", FizzBuzz.fizzBuzz(3));
        assertEquals("Fizz", FizzBuzz.fizzBuzz(6));
    }

    @Test
    void testBuzz() {
        assertEquals("Buzz", FizzBuzz.fizzBuzz(5));
        assertEquals("Buzz", FizzBuzz.fizzBuzz(10));
    }

    @Test
    void testNumber() {
        assertEquals("2", FizzBuzz.fizzBuzz(2));
        assertEquals("7", FizzBuzz.fizzBuzz(7));
    }
}