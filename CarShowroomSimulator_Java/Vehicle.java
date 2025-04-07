class Vehicle implements Comparable<Vehicle> {
    private String brand;
    private String model;
    private ItemCondition condition;
    private double price;
    private int year;
    private double mileage;
    private double engineCapacity;

    public Vehicle(String brand, String model, ItemCondition condition, double price, int year, double mileage, double engineCapacity) {
        this.brand = brand;
        this.model = model;
        this.condition = condition;
        this.price = price;
        this.year = year;
        this.mileage = mileage;
        this.engineCapacity = engineCapacity;
    }

    // Getters and setters

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public ItemCondition getCondition() {
        return condition;
    }

    public void setCondition(ItemCondition condition) {
        this.condition = condition;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    // Metoda z interfejsu Comparable do porównywania obiektów
    @Override
    public int compareTo(Vehicle other) {
        return this.model.compareTo(other.model);
    }

    public void print() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Condition: " + condition);
        System.out.println("Price: " + price);
        System.out.println("Year: " + year);
        System.out.println("Mileage: " + mileage);
        System.out.println("Engine Capacity: " + engineCapacity);
        System.out.println();
    }
}
