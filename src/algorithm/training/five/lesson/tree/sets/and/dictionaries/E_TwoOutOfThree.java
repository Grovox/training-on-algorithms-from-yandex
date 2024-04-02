package algorithm.training.five.lesson.tree.sets.and.dictionaries;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;

public class E_TwoOutOfThree {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        reader.readLine();
        Set<String> firstList = new HashSet<>(List.of(reader.readLine().split(" ")));
        reader.readLine();
        Set<String> secondList = new HashSet<>(List.of(reader.readLine().split(" ")));
        reader.readLine();
        StringTokenizer thirdList = new StringTokenizer(reader.readLine(), " ");

        Set<String> ans = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1) - Integer.parseInt(o2);
            }
        });

        for (String val : secondList) if (firstList.contains(val)) ans.add(val);
        while (thirdList.hasMoreTokens()){
            String val = thirdList.nextToken();
            if (firstList.contains(val) || secondList.contains(val)) ans.add(val);
        }

        Iterator<String> ansIter = ans.iterator();
        PrintWriter writer = new PrintWriter("output.txt");
        while (ansIter.hasNext()) writer.print(ansIter.next() + " ");
        writer.flush();
        writer.close();
    }
}
