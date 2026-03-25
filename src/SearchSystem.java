import java.util.*;

public class SearchSystem {

    static Scanner sc = new Scanner(System.in);

    public static void searchMedicine(String input) {

        input = input.trim().toLowerCase();

        MedicineInfo exactMatch = null;

        ArrayList<MedicineInfo> prefixMatches = new ArrayList<>();
        ArrayList<MedicineInfo> containsMatches = new ArrayList<>();


        for (MedicineInfo m : DatabaseLoader.medicines) {

            String name = m.name.toLowerCase();
            String generic = m.generic.toLowerCase();


            if (name.equals(input)) {
                exactMatch = m;
            }

            else if (name.startsWith(input)) {
                prefixMatches.add(m);
            }

            else if (name.contains(input) || generic.contains(input)) {
                containsMatches.add(m);
            }
        }


        if (exactMatch != null) {

            showMedicineDetails(exactMatch);
            showAvailability(exactMatch.name);
            return;
        }


        ArrayList<MedicineInfo> rankedResults = new ArrayList<>();

        rankedResults.addAll(prefixMatches);
        rankedResults.addAll(containsMatches);


        if (rankedResults.size() == 0) {

            System.out.println("\nMedicine not found.");
            return;
        }


        System.out.println("\nSuggestions:\n");

        int limit = Math.min(30, rankedResults.size());

        for (int i = 0; i < limit; i++) {

            MedicineInfo m = rankedResults.get(i);

            System.out.println((i + 1) + ". " + m.name +
                    " | Generic: " + m.generic);
        }


        System.out.print("\nSelect medicine number (0 to cancel): ");

        int choice = sc.nextInt();
        sc.nextLine();


        if (choice > 0 && choice <= limit) {

            MedicineInfo selected = rankedResults.get(choice - 1);

            showMedicineDetails(selected);

            showAvailability(selected.name);
        }
    }



    public static void showMedicineDetails(MedicineInfo m) {

        System.out.println("\nMedicine Found!\n");

        System.out.println("Name: " + m.name);
        System.out.println("Generic: " + m.generic);
        System.out.println("Manufacturer: " + m.manufacturer);

        DrugInfo info = DrugInfoLoader.getDrugInfo(m.generic);

        if (info != null) {

            System.out.println("\nUses: " + info.condition);
            System.out.println("Side Effects: " + info.review);

        } else {

            System.out.println("\nDrug information not available.");
        }
    }



    public static void showAvailability(String medicine) {

        System.out.println("\nAvailable at:");

        boolean available = false;

        for (Pharmacy p : PharmacySystem.pharmacies) {

            for (MedicineStock m : p.inventory) {

                if (m.medicineName.equalsIgnoreCase(medicine)) {

                    System.out.println(
                            p.name + " | Qty: " + m.quantity +
                                    " | Price: " + m.price
                    );

                    available = true;
                }
            }
        }

        if (!available) {

            System.out.println("No pharmacy currently has this medicine.");
        }
    }
}