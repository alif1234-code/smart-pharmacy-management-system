import java.util.ArrayList;

public class Pharmacy {

    String name;
    String location;

    ArrayList<MedicineStock> inventory = new ArrayList<>();

    public Pharmacy(String name, String location) {

        this.name = name;
        this.location = location;
    }

    public void addMedicine(String name, int quantity, double price) {

        inventory.add(new MedicineStock(name, quantity, price));

        System.out.println("Medicine added successfully");
    }

    public void showInventory() {

        System.out.println("\nInventory of " + name);

        for (MedicineStock m : inventory) {

            System.out.println(m.medicineName +
                    " | Qty: " + m.quantity +
                    " | Price: " + m.price);
        }
    }

    public MedicineStock findMedicine(String name) {

        for (MedicineStock m : inventory) {

            if (m.medicineName.equalsIgnoreCase(name)) {
                return m;
            }
        }

        return null;
    }
}