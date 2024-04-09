package algorithm.training.one.lesson.four.dictionaries.and.sorting.by.counting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
public class J_AdditionalCheckForCheating {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");

        int n = Integer.parseInt(tokenizer.nextToken());
        boolean isCaseSensitive = tokenizer.nextToken().equals("yes");
        boolean isStartWithNum = tokenizer.nextToken().equals("yes");
        Set<String> keyWords = new HashSet<>();
        for (int i = 0; i < n; i++){
            String in = reader.readLine();
            if (!isCaseSensitive) in = in.toLowerCase();
            keyWords.add(in);
        }

        Map<String, Integer> identifiersCounter = new HashMap<>();
        Map<String, LineAndIndex> identifiersPositionFirst = new HashMap<>();

        String line;
        int indexLine = 0;
        while((line = reader.readLine()) != null){
            if (!isCaseSensitive) line = line.toLowerCase();
            for(int i = 0; i < line.length(); i++){
                if (!isStartWithNum && String.valueOf(line.charAt(i)).matches("[0-9]")){
                    int indexEnd = line.length();
                    for (int j = i; j < line.length() && indexEnd == line.length(); j++){
                        String end = String.valueOf(line.charAt(j));
                        if (end.matches("\\W")) indexEnd = j;
                    }
                    i = indexEnd;
                    continue;
                }
                if (String.valueOf(line.charAt(i)).matches("\\W")) continue;
                int indexEnd = line.length();
                boolean isIdentifier = !isStartWithNum;
                for (int j = i; j < line.length() && indexEnd == line.length(); j++){
                    String end = String.valueOf(line.charAt(j));
                    if (!isIdentifier && end.matches("[A-z]")) isIdentifier = true;
                    if (end.matches("\\W") && isIdentifier) indexEnd = j;
                }
                if(isIdentifier){
                    String identifier = line.substring(i, indexEnd);
                    if(!keyWords.contains(identifier)){
                        if (!identifiersCounter.containsKey(identifier)) identifiersPositionFirst.put(identifier, new LineAndIndex(indexLine, i));
                        identifiersCounter.put(identifier ,identifiersCounter.getOrDefault(identifier, 0) + 1);
                    }
                }
                i = indexEnd;
            }
            indexLine ++;
        }
        String ans = "";
        int sizeAns = 0;
        for (String key : identifiersCounter.keySet()){
            if (sizeAns < identifiersCounter.get(key)){
                sizeAns = identifiersCounter.get(key);
                ans = key;
            }else if (sizeAns == identifiersCounter.get(key)){
                if (identifiersPositionFirst.get(key).line < identifiersPositionFirst.get(ans).line){
                    ans = key;
                }else if (identifiersPositionFirst.get(key).line == identifiersPositionFirst.get(ans).line){
                    if (identifiersPositionFirst.get(key).index < identifiersPositionFirst.get(ans).index){
                        ans = key;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}

class LineAndIndex{
    int line;
    int index;

    public LineAndIndex(int line, int index) {
        this.line = line;
        this.index = index;
    }
}