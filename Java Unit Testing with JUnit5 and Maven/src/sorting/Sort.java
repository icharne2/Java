package sorting;

public class Sort {
    private Strategy strategy;

    public Sort(Strategy strategy) {
        this.strategy = strategy;
    }
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public double executeStrategy(int[] arr, int n) {
        return strategy.execute(arr, n);

    }

}
