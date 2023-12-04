package Four.Lesson3ShortestPathsInGraphs;/*
package ShortestPathsInGraphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.PriorityQueue;

public class D_BusesInVasyuki {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String[] in = reader.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        in = reader.readLine().split(" ");
        String A = in[0], B = in[1];
        in = reader.readLine().split(" ");
        int K = Integer.parseInt(in[0]);

        PriorityQueue<Dist> minDist = new PriorityQueue<>();
        HashMap<String, Node> graph = new HashMap<>();
        for (int i = 0; i < K; i++) {
            in = reader.readLine().split(" ");
            Node node = addOrGetNode(graph, minDist, in[0]);
            Node adjacentNode = addOrGetNode(graph, minDist, in[2]);
            Edge edge1 = new Edge(adjacentNode, Integer.parseInt(in[1]), Integer.parseInt(in[3]));
            node.edges.add(edge1);
            adjacentNode.parents.put(node, edge1);
        }

        System.out.println(getWeightShortestPath(graph, minDist, A, B));
    }

    static Node addOrGetNode(HashMap<String, Node> graph, PriorityQueue<Dist> minDist, String value) {
        if (graph.containsKey(value)) return graph.get(value);
        Node node = new Node(value, Long.MAX_VALUE);
        graph.put(value, node);
        minDist.add(new Dist(node, Long.MAX_VALUE));
        return node;
    }

    static long getWeightShortestPath(HashMap<String, Node> graph, PriorityQueue<Dist> minDist, String start, String end){

        if(!graph.containsKey(start) || !graph.containsKey(end)) return -1;

        graph.get(start).dist = 0;
        minDist.offer(new Dist(graph.get(start), 0));

        while (!minDist.isEmpty()){
            Dist dist = minDist.poll();
            if(dist.node.visited) continue;
            if(dist.node.dist == Long.MAX_VALUE) break;
            for (Edge edge : dist.node.edges){
                if(dist.dist <= edge.timeStart){
                    Node adjacentNode = edge.adjacentNode;
                    if(adjacentNode.dist > edge.timeEnd){
                        adjacentNode.dist = edge.timeEnd;
                        minDist.offer(new Dist(adjacentNode, adjacentNode.dist));
                    }
                }
            }
            dist.node.visited = true;
        }

        if (graph.get(end).dist == Long.MAX_VALUE) return -1;
        return graph.get(end).dist;
    }
}
class Dist implements Comparable<Dist>{
    Node node;
    long dist;

    public Dist(Node node, long dist) {
        this.node = node;
        this.dist = dist;
    }

    @Override
    public int compareTo(Dist o) {
        if(this.equals(o))
            return -1;
        if (this.dist < o.dist) {
            return -1;
        }
        if (this.dist == o.dist){
            return 0;
        }
        return 1;
    }
}

class Node implements Comparable<Node>{
    long dist;
    String value;
    LinkedHashSet<Edge> edges = new LinkedHashSet<>();
    LinkedHashMap<Node, Edge> parents = new LinkedHashMap<>();
    boolean visited = false;

    Node(String value, long dist) {
        this.value = value;
        this.dist = dist;;
    }
}

class Edge{
    Node adjacentNode;
    int timeStart;
    int timeEnd;

    public Edge(Node adjacentNode, int timeStart, int timeEnd) {
        this.adjacentNode = adjacentNode;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }
}*/
