import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DatabaseLoader.loadMedicines();
        DrugInfoLoader.loadDrugInfo();

        System.out.println("Loaded medicines: " + DatabaseLoader .medicines.size());

        System.out.println("Database loaded: "
                + DatabaseLoader.medicines.size());

        while (true) {

            System.out.println("\n===== Pharmacy System =====");

            System.out.println("1 Search Medicine");
            System.out.println("2 Create Pharmacy");
            System.out.println("3 Show Pharmacies");
            System.out.println("4 Add Medicine to Pharmacy");
            System.out.println("5 Show Pharmacy Inventory");
            System.out.println("6 Place Order");
            System.out.println("7 Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.print("Enter medicine: ");
                String name = sc.nextLine();

                SearchSystem.searchMedicine(name);
            }

            else if (choice == 2) {

                System.out.print("Pharmacy name: ");
                String name = sc.nextLine();

                System.out.print("Location: ");
                String loc = sc.nextLine();

                PharmacySystem.createPharmacy(name, loc);
            }

            else if (choice == 3) {

                PharmacySystem.showPharmacies();
            }

            else if (choice == 4) {

                System.out.print("Pharmacy name: ");
                String p = sc.nextLine();

                Pharmacy ph = PharmacySystem.findPharmacy(p);

                if (ph != null) {

                    System.out.print("Medicine name: ");
                    String med = sc.nextLine();

                    System.out.print("Quantity: ");
                    int q = sc.nextInt();

                    System.out.print("Price: ");
                    double pr = sc.nextDouble();
                    sc.nextLine();

                    ph.addMedicine(med, q, pr);

                } else {

                    System.out.println("Pharmacy not found");
                }
            }

            else if (choice == 5) {

                System.out.print("Pharmacy name: ");
                String p = sc.nextLine();

                Pharmacy ph = PharmacySystem.findPharmacy(p);

                if (ph != null) {

                    ph.showInventory();
                }
            }

            else if (choice == 6) {

                System.out.print("Medicine: ");
                String med = sc.nextLine();

                System.out.print("Pharmacy: ");
                String ph = sc.nextLine();

                System.out.print("Customer: ");
                String cust = sc.nextLine();

                System.out.print("Quantity: ");
                int q = sc.nextInt();
                sc.nextLine();

                PharmacySystem.placeOrder(med, ph, cust, q);
            }

            else if (choice == 7) {

                System.out.println("Exiting...");
                break;
            }
        }
    }
}