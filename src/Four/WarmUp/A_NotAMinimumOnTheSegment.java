package Four.WarmUp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class A_NotAMinimumOnTheSegment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(), M = scanner.nextInt();
        scanner.nextLine();
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < N; i++) a.add(scanner.nextInt());
        scanner.nextLine();

        int L, R;
        List<String> results = new ArrayList<>();
        for(int i = 0; i < M; i++){
            L = scanner.nextInt();
            R = scanner.nextInt();
            scanner.nextLine();

            int max = Collections.max(a.subList(L, R + 1));
            int min = Collections.min(a.subList(L, R + 1));
            if(max == min){
                results.add("NOT FOUND");
            }else {
                results.add(String.valueOf(max));
            }
        }

        results.stream().forEach(System.out::println);
    }
}
