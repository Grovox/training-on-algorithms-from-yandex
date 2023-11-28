package One.lesson2;

import java.util.Arrays;
import java.util.Scanner;

public class D_MoreOfYourNeighbors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int result = 0;
        for(int i = 1; i < nums.length - 1; i++){
            if(nums[i] > nums[i + 1] && nums[i] > nums[i - 1]){
                result++;
            }
        }
        System.out.println(result);
    }
}
