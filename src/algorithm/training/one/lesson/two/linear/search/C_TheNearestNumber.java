package algorithm.training.one.lesson.two.linear.search;

import java.util.Scanner;

public class C_TheNearestNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] mass  = new int[n];
        for (int i = 0; i < n; i++){
            mass[i] = scanner.nextInt();
        }
        int x = scanner.nextInt();
        int result = mass[0];
        for (int i = 1; i < n; i++){
            if(Math.abs(x - result) > Math.abs(x - mass[i])){
                result = mass[i];
            }
        }
        System.out.println(result);
    }
}
