package test.sorting;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import sorting.*;

public class SortingTest {
    @Test
    public void testBubbleSort() {
        int[] input = {4, 2, 5, 1, 3};
        int[] expected = {1, 2, 3, 4, 5};

        Sort sorter = new Sort(new BubbleSort());
        long startTime = System.nanoTime();
        sorter.executeStrategy(input, input.length);
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1e6; // czas w milisekundach

        assertArrayEquals(expected, input);
        System.out.println("Czas BubbleSort: " + duration + " ms");
    }

    @Test
    public void testBubbleSortWithDuplicateElements() {
        int[] input = {4, 2, 5, 1, 3, 5, 4};
        int[] expected = {1, 2, 3, 4, 4, 5, 5};

        Sort sorter = new Sort(new BubbleSort());
        long startTime = System.nanoTime();
        sorter.executeStrategy(input, input.length);
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1e6; // czas w milisekundach

        assertArrayEquals(expected, input);
        System.out.println("Czas BubbleSort (z duplikatami): " + duration + " ms");
    }

    @Test
    public void testCountingSort() {
        int[] input = {4, 2, 5, 1, 3};
        int[] expected = {1, 2, 3, 4, 5};

        CountingSort countingSort = new CountingSort();
        long startTime = System.nanoTime();
        double time = countingSort.execute(input, input.length);
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1e6; // czas w milisekundach

        assertArrayEquals(expected, input);
        System.out.println("Czas CountingSort: " + duration + " ms");
    }

    @Test
    public void testCountingSortWithDuplicateElements() {
        int[] input = {4, 2, 5, 1, 3, 5, 4};
        int[] expected = {1, 2, 3, 4, 4, 5, 5};

        CountingSort countingSort = new CountingSort();
        long startTime = System.nanoTime();
        double time = countingSort.execute(input, input.length);
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1e6; // czas w milisekundach

        assertArrayEquals(expected, input);
        System.out.println("Czas CountingSort (z duplikatami): " + duration + " ms");
    }

    @Test
    public void testHeapSort() {
        int[] input = {4, 2, 5, 1, 3};
        int[] expected = {1, 2, 3, 4, 5};

        HeapSort heapSort = new HeapSort();
        long startTime = System.nanoTime();
        double time = heapSort.execute(input, input.length);
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1e6; // czas w milisekundach

        assertArrayEquals(expected, input);
        System.out.println("Czas HeapSort: " + duration + " ms");
    }

    @Test
    public void testHeapSortWithDuplicateElements() {
        int[] input = {4, 2, 5, 1, 3, 5, 4};
        int[] expected = {1, 2, 3, 4, 4, 5, 5};

        HeapSort heapSort = new HeapSort();
        long startTime = System.nanoTime();
        double time = heapSort.execute(input, input.length);
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1e6; // czas w milisekundach

        assertArrayEquals(expected, input);
        System.out.println("Czas HeapSort (z duplikatami): " + duration + " ms");
    }

    @Test
    public void testInsertionSort() {
        int[] input = {4, 2, 5, 1, 3};
        int[] expected = {1, 2, 3, 4, 5};

        InsertionSort insertionSort = new InsertionSort();
        long startTime = System.nanoTime();
        double time = insertionSort.execute(input, input.length);
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1e6; // czas w milisekundach

        assertArrayEquals(expected, input);
        System.out.println("Czas InsertionSort: " + duration + " ms");
    }

    @Test
    public void testSelectionSortWithDuplicateElements() {
        int[] input = {4, 2, 5, 1, 3, 5, 4};
        int[] expected = {1, 2, 3, 4, 4, 5, 5};

        SelectionSort selectionSort = new SelectionSort();
        long startTime = System.nanoTime();
        double time = selectionSort.execute(input, input.length);
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1e6; // czas w milisekundach

        assertArrayEquals(expected, input);
        System.out.println("Czas SelectionSort (z duplikatami): " + duration + " ms");
    }

    @Test
    public void testSelectionSort() {
        int[] input = {4, 2, 5, 1, 3};
        int[] expected = {1, 2, 3, 4, 5};

        SelectionSort selectionSort = new SelectionSort();
        long startTime = System.nanoTime();
        double time = selectionSort.execute(input, input.length);
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1e6; // czas w milisekundach

        assertArrayEquals(expected, input);
        System.out.println("Czas SelectionSort: " + duration + " ms");
    }
}
