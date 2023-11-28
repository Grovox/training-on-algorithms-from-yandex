package Four.warmUp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class E_AverageLevel {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(reader.readLine());
        int[] a = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int sum = Arrays.stream(a).sum();
        int sum2 = sum;
        PrintWriter writer = new PrintWriter("output.txt");

        for (int i = 0; i < n; i++){
            writer.print(String.valueOf(sum2 - a[i] * (n - i) + a[i] * i - (sum - sum2)) + " ");
            sum2 -= a[i];
        }
        writer.flush();
        writer.close();
    }
}