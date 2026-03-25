import java.util.ArrayList;

public class PharmacySystem {

    public static ArrayList<Pharmacy> pharmacies = new ArrayList<>();
    public static ArrayList<Order> orders = new ArrayList<>();

    public static void createPharmacy(String name, String location) {

        pharmacies.add(new Pharmacy(name, location));

        System.out.println("Pharmacy created");
    }

    public static Pharmacy findPharmacy(String name) {

        for (Pharmacy p : pharmacies) {

            if (p.name.equalsIgnoreCase(name)) {

                return p;
            }
        }

        return null;
    }

    public static void showPharmacies() {

        System.out.println("\nAvailable Pharmacies:");

        for (Pharmacy p : pharmacies) {

            System.out.println(p.name + " | " + p.location);
        }
    }

    public static void placeOrder(String medicine,
                                  String pharmacy,
                                  String customer,
                                  int qty) {

        orders.add(new Order(medicine, pharmacy, customer, qty));

        System.out.println("Order placed successfully");
    }
}