package algorithm.training.one.lesson.four.dictionaries.and.sorting.by.counting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class H_DecipheringTheMayaScript {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String[] in = reader.readLine().split(" ");
        int g = Integer.parseInt(in[0]), s = Integer.parseInt(in[1]);
        String line = reader.readLine();
        Map<Character, Integer> letters = new HashMap<>();
        for(int i = 0; i < g; i++){
            char key = line.charAt(i);
            letters.put(key, letters.getOrDefault(key,0) + 1);
        }

        line = reader.readLine();
        Map<Character, Integer> testLetters = new HashMap<>();
        for(int i = 0; i < g; i++){
            char key = line.charAt(i);
            testLetters.put(key, testLetters.getOrDefault(key, 0) + 1);
        }
        int ans = 0;
        int incidents = 0;
        for(char key : testLetters.keySet()){
            if (letters.containsKey(key) && letters.get(key).equals(testLetters.get(key))) incidents++;
        }
        if (incidents == letters.size()) ans++;

        for(int i  = 1; i < s - g + 1; i++){
            incidents += changeLetters(letters, testLetters, line.charAt(i - 1), -1);
            incidents += changeLetters(letters, testLetters, line.charAt(i + g - 1), 1);

            if (incidents == letters.size()) ans++;
        }
        System.out.println(ans);
    }

    public static int changeLetters(Map<Character, Integer> letters, Map<Character, Integer> testLetters, char key, int modifier){
       int ans = 0;
        if (letters.containsKey(key) && letters.get(key).equals(testLetters.get(key))) ans = -1;
        testLetters.put(key, testLetters.getOrDefault(key, 0) + modifier);
        if (letters.containsKey(key) && letters.get(key).equals(testLetters.get(key))) ans = 1;
        return ans;
    }
}