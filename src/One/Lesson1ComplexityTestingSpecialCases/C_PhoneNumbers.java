package One.Lesson1ComplexityTestingSpecialCases;

import java.util.Scanner;

public class C_PhoneNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] availableNumbers = new String[4];
        for (int i = 0; i < 4; i++){
            availableNumbers[i] = scanner.nextLine();
            availableNumbers[i] = availableNumbers[i].replaceAll("[-()+]","");
            if(availableNumbers[i].length() == 7){
                availableNumbers[i] = "8495" + availableNumbers[i];
            }
            if(availableNumbers[i].substring(0,1).equals("7")){
                availableNumbers[i] = "8" + availableNumbers[i].substring(1);
            }
        }

        for (int i = 1; i < 4; i++){
            if(availableNumbers[0].equals(availableNumbers[i])){
                System.out.println("YES");
            } else System.out.println("NO");
        }
    }
}
