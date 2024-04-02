package algorithm.training.five.lesson.two.linear.search;

import java.util.Scanner;

public class A_TheMinimumRectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int minX = scanner.nextInt(), minY = scanner.nextInt(), maxX = minX, maxY = minY;

        for (int i = 1; i < k; i++){
            int x = scanner.nextInt();
            if (x < minX){
                minX = x;
            } else if (x > maxX) maxX = x;

            int y = scanner.nextInt();
            if (y < minY){
                minY = y;
            }else if (y > maxY){
                maxY = y;
            }
        }

        if (k != 0){
            System.out.println(minX + " " + minY + " " + maxX + " " + maxY);
        }
    }
}
