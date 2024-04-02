package algorithm.training.four.warm.up;

import java.util.Scanner;
import java.util.Stack;

public class I_CorrectBracketSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();
        boolean result = true;
        Stack<Integer> stack = new Stack<>();
        char e;
        if(in.length() > 0) {
            e = in.charAt(0);
            if (e == ')' || e == ']' || e == '}'){
                result = false;
            }else {
                if (e == '('){
                    stack.push(1);
                }else if (e == '['){
                    stack.push(2);
                }else if (e == '{') stack.push(3);
            }

        }
        if(in.length() % 2 == 0 && result){
            for (int i = 1; i < in.length(); i++){
                e = in.charAt(i);
                if (e == '('){
                    stack.push(1);
                }else if (e == '['){
                    stack.push(2);
                }else if (e == '{'){
                    stack.push(3);
                }else if (e == ')'){
                    if(!stack.empty()){
                        if(stack.peek() == 1){
                            stack.pop();
                        } else {
                            result = false;
                            break;
                        }
                    }else {
                        result = false;
                        break;
                    }
                }else if (e == ']'){
                    if(!stack.empty()){
                        if(stack.peek() == 2){
                            stack.pop();
                        } else {
                            result = false;
                            break;
                        }
                    }else {
                        result = false;
                        break;
                    }
                }else if (e == '}'){
                    if(!stack.empty()){
                        if(stack.peek() == 3){
                            stack.pop();
                        } else {
                            result = false;
                            break;
                        }
                    }else {
                        result = false;
                        break;
                    }
                }
            }
        }else result = false;

        if(result){
            System.out.println("yes");
        }else System.out.println("no");
    }
}
