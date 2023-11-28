package Four.warmUp;

import java.math.BigInteger;
import java.util.Scanner;

public class F_Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextInt();

        n--;
        int r = 0, d = 0;
        BigInteger result = new BigInteger("0");
        while (n >= 0){
            if(a[n] == 0){
                n--;
            }else if(r != 0){
                if(a[n] < r){
                    r = r - a[n];
                    a[n] = 0;
                }else {
                    a[n] -= r;
                    r = 0;
                }
            }else if(a[n] >= k){
                d = a[n] / k;
                result = result.add(BigInteger.valueOf((long) (n + 1) * d));
                a[n] -= d * k;
            }else if(a[n] < k){
                result = result.add(BigInteger.valueOf((n + 1)));
                r = k - a[n];
                a[n] = 0;
            }
        }

        result = result.multiply(BigInteger.valueOf(2));
        System.out.println(result);
    }
}
