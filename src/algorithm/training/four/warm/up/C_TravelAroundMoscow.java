package algorithm.training.four.warm.up;

import java.util.Scanner;

public class C_TravelAroundMoscow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int xA = scanner.nextInt(), yA = scanner.nextInt(), xB = scanner.nextInt(), yB = scanner.nextInt();
        double dA = Math.sqrt(Math.pow(xA, 2) + Math.pow(yA, 2));
        double dB = Math.sqrt(Math.pow(xB, 2) + Math.pow(yB, 2));
        double ansOne = dA + dB;
        double ansTwo = 0;

        double cornerA = Math.abs(Math.atan2(yA, xA));
        double cornerB = Math.abs(Math.atan2(yB, xB));
        double corner;

        if(( yA >= 0 && yB >=  0 ) || ( yA <= 0 && yB <=  0 )){
            corner = Math.max(cornerA, cornerB) - Math.min(cornerA, cornerB);
        }else {
            corner = cornerA + cornerB;
            if (corner > Math.PI){
                corner = 2 * Math.PI - corner;
            }
        }

        double x, y;
        if(corner == 0){
            ansTwo = Math.abs(dA - dB);
        } else if (dA == dB) {
            ansTwo = corner * dA;
        } else if (dA > dB){
            ansTwo = corner * dB;

            x = dB / dA * xA;
            y = dB / dA * yA;
            ansTwo += Math.sqrt(Math.pow(xA - x, 2) + Math.pow(yA - y, 2));
        } else {
            ansTwo = corner * dA;

            x = dA / dB * xB;
            y = dA / dB * yB;
            ansTwo += Math.sqrt(Math.pow(xB - x, 2) + Math.pow(yB - y, 2));
        }

        System.out.println(Math.min(ansOne, ansTwo));

    }
}
