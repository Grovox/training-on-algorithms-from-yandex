package algorithm.training.one.lesson.two.linear.search;

import java.util.Scanner;

public class I_Sapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(), M = scanner.nextInt(), K = scanner.nextInt();
        int bomI, bomJ;

        int[][] bom = new int[N + 1][M + 1];
        for (int i = 0; i < K; i++){
            bomI = scanner.nextInt();
            bomJ = scanner.nextInt();
            bom[bomI][bomJ] = -1;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= N; i++){
            for (int j = 1; j <= M; j++){
                if(bom[i][j] == -1){
                    result.append("* ");
                }else {
                    int k = 0;
                    if(j > 0 && bom[i][j - 1] == -1) k += 1;
                    if(j < M && bom[i][j + 1] == -1) k += 1;
                    if(i > 0 && bom[i - 1][j] == -1) k += 1;
                    if(i < N && bom[i + 1][j] == -1) k += 1;
                    if(i < N && j > 0 && bom[i + 1][j - 1] == -1) k += 1;
                    if(i < N && j < M && bom[i + 1][j + 1] == -1) k += 1;
                    if(i > 0 && j > 0 && bom[i - 1][j - 1] == -1) k += 1;
                    if(i > 0 && j < M && bom[i - 1][j + 1] == -1) k += 1;

                    result.append(k).append(" ");
                }
            }
            result.append("\n");
        }

        System.out.println(result.toString());
    }
}
