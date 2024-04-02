package algorithm.training.one.lesson.two.linear.search;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class G_TheLargestProductOfTwoNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String[] in = reader.readLine().split(" ");

        int OnePos = -1, TwoPos = -1;
        int OneNeg = -1, TwoNeg = -1;
        for (int i = 0; i < in.length; i++){
            if(Integer.parseInt(in[i]) >= 0 && (OnePos == -1 || Integer.parseInt(in[i]) > Integer.parseInt(in[OnePos]))){
                TwoPos = OnePos;
                OnePos = i;
            }else if(Integer.parseInt(in[i]) >= 0 && (TwoPos == -1 || Integer.parseInt(in[i]) > Integer.parseInt(in[TwoPos]))){
                TwoPos = i;
            }else if(Integer.parseInt(in[i]) <= -1 && (OneNeg == -1 || Integer.parseInt(in[i]) < Integer.parseInt(in[OneNeg]))){
                TwoNeg = OneNeg;
                OneNeg = i;
            }else if(Integer.parseInt(in[i]) <= -1 && (TwoNeg == -1 || Integer.parseInt(in[i]) < Integer.parseInt(in[TwoNeg]))){
                TwoNeg = i;
            }
        }


        long resultOne = 0, resultTwo = 0;
        if(TwoPos != -1 && OnePos != -1) resultOne = (long) Integer.parseInt(in[OnePos]) * Integer.parseInt(in[TwoPos]);
        if(TwoNeg != -1 && OneNeg != -1) resultTwo = (long) Integer.parseInt(in[OneNeg]) * Integer.parseInt(in[TwoNeg]);
        if (resultOne >= resultTwo && TwoPos != -1 && OnePos != -1){
            if(Integer.parseInt(in[OnePos]) < Integer.parseInt(in[TwoPos])) {
                System.out.println(in[OnePos] + " " + in[TwoPos]);
            }else System.out.println(in[TwoPos] + " " + in[OnePos]);
        }else if (TwoNeg != -1 && OneNeg != -1){
            if (Integer.parseInt(in[OneNeg]) < Integer.parseInt(in[TwoNeg])) {
                System.out.println(in[OneNeg] + " " + in[TwoNeg]);
            } else System.out.println(in[TwoNeg] + " " + in[OneNeg]);
        }else if(OneNeg != -1 && OnePos != -1){
            System.out.println(in[OneNeg] + " " + in[OnePos]);
        }
    }
}
