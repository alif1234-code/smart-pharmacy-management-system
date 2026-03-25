import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class DatabaseLoader {

    public static ArrayList<MedicineInfo> medicines = new ArrayList<>();

    public static void loadMedicines() {

        try {

            BufferedReader br = new BufferedReader(new FileReader("medicine.csv"));

            String line;

            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length < 8) continue;

                String name = data[1].trim();        // brand_name
                String generic = data[5].trim();     // generic
                String manufacturer = data[7].trim();// manufacturer

                MedicineInfo m = new MedicineInfo(name, generic, manufacturer);

                medicines.add(m);
            }

            br.close();

        } catch (Exception e) {

            System.out.println("Error loading medicine database");
            e.printStackTrace();
        }
    }
}