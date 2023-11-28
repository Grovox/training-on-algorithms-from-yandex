package Four.Sorting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class D_MergeSorting {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(reader.readLine());
        String[] in = reader.readLine().split(" ");
        int[] a;
        if (!in[0].equals("")) {
            a = Arrays.stream(in).mapToInt(Integer::parseInt).toArray();
        } else a = new int[0];

        mergeSortOptimal(a);

        PrintWriter writer = new PrintWriter("output.txt");
        writer.print(Arrays.toString(a).replace(",", "").replace("[", "").replace("]", ""));
        writer.flush();
        writer.close();
    }
    public static void mergeSortOptimal(int[] arr) {
        mergeSortOptimal(arr, 0 , arr.length - 1);
    }
    public static void mergeSortOptimal(int[] arr, int low, int high) {
        if(low >= high) return;
        int mid = (low + high) / 2;
        mergeSortOptimal(arr, low, mid);
        mergeSortOptimal(arr, mid + 1, high);
        mergeOptimal(arr, low, mid, high);
    }
    public static void mergeOptimal(int[] arr, int low, int mid, int high){
        int end1 = mid - low + 1;
        int end2 = high - mid;
        int[] leftArr =  new int[end1];
        int[] rightArr = new int[end2];

        for (int i = 0; i < leftArr.length; i++)
            leftArr[i] = arr[low + i];
        for (int i = 0; i < rightArr.length; i++)
            rightArr[i] = arr[mid + i + 1];

        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = low; i <= high; i++) {
            if(leftIndex < end1 && (rightIndex >= end2 || leftArr[leftIndex] < rightArr[rightIndex])){
                arr[i] = leftArr[leftIndex];
                leftIndex++;
            } else {
                arr[i] = rightArr[rightIndex];
                rightIndex++;
            }
        }
    }
}