package tp1.LineCoverageTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import tp1.Palindrome;

public class Exo1Test {

    @Test
    void testPalindromeSimple() {
        assertTrue(Palindrome.isPalindrome("kayak"));
        assertFalse(Palindrome.isPalindrome("hello"));
    }
    @Test
    void testEmptyAndSingleChar() {
        assertTrue(Palindrome.isPalindrome(""));
        assertTrue(Palindrome.isPalindrome("a"));
    }
    @Test
    void testCaseSensitivity() {
        assertTrue(Palindrome.isPalindrome("Radar"), "'radar' should be a palindrome");
    }

    @Test
    void testTwoCharStrings() {
        assertTrue(Palindrome.isPalindrome("aa"), "'aa' should be a palindrome");
        assertFalse(Palindrome.isPalindrome("ab"), "'ab' should not be a palindrome");
    }


    @Test
    void testWithSpacesAndPunctuationIgnoreCase() {
        String s = "abc!cba".replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        assertTrue(Palindrome.isPalindrome(s));
    }

    @Test
    void testPalindromeWithSpacesAndPunctuation() {
        assertFalse(Palindrome.isPalindrome("Aman")); //
        assertTrue(Palindrome.isPalindrome("Esope reste ici et se repose"));
    }
    @Test
    void testNullStringThrows() {
        assertThrows(NullPointerException.class, () -> {
            Palindrome.isPalindrome(null);
        });
    }
}