package algorithm.training.one.lesson.four.dictionaries.and.sorting.by.counting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class F_Sales {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        Map<String, TreeMap<String, Long>> database = new TreeMap<>();
        String line;
        while ((line = reader.readLine()) != null && !line.equals("")){
            StringTokenizer stringTokenizer = new StringTokenizer(line, " ");
            String buyer = stringTokenizer.nextToken();
            String product = stringTokenizer.nextToken();
            Long price = Long.parseLong(stringTokenizer.nextToken());
            if (!database.containsKey(buyer)){
                TreeMap<String, Long> byes = new TreeMap<>();
                byes.put(product, price);
                database.put(buyer, byes);
            }else{
                TreeMap<String, Long> byes = database.get(buyer);
                if (!byes.containsKey(product)){
                    byes.put(product, price);
                }else byes.put(product, byes.get(product) + price);
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
