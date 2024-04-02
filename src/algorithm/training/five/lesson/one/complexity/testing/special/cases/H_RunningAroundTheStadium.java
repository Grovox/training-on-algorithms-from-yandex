package algorithm.training.five.lesson.one.complexity.testing.special.cases;

import java.util.Scanner;

public class H_RunningAroundTheStadium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int l = scanner.nextInt(), x1 = scanner.nextInt(), v1 = scanner.nextInt(), x2 = scanner.nextInt(), v2 = scanner.nextInt();


        if (x2 == x1 || (l - Math.max(x1, x2)) == Math.min(x1, x2)){
            System.out.println("YES");
            System.out.println(0.0);
        }else {
            if (v1 == 0 && v2 == 0) {
                System.out.println("NO");
            } else {
                double t1 = Double.MAX_VALUE, t2 = Double.MAX_VALUE;
                for (int i = -1; i < 3; i++) {
                    double d = (double) (l * i - x1 - x2) / (v1 + v2);
                    if (d > 0) t1 = Math.min(t1,d);
                }

                for (int i = -1; i < 3; i++) {
                    double d = (double) (l * i - x1 + x2) / (v1 - v2);
                    if (d > 0) t2 = Math.min(t2, d);
                }

                System.out.println("YES");

                if (v1 == v2) {
                    System.out.println(t1);
                } else if (v1 == -v2) {
                    System.out.println(t2);
                } else System.out.println(Math.min(t1, t2));
            }
        }
    }
}