package tp1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnagramTest {

    @Test
    void testNormalAnagram() {
        assertTrue(Anagram.isAnagram("listen", "silent"));
        assertTrue(Anagram.isAnagram("triangle", "integral"));
    }

    @Test
    void testDifferentLength() {
        assertFalse(Anagram.isAnagram("abc", "abcd"));
        assertFalse(Anagram.isAnagram("a", "aa"));
    }

    @Test
    void testCaseAndSpaces() {
        assertTrue(Anagram.isAnagram("A man", "nam a"));
        assertTrue(Anagram.isAnagram("Dormitory", "Dirty room"));
    }

    @Test
    void testNonAnagramSameLength() {
        assertFalse(Anagram.isAnagram("hello", "bello"));
        assertFalse(Anagram.isAnagram("aabb", "ababcc"));
    }

    @Test
    void testEmptyStrings() {
        assertTrue(Anagram.isAnagram("", ""));
    }

    @Test
    void testNullStrings() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, "abc"));
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram("abc", null));
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, null));
    }
}