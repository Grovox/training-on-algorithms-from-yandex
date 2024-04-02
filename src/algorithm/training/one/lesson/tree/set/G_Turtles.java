package algorithm.training.one.lesson.tree.set;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class G_Turtles {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        int size = Integer.parseInt(reader.readLine());
        Set<String> set = new HashSet<>();
        int result = 0;
        for (int i = 0; i < size; i++){
            String in = reader.readLine();
            if(!set.contains(in)){
                set.add(in);
                String[] elements = in.split(" ");
                if(Integer.parseInt(elements[0]) >= 0 && Integer.parseInt(elements[1]) >= 0 && Integer.parseInt(elements[0]) + Integer.parseInt(elements[1]) + 1 == size){
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}