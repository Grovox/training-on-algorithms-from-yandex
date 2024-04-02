package algorithm.training.one.lesson.tree.set;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class J_JoggingInManhattan {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String[] in = reader.readLine().split(" ");
        int t = Integer.parseInt(in[0]), d = Integer.parseInt(in[1]), n = Integer.parseInt(in[2]);
        int posRect[] = {0, 0, 0, 0};
        for (int i = 0; i < n; i++){
            posRect = extend(posRect, t);
            in = reader.readLine().split(" ");
            int navX = Integer.parseInt(in[0]), naxY = Integer.parseInt(in[1]);
            int navRect[] = {navX + naxY, navX + naxY, navX - naxY, navX - naxY};
            navRect = extend(navRect, d);
            posRect = intersect(posRect, navRect);
        }

        List<String> result = new ArrayList<>();
        for (int i = posRect[0]; i <= posRect[1]; i++){
            for (int j = posRect[2]; j <= posRect[3]; j++){
                if ((i + j) % 2 == 0) {
                    int x = (i + j) / 2;
                    int y = i - x;
                    result.add(x + " " + y);
                }
            }
        }
        PrintWriter writer = new PrintWriter("output.txt");
        writer.println(result.size());
        for (String cord : result){
            writer.println(cord);
        }
        writer.flush();
        writer.close();

    }
    static int[] intersect(int[] rect1, int[] rect2){
        int result[] = {Math.max(rect1[0], rect2[0]), Math.min(rect1[1], rect2[1]), Math.max(rect1[2], rect2[2]), Math.min(rect1[3],rect2[3])};
        return result;
    }

    static int[] extend(int[] rect, int d){
        rect[0] -= d;
        rect[1] += d;
        rect[2] -= d;
        rect[3] += d;
        return rect;
    }
}