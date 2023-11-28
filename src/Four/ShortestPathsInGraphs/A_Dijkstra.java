package Four.ShortestPathsInGraphs;

import java.util.Scanner;

public class A_Dijkstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int S = scanner.nextInt();
        int F = scanner.nextInt();
        scanner.nextLine();

        int[][] graph = new int[N + 1][N + 1];
        boolean[] visit = new boolean[N + 1];
        int[] dist = new int[N + 1];
        for (int i = 1; i < N + 1; i++){
            visit[i] = false;
            dist[i] = Integer.MAX_VALUE - 1;
            for (int j = 1; j < N + 1; j++){
                graph[i][j] = scanner.nextInt();
            }
        }
        dist[S] = 0;


        for(int i = 1; i < N + 1; i++){
            int path = 0;
            int max = Integer.MAX_VALUE - 1;
            for (int j = 1; j < N + 1; j++) {
                if (dist[j] <= max && !visit[j]){
                    max = dist[j];
                    path = j;
                }
            }
            visit[path] = true;

            for (int j = 1; j < N + 1; j++) {
                if(j != path && graph[path][j] != -1 && dist[j] > dist[path] + graph[path][j]){
                    dist[j] = dist[path] + graph[path][j];
                }
            }
        }
        if(dist[F] == Integer.MAX_VALUE - 1){
            System.out.println(-1);
        }else System.out.println(dist[F]);
    }
}
