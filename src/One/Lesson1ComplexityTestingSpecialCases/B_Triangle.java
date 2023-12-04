package One.Lesson1ComplexityTestingSpecialCases;

import java.util.Scanner;

public class B_Triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();

        if(A + B > C && A + C > B && B + C > A){
            System.out.println("Yes");
        }else System.out.println("No");

    }
}
