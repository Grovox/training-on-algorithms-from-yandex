package Four.Lesson2HashesForStrings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class D_CubesInTheMirror {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        reader.readLine();
        String[] s = reader.readLine().split(" ");

        long[] h = new long[s.length + 1];
        long[] hr = new long[s.length + 1];
        long[] x = new long[s.length + 1];
        x[0] = 1;
        int x1 = 59;
        long[] h2 = new long[s.length + 1];
        long[] hr2 = new long[s.length + 1];
        long[] x2 = new long[s.length + 1];
        x2[0] = 1;
        int x3 = 43;
        int p = 1000000 + 3;
        for(int i = 1; i <= s.length; i++){
            h[i] = (h[i - 1] * x1 + (Integer.parseInt(s[i - 1]))) % p;
            hr[i] = (hr[i - 1] * x1 + (Integer.parseInt(s[s.length - i]))) % p;
            x[i] = (x[i - 1] * x1) % p;

            h2[i] = (h2[i - 1] * x3 + (Integer.parseInt(s[i - 1]))) % p;
            hr2[i] = (hr2[i - 1] * x3 + (Integer.parseInt(s[s.length - i]))) % p;
            x2[i] = (x2[i - 1] * x3) % p;
        }

        PrintWriter writer = new PrintWriter("output.txt");
        int len = h.length - 1;
        int k = 0;

        if(len % 2 != 0) k++;

        for (int i = len/2 + len % 2; i < len; i++){
            if(k < len){
                if(((h[len] + h[k] * x[i - k] * x[i] + hr[len - i] * x[i]) % p == (h[i] * x[i] + hr[len]) % p &&
                        (h2[len] + h2[k] * x2[i - k] * x2[i] + hr2[len - i] * x2[i]) % p == (h2[i] * x2[i] + hr2[len]) % p) ||
                        ((h[len] + hr[k] * x[i - k] * x[i] + h[len - i] * x[i]) % p == (hr[i] * x[i] + h[len]) % p &&
                        (h2[len] + hr2[k] * x2[i - k] * x2[i] + h2[len - i] * x2[i]) % p == (hr2[i] * x2[i] + h2[len]) % p)){
                    writer.print(i + " ");
                }
            }
            k += 2;
        }
        writer.print(len);

        writer.flush();
        writer.close();
    }
}
