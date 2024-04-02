package algorithm.training.one.lesson.four.dictionaries.and.sorting.by.counting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class B_TheNumberOfTheWordAppearance {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        Map<String, Integer> counter = new HashMap<>();
        PrintWriter writer = new PrintWriter("output.txt");

        String line;
        while ((line = reader.readLine()) != null && !line.equals("")) {
            String[] in = line.split(" ");
            for (int i = 0; i < in.length; i++) {
                writer.print(counter.getOrDefault(in[i], 0) + " ");
                counter.put(in[i], counter.getOrDefault(in[i], 0) + 1);
            }
        }
        writer.flush();
        writer.close();
    }
}
