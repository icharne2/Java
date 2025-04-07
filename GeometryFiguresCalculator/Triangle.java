public class Triangle extends Figure implements Printable{
    private double side1, side2, side3;

    public Triangle(double side1, double side2, double side3) {
        // Konstruktor
        if (side1 <= 0 || side2 <= 0 || side3 <= 0 || (side1 + side2 <= side3) || (side1 + side3 <= side2) || (side2 + side3 <= side1)) {
            throw new IllegalArgumentException("Invalid triangle sides");
        }
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    double calculateArea() {
        // Pole dla trójkąta
        double s = (side1 + side2 + side3) / 2.0;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
    double calculatePerimeter() {
        // Obwód dla trójkąta
        return side1 + side2 + side3;
    }

    public void print() {
        System.out.println("Triangle sides: " + side1 + ", " + side2 + ", " + side3 + " area: " + calculateArea() + " perimeter: " + calculatePerimeter());
    }
}
