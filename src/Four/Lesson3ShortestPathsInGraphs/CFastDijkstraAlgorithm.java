package Four.Lesson3ShortestPathsInGraphs;/*
package ShortestPathsInGraphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CFastDijkstraAlgorithm {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String[] in = reader.readLine().split(" ");
        int N = Integer.parseInt(in[0]), K = Integer.parseInt(in[1]);

        PriorityQueue<Dist> minDist = new PriorityQueue<>();
        HashMap<String, Node> graph = new HashMap<>();
        for (int i = 0; i < K; i++) {
            in = reader.readLine().split(" ");
            Node node = addOrGetNode(graph, minDist, in[0]);
            Node adjacentNode = addOrGetNode(graph, minDist, in[1]);
            Edge edge1 = new Edge(adjacentNode, Integer.parseInt(in[2]));
            Edge edge2 = new Edge(node, Integer.parseInt(in[2]));
            node.edges.add(edge1);
            adjacentNode.parents.put(node, edge1);

            adjacentNode.edges.add(edge2);
            node.parents.put(adjacentNode, edge2);
        }

        in = reader.readLine().split(" ");

        System.out.println(getWeightShortestPath(graph, minDist, in[0], in[1]));
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
                Node adjacentNode = edge.adjacentNode;
                if(adjacentNode.dist > dist.node.dist + edge.weight){
                    adjacentNode.dist = dist.node.dist + edge.weight;
                    minDist.offer(new Dist(adjacentNode, adjacentNode.dist));
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

class Node implements{
    long dist;
    String value;
    LinkedHashSet <Edge> edges = new LinkedHashSet<>();
    LinkedHashMap<Node, Edge> parents = new LinkedHashMap<>();
    boolean visited = false;

    Node(String value, long dist) {
        this.value = value;
        this.dist = dist;
    }
}

class Edge{
    Node adjacentNode;
    int weight;

    Edge(Node adjacentNode, int weight) {
        this.adjacentNode = adjacentNode;
        this.weight = weight;
    }
}*/
