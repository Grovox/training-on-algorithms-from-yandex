package algorithm.training.five.lesson.two.linear.search;

import java.util.Scanner;

public class C_PetyaMashaAndTheRopes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int max = 0;
        int sum = 0;
        for (int i = 0; i < n; i++){
            int a = scanner.nextInt();
            sum += a;
            if (a > max) max = a;
        }

        if (sum - max >= max){
            System.out.println(sum);
        }else System.out.println(max - (sum - max));
    }
}
