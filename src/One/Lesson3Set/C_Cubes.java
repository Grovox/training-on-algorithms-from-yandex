package One.Lesson3Set;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class C_Cubes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String[] inStart = reader.readLine().split(" ");
        int n = Integer.parseInt(inStart[0]), m = Integer.parseInt(inStart[1]);

        TreeSet<Integer> cubesAnn = new TreeSet<>();
        TreeSet<Integer> cubesBoris = new TreeSet<>();
        TreeSet<Integer> cubesAll = new TreeSet<>();

        for (int i = 0; i < n; i++){
            cubesAnn.add(Integer.parseInt(reader.readLine()));
        }

        for (int i = 0; i < m; i++){
            int in = Integer.parseInt(reader.readLine());
            if(cubesAnn.contains(in)){
                cubesAll.add(in);
                cubesAnn.remove(in);
            }else cubesBoris.add(in);
        }

        PrintWriter writer = new PrintWriter("output.txt");
        Iterator iterator;
        writer.println(cubesAll.size());
        iterator = cubesAll.iterator();
        while (iterator.hasNext()) writer.print(iterator.next() + " ");
        writer.println();

        writer.println(cubesAnn.size());
        iterator = cubesAnn.iterator();
        while (iterator.hasNext()) writer.print(iterator.next() + " ");
        writer.println();

        writer.println(cubesBoris.size());
        iterator = cubesBoris.iterator();
        while (iterator.hasNext()) writer.print(iterator.next() + " ");

        writer.flush();
        writer.close();
    }
}