package Four.BruteForceAndMethodsOfItsOptimization;

import java.util.ArrayList;
import java.util.Scanner;

public class D_ASimpleTravelingSalesmanTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] graph = new int[N + 1][N + 1];
        int allMinEdges = 0;
        int[] minEdges = new int[N + 1];
        int minEdge = Integer.MAX_VALUE;
        for (int i = 1 ; i <= N; i++){
            minEdges[i] = Integer.MAX_VALUE;
            for (int j = 1 ; j <= N; j++){
                graph[i][j] = scanner.nextInt();
                if(minEdge > graph[i][j]) minEdge = graph[i][j];
                if(minEdges[i] > graph[i][j] && graph[i][j] != 0) minEdges[i] = graph[i][j];
            }
            if(minEdges[i] == Integer.MAX_VALUE) minEdges[i] = 0;
            allMinEdges += minEdges[i];
        }
        ArrayList<Integer> path = new ArrayList<>();
        path.add(1);
        int[] best =  new int[1];
        best[0] = Integer.MAX_VALUE;

        search(graph, path, N, 1, allMinEdges, minEdges, minEdge, 0, best);

        if (best[0] == Integer.MAX_VALUE){
            if(N == 1){
                System.out.println(0);
            }else System.out.println(-1);
        }else System.out.println(best[0]);
    }

    static void search(int[][] graph, ArrayList<Integer> path, int n, int node, int allMinEdges, int[] minEdges, int minEdge, int weight, int[] best){
        for (int i = 1; i <= n; i++){
            if(path.contains(i)) continue;
            if(i == node || graph[node][i] == 0) continue;
            if(weight + (n - path.size()) * minEdge >= best[0]) break;
            if(allMinEdges + weight >= best[0]) break;
            ArrayList<Integer> nextPath =  new ArrayList<>(path);
            nextPath.add(i);
            if(nextPath.size() < n) search(graph, nextPath, n, i, allMinEdges - minEdges[i], minEdges, minEdge, weight + graph[node][i], best);
            if(nextPath.size() == n){
                if(graph[i][1] != 0){
                    int res = graph[node][i] + weight + graph[i][1];
                    if(res < best[0]){
                        best[0] = res;
                    }
                }
            }
        }
    }
}
