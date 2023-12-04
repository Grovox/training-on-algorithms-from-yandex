package One.Lesson1ComplexityTestingSpecialCases;

import java.util.Scanner;

public class A_Conditioner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int troom = scanner.nextInt();
        int tcond = scanner.nextInt();
        scanner.nextLine();
        String operatingMode = scanner.nextLine();
        if(operatingMode.equals("freeze")){
            System.out.println(Math.min(troom, tcond));
        }
        if(operatingMode.equals("heat")){
            System.out.println(Math.max(troom, tcond));
        }
        if(operatingMode.equals("auto")){
            System.out.println(tcond);
        }
        if(operatingMode.equals("fan")){
            System.out.println(troom);
        }
    }
}
