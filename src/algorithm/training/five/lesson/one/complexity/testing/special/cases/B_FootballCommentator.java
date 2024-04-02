package algorithm.training.five.lesson.one.complexity.testing.special.cases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class B_FootballCommentator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String[] in = reader.readLine().split(":");
        int g1A = Integer.parseInt(in[0]), g2A = Integer.parseInt(in[1]);
        in = reader.readLine().split(":");
        int g1B = Integer.parseInt(in[0]), g2B = Integer.parseInt(in[1]);
        boolean oneIsHome = Integer.parseInt(reader.readLine()) == 1;
        int g1 = g1A + g1B;
        int g2 = g2A + g2B;

        if (g1 > g2){
            System.out.println(0);
        }else if (g1 == g2) {
            if (oneIsHome){
                if (g1B > g2A){
                    System.out.println(0);
                }else System.out.println(1);
            }else {
                if (g1A > g2B){
                    System.out.println(0);
                }else System.out.println(1);
            }
        } else {
            if (oneIsHome){
                if ((g1B + g2 - g1) > g2A){
                    System.out.println(g2 - g1);
                }else System.out.println(g2 - g1 + 1);
            } else {
                if (g1A > g2B){
                    System.out.println(g2 - g1);
                }else System.out.println(g2 - g1 + 1);
            }
        }
    }
}
