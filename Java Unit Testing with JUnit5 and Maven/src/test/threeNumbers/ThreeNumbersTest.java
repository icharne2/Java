package test.threeNumbers;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import threeNumbers.*;

public class ThreeNumbersTest {
    @Test
    public void testMakeTriangle() {
        // Przykładowe dane wejściowe
        int[] input = {-1, 0, 1, 2, -1, -4};
        // Oczekiwane trójki
        List<List<Integer>> expected = List.of(
                List.of(-1, 0, 1),
                List.of(-1, -1, 2)
        );

        // Tworzymy obiekt klasy threeNumbers
        threeNumbers tn = new threeNumbers();

        // Wywołujemy metodę makeTriangle, która znajduje trójki sumujące się do zera
        List<List<Integer>> result = tn.makeTriangle(input);

        // Sprawdzamy, czy lista wynikowa jest zgodna z oczekiwaniami
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
        assertTrue(expected.containsAll(result));
    }

}
