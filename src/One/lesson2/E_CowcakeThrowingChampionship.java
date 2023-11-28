package One.lesson2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class E_CowcakeThrowingChampionship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer[] a = new Integer[n];
        for(int i = 0 ; i < n; i++) a[i] = scanner.nextInt();
        int result = 0;
        int max = Arrays.stream(a).max(Comparator.naturalOrder()).get();
        for(int i = 1; i < n - 1; i++){
            if(a[i - 1] == max && a[i] % 10 == 5 && a[i + 1] < a[i]){
                result = a[i];
            }
        }
        int ans = 0;
        if(result > 0){
            for (int i = 0; i < n; i++){
                if(a[i] > result){
                    ans++;
                }
            }
            ans++;
        }
        System.out.println(ans);
    }
}
