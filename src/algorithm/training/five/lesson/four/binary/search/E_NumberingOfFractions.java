package algorithm.training.five.lesson.four.binary.search;

import java.util.Scanner;

public class E_NumberingOfFractions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();

        long l = 1, r = Math.min(n, Integer.MAX_VALUE), m;

        while (l < r){
            m = (l + r) / 2;
            if ((m % 2 == 0 && n < ((m * (m / 2)) + m / 2)) || (m % 2 == 1 && n <= (m * (m - m / 2)))){
                r = m;
            }else l = m + 1;
        }
        long k;
        long h = 1;
        if (l % 2 == 0){
            k = ((l * (l / 2)) + l / 2) - n;
            h += k;
            l -= k;
            System.out.println(h + "/" + l);
        }else {
            k = (l * (l - l / 2)) - n;
            h += k;
            l -= k;
            System.out.println(l + "/" + h);
        }
    }
}
