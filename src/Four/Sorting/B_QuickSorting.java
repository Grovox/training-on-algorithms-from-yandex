package Four.Sorting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class B_QuickSorting {
    static Random random = new Random();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(reader.readLine());
        String[] in = reader.readLine().split(" ");
        int[] a;
        if(!in[0].equals("")){
            a = Arrays.stream(in).mapToInt(Integer::parseInt).toArray();
        }else a = new int[0];

        quicksort(a);

        Arrays.stream(a).forEach(val -> System.out.print(val + " "));

    }
    public static void quicksort(int[] arr){
        quicksort(arr, 0, arr.length - 1);
    }
    public static void quicksort(int[] arr, int start, int end){
        if(start >= end) return;
        int rightStart = partition(arr, start, end);
        quicksort(arr, start, rightStart - 1);
        quicksort(arr, rightStart, end);
    }

    public static int partition(int[] arr, int left, int right){
        int k = random.nextInt(right + 1 - left) + left;
        int pivot = arr[k];
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