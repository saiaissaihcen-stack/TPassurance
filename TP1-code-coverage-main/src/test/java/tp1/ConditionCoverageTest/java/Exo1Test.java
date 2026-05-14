package tp1.ConditionCoverageTest.java;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import tp1.Palindrome;
public class Exo1Test {

    @Test
    void testEmptyString() {
        assertTrue(Palindrome.isPalindrome("")); // boucle jamais exécutée
    }

    @Test
    void testSingleChar() {
        assertTrue(Palindrome.isPalindrome("a")); // boucle jamais exécutée
    }

    @Test
    void testPalindromeEvenLength() {
        assertTrue(Palindrome.isPalindrome("abba")); // pair
    }

    @Test
    void testPalindromeOddLength() {
        assertTrue(Palindrome.isPalindrome("kayak")); // impair
    }

    @Test
    void testNonPalindrome() {
        assertFalse(Palindrome.isPalindrome("hello")); // condition true au moins une fois
    }

    @Test
    void testTwoCharStrings() {
        assertTrue(Palindrome.isPalindrome("aa"));  // condition false
        assertFalse(Palindrome.isPalindrome("ab")); // condition true
    }
}
