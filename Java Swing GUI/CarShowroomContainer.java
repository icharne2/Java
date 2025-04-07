import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarShowroomContainer {
    private Map<String, CarShowroom> showrooms;

    public CarShowroomContainer() {
        this.showrooms = new HashMap<>();
    }

    public void addCenter(String showroomName, int maxCapacity) {
        if (!showrooms.containsKey(showroomName)) {
            CarShowroom newShowroom = new CarShowroom(showroomName, maxCapacity);
            showrooms.put(showroomName, newShowroom);
        }
    }
    public void removeCenter(String showroomName) {
        if (!showrooms.containsKey(showroomName)) {
            System.out.println("The showroom named " + showroomName + " does not exist!");
            return;
        }
        showrooms.remove(showroomName);
    }
    public List<String> findEmptyShowrooms() {
        List<String> emptyShowrooms = new ArrayList<>();
        for (Map.Entry<String, CarShowroom> entry : showrooms.entrySet()) {
            String showroomName = entry.getKey();
            CarShowroom showroom = entry.getValue();
            if (showroom.getCapacity() == 0) {
                emptyShowrooms.add(showroomName);
            }
        }
        System.out.println("Empty showroom was found");
        return emptyShowrooms;
    }
    public void summary() {
        for (Map.Entry<String, CarShowroom> entry : showrooms.entrySet()) {
            String showroomName = entry.getKey();
            CarShowroom showroom = entry.getValue();
            int capacity = showroom.getCapacity();
            double filledPercentage = (double) showroom.getCapacity() / showroom.getMaxCapacity() * 100;
            System.out.println("Showroom: " + showroomName + ", Filled: " + filledPercentage+ " %");
        }
    }
    public List<String> displayAvailableShowrooms() {
        System.out.println("Showrooms with capacity less than max capacity:");
        for (Map.Entry<String, CarShowroom> entry : showrooms.entrySet()) {
            String showroomName = entry.getKey();
            CarShowroom showroom = entry.getValue();
            if (showroom.getCapacity() < showroom.getMaxCapacity()) {
                System.out.println("Showroom: " + showroomName + ", Filled: " + showroom.getCapacity()+ " out of " + showroom.getMaxCapacity());
            }
        }
        return null;
    }
    public CarShowroom getShowroom(String showroomName) {
        return showrooms.get(showroomName);
    }

    public Map<Object, Object> getShowrooms() {
        return Map.of();
    }
}
