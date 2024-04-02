package algorithm.training.one.lesson.two.linear.search;

import java.util.Arrays;
import java.util.Scanner;

public class A_IsTheListGrowing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean result = true;
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 1; i < nums.length; i++){
            if(nums[i] <= nums[i - 1]){
                result = false;
            }
        }

        if(result){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
