package algorithm.training.five.lesson.one.complexity.testing.special.cases;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class E_AProfitableStartup {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextInt(), k = scanner.nextInt(), d = scanner.nextInt();
        n *= 10;
        boolean flag = false;
        for (int i = 0; i < 10; i++){
            if ((n + i) % k == 0 && n >= k){
                n += i;
                flag = true;
                break;
            }
        }

        if (flag){
            PrintWriter writer = new PrintWriter("output.txt");
            writer.print(n);
            for (int i = 1; i < d; i ++){
                writer.print('0');
            }
            writer.flush();
            writer.close();
        }else System.out.println(-1);
    }
}
