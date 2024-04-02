package algorithm.training.five.lesson.tree.sets.and.dictionaries;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class B_AnAnagram {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        Map<Character, Integer> starsWord = new HashMap<>();
        String word1 = reader.readLine();
        for (int i = 0; i < word1.length(); i++){
            char key = word1.charAt(i);
            starsWord.put(key, starsWord.getOrDefault(key, 0) + 1);
        }
        String word2 = reader.readLine();
        boolean ans = word1.length() == word2.length();
        int len = starsWord.size();
        for (int i = 0; i < word2.length() && ans; i++){
            char key = word2.charAt(i);
            ans = starsWord.containsKey(key);
            starsWord.put(key, starsWord.getOrDefault(key, 0) - 1);
            if (starsWord.get(key) == 0) len--;
        }
        if (ans && len != 0) ans = false;
        if (ans){
            System.out.println("YES");
        }else System.out.println("NO");
    }
}
