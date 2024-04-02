package algorithm.training.five.lesson.two.linear.search;

import java.util.Scanner;

public class F_TheWheelOfFortune {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] c = new int[n];
        for (int i = 0; i < n; i++) c[i] = scanner.nextInt();
        int a = scanner.nextInt(), b = scanner.nextInt(), k = scanner.nextInt();

        int maxLeft, indexLeft;
        int maxRight, indexRight;

        int start = a / k;
        if (a % k == 0 && start > 0) start--;
        if (start != 0){
            if (start > n) start %= n;
            indexLeft = n - start;
            indexRight = start;
            maxLeft = c[indexLeft];
            maxRight = c[indexRight];
        }else {
            indexLeft = 0;
            indexRight = 0;
            maxLeft = c[0];
            maxRight = c[0];
        }

        int end = b / k;
        if ((b % k) == 0) end--;
        end -= start;
        if (end > n) end %= n;
        if (((b - a) / k) >= n) end = n;
        if (a >= b) end = 0;

        for (int i = 0; i < end || (start == 0 && i <= end); i++){
            if (maxLeft < c[indexLeft]) maxLeft = c[indexLeft];
            if (maxRight < c[indexRight]) maxRight = c[indexRight];

            indexLeft--;
            indexRight++;
            if (indexLeft == -1) indexLeft = n - 1;
            if (indexRight == n) indexRight = 0;
        }

        System.out.println(Math.max(maxLeft, maxRight));
    }
}
