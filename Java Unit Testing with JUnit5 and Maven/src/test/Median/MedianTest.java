package test.Median;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Median.*;

public class MedianTest {
    @Test
    public void testTableMedian() throws InvalidTableException {
        Median median = new Median();

        // Test dla dwóch tablic o nieparzystej liczbie elementów
        int[] table1 = {1, 3};
        int[] table2 = {2};
        assertEquals(2.0, median.tableMedian(table1, table2));

        // Test dla dwóch tablic o parzystej liczbie elementów
        int[] table3 = {1, 2};
        int[] table4 = {3, 4};
        assertEquals(2.5, median.tableMedian(table3, table4));

        // Test dla dwóch tablic o różnej liczbie elementów
        int[] table5 = {1, 3, 5};
        int[] table6 = {2, 4, 6, 8};
        assertEquals(4.0, median.tableMedian(table5, table6));
    }

    @Test
    public void testTableMedian_EmptyTable() {
        Median median = new Median();

        // Test dla pustej tablicy jako pierwszego argumentu
        int[] table1 = {};
        int[] table2 = {2};
        assertThrows(InvalidTableException.class, () -> {
            median.tableMedian(table1, table2);
        });

        // Test dla pustej tablicy jako drugiego argumentu
        int[] table3 = {1, 2, 3};
        int[] table4 = {};
        assertThrows(InvalidTableException.class, () -> {
            median.tableMedian(table3, table4);
        });

        // Test dla obu tablic będących puste
        int[] table5 = {};
        int[] table6 = {};
        assertThrows(InvalidTableException.class, () -> {
            median.tableMedian(table5, table6);
        });
    }

    @Test
    public void testTableMedian_NullTable() {
        Median median = new Median();

        // Test dla pierwszej tablicy będącej null
        int[] table1 = null;
        int[] table2 = {2};
        assertThrows(NullPointerException.class, () -> {
            median.tableMedian(table1, table2);
        });

        // Test dla drugiej tablicy będącej null
        int[] table3 = {1, 2, 3};
        int[] table4 = null;
        assertThrows(NullPointerException.class, () -> {
            median.tableMedian(table3, table4);
        });

        // Test dla obu tablic będących null
        int[] table5 = null;
        int[] table6 = null;
        assertThrows(NullPointerException.class, () -> {
            median.tableMedian(table5, table6);
        });
    }
}
