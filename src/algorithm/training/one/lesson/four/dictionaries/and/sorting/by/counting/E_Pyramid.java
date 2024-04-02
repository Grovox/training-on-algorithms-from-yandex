package algorithm.training.one.lesson.four.dictionaries.and.sorting.by.counting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class E_Pyramid {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(reader.readLine());
        Map<String, Integer> blocks = new HashMap<>();
        long result = 0;
        for (int i = 0; i < n; i++){
            String[] in = reader.readLine().split(" ");
            int h = Integer.parseInt(in[1]);
            if (blocks.get(in[0]) == null){
                result += h;
                blocks.put(in[0],h);
            }else if (blocks.get(in[0]) < h){
                result += h - blocks.get(in[0]);
                blocks.put(in[0], h);
            }
        }
        System.out.println(result);
    }
}
