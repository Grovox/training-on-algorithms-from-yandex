/*
package Five.Lesson4BinarySearch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class J_Rain {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int n = Integer.parseInt(tokenizer.nextToken());
        double h = Double.parseDouble(tokenizer.nextToken());
        int[] x = new int[n + 1];
        int[] y = new int[n + 1];
        for (int i = 0; i <= n; i++){
            tokenizer = new StringTokenizer(reader.readLine(), " ");
            x[i] = Integer.parseInt(tokenizer.nextToken());
            y[i] = Integer.parseInt(tokenizer.nextToken());
        }

        if (n > 1) {
            List<Integer> vertices = new ArrayList<>();
            List<Integer> lowlands = new ArrayList<>();

            int indexMaxVer = -1;

            if (y[0] > y[1]) {
                vertices.add(0);
            } else lowlands.add(0);
            for (int i = 1; i < n; i++){
                if (y[i] > y[i - 1] && y[i] > y[i - 1]){
                    vertices.add(i);
                    if (y[vertices.get(indexMaxVer)] < y[i]) indexMaxVer = vertices.size() - 1;
                }else if (y[i] < y[i - 1] && y[i] < y[i - 1]){
                    lowlands.add(i);
                }
            }
            if (y[n] > y[n - 1]) {
                vertices.add(n);
                if (y[vertices.get(indexMaxVer)] < y[n]) indexMaxVer = vertices.size() - 1;
            } else lowlands.add(n);

            for (int i = indexMaxVer; i < vertices.size() - 1; i++){
                int indexMinVertices = Math.min(y[vertices.get(i)], y[vertices.get(i + 1)]);
                Double sP = 0d;
                int prev = -1;
                int indexStart = -1;
                int indexEnd = -1;
                for (int j = vertices.get(i) + 1; j < vertices.get(i + 1); j++){
                    if (prev != -1 && y[j] < y[indexMinVertices]){
                        sP += x[prev] * y[j] - x[j] * y[prev];
                    } else{
                        if (y[j] > y[indexMinVertices] && sP == 0) indexStart = j;
                        if (y[j] > y[indexMinVertices] && indexEnd == -1  && sP != 0) indexEnd = j;
                    }
                    prev = j;
                }
                int indexLeftVer = vertices.get(i), indexRightVer = vertices.get(i + 1);
                if (indexEnd != -1) indexRightVer = indexEnd;
                if (indexStart != -1 && indexLeftVer != indexStart - 1) indexLeftVer = indexStart - 1;

                sP += x[prev] * y[indexRightVer] - x[indexRightVer] * y[prev];
                prev = indexRightVer;


                float kaf;
                float q = (x2 - x1) / (y1 - y2);
                float sn = (x3 - x4) + (y3 - y4) * q;   // c(x) + c(y)*q
                float fn = (x3 - x1) + (y3 - y1) * q;   // b(x) + b(y)*q
                kaf = fn / sn;

                float xD = x3 + (x4 - x3) * kaf;  // x3 + (-b(x))*n
                float yD = y3 + (y4 - y3) * kaf;  // y3 +(-b(y))*n


            }
        }
    }
}
*/
