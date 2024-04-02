package algorithm.training.five.lesson.two.linear.search;

import java.util.*;

public class I_PiratesOfTheBarentsSea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Cord> cords = new ArrayList<>();

        Comparator<Cord> sortY = new Comparator<Cord>() {
            @Override
            public int compare(Cord o1, Cord o2) {
                if (o1.y != o2.y) {
                    return o1.y - o2.y;
                }else return o1.x - o2.x;
            }
        };

        for (int i = 0; i < n; i++){
            Cord cord = new Cord(scanner.nextInt(), scanner.nextInt());
            cords.add(cord);
        }
        cords.sort(sortY);

        int ans = -1;
        for (int i = 1; i <= n; i++){
            int testAns = 0;
            int index = 1;
            for (Cord cord : cords){
                testAns += Math.abs(index - cord.y) + Math.abs(i - cord.x);
                index++;
            }
            if (ans == -1) ans = testAns;
            ans = Math.min(ans, testAns);
        }

        System.out.println(ans);
    }
}

class Cord{
    int y;
    int x;

    public Cord(int y, int x) {
        this.y = y;
        this.x = x;
    }
}