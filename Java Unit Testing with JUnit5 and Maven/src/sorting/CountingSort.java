package sorting;

public class CountingSort implements Strategy {
    @Override
    public double execute(int[] arr, int n) {
        long tStart = System.currentTimeMillis();
        int min = arr[0];
        int max = arr[0];

        // Znajdź wartość minimalną i maksymalną w tablicy arr
        for (int i = 1; i < n; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        int range = max - min + 1;

        int[] countArray = new int[range];
        int[] outputArray = new int[n];

        // Zlicz wystąpienia każdej wartości w tablicy arr
        for (int i = 0; i < n; i++) {
            countArray[arr[i] - min]++;
        }

        // Skumuluj częstotliwość wystąpień
        for (int i = 1; i < range; i++) {
            countArray[i] += countArray[i - 1];
        }

        // Umieść elementy w tablicy outputArray w odpowiednich miejscach
        for (int i = n - 1; i >= 0; i--) {
            outputArray[countArray[arr[i] - min] - 1] = arr[i];
            countArray[arr[i] - min]--;
        }

        // Skopiuj posortowaną tablicę z powrotem do tablicy wejściowej
        System.arraycopy(outputArray, 0, arr, 0, n);

        long tEnd = System.currentTimeMillis();
        long tDelta = tEnd - tStart;
        double elapsedSeconds = tDelta / 1000.0;

        return elapsedSeconds;
    }
}
