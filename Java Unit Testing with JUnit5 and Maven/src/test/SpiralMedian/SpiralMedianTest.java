package test.SpiralMedian;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import spiralMedian.*;

public class SpiralMedianTest {

    @Test
    public void testPrintSpiralMedian() {
        // Test dla poprawnych danych wejściowych
        int[][] matrix1 = {
                { 1, 2, 3, 4, 5},
                {16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},
                {14, 23, 22, 21, 8},
                {13, 12, 11, 10, 9}
        };
        int m1 = 5;
        int n1 = 5;

        spiralMedian spiral = new spiralMedian();
        try {
            spiral.printspiralMedian(matrix1, m1, n1);
        } catch (InvalidMatrixException e) {
            fail("Unexpected InvalidMatrixException");
        }

        // Test dla niepoprawnych danych wejściowych - nieprawidłowy wymiar macierzy (mniejszy)
        int[][] matrix2 = {
                {1, 2, 3},
                {4, 5, 6}
        };
        int m2 = 3; // Nieprawidłowy wymiar macierzy
        int n2 = 2;

        try {
            spiral.printspiralMedian(matrix2, m2, n2);
            fail("Expected InvalidMatrixException");
        } catch (InvalidMatrixException e) {
            assertEquals("Invalid matrix dimensions or structure.", e.getMessage());
        }

        // Test dla niepoprawnych danych wejściowych - nieprawidłowy wymiar macierzy (większy)
        int[][] matrix3 = {
                {1, 2},
                {3, 4},
                {5, 6}
        };
        int m3 = 2;
        int n3 = 3; // Nieprawidłowy wymiar macierzy

        try {
            spiral.printspiralMedian(matrix3, m3, n3);
            fail("Expected InvalidMatrixException");
        } catch (InvalidMatrixException e) {
            assertEquals("Invalid matrix dimensions or structure.", e.getMessage());
        }
    }
}