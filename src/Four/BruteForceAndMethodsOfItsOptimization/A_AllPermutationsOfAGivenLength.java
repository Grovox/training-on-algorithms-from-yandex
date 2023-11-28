package Four.BruteForceAndMethodsOfItsOptimization;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class A_AllPermutationsOfAGivenLength {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[] elements = new int[N];
        int sizeResult = 1;
        for (int i = 1; i <= N; i++){
            elements[i - 1] = i;
            sizeResult *= i;
        }
        PrintWriter writer = new PrintWriter("brackets2.out");
        writer.println(Arrays.toString(elements).replaceAll("\\D", ""));
        int index1 = 0, index2;
        for (int i = 1; i < sizeResult; i++){
            index1 = findMaxIndex(elements);
            index2 = findIndexBiggerElement(index1, elements);
            swap(index1, index2, elements);
            reverse(index1, elements);
            writer.println(Arrays.toString(elements).replaceAll("\\D", ""));
        }
        writer.flush();
        writer.close();
    }


    static int findMaxIndex(int[] elements){
        for (int i = elements.length - 2; i >= 0; i--){
            if(elements[i] < elements[i + 1])
                return i;
        }
        return -1;
    }

    static int findIndexBiggerElement(int index, int[] elements){
        for (int i = elements.length - 1; i >= 0; i--){
            if(elements[i] > elements[index])
                return i;
        }
        return -1;
    }

    static void swap(int index1, int index2, int[] elements){
        int buffer = elements[index1];
        elements[index1] = elements[index2];
        elements[index2] = buffer;
    }

    static void reverse(int index, int[] elements){
        for (int i = index + 1, k = elements.length - 1; i <= k; i++, k--){
            swap(i, k, elements);
        }
    }
}
