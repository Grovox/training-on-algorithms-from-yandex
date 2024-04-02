package algorithm.training.one.lesson.tree.set;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class I_Polyglots {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        int numStudent = Integer.parseInt(reader.readLine());
        Set<String> languages = new HashSet<>();
        Set<String> commonLanguages = new HashSet<>();
        int numLanguages = Integer.parseInt(reader.readLine());
        for(int i = 0; i < numLanguages; i ++){
            String in = reader.readLine();
            languages.add(in);
            commonLanguages.add(in);
        }
        for (int i = 1; i < numStudent; i++){
            numLanguages = Integer.parseInt(reader.readLine());
            Set<String> modCommonLanguages = new HashSet<>();
            for (int j = 0; j < numLanguages; j++){
                String in = reader.readLine();
                languages.add(in);
                if(commonLanguages.contains(in)){
                    modCommonLanguages.add(in);
                }
            }
            commonLanguages = modCommonLanguages;
        }


        PrintWriter writer = new PrintWriter("output.txt");
        writer.println(commonLanguages.size());
        for (String s : commonLanguages) writer.println(s);
        writer.println(languages.size());
        for (String s : languages) writer.println(s);
        writer.flush();
        writer.close();
    }
}

