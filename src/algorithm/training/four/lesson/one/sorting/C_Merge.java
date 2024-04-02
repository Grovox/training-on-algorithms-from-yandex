package algorithm.training.four.lesson.one.sorting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class C_Merge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(reader.readLine());
        String[] in = reader.readLine().split(" ");
        int[] a;
        if(!in[0].equals("")){
            a = Arrays.stream(in).mapToInt(Integer::parseInt).toArray();
        }else a = new int[0];
        int M = Integer.parseInt(reader.readLine());
        in = reader.readLine().split(" ");
        int[] b;
        if(!in[0].equals("")){
            b = Arrays.stream(in).mapToInt(Integer::parseInt).toArray();
        }else b = new int[0];

        PrintWriter writer = new PrintWriter("output.txt");
        writer.print(Arrays.toString(merge(a, b)).replace(",", "").replace("[", "").replace("]", ""));
        writer.flush();
        writer.close();
    }

    public static int[] merge(int[] arr1, int[] arr2){
        int index1 = 0;
        int index2 = 0;

        int end1 = arr1.length;
        int end2 = arr2.length;

        int[] dest = new int[end1 + end2];

        int iterationCount = end1 + end2;

        for(int i = 0; i <  iterationCount; i++){
            if( index1 < end1 && (index2 >= end2 || arr1[index1] < arr2[index2])){
                dest[i] = arr1[index1];
                index1++;
            } else {
                dest[i] = arr2[index2];
                index2++;
            }
        }
        return dest;
    }
}
