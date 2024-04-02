package algorithm.training.one.lesson.tree.set;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class A_TheNumberOfDifferentNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String[] in = reader.readLine().split(" ");
        MySetA<String> mySet = new MySetA<>();
        for (String s : in) mySet.add(s);
        System.out.println(mySet.length());

    }
}

class MySetA<T extends Object>{
    private int size = 1;
    private int length = 0;
    private List[] data = new List[size];

    public MySetA() {
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
