package algorithm.training.one.lesson.one.complexity.testing.special.cases;

import java.util.Scanner;

public class G_Details {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), k = scanner.nextInt(), m = scanner.nextInt();
        int result = 0;
        if(m <= k){
            while (n >= k){
                result += (n / k) * (k / m);
                n = (n / k) * (k % m) + n % k;
            }
        }
        System.out.println(result);
    }
}
