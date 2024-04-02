package algorithm.training.five.lesson.four.binary.search;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;

public class H_Elections {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(reader.readLine());

        int[] voices = new int[n];
        int[] bribes = new int[n];

        Map<Integer, List<Integer>> repeatVoices = new HashMap<>();

        int maxVoices = 0;

        for (int i = 0; i < n; i ++){
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            voices[i] = Integer.parseInt(tokenizer.nextToken());
            bribes[i] = Integer.parseInt(tokenizer.nextToken());

            if (!repeatVoices.containsKey(voices[i])) repeatVoices.put(voices[i], new ArrayList<>());
            repeatVoices.get(voices[i]).add(i);

            if (voices[i] > maxVoices){
                maxVoices = voices[i];
            }
        }
        List<Integer> voiceSort = new ArrayList<>(repeatVoices.keySet());
        voiceSort.sort(Comparator.reverseOrder());

        int[] preSize = new int[voiceSort.size()];
        long[] preSum = new long[voiceSort.size()];
        if (voiceSort.size() > 1){
            preSize[0] = repeatVoices.get(voiceSort.get(0)).size();
            preSum[0] = (long) (voiceSort.get(0) - voiceSort.get(1)) * preSize[0];
            for (int i = 1; i < voiceSort.size() - 1; i++){
                preSize[i] = preSize[i - 1] + repeatVoices.get(voiceSort.get(i)).size();
                preSum[i] = preSum[i - 1]  + (long) (voiceSort.get(i) - voiceSort.get(i + 1)) * preSize[i];
            }
            preSize[voiceSort.size() - 1] = preSize[voiceSort.size() - 2] + repeatVoices.get(voiceSort.get(voiceSort.size() - 1)).size();
            preSum[voiceSort.size() - 1] = preSum[voiceSort.size() - 2] + (long) voiceSort.get(voiceSort.size() - 1) * preSize[voiceSort.size() - 1];
        }


        int indexMinSum = 0;
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (bribes[i] == -1 || bribes[i] > minSum) continue;
            int sum = bribes[i];
            if (voices[i] == maxVoices && repeatVoices.get(maxVoices).size() > 1){
                sum++;
            }else if(voices[i] != maxVoices) {
                int l = 1, r = maxVoices, m;
                while (l < r) {
                    m = (l + r) / 2;
                    if (check(voices[i], maxVoices, m, voiceSort, preSum, preSize)) {
                        r = m;
                    } else l = m + 1;
                }
                sum += l;
            }
            if (minSum > sum){
                minSum = sum;
                indexMinSum = i;
            }
        }

        if (voices[indexMinSum] != maxVoices || repeatVoices.get(maxVoices).size() > 1) {
            if (voices[indexMinSum] == maxVoices && repeatVoices.get(maxVoices).size() > 1) {
                int i2;
                if (repeatVoices.get(maxVoices).get(0) != indexMinSum) {
                    i2 = repeatVoices.get(maxVoices).get(0);
                } else i2 = repeatVoices.get(maxVoices).get(1);

                voices[i2]--;
                voices[indexMinSum]++;
            } else {
                int index = 0;
                int m = minSum - bribes[indexMinSum];
                if (m >= preSum[index]){
                    if (index + 1 < voiceSort.size() && m >= preSum[index + 1]) {
                        int l = index, r = voiceSort.size() - 1, mx;
                        while (l < r) {
                            mx = (l + r + 1) / 2;
                            if (m >= preSum[mx]) {
                                l = mx;
                            } else r = mx - 1;
                        }
                        index = l;
                    }
                    voices[indexMinSum] += (int) preSum[index];
                    m -= (int) preSum[index];

                    int ref = 0;
                    if (voiceSort.size() > index + 1) ref = voiceSort.get(index + 1);
                    for (int i = 0; i <= index; i++) {
                        for (int j : repeatVoices.get(voiceSort.get(i))){
                            voices[j] = ref;
                        }
                    }
                    index++;
                }

                if (m / preSize[index] > 0){
                    int k = (int) (m / preSize[index]);
                    m -= preSize[index] * k;
                    voices[indexMinSum] += preSize[index] * k;
                    for (int i = 0; i <= index; i++) {
                        for (int j : repeatVoices.get(voiceSort.get(i))){
                            voices[j] -= k;
                        }
                    }
                }

                if (m != 0){
                    voices[indexMinSum] += m;
                    int i2  = repeatVoices.get(voiceSort.get(index)).get(0);
                    if (i2 == indexMinSum){
                        i2 = repeatVoices.get(voiceSort.get(index)).get(1);
                    }
                    voices[i2] -= m;
                }
            }
        }

        PrintWriter writer = new PrintWriter("output.txt");
        writer.println(minSum);
        writer.println(indexMinSum + 1);
        for (int i = 0; i < n; i++) writer.print(voices[i] + " ");
        writer.flush();
        writer.close();
    }
    public static boolean check(long ourVoice, int maxVoice, int m, List<Integer> voiceSort, long[] preSum, int[] preSize){
        if (ourVoice + m > maxVoice) return true;

        int index = 0;

        if (m >= preSum[index]){
            if (index + 1 < voiceSort.size() && m >= preSum[index + 1]) {
                int l = index, r = voiceSort.size() - 1, mx;
                while (l < r) {
                    mx = (l + r + 1) / 2;
                    if (m >= preSum[mx]) {
                        l = mx;
                    } else r = mx - 1;
                }
                index = l;
            }
            ourVoice += preSum[index];
            m -= (int) preSum[index];
            index++;

            maxVoice = voiceSort.get(index);
        }
        if (m != 0){
            int k = m / preSize[index];
            ourVoice += (long) preSize[index] * k;
            maxVoice -= k;
            m %= preSize[index];
        }
        if (preSize[index] == 1 && m != 0){
            maxVoice -= m;
        }
        ourVoice += m;

        return ourVoice > maxVoice;
    }
}
