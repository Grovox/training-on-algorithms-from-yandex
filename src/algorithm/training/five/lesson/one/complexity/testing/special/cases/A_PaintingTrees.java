package algorithm.training.five.lesson.one.complexity.testing.special.cases;

import java.util.Scanner;

public class A_PaintingTrees {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long p = scanner.nextInt(), v = scanner.nextInt();
        long q = scanner.nextInt(), m = scanner.nextInt();
        long ans = 2;
        long len = Math.max(p, q) - Math.min(p, q) - 1;
        if((v + m) > len){
            if (v > len + m){
                ans += v * 2 - 1;
            }else if (m > len + v){
                ans += m * 2 - 1;
            }else ans += len + m + v;
        } else ans += v * 2L + m * 2L;
        System.out.println(ans);
    }
}
