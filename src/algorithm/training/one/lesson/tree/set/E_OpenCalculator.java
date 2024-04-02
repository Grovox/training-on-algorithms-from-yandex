package algorithm.training.one.lesson.tree.set;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class E_OpenCalculator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        Set<String> haveNum = new HashSet<>(List.of(reader.readLine().split(" ")));
        Set<String> DontHaveNum = new HashSet<>();
        String[] in = reader.readLine().split("");
        for (int i = 0; i < in.length; i++){
            if(!haveNum.contains(in[i])){
                DontHaveNum.add(in[i]);
            }
        }

        System.out.println(DontHaveNum.size());
    }
}
