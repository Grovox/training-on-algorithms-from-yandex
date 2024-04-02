package algorithm.training.five.lesson.tree.sets.and.dictionaries;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;

public class A_Playlists {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(reader.readLine());
        Set<String> allMusic = new HashSet<>();
        Set[] personalMusic = new Set[n];
        for (int i = 0; i < n; i++){
            reader.readLine();
            String[] in = reader.readLine().split(" ");
            allMusic.addAll(Arrays.stream(in).toList());
            personalMusic[i] = new HashSet<String>(Arrays.stream(in).toList());
        }

        Queue<String> ans = new PriorityQueue<>();
        for (String music : allMusic){
            boolean hasAllPersonal = true;
            for (int i = 0; i < n && hasAllPersonal; i++){
                if (!personalMusic[i].contains(music)) hasAllPersonal = false;
            }
            if (hasAllPersonal)ans.offer(music);
        }
        PrintWriter writer = new PrintWriter("output.txt");
        writer.println(ans.size());
        while (!ans.isEmpty()) writer.print(ans.poll() + " ");
        writer.flush();
        writer.close();
    }
}
