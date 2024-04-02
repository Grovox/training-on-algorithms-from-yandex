package algorithm.training.five.lesson.two.linear.search;

import java.io.BufferedReader;
import java.io.FileReader;

public class J_TwoRectangles {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String[] in = reader.readLine().split(" ");
        int n = Integer.parseInt(in[0]), m = Integer.parseInt(in[1]);
        String[] lines = new String[n];
        for (int i = 0; i < n; i++) lines[i] = reader.readLine();

        int xS1 = -1, yS1 = -1;
        int xE1 = -1, yE1 = -1;
        int xS2 = -1, yS2 = -1;
        int xE2 = -1, yE2 = -1;
        boolean isError = false;

        for (int i = 0; i < n && yS1 == -1; i++) {
            for (int j = 0; j < m && yS1 == -1; j++) {
                if (lines[i].charAt(j) == '#'){
                    yS1 = i;
                    xS1 = j;
                }
            }
        }
        if (yS1 != -1){
            for (int i = xS1; i < m && lines[yS1].charAt(i) == '#'; i++) xE1 = i;
            for (int i = yS1; i < n && lines[i].charAt(xS1) == '#' && lines[i].charAt(xE1) == '#'; i++){
                if (xS1 > 0 && lines[i].charAt(xS1 - 1) == '#' && xE1 < (m - 1) && lines[i].charAt(xE1 + 1) == '#') break;
                yE1 = i;
            }
            for (int i = yS1; i <= yE1 && !isError; i++) {
                for (int j = xS1; j <= xE1 && !isError; j++) {
                    if (lines[i].charAt(j) != '#') isError = true;
                }
            }
        }else isError = true;

        if (!isError){
            for (int i = 0; i < n && yS2 == -1; i++) {
                for (int j = 0; j < m && yS2 == -1; j++) {
                    if ((i >= yS1 && i <= yE1) && (j >= xS1 && j <= xE1)) continue;
                    if (lines[i].charAt(j) == '#'){
                        yS2 = i;
                        xS2 = j;
                    }
                }
            }

            if (yS2 != -1){
                for (int i = xS2; i < m && lines[yS2].charAt(i) == '#'; i++){
                    if ((yS2 >= yS1 && yS2 <= yE1) && (i >= xS1 && i <= xE1)) continue;
                    xE2 = i;
                }
                for (int i = yS2; i < n && lines[i].charAt(xS2) == '#' && lines[i].charAt(xE2) == '#'; i++) yE2 = i;
                for (int i = yS2; i <= yE2 && !isError; i++) {
                    for (int j = xS2; j <= xE2 && !isError; j++) {
                        if (lines[i].charAt(j) != '#') isError = true;
                    }
                }

                if(!isError){
                    for (int i = 0; i < n && !isError; i++) {
                        for (int j = 0; j < m && !isError; j++) {
                            if (((i >= yS1 && i <= yE1) && (j >= xS1 && j <= xE1)) || ((i >= yS2 && i <= yE2) && (j >= xS2 && j <= xE2))) continue;
                            if (lines[i].charAt(j) == '#') isError = true;
                        }
                    }
                }
            }else {
                if ((xE1 - xS1 + 1) * (yE1 - yS1 + 1) < 2) isError = true;
            }
        }
        if(isError){
            System.out.println("NO");
        }else {
            if (yS2 == -1){
                if ((xE1 - xS1 + 1) > 1){
                    xS2 = xS1;
                    xE2 = xS1;
                    xS1 += 1;
                    yS2 = yS1;
                    yE2 = yE1;
                }else {
                    yS2 = yS1;
                    yE2 = yS1;
                    yS1 +=1;
                    xS2 = xS1;
                    xE2 = xE1;
                }
            }
            String[] out = new String[n];
            for(int i = 0; i < n; i++){
                out[i] = "";
                for(int j = 0; j < m; j++){
                    if ((i >= yS1 && i <= yE1) && (j >= xS1 && j <= xE1)) {
                        out[i] += "a";
                    } else if((i >= yS2 && i <= yE2) && (j >= xS2 && j <= xE2)){
                        out[i] += "b";
                    }else{
                        out[i] += ".";
                    }
                }
            }
            
            System.out.println("YES");
            for(int i = 0; i < n;i++){
                System.out.println(out[i]);
            }
        }
    }
}
