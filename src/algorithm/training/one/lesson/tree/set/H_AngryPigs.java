package algorithm.training.one.lesson.tree.set;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class H_AngryPigs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(reader.readLine());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++){
            String[] in = reader.readLine().split(" ");
            set.add(in[0]);
        }
        System.out.println(set.size());
    }
}
