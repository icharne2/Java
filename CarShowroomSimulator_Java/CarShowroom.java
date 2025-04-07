import java.util.*;
class CarShowroom {
    private String showroomName;
    private List<Vehicle> vehicles;
    private int maxCapacity;

    //Konstruktor
    public CarShowroom(String showroomName, int maxCapacity) {
        this.showroomName = showroomName;
        this.vehicles = new ArrayList<>();
        this.maxCapacity = maxCapacity;
    }

    // Getters i setters

    public String getShowroomName() {
        return showroomName;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    // Metoda dodająca produkt do salonu
    public void addProduct(Vehicle vehicle) {
        // Sprawdzenie, czy produkt już istnieje w salonie
        if (vehicles.contains(vehicle)) {
            // Jeśli tak, zaktualizuj istniejący produkt (zwiększ przebieg)
            int index = vehicles.indexOf(vehicle);
            Vehicle existingVehicle = vehicles.get(index);
            existingVehicle.setMileage(existingVehicle.getMileage() + vehicle.getMileage());
        } else {
            // Jeśli produkt nie istnieje w salonie
            if (vehicles.size() < maxCapacity) {
                // Sprawdzenie, czy nie przekroczono maksymalnej pojemności salonu
                // Jeśli nie, dodaj nowy produkt
                vehicles.add(vehicle);
            } else {
                // Jeśli przekroczono maksymalną pojemność salonu, wyświetl komunikat o błędzie
                System.err.println("Error: Showroom capacity exceeded.");
            }
        }
    }


    // Metoda zmniejszająca ilość danego produktu o jeden lub usuwająca go całkowicie
    public void getProduct(Vehicle vehicle) {
        // Sprawdzenie, czy produkt istnieje w salonie
        if (vehicles.contains(vehicle)) {
            // Pobranie indeksu produktu w salonie
            int index = vehicles.indexOf(vehicle);

            // Zmniejszenie ilości dostępnych pojazdów o 1
            vehicles.get(index).setMileage(vehicles.get(index).getMileage() - 1);

            // Sprawdzenie, czy ilość dostępnych pojazdów osiągnęła 0
            if (vehicles.get(index).getMileage() == 0) {
                // Jeśli tak, usuń pojazd z salonu
                vehicles.remove(index);
            }
        }
    }


    // Metoda usuwająca produkt całkowicie z magazynu
    public void removeProduct(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    // Metoda wyszukująca produkt po nazwie
    public Vehicle search(String modelName) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getModel().equals(modelName)) {
                return vehicle;
            }
        }
        return null;
    }
    // Metoda wyszukująca produkty po fragmencie nazwy
    public List<Vehicle> searchPartial(String partialName) {
        // Lista przechowująca pasujące pojazdy
        List<Vehicle> matchingVehicles = new ArrayList<>();
        // Iteracja przez wszystkie pojazdy w salonie
        for (Vehicle vehicle : vehicles) {
            // Sprawdzenie, czy nazwa modelu pojazdu zawiera podany fragment
            if (vehicle.getModel().contains(partialName)) {
                // Jeśli tak, dodaj pojazd do listy pasujących pojazdów
                matchingVehicles.add(vehicle);
            }
        }
        return matchingVehicles;
    }

    // Metoda zwracająca ilość produktów o danym stanie
    public int countByCondition(ItemCondition condition) {
        // Zmienna przechowująca liczbę pojazdów o zadanym stanie
        int count = 0;
        // Iteracja przez wszystkie pojazdy w salonie
        for (Vehicle vehicle : vehicles) {
            // Sprawdzenie, czy stan pojazdu zgadza się z zadanym stanem
            if (vehicle.getCondition() == condition) {
                count++;
            }
        }
        return count;
    }

    // Metoda wypisująca informacje o wszystkich produktach
    public void summary() {
        // Iteracja przez wszystkie pojazdy w salonie
        for (Vehicle vehicle : vehicles) {
            vehicle.print();
        }
    }
    //Metoda zwracająca posortowaną listę produktów po nazwie
    public List<Vehicle> sortByName() {
        // Tworzymy kopię listy pojazdów, aby nie modyfikować oryginalnej listy
        List<Vehicle> sortedVehicles = new ArrayList<>(vehicles);
        // Sortujemy listę pojazdów używając naturalnego porządku (implementacja Comparable w klasie Vehicle)
        Collections.sort(sortedVehicles);
        return sortedVehicles;
    }

    // Metoda zwracająca posortowaną listę produktów po ilości (malejąco)
    public List<Vehicle> sortByAmount() {
        // Tworzymy kopię listy pojazdów, aby nie modyfikować oryginalnej listy
        List<Vehicle> sortedVehicles = new ArrayList<>(vehicles);
        // Sortujemy listę pojazdów używając komparatora po ilości w kolejności malejącej
        sortedVehicles.sort(Comparator.comparingDouble(Vehicle::getMileage).reversed());
        return sortedVehicles;
    }
    //Metoda zwracająca produkt, którego jest najwięcej
    public Vehicle max() {
        if (vehicles.isEmpty()) {
            return null; // Zwracamy null, jeśli magazyn jest pusty
        }

        // Sortujemy pojazdy po przebiegu, aby pojazdy o tej samej ilości były obok siebie
        vehicles.sort(Comparator.comparingDouble(Vehicle::getMileage));

        int maxCount = 1; // Zaczynamy od 1, ponieważ przynajmniej jeden pojazd jest w magazynie
        Vehicle maxVehicle = vehicles.get(0); // Inicjalizujemy maxVehicle pierwszym pojazdem

        // Znajdujemy pojazd, którego ilość jest największa
        int currentCount = 1;
        for (int i = 1; i < vehicles.size(); i++) {
            if (vehicles.get(i).getMileage() == vehicles.get(i - 1).getMileage()) {
                currentCount++;
            } else {
                currentCount = 1;
            }

            if (currentCount > maxCount) {
                maxCount = currentCount;
                maxVehicle = vehicles.get(i);
            }
        }

        return maxVehicle;
    }
}