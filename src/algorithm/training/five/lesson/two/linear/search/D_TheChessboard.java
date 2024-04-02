package algorithm.training.five.lesson.two.linear.search;

import java.util.Scanner;

public class D_TheChessboard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        int[][] board = new int[10][10];
        for (int i = 0; i < n; i++){
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
            board[x[i]][y[i]] = 1;
        }

        int ans = n * 4;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        for (int i = 0; i < n; i++){
            for (int j = 0; j < 4; j++){
                ans -= board[x[i] + dx[j]][y[i] + dy[j]];
            }
        }

        System.out.println(ans);
    }
}
