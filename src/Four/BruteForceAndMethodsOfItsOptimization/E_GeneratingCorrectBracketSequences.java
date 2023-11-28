package Four.BruteForceAndMethodsOfItsOptimization;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class E_GeneratingCorrectBracketSequences {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        if(N != 0 && N % 2 == 0){
            PrintWriter writer = new PrintWriter("output.txt");
            gen(N/2, 0, new ArrayDeque<>(), "", writer);
            writer.flush();
            writer.close();
        }
    }

    public static void gen(int n, int counterOpen, Deque<Character> stackOpen, String result, PrintWriter writer){
        if (counterOpen == n && stackOpen.isEmpty()){
            writer.println(result);
            return;
        }
        if(counterOpen < n){
            stackOpen.push('(');
            gen(n, counterOpen + 1, stackOpen, result + '(', writer);
            stackOpen.push('[');
            gen(n, counterOpen + 1, stackOpen, result + '[', writer);
        }
        if (counterOpen > 0 && !stackOpen.isEmpty() && stackOpen.peek() == '('){
            stackOpen.pop();
            gen(n, counterOpen, new ArrayDeque<>(stackOpen), result + ')', writer);
        }else if (counterOpen > 0 && !stackOpen.isEmpty() && stackOpen.peek() == '['){
            stackOpen.pop();
            gen(n, counterOpen, new ArrayDeque<>(stackOpen), result + ']', writer);
        }
    }
}

