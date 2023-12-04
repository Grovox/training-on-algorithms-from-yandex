package One.Lesson2LinearSearch;

import java.util.Scanner;

public class J_MaximTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        float[] f = new float[n];
        f[0] = scanner.nextFloat();
        boolean[] fb = new boolean[n];
        scanner.nextLine();
        for (int i = 1; i < n; i++){
            String[] in = scanner.nextLine().split(" ");
            f[i] = Float.parseFloat(in[0]);
            fb[i] = in[1].equals("closer");
        }
        float left = 30;
        float right = 4000;

        for (int i = 1; i < n; i++){
            float change;
            if(f[i] > f[i - 1]){
                change = (f[i] - f[i - 1]) / 2 + f[i - 1];
                if (fb[i]){
                    if(left < change) left = change;
                }else {
                    if (right > change) right = change;
                }
            }else {
                change = (f[i - 1] - f[i]) / 2 + f[i];
                if (fb[i]){
                    if (right > change) right = change;
                }else {
                    if(left < change) left = change;
                }
            }
        }

        System.out.println(left + " " + right);
    }
}
