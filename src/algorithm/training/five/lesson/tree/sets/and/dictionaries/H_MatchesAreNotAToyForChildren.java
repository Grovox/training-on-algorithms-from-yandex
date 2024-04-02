package algorithm.training.five.lesson.tree.sets.and.dictionaries;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class H_MatchesAreNotAToyForChildren {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(reader.readLine());
        List<CordMatches> cordsOne = new ArrayList<>();
        for (int i = 0;  i < n; i++){
            String[] in = reader.readLine().split(" ");
            int x1 = Integer.parseInt(in[0]), y1 = Integer.parseInt(in[1]);
            int x2 = Integer.parseInt(in[2]), y2 = Integer.parseInt(in[3]);
            CordMatches cordMatches = new CordMatches(x1, y1, x2, y2);
            cordsOne.add(cordMatches);
        }
        List<CordMatches> cordsTwo = new ArrayList<>();
        for (int i = 0;  i < n; i++){
            String[] in = reader.readLine().split(" ");
            int x1 = Integer.parseInt(in[0]), y1 = Integer.parseInt(in[1]);
            int x2 = Integer.parseInt(in[2]), y2 = Integer.parseInt(in[3]);
            CordMatches cordMatches = new CordMatches(x1, y1, x2, y2);
            cordsTwo.add(cordMatches);
        }

        Map<String, Integer> map = new HashMap<>();
        int maxMatchesEquals = 0;
        for (CordMatches cordTwo : cordsTwo){
            for (CordMatches cordOne : cordsOne){
                int xShift = cordTwo.xS - cordOne.xS;
                int yShift = cordTwo.yS - cordOne.yS;
                if ((cordOne.xS + xShift != cordTwo.xS || cordOne.yS + yShift != cordTwo.yS || cordOne.xE + xShift != cordTwo.xE || cordOne.yE + yShift != cordTwo.yE) &&
                        (cordOne.xS + xShift != cordTwo.xE || cordOne.yS + yShift != cordTwo.yE || cordOne.xE + xShift != cordTwo.xS || cordOne.yE + yShift != cordTwo.yS)){
                    xShift = cordTwo.xE - cordOne.xS;
                    yShift = cordTwo.yE - cordOne.yS;
                }
                if ((cordOne.xS + xShift != cordTwo.xS || cordOne.yS + yShift != cordTwo.yS || cordOne.xE + xShift != cordTwo.xE || cordOne.yE + yShift != cordTwo.yE) &&
                        (cordOne.xS + xShift != cordTwo.xE || cordOne.yS + yShift != cordTwo.yE || cordOne.xE + xShift != cordTwo.xS || cordOne.yE + yShift != cordTwo.yS)) continue;

                String key = xShift + " " + yShift;
                map.put(key, map.getOrDefault(xShift + " " + yShift, 0) + 1);
                if (map.get(key) > maxMatchesEquals) maxMatchesEquals = map.get(key);
            }
        }
        System.out.println(n - maxMatchesEquals);
    }
}
class CordMatches{
    int xS;
    int yS;
    int xE;
    int yE;

    public CordMatches(int xS, int yS, int xE, int yE) {
        this.xS = xS;
        this.yS = yS;
        this.xE = xE;
        this.yE = yE;
    }
}
