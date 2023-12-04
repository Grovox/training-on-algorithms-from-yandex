package Four.WarmUp;

import java.util.Scanner;

public class H_ContestResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt(), b = scanner.nextInt(), n = scanner.nextInt();
        int c = b / n;
        if (b % n > 0) c++;
        if(a > c){
            System.out.println("Yes");
        } else System.out.println("No");
    }
}
