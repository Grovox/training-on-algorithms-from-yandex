package algorithm.training.one.lesson.four.dictionaries.and.sorting.by.counting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class I_StressTest {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(reader.readLine());
        Map<String, Set<String>> dictionary = new HashMap<>();
        for(int i = 0; i < n; i++){
            String in = reader.readLine();
            String simpleWord = in.toLowerCase();
            if(!dictionary.containsKey(simpleWord)){
                Set<String> words = new HashSet<>();
                words.add(in);
                dictionary.put(simpleWord, words);
            }else dictionary.get(simpleWord).add(in);
        }
        int ans = 0;
        String line = reader.readLine();
        StringTokenizer text = new StringTokenizer(line, " ");

        while(text.hasMoreTokens()){
                String word = text.nextToken();
                String simpleWord = word.toLowerCase();
                if(word.equals(simpleWord) || duplicateUpperCase(word)) {
                    ans++;
                    continue;
                }
                if(dictionary.containsKey(simpleWord)){
                    if(!dictionary.get(simpleWord).contains(word)) ans++;
                }
        }
        System.out.println(ans);
    }
    public static boolean duplicateUpperCase(String word) {
        boolean lastUpperCase = false;
        for(int i = 0; i < word.length(); i++) {
            boolean upperCase = Character.isUpperCase(word.charAt(i));
            if (lastUpperCase && upperCase) return true;
            if(upperCase) lastUpperCase = upperCase;
        }
        return false;
    }
}
