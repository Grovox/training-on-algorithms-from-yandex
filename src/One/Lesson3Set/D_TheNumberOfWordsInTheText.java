package One.Lesson3Set;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class D_TheNumberOfWordsInTheText {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        Set<String> set = new HashSet<>();
        while (reader.ready()){
            String[] in = reader.readLine().split(" ");
            for (int i = 0; i < in.length; i++){
                in[i].replace(" ", "");
                if (!in[i].equals("")) set.add(in[i]);
            }
        }
        System.out.println(set.size());
    }
}
