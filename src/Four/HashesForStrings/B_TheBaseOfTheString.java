package Four.HashesForStrings;

import java.util.Scanner;

public class B_TheBaseOfTheString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        long[] h = new long[s.length() + 1];
        long[] x = new long[s.length() + 1];
        x[0] = 1;
        int x1 = 78;
        int p = 1000000000 + 7;
        for(int i = 1; i <= s.length(); i++){
            h[i] = (h[i - 1] * x1 + (s.charAt(i - 1) - 'A')) % p;
            x[i] = (x[i - 1] * x1) % p;
        }
        int result = 0;

        int l = h.length - 1;
        for (int i = 1; i <= h.length; i++){
            if(h[l] == (h[l - i] + h[i] * x[l - i]) % p){
                result = i;
                break;
            }
        }

        if(result == 0) result = s.length();

        System.out.println(result);
    }
}
