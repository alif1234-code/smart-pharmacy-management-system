import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class DrugInfoLoader {

    public static HashMap<String, DrugInfo> drugMap = new HashMap<>();


    public static void loadDrugInfo() {

        try {

            BufferedReader br = new BufferedReader(new FileReader("drugsComTrain_raw.csv"));

            String line;

            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {

                String[] data = line.split("," , 7);

                if (data.length < 4) continue;

                String drug = data[1].toLowerCase().trim();
                String condition = data[2];
                String review = data[3];

                DrugInfo info = new DrugInfo(drug, condition, review);

                drugMap.put(drug, info);
            }

            br.close();

            System.out.println("Drug info loaded: " + drugMap.size());

        }

        catch (Exception e) {

            System.out.println("Error loading drug info database");
        }
    }



    public static DrugInfo getDrugInfo(String generic) {

        return drugMap.get(generic.toLowerCase());
    }
}