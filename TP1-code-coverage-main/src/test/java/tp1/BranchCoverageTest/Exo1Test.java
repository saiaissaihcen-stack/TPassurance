package tp1.BranchCoverageTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import tp1.Palindrome;

public class Exo1Test {

    @Test
    void testEmptyString() {
        assertTrue(Palindrome.isPalindrome("")); // boucle jamais exécutée
    }

    @Test
    void testPalindromeEvenLength() {
        assertTrue(Palindrome.isPalindrome("abba")); // boucle exécutée, if jamais vrai
    }

    @Test
    void testPalindromeOddLength() {
        assertTrue(Palindrome.isPalindrome("kayak")); // boucle exécutée, if jamais vrai
    }

    @Test
    void testNonPalindromeEvenLength() {
        assertFalse(Palindrome.isPalindrome("abca")); // if vrai pour retourner false
    }

    @Test
    void testNonPalindromeOddLength() {
        assertFalse(Palindrome.isPalindrome("abcbaX")); // if vrai pour retourner false
    }

    @Test
    void testCaseSensitive() {
        assertTrue(Palindrome.isPalindrome("Radar")); // majuscule != minuscule
        assertTrue(Palindrome.isPalindrome("radar"));
    }

    @Test
    void testTwoCharStrings() {
        assertTrue(Palindrome.isPalindrome("aa"));
        assertFalse(Palindrome.isPalindrome("ab"));
    }

    @Test
    void testWithSpacesAndPunctuation() {
        assertTrue(Palindrome.isPalindrome("abc!cba")); // branch pour les caractères spéciaux
        assertTrue(Palindrome.isPalindrome("a a")); // branch boucle exécutée, if jamais vrai
    }
    @Test
    void testPartialMismatch() {
        // ici le premier caractère est correct, mais le dernier ne correspond pas, boucle continue
        assertFalse(Palindrome.isPalindrome("abca"));
        assertFalse(Palindrome.isPalindrome("abca"));
    }
}