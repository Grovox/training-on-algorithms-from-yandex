package four.Lesson2HashesForStrings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class E_SubPalindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String s = reader.readLine();
        long[] h = new long[s.length() + 1];
        long[] hr = new long[s.length() + 1];
        long[] x = new long[s.length() + 1];
        x[0] = 1;
        int x1 = 11;
        int p = 1000000000 + 7;
        for(int i = 1; i < s.length() + 1; i++){
            h[i] = (h[i - 1] * x1 + s.charAt(i - 1) - 'A') % p;
            hr[i] = (hr[i - 1] * x1 + s.charAt(s.length() - i) - 'A') % p;
            x[i] = (x[i - 1] * x1) % p;
        }
        long result = 0;
        int len = h.length - 1;
        for (int i = 3; i < len - 1; i++){
            int m;
            int l = i;
            int r = Math.min((i - 1) * 2, len);
            if((h[l] + h[l - 2] * x[1]) % p == (h[l - 1] + h[l - 1] * x[1]) % p) {
                while (l < r) {
                    m = (l + r + 1) / 2;
                    if ((h[i - 1] + hr[len - m] * x[m - i + 1]) % p == (hr[len - i + 1] + h[i + i - 2 - m] * x[m - i + 1]) % p) {
                        l = m;
                    } else r = m - 1;
                }
                result += l - i + 1;
            }

            l = i + 1;
            r = Math.min((i - 1) * 2  + 1, len);
            if ((h[l] + h[l - 3] * x[1]) % p == (h[l - 2] + h[l - 1] * x[1]) % p) {
                while (l < r) {
                    m = (l + r + 1) / 2;
                    if ((h[i - 1] + hr[len - m] * x[m - i]) % p == (hr[len - i] + h[i + i - 1 - m] * x[m - i]) % p) {
                        l = m;
                    } else r = m - 1;
                }
                result += l - i;
            }
        }
        if(len > 1 && (h[1] + h[1] * x[1]) % p == (h[2]) % p) result++;
        if(len > 2 && (h[1] + h[2] * x[1]) % p == (h[3]) % p) result++;
        if(len > 3 && (h[len - 1] + h[len - 3] * x[1]) % p == (h[len - 2] + h[len - 2] * x[1]) % p) result++;
        if(len > 3 && (h[len - 2]) % p == (hr[2] + h[len - 4] * x[2]) % p) result++;
        if(len > 2 && (h[len] + h[len - 2] * x[1]) % p == (h[len - 1] + h[len - 1] * x[1]) % p) result++;
        if(len > 3 && (h[len] + h[len - 3] * x[1]) % p == (h[len - 2] + h[len - 1] * x[1]) % p) result++;


        result += len;
        System.out.println(result);
    }
}