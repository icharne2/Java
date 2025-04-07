public class Main {
    public static void main(String[] args) {
        // Zadanie 4a: Tworzenie kontenera na salony
        CarShowroomContainer container = new CarShowroomContainer();

        // Zadanie 4a: Dodanie salonów do kontenera
        container.addCenter("Main Showroom", 10);
        container.addCenter("Secondary Showroom", 5);

        // Zadanie 3a: Pobranie referencji do salonów
        CarShowroom mainShowroom = container.getShowrooms().get("Main Showroom");
        CarShowroom secondaryShowroom = container.getShowrooms().get("Secondary Showroom");

        // Zadanie 2a: Tworzenie pojazdów
        Vehicle car1 = new Vehicle("Toyota", "Camry", ItemCondition.NEW, 35000.0, 2022, 0.0, 2.5);
        Vehicle car2 = new Vehicle("Honda", "Accord", ItemCondition.USED, 25000.0, 2019, 15000.0, 2.0);
        Vehicle car3 = new Vehicle("Ford", "Mustang", ItemCondition.DAMAGED, 30000.0, 2020, 20000.0, 5.0);

        // Zadanie 3b: Dodanie pojazdów do salonów
        mainShowroom.addProduct(car1);
        mainShowroom.addProduct(car2);
        mainShowroom.addProduct(car3);
        secondaryShowroom.addProduct(car2);

        // Zadanie 3h: Wypisanie informacji o pojazdach w salonie
        mainShowroom.summary();

        // Zadanie 3b: Zmniejszenie ilości danego pojazdu
        //mainShowroom.getProduct(car1);
        //mainShowroom.summary();

        // Zadanie 3c: Usunięcie pojazdu z salonu
        System.out.print("Usunięcie pojazdu z salonu");
        mainShowroom.removeProduct(car2);
        mainShowroom.summary();

        // Zadanie 3d: Wyszukanie pojazdu po nazwie
        System.out.print("Wyszukanie pojazdu po nazwie");
        System.out.println("Search: " + mainShowroom.search("Accord"));

        // Zadanie 3e: Wyszukanie pojazdów po fragmencie nazwy
        System.out.print("Wyszukanie pojazdów po fragmencie nazwy");
        System.out.println("Search Partial: " + mainShowroom.searchPartial("a"));

        // Zadanie 3f: Zliczenie ilości pojazdów o danym stanie
        //System.out.println("Count by Condition (USED): " + mainShowroom.countByCondition(ItemCondition.USED));

        // Zadanie 3g: Sortowanie pojazdów po nazwie
        System.out.print("Sortowanie pojazdów po nazwie");
        System.out.println("Sort by Name: " + mainShowroom.sortByName());

        // Zadanie 3i: Sortowanie pojazdów po ilości (malejąco)
        System.out.print("Sortowanie pojazdów po ilości (malejąco)");
        System.out.println("Sort by Amount: " + mainShowroom.sortByAmount());

        // Zadanie 3j: Znalezienie pojazdu z największym przebiegiem
        System.out.print("Znalezienie pojazdu z największym przebiegiem");
        System.out.println("Max Mileage: " + mainShowroom.max());

        // Zadanie 4d: Wypisanie informacji o wszystkich salonach
        System.out.print("Wypisanie informacji o wszystkich salonach");
        container.summary();

        // Zadanie 4e: Dodanie pojazdu do salonu z kontenera
        System.out.print("Dodanie pojazdu do salonu z kontenera");
        container.addProductToShowroom("Main Showroom", car3);
        mainShowroom.summary();

        // Zadanie 4b: Usunięcie salonu z kontenera
        //System.out.print("Usunięcie salonu z kontenera");
        //container.removeCenter("Secondary Showroom");
        //container.summary();

        // Zadanie 4c: Znalezienie pustych salonów w kontenerze
        //System.out.print("Znalezienie pustych salonów w kontenerze");
        //System.out.println("Empty Showrooms: " + container.findEmpty());
    }
}
