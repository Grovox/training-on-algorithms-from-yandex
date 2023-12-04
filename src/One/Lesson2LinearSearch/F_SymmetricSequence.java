package One.Lesson2LinearSearch;

import java.util.Scanner;

public class F_SymmetricSequence {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextInt();

        int result = 0;
        for (int i = 0; i < n; i++){
            boolean flag = true;
            int l = 0, r = n + i - 1;
            while (r - l > 0){
                if(r < n && a[l] != a[r]){
                    flag = false;
                    break;
                }
                l++;
                r--;
            }
            if(flag){
                result = i;
                break;
            }
        }
        System.out.println(result);
        for (int i = result - 1; i >= 0; i--) System.out.print(a[i] + " ");
    }
}
