package algorithm.training.four.lesson.four.brute.force.and.methods.ofIts.optimization;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class C_MaximumCut {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String[] in = reader.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int[][] graph = new int[N][N];
        for (int i = 0; i < N; i++){
            in = reader.readLine().split(" ");
            for (int j = 0; j < N; j++){
                graph[i][j] = Integer.parseInt(in[j]);
            }
        }

        int size = ((1 << N) / 2 + N % 2);
        int resultSum = 0;
        int resultPath = 0;

        for (int i = 1; i < size; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                if((i >> j & 1) != 0){
                    for(int k = 0; k < N; k++){
                        if(j == k) continue;
                        if((i >> k & 1) == 0){
                            sum += graph[j][k];
                        }
                    }
                }
            }
            if(resultSum < sum){
                resultSum = sum;
                resultPath = i;
            }
        }
        PrintWriter writer = new PrintWriter("output.txt");
        writer.println(resultSum);
        for (int j = 0; j < graph.length; j++) {
            writer.print(((resultPath >> j & 1) == 1 ? 2 : 1) + " ");
        }
        writer.flush();
        writer.close();
    }
}