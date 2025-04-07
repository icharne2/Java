import javax.swing.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Tworzenie instancji pojazdów
        Vehicle vehicle1 = new Vehicle("Toyota", "Camry", ItemCondition.USED, 15000.0, 2018, 50000.0, 1.8);
        Vehicle vehicle2 = new Vehicle("Honda", "Accord", ItemCondition.NEW, 25000.0, 2020, 20000.0, 2.0);
        Vehicle vehicle3 = new Vehicle("Ford", "Mustang", ItemCondition.DAMAGED, 1000.0, 2010, 190000.0, 3.0);
        Vehicle vehicle4 = new Vehicle("BMW", "5 Series", ItemCondition.NEW, 80000, 2012, 80000, 2);
        Vehicle vehicle5 = new Vehicle("Chevrolet", "Camaro", ItemCondition.NEW, 75000, 2011, 80000, 1.0);
        Vehicle vehicle6 = new Vehicle("Mercedes-Benz", "C-Class", ItemCondition.NEW, 80000, 2012, 80000, 2);

        // Tworzenie kontenera na salony samochodowe
        CarShowroomContainer container = new CarShowroomContainer();

        // Dodanie salonów do kontenera
        container.addCenter("Showroom_1", 2);
        container.addCenter("Showroom_2", 5);
        container.addCenter("Showroom_3", 4);

        // Pobranie salonów z kontenera
        CarShowroom showroom1 = container.getShowroom("Showroom_1");
        CarShowroom showroom2 = container.getShowroom("Showroom_2");
        CarShowroom showroom3 = container.getShowroom("Showroom_3");

        // Dodanie pojazdów do poszczególnych salonów
        showroom1.addVehicle(vehicle1);
        showroom1.addVehicle(vehicle2);
        showroom2.addVehicle(vehicle3);
        showroom2.addVehicle(vehicle5);
        showroom3.addVehicle(vehicle6);
        showroom3.addVehicle(vehicle4);

        // Lista nazw salonów
        List<String> centerNames = Arrays.asList("Showroom_1", "Showroom_2", "Showroom_3");

        // Dane samochodów dla każdego salonu
        Map<String, List<String>> vehicleData = new HashMap<>();
        vehicleData.put("Showroom_1", Arrays.asList("Toyota Camry", "Honda Accord"));
        vehicleData.put("Showroom_2", Arrays.asList("Ford Mustang", "Chevrolet Camaro"));
        vehicleData.put("Showroom_3", Arrays.asList("BMW 5 Series", "Mercedes-Benz C-Class"));

        // Tworzenie interfejsu użytkownika (GUI) dla salonów samochodowych
        SwingUtilities.invokeLater(() -> new CarShowroomGUI(vehicleData, centerNames));

}}