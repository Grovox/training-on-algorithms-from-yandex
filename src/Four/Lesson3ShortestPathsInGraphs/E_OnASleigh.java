package Four.Lesson3ShortestPathsInGraphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class E_OnASleigh {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String[] in = reader.readLine().split(" ");
        int N = Integer.valueOf(in[0]);

        List<Sleigh> sleighs = new ArrayList<>();
        sleighs.add(new Sleigh(0, 0));
        for (int i = 1; i <= N; i++) {
            in = reader.readLine().split(" ");
            sleighs.add(new Sleigh(Integer.parseInt(in[0]), Integer.parseInt(in[1])));
        }

        List<List<Edge>> graph = new ArrayList<>();
        graph.add(null);
        for (int i = 1; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            in = reader.readLine().split(" ");
            graph.get(Integer.parseInt(in[0])).add(new Edge(Integer.parseInt(in[1]), Integer.parseInt(in[2])));
            graph.get(Integer.parseInt(in[1])).add(new Edge(Integer.parseInt(in[0]), Integer.parseInt(in[2])));
        }

        double[][] graphFinish = new double[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            BFS(graph ,graphFinish, i, sleighs);
        }

        Result result = getWeightShortestPath(graphFinish, 1);

        System.out.println(result.time);
        for (int i = 0; i < result.path.size(); i++) {
            System.out.print(result.path.get(i) + " ");
        }
    }

    static void BFS(List<List<Edge>> graph, double[][] graphFinish, int nodeStart, List<Sleigh> sleighs){
            HashSet<Integer> passed = new HashSet<>();
            Queue<Integer> queue = new ArrayDeque<>();
            double[] weight = new double[graph.size()];
            weight[nodeStart] = sleighs.get(nodeStart).t;
            queue.add(nodeStart);
            while (!queue.isEmpty()) {
                int node = queue.poll();

                if (!passed.contains(node)) {
                    if(node != nodeStart){
                        graphFinish[nodeStart][node] = weight[node];
                    }
                }
                passed.add(node);
                for (Edge edge : graph.get(node)) {
                    if (!passed.contains(edge.value)) {
                        queue.add(edge.value);
                        weight[edge.value] = weight[node] + edge.weight / sleighs.get(nodeStart).v;
                    }
                }
            }
            passed.clear();
    }

    static Result getWeightShortestPath(double[][] graph, int start){
        int len = graph.length;
        int[] paths = new int[len];
        paths[start] = -1;
        boolean[] visited = new boolean[len];
        double[] dist = new double[len];
        for (int i = 1; i < len; i++){
            dist[i] = Double.MAX_VALUE;
        }
        dist[start] = 0d;
        for (int t = 1; t < len; t++){
            int index = -1;
            double nowDist = Double.MAX_VALUE;
            for (int i = 1; i < len; i++){
                if(nowDist > dist[i] && !visited[i]) {
                    nowDist = dist[i];
                    index = i;
                }
            }
            if(index == -1) break;
            if(nowDist == Double.MAX_VALUE) break;
            for (int edge = 1; edge < len; edge++){
                if(edge == index) continue;
                if(dist[edge] > graph[edge][index] + dist[index]){
                    dist[edge] = graph[edge][index] + dist[index];
                    paths[edge] = index;
                }
            }
            visited[index] = true;
        }
        int result = - 1;
        double max  = 0;
        for (int i = 2; i < len; i++){
            if(dist[i] > max){
                max = dist[i];
                result = i;
            }
        }

        List<Integer> path = new ArrayList<>();
        path.add(result);
        int index = paths[result];
        while (index != -1) {
            path.add(index);
            index = paths[index];
        }

        return new Result(max, path);
    }
}
class Edge{
    int value;
    double weight;

    public Edge(int value, double weight) {
        this.value = value;
        this.weight = weight;
    }
}

class Result{
    double time;
    List<Integer> path;

    public Result(Double time, List<Integer> path) {
        this.time = time;
        this.path = path;
    }

    @Override
    public String toString() {
        return time + "\n" + path;
    }
}

class Sleigh{
    double t;
    double v;

    public Sleigh(int t, int v) {
        this.t = t;
        this.v = v;
    }
}