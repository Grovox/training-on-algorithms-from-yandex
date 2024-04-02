package algorithm.training.five.lesson.four.binary.search;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class F_BikePaths {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int w = Integer.parseInt(tokenizer.nextToken()), h = Integer.parseInt(tokenizer.nextToken()), n = Integer.parseInt(tokenizer.nextToken());

        Map<Integer, MinMax> xMinMaxMap = new TreeMap<>();
        Map<Integer, MinMax> yMinMaxMap = new TreeMap<>();
        int maxX = -1, minX = -1, maxY = -1, minY = -1;

        for (int i = 0; i < n; i++){
            tokenizer = new StringTokenizer(reader.readLine(), " ");

            int x = Integer.parseInt(tokenizer.nextToken());

            if (maxX < x || maxX == -1) maxX = x;
            if (minX > x || minX == -1) minX = x;

            int y = Integer.parseInt(tokenizer.nextToken());

            if (maxY < y || maxY == -1) maxY = y;
            if (minY > y || minY == -1) minY = y;

            if (!xMinMaxMap.containsKey(x)){
                xMinMaxMap.put(x, new MinMax(y, y));
            }else {
                if (y > xMinMaxMap.get(x).max) xMinMaxMap.get(x).max = y;
                if (y < xMinMaxMap.get(x).min) xMinMaxMap.get(x).min = y;
            }

            if (!yMinMaxMap.containsKey(y)){
                yMinMaxMap.put(y, new MinMax(x, x));
            }else {
                if (x > yMinMaxMap.get(y).max) yMinMaxMap.get(y).max = x;
                if (x < yMinMaxMap.get(y).min) yMinMaxMap.get(y).min = x;
            }
        }
        List<Integer> xSortList = new ArrayList<>(xMinMaxMap.keySet());

        int[] afterXMax = new int[xSortList.size()];
        int[] afterXMin = new int[xSortList.size()];
        int min = 0, max = 0;

        for (int i = xSortList.size() - 1; i >= 0; i--){
            if (xMinMaxMap.containsKey(xSortList.get(i))){
                if (xMinMaxMap.get(xSortList.get(i)).min < min || min == 0) min = xMinMaxMap.get(xSortList.get(i)).min;
                if (xMinMaxMap.get(xSortList.get(i)).max > max || max == 0) max = xMinMaxMap.get(xSortList.get(i)).max;
            }
            afterXMax[i] = max;
            afterXMin[i] = min;
        }

        int[] prevXMax = new int[xSortList.size()];
        int[] prevXMin = new int[xSortList.size()];
        min = 0;
        max = 0;
        for (int i = 0; i < xSortList.size(); i++){
            if (xMinMaxMap.containsKey(xSortList.get(i))){
                if (xMinMaxMap.get(xSortList.get(i)).min < min || min == 0) min = xMinMaxMap.get(xSortList.get(i)).min;
                if (xMinMaxMap.get(xSortList.get(i)).max > max || max == 0) max = xMinMaxMap.get(xSortList.get(i)).max;
            }
            prevXMax[i] = max;
            prevXMin[i] = min;
        }

        List<Integer> ySortList = new ArrayList<>(yMinMaxMap.keySet());
        int[] afterYMax = new int[ySortList.size()];
        int[] afterYMin = new int[ySortList.size()];
        min = 0;
        max = 0;
        for (int i = ySortList.size() - 1; i >= 0; i--){
            if (yMinMaxMap.containsKey(ySortList.get(i))){
                if (yMinMaxMap.get(ySortList.get(i)).min < min || min == 0) min = yMinMaxMap.get(ySortList.get(i)).min;
                if (yMinMaxMap.get(ySortList.get(i)).max > max || max == 0) max = yMinMaxMap.get(ySortList.get(i)).max;
            }

            afterYMax[i] = max;
            afterYMin[i] = min;
        }

        int[] prevYMax = new int[ySortList.size()];
        int[] prevYMin = new int[ySortList.size()];
        min = 0;
        max = 0;
        for (int i = 0; i < ySortList.size(); i++){
            if (yMinMaxMap.containsKey(ySortList.get(i))){
                if (yMinMaxMap.get(ySortList.get(i)).min < min || min == 0) min = yMinMaxMap.get(ySortList.get(i)).min;
                if (yMinMaxMap.get(ySortList.get(i)).max > max || max == 0) max = yMinMaxMap.get(ySortList.get(i)).max;
            }

            prevYMax[i] = max;
            prevYMin[i] = min;
        }

        int ans = w;
        int keyPrev = -1, keyAfter;
        for (int i = 0; i < xSortList.size(); i++){
            if (i > 0) keyPrev = i - 1;
            boolean isFind = false;
            int l = i, r = xSortList.size() - 1, m;
            while (l < r){
                m = (l + r) / 2;
                if (m == xSortList.size() - 1) {
                    keyAfter = -1;
                }else keyAfter = m + 1;
                if (check(xSortList.get(i), xSortList.get(m), keyPrev, keyAfter, prevXMax, prevXMin, afterXMax, afterXMin)){
                    r = m;
                    isFind = true;
                }else l = m + 1;
            }
            if (xSortList.get(l) - xSortList.get(i) + 1 == 100){
                System.out.println(true);
            }
            if (xSortList.get(l) - xSortList.get(i) + 1 < ans && (isFind || (i == 0 && l == ySortList.size() - 1))) ans = xSortList.get(l) - xSortList.get(i) + 1;
        }
        keyPrev = -1;
        for (int i = 0; i < ySortList.size(); i++){
            if (i > 0) keyPrev = i - 1;
            boolean isFind = false;
            int l = i, r = ySortList.size() - 1, m;
            while (l < r){
                m = (l + r) / 2;
                if (m == ySortList.size() - 1) {
                    keyAfter = -1;
                }else keyAfter = m + 1;
                if (check(ySortList.get(i), ySortList.get(m), keyPrev, keyAfter, prevYMax, prevYMin, afterYMax, afterYMin)){
                    r = m;
                    isFind = true;
                }else l = m + 1;
            }
            if (ySortList.get(l) - ySortList.get(i) + 1 < ans && (isFind || (i == 0 && l == ySortList.size() - 1))) ans = ySortList.get(l) - ySortList.get(i) + 1;
        }
        System.out.println(ans);
    }
    public static boolean check(int start, int end, int keyPrev, int keyAfter, int[] prevMax, int[] prevMin,
                                int[] afterMax, int[] afterMin){
        int wight = end - start + 1;
        int minPrev = 0, maxPrev = 0;
        if (keyPrev != -1) {
            maxPrev = prevMax[keyPrev];
            minPrev = prevMin[keyPrev];
        }

        int minAfter = 0, maxAfter = 0;
        if (keyAfter != -1) {
            maxAfter = afterMax[keyAfter];
            minAfter = afterMin[keyAfter];
        }

        if (maxAfter != 0 && minAfter != 0 && maxAfter - minAfter + 1 > wight) return false;
        if (maxPrev != 0 && minPrev != 0 && maxPrev - minPrev + 1 > wight) return false;
        if (maxPrev != 0 && minAfter != 0 && maxPrev - minAfter + 1 > wight) return false;
        if (maxAfter != 0 && minPrev != 0 && maxAfter - minPrev + 1 > wight) return false;
        return true;
    }
}

class MinMax{
    int min;
    int max;

    public MinMax(int min, int max) {
        this.min = min;
        this.max = max;
    }
}
