package algorithm.training.five.lesson.four.binary.search;

import java.util.Scanner;

public class D_Report {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int w = scanner.nextInt(), n = scanner.nextInt(), nb = scanner.nextInt();
        int[] a = new int[n];
        int aMax = 0;
        for (int i = 0; i < n ; i++){
            a[i] = scanner.nextInt();
            if (a[i] > aMax) aMax = a[i];
        }
        int[] b = new int[nb];
        int bMax = 0;
        for (int i = 0; i < nb; i++){
            b[i] = scanner.nextInt();
            if (b[i] > bMax) bMax = b[i];
        }
        int maxLen = Math.max(lenText(a, aMax), lenText(b, w - aMax));
        int l = aMax, r = w - bMax, m;
        while (l < r){
            m = (l + r + 1) / 2;
            if (maxLen >= Math.max(lenText(a, m), lenText(b, w - m))){
                maxLen = Math.max(lenText(a, m), lenText(b, w - m));
                l = m;
            } else r = m - 1;
        }

        r = l;
        l = aMax;

        while (l < r){
            m = (l + r) / 2;
            if (maxLen > Math.max(lenText(a, m), lenText(b, w - m))){
                maxLen = Math.max(lenText(a, m), lenText(b, w - m));
                r = m;
            } else l = m + 1;
        }

        System.out.println(Math.max(lenText(a, l), lenText(b, w - l)));
    }
    public static int lenText(int[] a, int wight){
        int len = 1;
        int nowWight = a[0];
        for (int i = 1; i < a.length; i++){
            if (nowWight + 1 + a[i] <= wight){
                nowWight += 1 + a[i];
            }else {
                len++;
                nowWight = a[i];
            }
        }
        return len;
    }
}
