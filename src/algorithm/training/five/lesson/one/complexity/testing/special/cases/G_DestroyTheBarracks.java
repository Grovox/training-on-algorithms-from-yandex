package algorithm.training.five.lesson.one.complexity.testing.special.cases;

import java.util.Scanner;

public class G_DestroyTheBarracks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt(), y = scanner.nextInt(), p = scanner.nextInt();
        int ans = 1;
        y -= x;

        if (y > 0){
            if (p >= x && y >= x){
                x = 0;
            }else if (p >= x && y < x){
                p -= (x - y);
                x -= p;
                ans++;
                while (p > 0 && x > 0){
                    p -= x;
                    x -= p;
                    ans++;
                }
            }else{
                int topAns = 5000;
                int step = 0;
                for (int i = y; i > 0; i -= (x - p), step++){
                    if (i < x){
                        int testAns = 1;
                        int testP = p - (x - i);
                        int testX = x - testP;
                        while (testP > 0 && testX > 0){
                            testP -= testX;
                            testX -= testP;
                            testAns++;
                        }
                        if (testX > 0){
                            if (topAns > testAns + step){
                                topAns = testAns + step;
                            }
                        }
                    }
                }
                if (step < topAns){
                    ans += step;
                }else ans += topAns;
            }
        }

        if (x > 0){
            System.out.println(ans);
        }else System.out.println(-1);
    }
}
