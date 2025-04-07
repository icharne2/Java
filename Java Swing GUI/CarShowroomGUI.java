import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class CarShowroomGUI extends JFrame {

    private JList<String> centerList;
    private Map<String, JList<String>> vehicleLists;
    private JPanel vehiclePanel;
    private JLabel headLabel;

    // Konstruktor
    public CarShowroomGUI(Map<String, List<String>> vehicleData, List<String> centerNames) {
        super("Car Showrooms");

        // Inicjalizacja listy salonów
        DefaultListModel<String> centerListModel = new DefaultListModel<>();
        for (String center : centerNames) {
            centerListModel.addElement(center);
        }
        centerList = new JList<>(centerListModel);
        centerList.addListSelectionListener(e -> updateVehicleList(centerList.getSelectedValue()));

        // Inicjalizacja mapy list pojazdów dla każdego salonu
        vehicleLists = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : vehicleData.entrySet()) {
            vehicleLists.put(entry.getKey(), createVehicleList(entry.getValue()));
        }

        // Ustawienie layoutu i dodanie komponentów do interfejsu
        JPanel panel = new JPanel(new BorderLayout());

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(new JScrollPane(centerList), BorderLayout.CENTER);
        panel.add(centerPanel, BorderLayout.WEST);

        vehiclePanel = new JPanel(new BorderLayout());
        panel.add(vehiclePanel, BorderLayout.CENTER);

        headLabel = new JLabel("Select a showroom to see vehicles", SwingConstants.CENTER);
        panel.add(headLabel, BorderLayout.NORTH);

        // Dodanie przycisków
        JPanel buttonPanel = new JPanel(new GridLayout(1, 5)); // Dodanie pięciu przycisków
        JButton removeShowroomButton = new JButton("Remove Car Showroom");
        JButton removeVehicleButton = new JButton("Remove Vehicle");
        JButton addShowroomButton = new JButton("Add Car Showroom Center");
        JButton addVehicleButton = new JButton("Add New Vehicle");
        JButton sortCentersButton = new JButton("Sort Centers by Current Load");

        buttonPanel.add(removeShowroomButton);
        buttonPanel.add(removeVehicleButton);
        buttonPanel.add(addShowroomButton);
        buttonPanel.add(addVehicleButton);
        buttonPanel.add(sortCentersButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Dodanie panelu do ramki
        add(panel);

        // Dodanie obsługi zdarzeń przycisków
        removeShowroomButton.addActionListener(e -> removeSelectedShowroom());
        removeVehicleButton.addActionListener(e -> removeSelectedVehicle());
        addShowroomButton.addActionListener(e -> addNewShowroom());
        addVehicleButton.addActionListener(e -> addNewVehicle());
        sortCentersButton.addActionListener(e -> sortCentersByLoad());

        // Wyświetlenie okna
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Metoda tworząca listę pojazdów dla danego salonu
    private JList<String> createVehicleList(List<String> vehicles) {
        DefaultListModel<String> vehicleListModel = new DefaultListModel<>();
        for (String vehicle : vehicles) {
            vehicleListModel.addElement(vehicle);
        }
        return new JList<>(vehicleListModel);
    }

    // Metoda aktualizująca listę pojazdów dla wybranego salonu
    private void updateVehicleList(String selectedCenter) {
        JList<String> selectedVehicleList = vehicleLists.get(selectedCenter);
        if (selectedVehicleList != null) {
            vehiclePanel.removeAll();
            vehiclePanel.add(new JScrollPane(selectedVehicleList), BorderLayout.CENTER);
            headLabel.setText("Head");
            revalidate();
            repaint();
        } else {
            vehiclePanel.removeAll();
            headLabel.setText("Select a showroom to see vehicles");
            revalidate();
            repaint();
        }
    }

    // Metoda usuwająca wybrany salon
    private void removeSelectedShowroom() {
        String selectedCenter = centerList.getSelectedValue();
        if (selectedCenter != null) {
            try {
                vehicleLists.remove(selectedCenter);
                ((DefaultListModel<String>) centerList.getModel()).removeElement(selectedCenter);
                vehiclePanel.removeAll();
                headLabel.setText("Select a showroom to see vehicles");
                revalidate();
                repaint();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error occurred while removing the showroom: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Metoda usuwająca wybrany pojazd
    private void removeSelectedVehicle() {
        String selectedCenter = centerList.getSelectedValue();
        JList<String> selectedVehicleList = vehicleLists.get(selectedCenter);
        String selectedVehicle = selectedVehicleList.getSelectedValue();

        if (selectedCenter != null && selectedVehicle != null) {
            try {
                DefaultListModel<String> vehicleListModel = (DefaultListModel<String>) selectedVehicleList.getModel();
                vehicleListModel.removeElement(selectedVehicle);
                revalidate();
                repaint();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error occurred while removing the vehicle: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Metoda dodająca nowy salon
    private void addNewShowroom() {
        String newCenter = JOptionPane.showInputDialog("Enter the name of the new car showroom:");

        if (newCenter != null && !newCenter.isEmpty()) {
            ((DefaultListModel<String>) centerList.getModel()).addElement(newCenter);
            vehicleLists.put(newCenter, new JList<>(new DefaultListModel<>()));
            revalidate();
            repaint();
        }
    }

    // Metoda dodająca nowy pojazd
    private void addNewVehicle() {
        String selectedCenter = centerList.getSelectedValue();

        if (selectedCenter != null) {
            String newVehicle = JOptionPane.showInputDialog("Enter the name of the new vehicle:");

            if (newVehicle != null && !newVehicle.isEmpty()) {
                DefaultListModel<String> vehicleListModel = (DefaultListModel<String>) vehicleLists.get(selectedCenter).getModel();
                vehicleListModel.addElement(newVehicle);
                revalidate();
                repaint();
            }
        }
    }

    // Metoda sortująca salony według obciążenia
    private void sortCentersByLoad() {
        // Tworzenie listy wpisów mapy zawierającej nazwy salonów i ich listy pojazdów
        List<Map.Entry<String, JList<String>>> sortedEntries = new ArrayList<>(vehicleLists.entrySet());

        // Sortowanie wpisów według rozmiaru listy pojazdów (obciążenia)
        sortedEntries.sort(Comparator.comparingInt(entry -> entry.getValue().getModel().getSize()));

        // Tworzenie nowego modelu listy salonów na podstawie posortowanych wpisów
        DefaultListModel<String> sortedListModel = new DefaultListModel<>();
        sortedEntries.forEach(entry -> sortedListModel.addElement(entry.getKey()));

        // Ustawienie nowego modelu jako modelu listy salonów
        centerList.setModel(sortedListModel);

        revalidate();

        repaint();
    }


    public static void main(String[] args) {
        // Testowe dane
        Map<String, List<String>> vehicleData = new HashMap<>();
        vehicleData.put("Center_1", Arrays.asList("Car_1", "Car_2", "Car_3"));
        vehicleData.put("Center_2", Arrays.asList("Car_4", "Car_5"));
        vehicleData.put("Center_3", Arrays.asList("Car_6"));

        List<String> centerNames = new ArrayList<>(vehicleData.keySet());

        // Tworzenie interfejsu graficznego
        SwingUtilities.invokeLater(() -> new CarShowroomGUI(vehicleData, centerNames));
    }
}
