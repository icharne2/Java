package Testing;
import sorting.*;
import PAYPALISHIRING.*;
import Median.*;
import spiralMedian.*;
import threeNumbers.*;

import java.util.*;

import static jdk.internal.org.jline.utils.Colors.s;

public class Testing {

    public void testSorting()
    {
        int[] table1 = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, 210, 220, 230, 240, 250, 260, 270, 280, 290, 300, 310, 320, 330, 340, 350, 360, 370, 380, 390, 400};
        int[] table2 = {320, 370, 210, 90, 190, 100, 50, 110, 220, 390, 380, 350, 330, 280, 40, 260, 60, 140, 270, 360, 200, 160, 130, 310, 230, 120, 300, 80, 330, 390, 140, 80, 140, 100, 330, 50, 250, 260, 190, 360, 220};
        int[] table3 = {400, 390, 380, 370, 360, 350, 340, 330, 320, 310, 300, 290, 280, 270, 260, 250, 240, 230, 220, 210, 200, 190, 180, 170, 160, 150, 140, 130, 120, 110, 100, 90, 80, 70, 60, 50, 40, 30, 20, 10};

        Sort sorter = new Sort(new BubbleSort());
        System.out.println("Bubble sort");

        // Kopiowanie tablic przed sortowaniem
        int[] copyTable1 = Arrays.copyOf(table1, table1.length);
        int[] copyTable2 = Arrays.copyOf(table2, table2.length);
        int[] copyTable3 = Arrays.copyOf(table3, table3.length);

        double time = sorter.executeStrategy(copyTable1, copyTable1.length);
        System.out.println("Optimistic execution time in seconds: " + time);

        time = sorter.executeStrategy(copyTable2, copyTable2.length);
        System.out.println("Expected execution time in seconds: " + time);

        time = sorter.executeStrategy(copyTable3, copyTable3.length);
        System.out.println("Pessimistic execution time in seconds: " + time);

        System.out.println("");
        System.out.println("Selection sort");
        sorter.setStrategy(new SelectionSort());
        // Kopiowanie tablic przed sortowaniem
        copyTable1 = Arrays.copyOf(table1, table1.length);
        copyTable2 = Arrays.copyOf(table2, table2.length);
        copyTable3 = Arrays.copyOf(table3, table3.length);

        time = sorter.executeStrategy(copyTable1, copyTable1.length);
        System.out.println("Optimistic execution time in seconds: " + time);

        time = sorter.executeStrategy(copyTable2, copyTable2.length);
        System.out.println("Expected execution time in seconds: " + time);

        time = sorter.executeStrategy(copyTable3, copyTable3.length);
        System.out.println("Pessimistic execution time in seconds: " + time);

        System.out.println("");
        System.out.println("Insertion sort");
        sorter.setStrategy(new InsertionSort());

        // Kopiowanie tablic przed sortowaniem
        copyTable1 = Arrays.copyOf(table1, table1.length);
        copyTable2 = Arrays.copyOf(table2, table2.length);
        copyTable3 = Arrays.copyOf(table3, table3.length);

        time = sorter.executeStrategy(copyTable1, copyTable1.length);
        System.out.println("Optimistic execution time in seconds: " + time);

        time = sorter.executeStrategy(copyTable2, copyTable2.length);
        System.out.println("Expected execution time in seconds: " + time);

        time = sorter.executeStrategy(copyTable3, copyTable3.length);
        System.out.println("Pessimistic execution time in seconds: " + time);

        System.out.println("");
        System.out.println("Heap sort");
        sorter.setStrategy(new HeapSort());
        // Kopiowanie tablic przed sortowaniem
        copyTable1 = Arrays.copyOf(table1, table1.length);
        copyTable2 = Arrays.copyOf(table2, table2.length);
        copyTable3 = Arrays.copyOf(table3, table3.length);

        time = sorter.executeStrategy(copyTable1, copyTable1.length);
        System.out.println("Optimistic execution time in seconds: " + time);

        time = sorter.executeStrategy(copyTable2, copyTable2.length);
        System.out.println("Expected execution time in seconds: " + time);

        time = sorter.executeStrategy(copyTable3, copyTable3.length);
        System.out.println("Pessimistic execution time in seconds: " + time);

        System.out.println("");
        System.out.println("Counting sort");
        sorter.setStrategy(new CountingSort());
        // Kopiowanie tablic przed sortowaniem
        copyTable1 = Arrays.copyOf(table1, table1.length);
        copyTable2 = Arrays.copyOf(table2, table2.length);
        copyTable3 = Arrays.copyOf(table3, table3.length);

        time = sorter.executeStrategy(copyTable1, copyTable1.length);
        System.out.println("Optimistic execution time in seconds: " + time);

        time = sorter.executeStrategy(copyTable2, copyTable2.length);
        System.out.println("Expected execution time in seconds: " + time);

        time = sorter.executeStrategy(copyTable3, copyTable3.length);
        System.out.println("Pessimistic execution time in seconds: " + time);
    }

    public void testConvertion(){
        //Test dla 4 wierszy
        int nRows = 3;
        String text = "PAYPALISHIRING";

        //Tworzenie obiektu klasy Convertion
        Convertion convertion= new Convertion();

        //Przed zminą
        System.out.println("Input: " + text + ", numRows = " + nRows);
        //Po zmianie
        String newText = convertion.convert(text, nRows);
        System.out.println("Output: " + newText);

        //Test dla 4 wierszy
        nRows++;
        System.out.println("Input: " + text + ", numRows = " + nRows);
        newText = convertion.convert(text, nRows);
        System.out.println("Output: " + newText);
    }

    public void testMedian() {
        int[] table1 = {9, 17, 23, 41, 51, 63, 77, 82, 95, 101, 112, 125, 138, 147, 153, 169, 179, 184, 191, 206, 218, 222, 235, 248, 254, 268, 275, 283, 296, 304, 319, 337, 342, 356, 365, 372, 384, 398, 401};
        int[] table2 = {325, 379, 213, 92, 192, 103, 56, 114, 229, 391, 381, 357, 331, 286, 45, 265, 61, 147, 277, 362, 209, 167, 139, 311, 236, 127, 306, 89, 336, 398, 144, 83, 142, 104, 335, 54, 252, 264, 194, 368, 224};
        Median median = new Median();

        try {
            System.out.println("Median: " + median.tableMedian(table1, table2));
        } catch (InvalidTableException e) {
            System.out.println("Invalid tables: " + e.getMessage());
        }
    }

    public void testThreeNumbers(){
        //Przykład 1.
        System.out.println("Przyklad 1");
        int[] nums1= {-1, 0, 3, 4, 2, 4, 5, 6, 7, -5, 3, 0, 0, 2, 3, 4};
        threeNumbers threesome = new threeNumbers();
        List<List<Integer>> result1  = threesome.makeTriangle(nums1);
        printResult(result1);

        //Przykład 2.
        System.out.println("Przyklad 2");
        int[] nums2= {0, 1, 1};
        List<List<Integer>> result2  = threesome.makeTriangle(nums2);
        printResult(result2);

        //Przykład 3.
        System.out.println("Przyklad 3");
        int[] nums3 = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result3  = threesome.makeTriangle(nums3);
        printResult(result3);
    }

    private void printResult(List<List<Integer>> result) {
        if (result.isEmpty()) {
            System.out.println("Wyjście: []");
            System.out.println("Brak możliwych trójek sumujących się do 0.");
        } else {
            System.out.println("Wyjście:");
            for (List<Integer> triplet : result) {
                System.out.println(triplet);
            }
            System.out.println("Znaleziono trójki sumujące się do 0.");
        }
        System.out.println();
    }

    public void testspiralMedian() {
        spiralMedian spiral = new spiralMedian();

        int[][] tab = {
                { 1, 2, 3, 4, 5},
                { 6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };

        int m = 5; // liczba wierszy
        int n = 5; // liczba kolumn

        try {
            spiral.printspiralMedian(tab, m, n);
        } catch (InvalidMatrixException e) {
            System.out.println("Wyjątek: " + e.getMessage());
        }
    }
}
