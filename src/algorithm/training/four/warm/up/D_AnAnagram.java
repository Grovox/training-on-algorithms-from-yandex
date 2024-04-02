package algorithm.training.four.warm.up;

import java.util.Scanner;

public class D_AnAnagram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int result = 1;
        if(s1.length() == s2.length()){
            result = 0;
            for(int i = 0; i < s1.length(); i++){
                result += s1.charAt(i) + 'A';
                result -= s2.charAt(i) + 'A';
            }
        }
        if(result == 0){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
