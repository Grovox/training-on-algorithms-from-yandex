package algorithm.training.five.lesson.two.linear.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class G_NoMoreNoLess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int k = 0; k < t; k++){
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = scanner.nextInt();
            int len = 0;
            int maxLen = 0;
            int ans = 0;
            int size = 0;
            List<Integer> sizes = new ArrayList<>();
            for (int i = 0; i < n; i++){
                if (maxLen > a[i]){
                    len = a[i] - (maxLen - len);
                    maxLen = a[i];
                }
                if (len <= 0){
                    sizes.add(size);
                    size = 0;
                    len = a[i];
                    maxLen = a[i];
                    ans++;
                }
                len--;
                size++;
            }
            if (size > 0) sizes.add(size);
            System.out.println(ans);
            for (int i = 1; i < sizes.size(); i++){
                System.out.print(sizes.get(i) + " ");
            }
            System.out.println();
        }
    }
}
