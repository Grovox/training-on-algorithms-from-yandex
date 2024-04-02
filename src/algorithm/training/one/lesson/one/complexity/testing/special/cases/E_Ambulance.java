package algorithm.training.one.lesson.one.complexity.testing.special.cases;

import java.util.Scanner;

public class E_Ambulance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k1 = scanner.nextInt(), m = scanner.nextInt(), k2 = scanner.nextInt(), p2 = scanner.nextInt(), n2 = scanner.nextInt();
        int p1 = -1, n1 = -1;

        boolean flag = false;
        int entrance1;
        int floor1;
        int entrance2;
        int floor2;
        for (int flatsOnFloor = 1; flatsOnFloor < 1000000; flatsOnFloor++){
            entrance2 = ((k2 - 1) / flatsOnFloor) / m + 1;
            floor2 = ((k2 - 1) / flatsOnFloor) % m + 1;

            if (entrance2 == p2 && floor2 == n2) {
                entrance1 = ((k1 - 1) / flatsOnFloor) / m + 1;
                floor1 = ((k1 - 1) / flatsOnFloor) % m + 1;
            }else {
                entrance1 = -1;
                floor1 = -1;
            }

            if (entrance1 != -1) {
                flag = true;
                if (p1 == -1) {
                    p1 = entrance1;
                    n1 = floor1;
                } else if (p1 != entrance1 && p1 != 0) {
                    p1 = 0;
                } else if (n1 != floor1 && n1 != 0) {
                    n1 = 0;
                }
            }
        }
        if (flag) {
            System.out.println(p1 + " " + n1);
        } else {
            System.out.println(-1 + " " + -1);
        }
    }
}