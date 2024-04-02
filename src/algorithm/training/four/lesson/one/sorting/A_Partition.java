package algorithm.training.four.lesson.one.sorting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class A_Partition {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(reader.readLine());
        String[] in = reader.readLine().split(" ");
        int[] a;
        if(!in[0].equals("")){
            a = Arrays.stream(in).mapToInt(Integer::parseInt).toArray();
        }else a = new int[0];

        int x = Integer.parseInt(reader.readLine());
        int result = partition(a, x);

        System.out.println(result);
        System.out.println(a.length - result);

    }
    public static int partition(int[] arr, int pivot){
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            while (arr[left] < pivot && left < right) left++;
            while (arr[right] >= pivot && right > left) right--;
            if(left < right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
            if(left == right){
                if (arr[left] >= pivot){
                        right--;
                }else left ++;
            }
        }
        return left;
    }
}