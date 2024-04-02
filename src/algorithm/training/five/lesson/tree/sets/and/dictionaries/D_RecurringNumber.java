package algorithm.training.five.lesson.tree.sets.and.dictionaries;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class D_RecurringNumber {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String[] in = reader.readLine().split(" ");
        int n = Integer.parseInt(in[0]), k = Integer.parseInt(in[1]);
        Map<String, Set<Integer>> a = new HashMap<>();
        boolean ans = false;
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        for (int i = 0; i < n; i++){
            String num = tokenizer.nextToken();
            if (!ans){
                if (!a.containsKey(num)){
                    a.put(num, new HashSet<>());
                }else {
                    for (int index : a.get(num)){
                        if (Math.abs(i - index) <= k) {
                            ans = true;
                            break;
                        }
                    }
                }
                a.get(num).add(i);
            }
        }

        if (ans){
            System.out.println("YES");
        }else System.out.println("NO");
    }
}
