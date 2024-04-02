package algorithm.training.five.lesson.tree.sets.and.dictionaries;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class C_DeletingNumbers {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(reader.readLine());
        Map<Integer, Integer> numRepeat = new HashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int sizeNums = 0;
        int max = 0;
        for (int i = 0; i < n; i++){
            sizeNums ++;
            int a = Integer.parseInt(tokenizer.nextToken());
            numRepeat.put(a, numRepeat.getOrDefault(a, 0) + 1);

            int count = numRepeat.get(a);
            count += Math.max(numRepeat.getOrDefault(a - 1, 0), numRepeat.getOrDefault(a + 1, 0));
            if (count > max) max = count;
        }

        System.out.println(sizeNums - max);
    }
}
