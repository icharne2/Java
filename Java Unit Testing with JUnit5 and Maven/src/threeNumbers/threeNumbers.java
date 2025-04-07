package threeNumbers;
import java.util.*;

public class threeNumbers {
    public List<List<Integer>> makeTriangle(int[] table) {
        Arrays.sort(table); // Sortujemy tablicę dla łatwiejszej obsługi

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < table.length - 2; i++) {
            if (i > 0 && table[i] == table[i - 1]) {
                continue; // Pomijamy powtarzające się liczby, aby uniknąć powielania trójek
            }
            int left = i + 1;
            int right = table.length - 1;

            while (left < right) {
                int sum = table[i] + table[left] + table[right];
                if (sum == 0) {
                    List<Integer> triplet = Arrays.asList(table[i], table[left], table[right]);
                    result.add(triplet);
                    // Pomijamy powtarzające się liczby wewnątrz trójki
                    while (left < right && table[left] == table[left + 1]) left++;
                    while (left < right && table[right] == table[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
    public boolean ifThreeInList(List<List<Integer>> result, int a, int b, int c) {
        for (List<Integer> triplet : result) {
            if (triplet.contains(a) && triplet.contains(b) && triplet.contains(c)) {
                return true;
            }
        }
        return false;
    }
}
