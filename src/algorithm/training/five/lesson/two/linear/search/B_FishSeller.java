package algorithm.training.five.lesson.two.linear.search;

import java.util.Scanner;

public class B_FishSeller {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), k = scanner.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextInt();

        int maxSell = 0;
        for (int i = 0; i < n; i++){
            for (int j = 1; j <= k && i + j < n; j++){
                if (a[i + j] - a[i] > maxSell){
                    maxSell = a[i + j] - a[i];
                }
            }
        }

        System.out.println(maxSell);
    }
}
