package algorithm.training.one.lesson.two.linear.search;

import java.util.Scanner;

public class E_CowcakeThrowingChampionship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer[] a = new Integer[n];
        for(int i = 0 ; i < n; i++) a[i] = scanner.nextInt();
        int result = 0;
        int maxIndex = 0;
        for (int i = 1; i < n; i++){
            if (a[maxIndex] < a[i]) {
                maxIndex = i;
            }
        }
        for(int i = maxIndex + 1; i < n - 1; i++){
            if(a[i] % 10 == 5 && a[i + 1] < a[i] && a[i] > result){
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
