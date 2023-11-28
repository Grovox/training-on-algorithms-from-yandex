package One.lesson2;

import java.util.Scanner;

public class B_DetermineTheTypeOfSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int flag = -2000000000;
        int enteredNum;
        int prevNum = flag;
        boolean constant = false, ascending = false, descending = false;


        enteredNum = scanner.nextInt();
        if(prevNum == flag && enteredNum == flag){
            System.out.println("RANDOM");
        }else {
            prevNum = enteredNum;
            enteredNum = scanner.nextInt();
            if(enteredNum == flag){
                constant = true;
            }
            while (enteredNum != flag){
                if(enteredNum == prevNum){
                    constant = true;
                }
                if(enteredNum > prevNum){
                    ascending = true;
                }
                if(enteredNum < prevNum){
                    descending = true;
                }
                prevNum = enteredNum;
                enteredNum = scanner.nextInt();
            }

            if(constant && !ascending && !descending){
                System.out.println("CONSTANT");
            }else if(!constant && ascending && !descending){
                System.out.println("ASCENDING");
            }else if(!constant && !ascending && descending){
                System.out.println("DESCENDING");
            }else if(constant && ascending && !descending){
                System.out.println("WEAKLY ASCENDING");
            }else if(constant && !ascending && descending){
                System.out.println("WEAKLY DESCENDING");
            }else {
                System.out.println("RANDOM");
            }
        }
    }
}
