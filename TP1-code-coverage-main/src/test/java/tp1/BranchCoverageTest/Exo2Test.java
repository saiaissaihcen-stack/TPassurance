package tp1.BranchCoverageTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import tp1.Anagram;

public class Exo2Test {

    // Null check
    @Test
    void testNullStrings() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, "abc"));
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram("abc", null));
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, null));
    }

    // Longueur différente
    @Test
    void testDifferentLength() {
        assertFalse(Anagram.isAnagram("abc", "ab"));
    }

    // Anagramme vrai
    @Test
    void testValidAnagram() {
        assertTrue(Anagram.isAnagram("listen", "silent")); // branche if faux et for boucle complète
    }

    // Anagramme faux (mêmes longueurs mais lettres différentes)
    @Test
    void testInvalidAnagram() {
        assertFalse(Anagram.isAnagram("apple", "palez")); // déclenche if (c != 0) vrai
    }

    // Anagramme avec majuscules et espaces
    @Test
    void testAnagramWithSpacesAndCase() {
        assertTrue(Anagram.isAnagram("A gentleman", "Elegant man")); // teste normalisation
    }
}