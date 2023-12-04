package Four.WarmUp;

import java.util.Scanner;

public class G_RabbitLearnsGeometry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine();
        int[][] a = new int[N][M];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                a[i][j] = scanner.nextInt();
            }
        }

        int dp[][] = new int[N][M];
        int result = a[0][0];
        dp[0][0] = a[0][0];
        for (int i = 1; i < N; i++){
            dp[i][0] = a[i][0];
            if(dp[i][0] > result) result = 1;
        }
        for (int j = 1; j < M; j++){
            dp[0][j] = a[0][j];
            if(dp[0][j] > result) result = 1;
        }

        for (int i = 1; i < N; i++){
            for (int j = 1; j < M; j++){
                if (a[i][j] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }else dp[i][j] = 0;
                if(dp[i][j] > result) result = dp[i][j];
            }
        }
        System.out.println(result);
    }
}
