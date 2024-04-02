package algorithm.training.five.lesson.four.binary.search;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C_Saruman {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int n = Integer.parseInt(tokenizer.nextToken()), m = Integer.parseInt(tokenizer.nextToken());
        tokenizer = new StringTokenizer(reader.readLine(), " ");

        long[] sum = new long[n];
        sum[0] = Integer.parseInt(tokenizer.nextToken());
        for (int i = 1; i < n; i++) sum[i] = sum[i - 1] + Integer.parseInt(tokenizer.nextToken());

        PrintWriter writer = new PrintWriter("output.txt");
        for (int i = 0; i < m; i++){
            tokenizer = new StringTokenizer(reader.readLine(), " ");
            int d = Integer.parseInt(tokenizer.nextToken());
            long s = Long.parseLong(tokenizer.nextToken());
            int ans = 0;
            if (sum[d - 1] < s){
                ans = rBinSearch(sum, d, s);
                if((sum[ans + d - 1] != s && ans == 0) || sum[ans + d - 1] - sum[ans - 1] != s) ans = -2;
            }else if (sum[d - 1] > s) ans = -2;
            writer.println(ans + 1);
        }
        writer.flush();
        writer.close();
    }
    public static int rBinSearch(long sum[], int d, long s){
        int l = 0, r = sum.length - d, m;
        while (l < r){
            m = (l + r + 1) / 2;
            if ((sum[m + d - 1] - sum[m - 1]) <= s){
                l = m;
            }else {
                r = m - 1;
            }
        }
        return l;
    }
}
