package algorithm.training.five.lesson.one.complexity.testing.special.cases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class D_BishopsAndRooks {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String[] in = new String[8];
        boolean[][] board = new boolean[8][8];
        for (int i = 0; i < 8; i ++) {
            in[i] = reader.readLine();
        }
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if (in[i].charAt(j) == 'R'){
                    board[i][j] = true;
                    for (int h = i + 1; h < 8; h++){
                        if (in[h].charAt(j) != '*') break;
                        board[h][j] = true;
                    }
                    for (int h = i - 1; h >= 0; h--){
                        if (in[h].charAt(j) != '*') break;
                        board[h][j] = true;
                    }
                    for (int w = j + 1; w < 8; w++){
                        if (in[i].charAt(w) != '*') break;
                        board[i][w] = true;
                    }
                    for (int w = j - 1; w >= 0; w--){
                        if (in[i].charAt(w) != '*') break;
                        board[i][w] = true;
                    }
                } else if (in[i].charAt(j) == 'B'){
                    board[i][j] = true;
                    for (int h = i + 1, w = j + 1; h < 8 && w < 8; h++, w++){
                        if (in[h].charAt(w) != '*') break;
                        board[h][w] = true;
                    }
                    for (int h = i + 1, w = j - 1; h < 8 && w >= 0; h++, w--){
                        if (in[h].charAt(w) != '*') break;
                        board[h][w] = true;
                    }
                    for (int h = i - 1, w = j + 1; h >= 0 && w < 8; h--, w++){
                        if (in[h].charAt(w) != '*') break;
                        board[h][w] = true;
                    }
                    for (int h = i - 1, w = j - 1; h >= 0 && w >= 0; h--, w--){
                        if (in[h].charAt(w) != '*') break;
                        board[h][w] = true;
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if (!board[i][j]) ans++;
            }
        }
        System.out.println(ans);
    }
}
