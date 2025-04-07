import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(true){
            printMenu();
            int choice = scan.nextInt();
            scan.nextLine(); // Oczyszczenie bufora po wczytaniu liczby

            switch (choice){
                case 1:
                    Triangle tri = createTriangle();
                    tri.print();
                    break;
                case 2:
                    Square sqr = createSquare();
                    sqr.print();
                    break;
                case 3:
                    Circle circ = createCircle();
                    circ.print();

                    break;
                case 4:
                    Prism prism = createPrism();
                    prism.print();
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Select number:");
        System.out.println("Menu:");
        System.out.println("1. Triangle");
        System.out.println("2. Square");
        System.out.println("3. Circle");
        System.out.println("4. Prism");
        System.out.println("5. Exit");
    }
    private static Triangle createTriangle() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter side 1: ");
        double side1 = scan.nextDouble();
        System.out.print("Enter side 2: ");
        double side2 = scan.nextDouble();
        System.out.print("Enter side 3: ");
        double side3 = scan.nextDouble();

        return new Triangle(side1, side2, side3);
    }

    private static Square createSquare() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter side: ");
        double side = scan.nextDouble();

        return new Square(side);
    }

    private static Circle createCircle() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter radius: ");
        double radius = scan.nextDouble();

        return new Circle(radius);
    }

    private static Prism createPrism() {
        Figure figure = null;

        Scanner scan = new Scanner(System.in);
        System.out.println("Select number of figure:");
        System.out.println("1. Triangle");
        System.out.println("2. Square");
        System.out.println("3. Circle");

        int choice = scan.nextInt();
        switch (choice){
            case 1:
                figure = createTriangle();
                break;
            case 2:
                figure = createTriangle();
                break;
            case 3:
                figure = createTriangle();
                break;
            default:
                System.out.println("Invalid input.");
        }

        System.out.println("Paste height");
        double height = scan.nextInt();

        return new Prism(figure, height);
    }
}
