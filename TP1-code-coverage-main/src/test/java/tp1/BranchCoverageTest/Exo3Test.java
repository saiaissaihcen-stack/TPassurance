package tp1.BranchCoverageTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import tp1.BinarySearch;

public class Exo3Test {

    // Null check
    @Test
    void testNullArray() {
        assertThrows(NullPointerException.class, () -> BinarySearch.binarySearch(null, 5));
    }

    // Element présent (cas simple)
    @Test
    void testElementFound() {
        int[] arr = {1, 3, 5, 7, 9};
        assertEquals(2, BinarySearch.binarySearch(arr, 5)); // array[mid] == element
    }

    // Element plus grand que mid
    @Test
    void testElementGreaterThanMid() {
        int[] arr = {1, 3, 5, 7, 9};
        assertEquals(4, BinarySearch.binarySearch(arr, 9)); // array[mid] <= element
    }

    // Element plus petit que mid
    @Test
    void testElementLessThanMid() {
        int[] arr = {1, 3, 5, 7, 9};
        assertEquals(0, BinarySearch.binarySearch(arr, 1)); // array[mid] > element
    }

    // Element absent
    @Test
    void testElementNotFound() {
        int[] arr = {1, 3, 5, 7, 9};
        assertEquals(-1, BinarySearch.binarySearch(arr, 4)); // boucle complète mais pas trouvé
    }

    // Tableau vide
    @Test
    void testEmptyArray() {
        int[] arr = {};
        assertEquals(-1, BinarySearch.binarySearch(arr, 5)); // boucle jamais exécutée
    }
}