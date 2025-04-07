package Median;
import sorting.*;
public class Median {
    public double tableMedian(int[] table1, int[] table2) throws InvalidTableException {
        if (table1.length == 0 || table2.length == 0) {
            throw new InvalidTableException("One of the input tables is empty.");
        }

        int[] result = new int[table1.length + table2.length];
        int index = 0;

        for (int num : table1) {
            result[index++] = num;
        }
        for (int num : table2) {
            result[index++] = num;
        }
        //Sortowanie tabeli
        Sort sorter = new Sort(new BubbleSort());
        sorter.executeStrategy(result, result.length);

        double median;
        if(result.length%2==0){
            median=(result[result.length/2]+result[result.length/2-1])/2.0;
        }
        else
            median=result[result.length/2];

        return median;
    }
}
