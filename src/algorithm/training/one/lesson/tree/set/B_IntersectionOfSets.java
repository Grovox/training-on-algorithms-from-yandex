package algorithm.training.one.lesson.tree.set;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class B_IntersectionOfSets {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String[] line1 = reader.readLine().split(" ");
        String[] line2 = reader.readLine().split(" ");

        MySetB<String> mySet = new MySetB<>();

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1) - Integer.parseInt(o2);
            }
        };

        Queue<String> result = new PriorityQueue<>(comparator);
        for(int i = 0; i < line1.length; i++) mySet.add(line1[i]);
        for(int i = 0; i < line2.length; i++){
            if(mySet.contains(line2[i])){
                result.offer(line2[i]);
            }
        }
        PrintWriter writer = new PrintWriter("output.txt");
        while (result.size() > 0) writer.print(result.poll() + " ");
        writer.flush();
        writer.close();
    }
}


class MySetB<T extends Object>{
    private int size = 1;
    private int length = 0;
    private List[] data = new List[size];

    public MySetB() {
        data[0] = new ArrayList<>();
    }

    public void add(T e){
        if(!contains(e)) {
            length++;
            data[e.hashCode() % size].add(e);
        }

        if(length == size){
            List[] buffet = data;
            size *= 2;
            data = new List[size];
            for (int i = 0; i < size; i++) data[i] = new ArrayList<>();
            for (int i = 0; i < buffet.length; i++){
                for (int j = 0; j < buffet[i].size(); j++){
                    data[buffet[i].get(j).hashCode() % size].add(buffet[i].get(j));
                }
            }
        }
    }

    public boolean contains(T e){
        int hash = e.hashCode() % size;
        for (int i = 0; i < data[hash].size(); i++){
            if(data[hash].get(i).equals(e)){
                return true;
            }
        }
        return false;
    }

    public int length() {
        return length;
    }
}
