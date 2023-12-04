package Four.Lesson2HashesForStrings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class C_ZFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String s = reader.readLine();
        long[] h = new long[s.length() + 1];
        long[] x = new long[s.length() + 1];
        x[0] = 1;
        int x1 = 78;
        int p = 1000000000 + 7;
        for(int i = 1; i <= s.length(); i++){
            h[i] = (h[i - 1] * x1 + (s.charAt(i - 1) - 'A')) % p;
            x[i] = (x[i - 1] * x1) % p;
        }
        PrintWriter writer = new PrintWriter("output.txt");
        writer.print("0 ");
        int len = h.length - 1;
        int l, r, m;
        for (int i = 1; i < len; i++){
            l = 0;
            r = len - i;
            while (l < r){
                 m = (l + r + 1) / 2;
                 if((h[m] + h[i] * x[m]) % p == h[m + i]){
                    l = m;
                }else r = m - 1;
             }
            writer.print(l + " ");
        }

        writer.flush();
        writer.close();
    }
}
