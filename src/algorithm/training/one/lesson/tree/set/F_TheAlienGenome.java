package algorithm.training.one.lesson.tree.set;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class F_TheAlienGenome {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String Gen1 = reader.readLine();
        String Gen2 = reader.readLine();
        HashMap<String,Integer> hashMap = new HashMap<>();
        for (int i = 0, j = 2; j <= Gen1.length(); i++, j++){
            hashMap.put(Gen1.substring(i, j), hashMap.getOrDefault(Gen1.substring(i, j), 0) + 1);
        }
        int result = 0;
        Set<String> set = new HashSet<>();
        for (int i = 0, j = 2; j <= Gen2.length(); i++, j++){
            if(!set.contains(Gen2.substring(i, j))){
                result += hashMap.getOrDefault(Gen2.substring(i, j), 0);
                set.add(Gen2.substring(i, j));
            }
        }
        System.out.println(result);
    }
}
