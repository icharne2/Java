public class Prism {
    private Figure base;
    private double height;

    //Konstruktor
    public Prism(Figure base, double height){
        if(height <= 0){
            throw new IllegalArgumentException("Invalid prism height");
        }
        this.base = base;
        this.height = height;
    }
    //Pole
    public double calculateSurfaceArea() {
        double baseArea = base.calculateArea();
        double lateralSurfaceArea = base.calculatePerimeter() * height;
        return 2 * baseArea + lateralSurfaceArea;
    }
    //Objętosc
    public double calculateVolume() {
        return base.calculateArea() * height;
    }

    public void print() {
        System.out.println("Square height: " + height + " area: " + calculateSurfaceArea() + " volume: " + calculateVolume());
    }
}
