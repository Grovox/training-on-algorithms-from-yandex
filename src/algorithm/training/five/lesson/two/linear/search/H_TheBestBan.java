package algorithm.training.five.lesson.two.linear.search;

import java.util.*;

public class H_TheBestBan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();

        int[][] a = new int[n][m];
        boolean isRepeatMax = false;

        int max1 = 0, max2 = 0;
        int i1 = -1, j1 = -1, i2 = -1, j2 = -1;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                a[i][j] = scanner.nextInt();
                if (max1 != 0 && max2 == 0){
                    max2 = a[i][j];
                    i2 = i;
                    j2 = j;
                }

                if (max1 == 0 || a[i][j] >= max1){
                    if (i1 != i && j1 != j){
                        max2 = max1;
                        i2 = i1;
                        j2 = j1;
                    }
                    isRepeatMax = false;
                    if (max1 == a[i][j]) isRepeatMax = true;
                    j1 = j;
                    max1 = a[i][j];
                    i1 = i;
                }else {
                    if (i1 != i && (j1 != j || isRepeatMax) && a[i][j] >= max2){
                        max2 = a[i][j];
                        i2 = i;
                        j2 = j;
                    }
                }
            }
        }

        int maxE1 = 0;
        for (int i = 0; i < n; i ++){
            for (int j = 0; j < m; j++){
                if (i == i1  || j == j2) continue;
                if (a[i][j] > maxE1) maxE1 = a[i][j];
            }
        }
        int maxE2 = 0;
        for (int i = 0; i < n; i ++){
            for (int j = 0; j < m; j++){
                if (i == i2  || j == j1) continue;
                if (a[i][j] > maxE2) maxE2 = a[i][j];
            }
        }
        int ansN, ansM;
        if (maxE1 < maxE2){
            ansN = i1 + 1;
            ansM = j2 + 1;
        }else {
            ansN = i2 + 1;
            ansM = j1 + 1;
        }
        System.out.println(ansN + " " + ansM);
    }
}