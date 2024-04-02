package algorithm.training.one.lesson.four.dictionaries.and.sorting.by.counting;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class D_Keyboard {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] c = new int[n + 1];
        for (int i = 1; i <= n; i++) c[i] = scanner.nextInt();
        int k = scanner.nextInt();
        for (int i = 0; i < k; i++) c[scanner.nextInt()]--;
        PrintWriter writer = new PrintWriter("output.txt");
        for (int i = 1; i <= n; i++){
            if(c[i] < 0){
                writer.println("YES");
            }else writer.println("NO");
        }
        writer.flush();
        writer.close();
    }
}
