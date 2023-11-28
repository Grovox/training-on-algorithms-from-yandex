package Four.HashesForStrings;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class A_EqualityOfSubstrings {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int q = scanner.nextInt();

        long[] hash = new long[s.length() + 1];
        long[] x = new long[s.length() + 1];
        x[0] = 1;
        int x1 = 78;
        int p = 1000000000 + 7;
        for(int i = 1; i <= s.length(); i++){
            hash[i] = (hash[i - 1] * x1 + (s.charAt(i - 1) - 'A')) % p;
            x[i] = (x[i - 1] * x1) % p;
        }


        PrintWriter writer = new PrintWriter("output.txt");
        int l, a, b;
        for(int i = 0; i < q; i++){
            l = scanner.nextInt();
            a = scanner.nextInt();
            b = scanner.nextInt();

            if((hash[a + l] + hash[b] * x[l]) % p == (hash[b + l] + hash[a] * x[l]) % p){
                writer.println("yes");
            }else writer.println("no");

        }
        writer.flush();
        writer.close();
    }
}
