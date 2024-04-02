package algorithm.training.five.lesson.two.linear.search;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class E_AnAmbitiousSnail {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(reader.readLine());
        Set<Integer> ratingGoodDays = new HashSet<>();
        Set<Integer> ratingBedDays = new HashSet<>();

        long ans = 0;
        long maxNegDayA = -1, maxPosDayB = -1, maxDay = -1;
        int indexMaxNegDay = -1, indexMaxPosDay = -1;

        for (int i = 1; i <= n; i++){
            String[] in = reader.readLine().split(" ");
            int a = Integer.parseInt(in[0]);
            int b = Integer.parseInt(in[1]);
            int height = a - b;

            if (height > 0){
                if (b > maxPosDayB){
                    maxPosDayB = b;
                    indexMaxPosDay = i;
                }
                ans += height;

                ratingGoodDays.add(i);
            }else {
                if (a > maxNegDayA){
                    maxNegDayA = a;
                    indexMaxNegDay = i;
                }
                ratingBedDays.add(i);
            }
        }
        long ansOne = ans + maxPosDayB;
        long ansTwo = ans + maxNegDayA;

        PrintWriter writer = new PrintWriter("output.txt");

        if (ansOne > ansTwo){
            writer.println(ansOne);
            for (int val : ratingGoodDays) {
                if (val == indexMaxPosDay) continue;
                writer.print(val + " ");
            }
            writer.print(indexMaxPosDay + " ");
            for (int val : ratingBedDays) {
                writer.print(val + " ");
            }
        }else if (ansTwo > maxDay){
            writer.println(ans + maxNegDayA);
            for (int val : ratingGoodDays) {
                writer.print(val + " ");
            }
            writer.print(indexMaxNegDay + " ");
            for (int val : ratingBedDays) {
                if (val == indexMaxNegDay) continue;
                writer.print(val + " ");
            }
        }
        writer.flush();
        writer.close();
    }
}
