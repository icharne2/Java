import java.util.*;
class CarShowroomContainer {
    private Map<String, CarShowroom> showrooms;

    //Konstruktor
    public CarShowroomContainer() {
        this.showrooms = new HashMap<>();
    }

    // Getters i Setters
    public Map<String, CarShowroom> getShowrooms() {
        return showrooms;
    }

    public void setShowrooms(Map<String, CarShowroom> showrooms) {
        this.showrooms = showrooms;
    }

    // Metoda dodająca nowy salon do spisu salonów
    public void addCenter(String showroomName, int maxCapacity) {
        CarShowroom showroom = new CarShowroom(showroomName, maxCapacity);
        showrooms.put(showroomName, showroom);
    }
    //Metoda usuwająca salon o podanej nazwie
    public void removeCenter(String showroomName) {
        showrooms.remove(showroomName);
    }
    //Metoda zwracająca listę pustych magazynów
    public List<String> findEmpty() {
        // Lista przechowująca nazwy pustych salonów
        List<String> emptyShowrooms = new ArrayList<>();

        // Iteracja przez wszystkie wpisy w mapie (nazwa salonu i obiekt CarShowroom)
        for (Map.Entry<String, CarShowroom> entry : showrooms.entrySet()) {
            // Sprawdzenie, czy salon nie zawiera żadnych pojazdów
            if (entry.getValue().getVehicles().isEmpty()) {
                // Jeśli tak, dodaj nazwę salonu do listy pustych salonów
                emptyShowrooms.add(entry.getKey());
            }
        }
        return emptyShowrooms;
    }
    //Metoda wypisująca informacje zawierające nazwę salonu i procentowe zapełnienie
    public void summary() {
        // Iteracja przez wszystkie wpisy w mapie (nazwa salonu i obiekt CarShowroom)
        for (Map.Entry<String, CarShowroom> entry : showrooms.entrySet()) {
            // Pobranie obiektu CarShowroom
            CarShowroom showroom = entry.getValue();
            System.out.println("Showroom Name: " + showroom.getShowroomName());
            System.out.println("Occupancy: " + (showroom.getVehicles().size() * 100.0 / showroom.getMaxCapacity()) + "%");
            System.out.println();
        }
    }

    // Dodatkowa metoda umożliwiająca dodanie produktu do określonego salonu.
    // Jeśli salon o podanej nazwie istnieje, produkt zostanie dodany do tego salonu.
    // W przeciwnym razie zostanie wyświetlony błąd.
    public void addProductToShowroom(String showroomName, Vehicle vehicle) {
        // Pobranie obiektu CarShowroom na podstawie nazwy salonu
        CarShowroom showroom = showrooms.get(showroomName);
        // Sprawdzenie, czy salon istnieje
        if (showroom != null) {
            showroom.addProduct(vehicle);
        } else {
            // Jeśli salon nie został znaleziony, wyświetl komunikat o błędzie
            System.err.println("Error: Showroom not found.");
        }
    }
}