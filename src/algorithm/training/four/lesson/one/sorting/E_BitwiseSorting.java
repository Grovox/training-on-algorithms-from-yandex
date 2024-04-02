package algorithm.training.four.lesson.one.sorting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class E_BitwiseSorting {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(reader.readLine());
        String[] a = new String[N];
        for(int i = 0; i < N; i++) a[i] = reader.readLine();

        int size = a[0].length();
        String[] result = new String[N];

        PrintWriter writer = new PrintWriter("output.txt");

        writer.println("Initial array:");
        writer.println(Arrays.toString(a).replace("[", "").replace("]", ""));
        writer.println("**********");

        int[] count = new int[10];
        int[] pos = new int[10];
        for(int i = size - 1; i >= 0; i--){
            for (int j = 0; j < N; j++){
                char c = a[j].charAt(i);
                if(c == '0'){
                    count[0]++;
                }else if(c == '1'){
                    count[1]++;
                }else if(c == '2'){
                    count[2]++;
                }else if(c == '3'){
                    count[3]++;
                }else if(c == '4'){
                    count[4]++;
                }else if(c == '5'){
                    count[5]++;
                }else if(c == '6'){
                    count[6]++;
                }else if(c == '7'){
                    count[7]++;
                }else if(c == '8'){
                    count[8]++;
                }else if(c == '9'){
                    count[9]++;
                }
            }

            for (int j = 1; j < 10; j++){
                if(count[j - 1] == 0){
                    pos[j] = pos[j - 1];
                }else pos[j] = pos[j - 1] + count[j - 1];
            }

            for (int j = 0; j < N; j++){
                char c = a[j].charAt(i);
                if(c == '0') {
                    result[pos[0]] = a[j];
                    pos[0]++;
                }else if(c == '1') {
                    result[pos[1]] = a[j];
                    pos[1]++;
                }else if(c == '2') {
                    result[pos[2]] = a[j];
                    pos[2]++;
                }else if(c == '3') {
                    result[pos[3]] = a[j];
                    pos[3]++;
                }else if(c == '4') {
                    result[pos[4]] = a[j];
                    pos[4]++;
                }else if(c == '5') {
                    result[pos[5]] = a[j];
                    pos[5]++;
                }else if(c == '6') {
                    result[pos[6]] = a[j];
                    pos[6]++;
                }else if(c == '7') {
                    result[pos[7]] = a[j];
                    pos[7]++;
                }else if(c == '8') {
                    result[pos[8]] = a[j];
                    pos[8]++;
                }else if(c == '9') {
                    result[pos[9]] = a[j];
                    pos[9]++;
                }
            }

            writer.println("Phase " + (size - i));

            int k = 0;
            for (int j = 0; j < 10; j++){
                writer.print("Bucket " + j + ": ");
                if(count[j] == 0) writer.append("empty");
                while (count[j] != 0) {
                    writer.print(result[k]);
                    k++;
                    count[j]--;
                    if(count[j] > 0) writer.append(", ");
                }
                writer.append("\n");
            }
            writer.println("**********");
            a = result.clone();
            pos = new int[10];

        }
        writer.println("Sorted array:");
        writer.println(Arrays.toString(result).replace("[","").replace("]",""));
        writer.flush();
        writer.close();
    }
}