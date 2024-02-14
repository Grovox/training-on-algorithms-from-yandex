package One.Lesson4DictionariesAndSortingByCounting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

public class F_Sales {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        Map<String, TreeMap<String, Long>> database = new TreeMap<>();
        String line;
        while ((line = reader.readLine()) != null && !line.equals("")){
            String[] lineDateBase = line.split(" ");
            Long price = Long.parseLong(lineDateBase[2]);
            if (database.get(lineDateBase[0]) == null){
                TreeMap<String, Long> byes = new TreeMap<>();
                byes.put(lineDateBase[1], price);
                database.put(lineDateBase[0], byes);
            }else{
                TreeMap<String, Long> byes = database.get(lineDateBase[0]);
                if (byes.get(lineDateBase[1]) == null){
                    byes.put(lineDateBase[1], price);
                }else byes.put(lineDateBase[1], byes.get(lineDateBase[1]) + price);
            }
        }

        PrintWriter writer = new PrintWriter("output.txt");
        for (Map.Entry<String, TreeMap<String, Long>> entryDatabase : database.entrySet()){
            writer.println(entryDatabase.getKey() + ":");
            for (Map.Entry<String, Long> entryByes : entryDatabase.getValue().entrySet()){
                writer.println(entryByes.getKey() + " " + entryByes.getValue());
            }
        }
        writer.flush();
        writer.close();
    }
}
