package test.PAYPALISHIRING;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import PAYPALISHIRING.*;

public class ConvertionTest {
    @Test
    public void testConversion() {
        Convertion convertion = new Convertion();

        // Test  - numRows = 3
        String input1 = "PAYPALISHIRING";
        int numRows1 = 3;
        String expected1 = "PAHNAPLSIIGYIR";
        assertEquals(expected1, convertion.convert(input1, numRows1));

        // Test  - numRows = 4
        String input2 = "PAYPALISHIRING";
        int numRows2 = 4;
        String expected2 = "PINALSIGYAHRPI";
        assertEquals(expected2, convertion.convert(input2, numRows2));

        // Test - numRows = 1
        String input3 = "PAYPALISHIRING";
        int numRows3 = 1;
        String expected3 = "PAYPALISHIRING";
        assertEquals(expected3, convertion.convert(input3, numRows3));

        // Test - input jest pusty
        String input4 = "";
        int numRows4 = 3;
        String expected4 = "";
        assertEquals(expected4, convertion.convert(input4, numRows4));
    }
}
