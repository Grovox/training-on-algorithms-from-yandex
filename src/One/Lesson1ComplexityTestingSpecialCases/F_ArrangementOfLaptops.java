package One.Lesson1ComplexityTestingSpecialCases;

import java.util.Scanner;

public class F_ArrangementOfLaptops {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int h1 = scanner.nextInt(), w1 = scanner.nextInt(), h2 = scanner.nextInt(), w2 = scanner.nextInt();
        int wResult = w1 + w2;
        int hResult = Math.max(h1, h2);
        if((h1 + h2) * Math.max(w1,w2) < wResult * hResult){
            wResult = h1 + h2;
            hResult = Math.max(w1, w2);
        }
        if((w1 + h2) * Math.max(h1,w2) < wResult * hResult){
            wResult = w1 + h2;
            hResult = Math.max(h1, w2);
        }
        if((h1 + w2) * Math.max(w1,h2) < wResult * hResult){
            wResult = h1 + w2;
            hResult = Math.max(w1, h2);
        }
        System.out.println(wResult + " " + hResult);
    }
}
