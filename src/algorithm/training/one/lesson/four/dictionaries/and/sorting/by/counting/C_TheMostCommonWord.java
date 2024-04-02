package algorithm.training.one.lesson.four.dictionaries.and.sorting.by.counting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class C_TheMostCommonWord {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        Map<String, Integer> counter = new HashMap<>();

        int numRepeatResult = 0;
        String result = "";
        String line;
        while ((line = reader.readLine()) != null && !line.equals("")) {
            String[] in = line.split(" ");
            for (int i = 0; i < in.length; i++) {
                counter.put(in[i], counter.getOrDefault(in[i], 0) + 1);
                if(counter.get(in[i]) > numRepeatResult){
                    result = in[i];
                    numRepeatResult = counter.get(in[i]);
                } else if (counter.get(in[i]) == numRepeatResult){
                    if(in[i].compareTo(result) < 0){
                        result = in[i];
                    }
                }
            }
        }

        PrintWriter writer = new PrintWriter("output.txt");
        writer.println(result);
        writer.flush();
        writer.close();
    }
}
