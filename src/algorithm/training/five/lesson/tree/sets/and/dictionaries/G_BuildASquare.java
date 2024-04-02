package algorithm.training.five.lesson.tree.sets.and.dictionaries;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class G_BuildASquare {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(reader.readLine());
        List<Cord> cords = new ArrayList<>();
        Set<String> cordsString = new HashSet<>();
        for (int i = 0; i < n; i++){
            String in = reader.readLine();
            cordsString.add(in);
            String[] XY = in.split(" ");
            Cord cord = new Cord(Integer.parseInt(XY[0]),Integer.parseInt(XY[1]));
            cords.add(cord);
        }
        List<String> ans = new ArrayList<>();
        ans.add((cords.get(0).x - 1) + " " + cords.get(0).y);
        ans.add(cords.get(0).x + " " + (cords.get(0).y - 1));
        ans.add((cords.get(0).x - 1) + " " + (cords.get(0).y - 1));
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                double x0 = (double)(cords.get(i).x + cords.get(j).x) / 2, y0 = (double)(cords.get(i).y + cords.get(j).y) / 2;
                double x1, y1, x2, y2;
                x1 = (x0 + (cords.get(i).x - x0) * Math.cos(Math.PI/2) - (cords.get(i).y - y0) * Math.sin(Math.PI/2));
                y1 = (y0 + (cords.get(i).x - x0) * Math.sin(Math.PI/2) + (cords.get(i).y - y0) * Math.cos(Math.PI/2));
                x2 = (x0 + (cords.get(j).x - x0) * Math.cos(Math.PI/2) - (cords.get(j).y - y0) * Math.sin(Math.PI/2));
                y2 = (y0 + (cords.get(j).x - x0) * Math.sin(Math.PI/2) + (cords.get(j).y - y0) * Math.cos(Math.PI/2));
                double count = 10;
                x1 = Math.round(x1 * count) / count;
                y1 = Math.round(y1 * count) / count;
                x2 = Math.round(x2 * count) / count;
                y2 = Math.round(y2 * count) / count;
                if (x1 % 1 != 0 || y1 % 1 != 0 || x2 % 1 != 0 || y2 % 1 != 0) continue;
                if (x1 > Integer.MAX_VALUE || y1 > Integer.MAX_VALUE || x2 > Integer.MAX_VALUE || y2 > Integer.MAX_VALUE) continue;
                if (x1 < Integer.MIN_VALUE || y1 < Integer.MIN_VALUE || x2 < Integer.MIN_VALUE || y2 < Integer.MIN_VALUE) continue;
                String cord1 = (int) x1 + " " + (int) y1;
                String cord2 = (int) x2 + " " + (int) y2;
                if (cordsString.contains(cord1) && cordsString.contains(cord2)){
                    ans.clear();
                    break;
                }else if (ans.size() > 1){
                    ans.clear();
                    if (!cordsString.contains(cord1)) ans.add(cord1);
                    if (!cordsString.contains(cord2)) ans.add(cord2);
                }
            }
            if (ans.isEmpty()) break;
        }
        System.out.println(ans.size());
        for (String an : ans) System.out.println(an);
    }
}

class Cord{
    int x;
    int y;

    public Cord(int x, int y) {
        this.x = x;
        this.y = y;
    }
}