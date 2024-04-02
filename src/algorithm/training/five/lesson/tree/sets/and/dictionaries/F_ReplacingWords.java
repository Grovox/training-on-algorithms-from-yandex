package algorithm.training.five.lesson.tree.sets.and.dictionaries;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;

public class F_ReplacingWords {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        Map<Character, Set<String>> dictionary = new HashMap<>();
        StringTokenizer in = new StringTokenizer(reader.readLine(), " ");
        int maxSize = 0;
        while (in.hasMoreTokens()){
            String val = in.nextToken();
            if (val.length() > maxSize) maxSize = val.length();
            if (!dictionary.containsKey(val.charAt(0))) dictionary.put(val.charAt(0), new HashSet<>());
            dictionary.get(val.charAt(0)).add(val);
        }

        List<String> ans = new ArrayList<>();
        in = new StringTokenizer(reader.readLine(), " ");
        while (in.hasMoreTokens()){
            String val = in.nextToken();
            String reduction = null;
            if (dictionary.containsKey(val.charAt(0))){
                Set<String> partDictionary = dictionary.get(val.charAt(0));
                String testReduction = "";
                for (int i = 0; i < val.length() && i < maxSize && reduction == null; i++){
                    testReduction += val.charAt(i);
                    if (partDictionary.contains(testReduction)){
                        reduction = testReduction;
                    }
                }
            }
            if (reduction != null){
                ans.add(reduction);
            }else  ans.add(val);
        }
        PrintWriter writer = new PrintWriter("output.txt");
        for (String an : ans) writer.print(an + " ");
        writer.flush();
        writer.close();
    }
}
