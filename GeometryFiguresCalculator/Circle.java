public class Circle extends Figure implements Printable{
    private double radius;

    public Circle(double radius) {
        // Konstruktor
        if (radius <= 0) {
            throw new IllegalArgumentException("Invalid circle radius");
        }
        this.radius = radius;
    }

    double calculateArea() {
        //  Pole dla koła
        return Math.PI * Math.pow(radius, 2);
    }

    double calculatePerimeter() {
        // Obwód dla koła
        return 2 * Math.PI * radius;
    }
    public void print() {
        System.out.println("Circle radius: " + radius + " area: " + calculateArea() + " perimeter" + calculatePerimeter());
    }
}