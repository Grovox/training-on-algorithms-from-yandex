package Four.WarmUp;

import java.util.Scanner;

public class B_AddTwoFractions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt(), d = scanner.nextInt();
        int m = a * d + c * b;
        int n = b * d;

        for (int i = 2; i <= n; i++){
            if(n % i == 0 && m % i == 0){
                m = m / i;
                n = n / i;
                i = 1;
            }
        }
        System.out.println(m + " " + n);
    }
}
