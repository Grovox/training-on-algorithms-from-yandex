package algorithm.training.five.lesson.four.binary.search;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class A_QuickArraySearch {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] mass = new int[n];
        for (int i = 0; i < n; i++) mass[i] = scanner.nextInt();
        Arrays.sort(mass);
        int k = scanner.nextInt();

        PrintWriter writer = new PrintWriter("output.txt");
        for (int i = 0; i < k; i++){
            int L = scanner.nextInt(), R = scanner.nextInt();
            int indexMin = 0;
            if (mass[0] > R || mass[mass.length - 1] < L){
                writer.print("0 ");
                continue;
            }
            if (mass[indexMin] < L) indexMin = lBinSearch(0, mass.length - 1, mass, L);
            int indexMax = mass.length - 1;
            if (mass[indexMin] > R){
                writer.print("0 ");
                continue;
            }
            if (mass[indexMax] > R) indexMax = rBinSearch(indexMin, mass.length - 1, mass, R);

            writer.print((indexMax - indexMin + 1) + " ");
        }
        writer.flush();
        writer.close();
    }
    public static int lBinSearch(int l, int r, int[] mass, int L){
        int m = 0;
        while (l < r){
            m = (l + r) / 2;
            if (mass[m] >= L) {
                r = m;
            }else l = m + 1;
        }
        return l;
    }
    public static int rBinSearch(int l, int r, int[] mass, int R){
        int m = 0;
        while (l < r){
            m = (l + r + 1) / 2;
            if (mass[m] <= R){
                l = m;
            } else r = m - 1;
        }
        return l;
    }
}
