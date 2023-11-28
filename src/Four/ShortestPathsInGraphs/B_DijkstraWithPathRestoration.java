package Four.ShortestPathsInGraphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B_DijkstraWithPathRestoration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int S = scanner.nextInt();
        int F = scanner.nextInt();
        scanner.nextLine();

        int[][] graph = new int[N + 1][N + 1];
        boolean[] visit = new boolean[N + 1];
        int[] dist = new int[N + 1];
        int[] path = new int[N + 1];
        for (int i = 1; i < N + 1; i++){
            visit[i] = false;
            dist[i] = Integer.MAX_VALUE - 1;;
            path[i] = Integer.MAX_VALUE - 1;;
            for (int j = 1; j < N + 1; j++){
                graph[i][j] = scanner.nextInt();
            }
        }
        dist[S] = 0;
        path[S] = -1;


        for(int i = 1; i < N + 1; i++){
            int PMD = 0;
            int max = Integer.MAX_VALUE - 1;
            for (int j = 1; j < N + 1; j++) {
                if (dist[j] <= max && !visit[j]){
                    max = dist[j];
                    PMD = j;
                }
            }
            visit[PMD] = true;

            for (int j = 1; j < N + 1; j++) {
                if(j != PMD && graph[PMD][j] != -1 && dist[j] > dist[PMD] + graph[PMD][j]){
                    dist[j] = dist[PMD] + graph[PMD][j];
                    path[j] = PMD;
                }
            }
        }

       if(dist[F] == Integer.MAX_VALUE - 1){
           System.out.println(-1);
       }else {
           List<Integer> result = new ArrayList<>();
           result.add(F);
           int index = path[F];
           while (index != -1) {
               result.add(index);
               index = path[index];
           }

           for (int i = result.size() - 1; i >= 0; i--) {
               System.out.print(result.get(i) + " ");
           }
       }
    }
}
