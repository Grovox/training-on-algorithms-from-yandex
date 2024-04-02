package algorithm.training.five.lesson.four.binary.search;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class G_TheNewPlusOffice {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int w = Integer.parseInt(tokenizer.nextToken()), h = Integer.parseInt(tokenizer.nextToken());

        int[][] lines = new int[w + 1][h + 1];
        int[][] columns = new int[w + 1][h + 1];

        List<Cord> cordsStart = new ArrayList<>();

        for (int i = 1; i <= w; i++){
            String in = reader.readLine();
            for (int j = 1; j <= h; j++){
                char s = in.charAt(j - 1);
                if (s == '#'){
                    lines[i][j] = lines[i][j - 1] + 1;
                    columns[i][j] = columns[i - 1][j] + 1;

                    if (j != h && columns[i][j] >= 3 && lines[i - 1][j + 1] >= 3){
                        cordsStart.add(new Cord(i - 1, j));
                    }
                }
            }
        }



        int l = 1, r = Math.min(w,h) / 3, m;
        while (l < r){
            m = (l + r + 1) / 2;
            if ( check(w, h, m, cordsStart, lines, columns)){
                l = m;
            }else r = m - 1;
        }
        System.out.println(l);
    }
    public static boolean check(int w, int h, int k, List<Cord> cordsStart, int[][] lines, int[][] columns){
        for (Cord cord : cordsStart){
            if (cord.i + k + k - 1 > w || cord.j + k + k - 1 > h) continue;
            int iC = cord.i, jC = cord.j;
            int dk = k * 3;
            boolean ans = true;

            for (int i = 0; i < k; i++){
                if (columns[iC + k + k - 1][jC + i] < dk || lines[iC + i][jC + k + k - 1] < dk){
                    ans = false;
                    break;
                }

            }
            if (ans) return true;
        }
        return false;
    }
}

class Cord{
    int i;
    int j;

    public Cord(int i, int j) {
        this.i = i;
        this.j = j;
    }
}