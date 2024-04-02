package algorithm.training.four.lesson.four.brute.force.and.methods.ofIts.optimization;

import java.util.Scanner;

public class B_TheLostWorld {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] result = new int[1];
        search(N, 0, new int[N], result);
        System.out.println(result[0]);
    }

    static void search(int n, int index, int[] dino, int[] result){
        for(int i = 0; i < n; i++){
            if(index == 0){
                dino[index] = i;
                search(n, index + 1, dino, result);
                if(n == 1) result[0] += 1;
            } else {
                boolean flag = false;
                for (int j = 0; j < index; j++){
                    if (i == dino[j] || i == dino[j] + index - j || i == dino[j] - index + j){
                        flag = true;
                        break;
                    }
                }
                if(flag) continue;
                if(index + 1 == n){
                    result[0] += 1;
                }else{
                    dino[index] = i;
                    search(n, index + 1, dino, result);
                }
            }

        }
    }
}
