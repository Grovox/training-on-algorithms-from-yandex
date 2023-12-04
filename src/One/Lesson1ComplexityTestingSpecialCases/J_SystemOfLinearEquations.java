package One.Lesson1ComplexityTestingSpecialCases;

import java.util.Scanner;

public class J_SystemOfLinearEquations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double  a = scanner.nextDouble(), b = scanner.nextDouble(), c = scanner.nextDouble(), d = scanner.nextDouble(), e = scanner.nextDouble(), f = scanner.nextDouble();

        double D, Dx, Dy, zero, x, y;
        zero = 1.0e-7;
        D = a * d - c * b;
        Dx = e * d - f * b;
        Dy = a * f - c * e;

        if (!(Math.abs(D) <= zero)) {
            x = Dx / D;
            y = Dy / D;
            System.out.println("2 " + x + " " + y);
        } else {
            if (Math.abs(a) + Math.abs(b) + Math.abs(c) + Math.abs(d) <= zero) {
                if (Math.abs(e) + Math.abs(f) <= zero)
                    System.out.println("5"); // бесконечное множество решений
                else
                    System.out.println("0"); // решений нет
            } else if (!(Math.abs(Dx) <= zero) || !(Math.abs(Dy) <= zero))
                System.out.println("0"); // нет решений
            else if (b == 0) {
                if (!(Math.abs(a) <= zero))
                    System.out.println("3 " + e / a); // y - любое число
                else if (Math.abs(d) <= zero)
                    System.out.println("3 " + f / c); // y - любое число
                else if (Math.abs(c) <= zero)
                    System.out.println("4 " + f / d); // x - любое число
                else
                    System.out.println("1 " + -c/d + " " + f/d); // y = kx + b
            } else if (a == 0) {
                if (!(Math.abs(b) <= zero))
                    System.out.println("4 " + e / b); // x - любое число
                else if (Math.abs(d) <= zero)
                    System.out.println("3 " + f / c); // y - любое число
                else if (Math.abs(c) <= zero)
                    System.out.println("4 " + f / d); // x - любое число
                else
                    System.out.println("1 " + -c/d + " " + f/d); // y = kx + b
            } else
                System.out.println("1 " + -a/b + " " + e/b); // y = kx + b
        }
    }
}
