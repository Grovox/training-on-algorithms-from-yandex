package algorithm.training.one.lesson.one.complexity.testing.special.cases;

import java.util.Scanner;

public class H_Metro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt(), b = scanner.nextInt(), n = scanner.nextInt(), m = scanner.nextInt();
        int minA = n + a * (n - 1), minB = m + b * (m - 1), maxA = n + a * (n + 1), maxB = m + b * (m + 1);
        if(minA > maxB || maxA < minB){
            System.out.println(-1);
        }else {
            System.out.println(Math.max(minA, minB) + " " + Math.min(maxA, maxB));
        }
    }
}
