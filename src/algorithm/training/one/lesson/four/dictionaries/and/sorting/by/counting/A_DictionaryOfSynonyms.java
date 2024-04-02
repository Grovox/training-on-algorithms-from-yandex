package algorithm.training.one.lesson.four.dictionaries.and.sorting.by.counting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class A_DictionaryOfSynonyms {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(reader.readLine());
        Map<String, String> dictionary = new HashMap<>();
        for (int i = 0; i < n; i++){
            String[] in = reader.readLine().split(" ");
            dictionary.put(in[0],in[1]);
            dictionary.put(in[1],in[0]);
        }
        PrintWriter writer = new PrintWriter("output.txt");
        writer.println(dictionary.get(reader.readLine()));
        writer.flush();
        writer.close();
    }
}
