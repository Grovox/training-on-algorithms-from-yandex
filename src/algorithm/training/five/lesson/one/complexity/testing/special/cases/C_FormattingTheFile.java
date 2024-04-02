package algorithm.training.five.lesson.one.complexity.testing.special.cases;

import java.util.Scanner;

public class C_FormattingTheFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long ans = 0;
        for (int i = 0; i < n; i++){
            int a = scanner.nextInt();
            ans += a / 4;
            a %= 4;
            ans += (a / 3) * 2;
            a %= 3;
            ans += a;
        }
        System.out.println(ans);
    }
}
