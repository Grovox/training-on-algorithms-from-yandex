package algorithm.training.five.lesson.one.complexity.testing.special.cases;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class F_MishaAndMathematics {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        boolean prevNumIsEven = scanner.nextInt() % 2 == 0;
        StringBuffer ans = new StringBuffer();

        for (int i = 1; i < n; i++){
            boolean nowNumIsEven = scanner.nextInt() % 2 == 0;
            if (prevNumIsEven && nowNumIsEven){
                ans.append("+");
            } else if ((prevNumIsEven && !nowNumIsEven) || (!prevNumIsEven && nowNumIsEven)){
                ans.append("+");
                prevNumIsEven = false;
            }else if (!prevNumIsEven && !nowNumIsEven){
                ans.append("x");
                prevNumIsEven = false;
            }
        }

        PrintWriter writer = new PrintWriter("output.txt");
        writer.println(ans);
        writer.flush();
        writer.close();
    }
}
