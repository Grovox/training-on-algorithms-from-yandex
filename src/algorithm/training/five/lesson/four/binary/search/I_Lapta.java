package algorithm.training.five.lesson.four.binary.search;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class I_Lapta{
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int d = Integer.parseInt(tokenizer.nextToken()), n = Integer.parseInt(tokenizer.nextToken());

        int[] x = new int[n];
        int[] y = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++){
            tokenizer = new StringTokenizer(reader.readLine(), " ");
            x[i] = Integer.parseInt(tokenizer.nextToken());
            y[i] = Integer.parseInt(tokenizer.nextToken());
            v[i] = Integer.parseInt(tokenizer.nextToken());
        }
        double l = 0, r = 4 * d;
        while (r - l > 0.000001){
            double m = (l + r) / 2;
            if(check(m, d, x, y, v)[0] != 0){
                l = m;
            } else r = m;
        }
        double[] now = check(l, d, x, y, v);
        System.out.println(l);
        DecimalFormat decimalFormat = new DecimalFormat("#.#####");
        System.out.println(decimalFormat.format(now[1]) + " " + decimalFormat.format(now[2]));
    }

    private static double[] check(double time, int d, int[] x, int[] y, int[] v) {
        return checkRect(-d, 0, d, d, time, d, x, y, v);
    }

    private static double[] checkRect(double xll, double yll, double xru, double yru, double time, double d, int[] x, int[] y, int[] v) {
        if (    !pointInCircle(0, 0, d, xll, yll) &&
                !pointInCircle(0, 0, d, xll, yru) &&
                !pointInCircle(0, 0, d, xru, yll) &&
                !pointInCircle(0, 0, d, xru, yru)) return new double[]{0, 0, 0};
        if (xru - xll < 0.000001) return new double[]{1, (xll + xru) / 2, (yll + yru) / 2};
        for (int i = 0; i < x.length; i++){
            if (    pointInCircle(x[i], y[i], v[i] * time, xll, yll) &&
                    pointInCircle(x[i], y[i], v[i] * time, xll, yru) &&
                    pointInCircle(x[i], y[i], v[i] * time, xru, yll) &&
                    pointInCircle(x[i], y[i], v[i] * time, xru, yru)) return new double[]{0, 0, 0};
        }
        double[] xs = new double[]{xll, (xll + xru) / 2, xru};
        double[] ys = new double[]{yll, (yll + yru) / 2, yru};
        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 2; j++){
                double[] quarter = checkRect(xs[i], ys[j], xs[i + 1], ys[j + 1], time, d, x , y, v);
                if (quarter[0] != 0) return quarter;
            }
        }
        return new double[]{0, 0, 0};
    }

    private static boolean pointInCircle(double x0, double y0, double r0, double xp, double yp) {
        return Math.pow((xp - x0), 2) + Math.pow((yp - y0), 2) - Math.pow(r0, 2) < 0.000001;
    }
}
