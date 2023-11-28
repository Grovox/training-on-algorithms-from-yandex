package Four.warmUp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J_GroupProject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int n, a, b;
        int groups;
        List<String> results = new ArrayList<>();
        for (int i = 0; i < t; i++){
            n = scanner.nextInt();
            a = scanner.nextInt();
            b = scanner.nextInt();
            groups = n / a;
            if(n % a <= (long) (b - a) * groups){
                results.add("YES");
            }else results.add("NO");
        }
        results.stream().forEach(System.out::println);
    }
}
