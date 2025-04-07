public class Square extends Figure implements Printable{
    private double side;

    public Square(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Invalid side");
        }
        this.side = side;
    }
    double calculateArea() {
        // Pole dla kwadratu
        return Math.pow(side, 2);
    }

    double calculatePerimeter() {
        // Obwód dla kwadratu
        return side * 4;
    }
    public void print() {
        System.out.println("Square side: " + side + " perimeter: " + calculatePerimeter() + " area: " + calculateArea());
    }

}