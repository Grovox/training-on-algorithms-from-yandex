package algorithm.training.one.lesson.two.linear.search;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class H_TheLargestProductOfThreeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String[] in = reader.readLine().split(" ");

        int APosMax = -1, BPosMax = -1, CPosMax = -1;
        int APosMin = -1, BPosMin = -1;
        int ANegMax = -1, BNegMax = -1, CNegMax = -1;
        int ANegMin = -1, BNegMin = -1;

        for (int i = 0; i < in.length; i++){
            if(Integer.parseInt(in[i]) >= 0){
                if(APosMax == -1 || Integer.parseInt(in[i]) >= Integer.parseInt(in[APosMax])){
                    CPosMax = BPosMax;
                    BPosMax = APosMax;
                    APosMax = i;
                }else if(BPosMax == -1 || Integer.parseInt(in[i]) >= Integer.parseInt(in[BPosMax])){
                    CPosMax = BPosMax;
                    BPosMax = i;
                }else if(CPosMax == -1 || Integer.parseInt(in[i]) >= Integer.parseInt(in[CPosMax])){
                    CPosMax = i;
                }

                if(APosMin == -1 || Integer.parseInt(in[i]) <= Integer.parseInt(in[APosMin])){
                    BPosMin = APosMin;
                    APosMin = i;
                }else if(BPosMin == -1 || Integer.parseInt(in[i]) <= Integer.parseInt(in[BPosMin])){
                    BPosMin = i;
                }
            }else {
                if(ANegMax == -1 || Integer.parseInt(in[i]) >= Integer.parseInt(in[ANegMax])){
                    CNegMax = BNegMax;
                    BNegMax = ANegMax;
                    ANegMax = i;
                }else if(BNegMax == -1 || Integer.parseInt(in[i]) >= Integer.parseInt(in[BNegMax])){
                    CNegMax = BNegMax;
                    BNegMax = i;
                }else if(CNegMax == -1 || Integer.parseInt(in[i]) >= Integer.parseInt(in[CNegMax])){
                    CNegMax = i;
                }

                if(ANegMin == -1 || Integer.parseInt(in[i]) <= Integer.parseInt(in[ANegMin])){
                    BNegMin = ANegMin;
                    ANegMin = i;
                }else if(BNegMin == -1 || Integer.parseInt(in[i]) <= Integer.parseInt(in[BNegMin])){
                    BNegMin = i;
                }
            }
        }


        long result1 = 0, result2 = 0, result3 = Long.MIN_VALUE, result4 = Long.MIN_VALUE;
        if(APosMax != -1 && BPosMax != -1 && CPosMax != -1) result1 = (long) Integer.parseInt(in[APosMax]) * Integer.parseInt(in[BPosMax]) * Integer.parseInt(in[CPosMax]);
        if(ANegMin != -1 && BNegMin != -1 && APosMax != -1) result2 = (long) Integer.parseInt(in[ANegMin]) * Integer.parseInt(in[BNegMin]) * Integer.parseInt(in[APosMax]);

        if(ANegMax != -1 && BNegMax != -1 && CNegMax != -1) result3 = (long) Integer.parseInt(in[ANegMax]) * Integer.parseInt(in[BNegMax]) * Integer.parseInt(in[CNegMax]);
        if(ANegMax != -1 && APosMin != -1 && BPosMin != -1) result4 = (long) Integer.parseInt(in[ANegMax]) * Integer.parseInt(in[APosMin]) * Integer.parseInt(in[BPosMin]);

        if(APosMax != -1 && BPosMax != -1 && CPosMax != -1 && result1 >= result2){
            System.out.println(in[APosMax] + " " + in[BPosMax] + " " + in[CPosMax]);
        }else if (ANegMin != -1 && BNegMin != -1 && APosMax != -1 && result2 >= result1){
            System.out.println(in[ANegMin] + " " + in[BNegMin] + " " + in[APosMax]);
        }else if (ANegMax != -1 && BNegMax != -1 && CNegMax != -1 && result3 >= result4){
            System.out.println(in[ANegMax] + " " + in[BNegMax] + " " + in[CNegMax]);
        }else if (ANegMax != -1 && APosMin != -1 && BPosMin != -1 && result4 >= result3){
            System.out.println(in[ANegMax] + " " + in[APosMin] + " " + in[BPosMin]);
        }
    }
}
