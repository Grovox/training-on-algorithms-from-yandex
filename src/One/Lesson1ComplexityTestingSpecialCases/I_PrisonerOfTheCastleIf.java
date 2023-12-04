package One.Lesson1ComplexityTestingSpecialCases;

import java.util.Scanner;

public class I_PrisonerOfTheCastleIf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt(), B = scanner.nextInt(), C = scanner.nextInt(), D = scanner.nextInt(), E = scanner.nextInt();

         if((A <= D && B <= E) || (B <= D && A <= E) || (B <= D && C <= E) || (C <= D && B <= E) || (A <= D && C <= E) || (C <= D && A <= E)){
             System.out.println("YES");
         }else {
             System.out.println("NO");
         }
    }
}
