package algorithm.training.five.lesson.four.binary.search;

import java.util.Scanner;

public class B_OneDimensionalNavalBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        if (n > 0){
            long l = 1, r = Math.min(n, 2000000), m = 0;
            while (l < r){
                m = (l + r + 1) / 2;
                if (check(m, n)){
                    l = m;
                }else r = m - 1;
            }
            System.out.println(l);
        }else System.out.println(0);
    }
    public static boolean check(long k, long n){
        long ans = 0;
        long ship = 1;
        for (long i = k; i > 0; i--){
            ans += ship * i + i - 1;
            ship++;
        }
        ans += k - 1;
        return ans <= n;
    }
}
