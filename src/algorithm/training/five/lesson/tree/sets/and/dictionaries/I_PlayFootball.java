package algorithm.training.five.lesson.tree.sets.and.dictionaries;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class I_PlayFootball {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        HashMap<String, Integer> totalGoals = new HashMap<>();
        HashMap<String, Integer> countGames = new HashMap<>();
        HashMap<String, Integer> totalGoalsPlayer = new HashMap<>();
        HashMap<String, String> playersCommand = new HashMap<>();
        HashMap<Integer,HashMap<String,Integer>> goalsOnMinute = new HashMap<>();
        HashMap<String, List<Integer>> goalsMinutesPayer = new HashMap<>();
        HashMap<String, Integer> commandsOpenScore = new HashMap<>();
        HashMap<String, Integer> playersOpenScore = new HashMap<>();

        String line;
        PrintWriter writer = new PrintWriter("output.txt");
        while ((line = reader.readLine()) != null && !line.equals("")){
            if (line.length() > 16 && line.substring(0, 16).equals("Total goals for ")){
                writer.println(totalGoals.getOrDefault(line.substring(17, line.length() - 1), 0));

            }  else if (line.length() > 24 && line.substring(0, 24).equals("Mean goals per game for ")){
                String key = line.substring(25, line.length() - 1);
                writer.println((float) totalGoals.get(key) / countGames.get(key));

            }  else if (line.length() > 15 && line.substring(0, 15).equals("Total goals by ")){
                writer.println(totalGoalsPlayer.getOrDefault(line.substring(15), 0));

            }  else if (line.length() > 23 && line.substring(0, 23).equals("Mean goals per game by ")){
                String key = line.substring(23);
                writer.println((float) totalGoalsPlayer.get(key) / countGames.get(playersCommand.get(key)));

            }  else if (line.length() > 16 && line.substring(0, 16).equals("Goals on minute ")){
                int indexSp = line.indexOf(" b", 16);
                int minute = Integer.parseInt(line.substring(16, indexSp));
                String key = line.substring(indexSp + 4);
                if (!goalsOnMinute.containsKey(minute)){
                    writer.println(0);
                }else writer.println(goalsOnMinute.get(minute).getOrDefault(key, 0));

            }  else if (line.length() > 15 && line.substring(0, 15).equals("Goals on first ")){
                int indexSp = line.indexOf(" m", 15);
                int minute = Integer.parseInt(line.substring(15, indexSp));
                String key = line.substring(indexSp + 12);
                int ans = 0;
                if (goalsMinutesPayer.containsKey(key)){
                    for (int minutePlayers : goalsMinutesPayer.get(key)){
                        if (minutePlayers > minute) continue;
                        ans++;
                    }
                }
                writer.println(ans);

            }  else if (line.length() > 14 && line.substring(0, 14).equals("Goals on last ")){
                int indexSp = line.indexOf(" m", 14);
                int minute = 91 - Integer.parseInt(line.substring(14, indexSp));
                String key = line.substring(indexSp + 12);
                int ans = 0;
                if (goalsMinutesPayer.containsKey(key)) {
                    for (int minutePlayers : goalsMinutesPayer.get(key)) {
                        if (minutePlayers < minute) continue;
                        ans++;
                    }
                }
                writer.println(ans);

            }  else if (line.length() > 15 && line.substring(0, 15).equals("Score opens by ")){
                String key = line.substring(15);
                if (key.charAt(0) == '\"'){
                    key = key.substring(1, key.length() -1);
                    writer.println(commandsOpenScore.getOrDefault(key, 0));
                }else writer.println(playersOpenScore.getOrDefault(key, 0));

            } else {
                int indexSp = line.indexOf("-");
                String nameOneTeam = line.substring(1, indexSp - 2);
                int indexSp2 = line.indexOf("\"", indexSp + 3);
                String nameTwoTeam = line.substring(indexSp + 3, indexSp2);
                String[] score = line.substring(indexSp2 + 2).split(":");
                int goalsOneTeam = Integer.parseInt(score[0]);
                int goalsTwoTeam = Integer.parseInt(score[1]);

                totalGoals.put(nameOneTeam, totalGoals.getOrDefault(nameOneTeam, 0) + goalsOneTeam);
                totalGoals.put(nameTwoTeam, totalGoals.getOrDefault(nameTwoTeam, 0) + goalsTwoTeam);

                countGames.put(nameOneTeam, countGames.getOrDefault(nameOneTeam, 0) + 1);
                countGames.put(nameTwoTeam, countGames.getOrDefault(nameTwoTeam, 0) + 1);

                int minMinute = 91;
                String playerOpenScore = "";
                String commandOpenScore = "";
                for (int i = 0; i < goalsOneTeam; i++) {
                    line = reader.readLine();
                    String namePlayer = line.substring(0, line.length() - 3);
                    if (namePlayer.charAt(namePlayer.length() - 1) == ' ') namePlayer = namePlayer.substring(0, namePlayer.length() - 1);
                    int minute = Integer.parseInt(line.substring(line.length() - 3, line.length() - 1).replace(" ", ""));

                    totalGoalsPlayer.put(namePlayer, totalGoalsPlayer.getOrDefault(namePlayer, 0) + 1);
                    playersCommand.put(namePlayer, nameOneTeam);
                    if (!goalsOnMinute.containsKey(minute)) goalsOnMinute.put(minute, new HashMap<>());
                    goalsOnMinute.get(minute).put(namePlayer, goalsOnMinute.get(minute).getOrDefault(namePlayer, 0) + 1);
                    if (!goalsMinutesPayer.containsKey(namePlayer)) goalsMinutesPayer.put(namePlayer, new ArrayList<>());
                    goalsMinutesPayer.get(namePlayer).add(minute);

                    if (minMinute > minute){
                        minMinute = minute;
                        playerOpenScore = namePlayer;
                        commandOpenScore = nameOneTeam;
                    }
                }
                for (int i = 0; i < goalsTwoTeam; i++) {
                    line = reader.readLine();
                    String namePlayer = line.substring(0, line.length() - 3);
                    if (namePlayer.charAt(namePlayer.length() - 1) == ' ') namePlayer = namePlayer.substring(0, namePlayer.length() - 1);
                    int minute = Integer.parseInt(line.substring(line.length() - 3, line.length() - 1).replace(" ", ""));

                    totalGoalsPlayer.put(namePlayer, totalGoalsPlayer.getOrDefault(namePlayer, 0) + 1);
                    playersCommand.put(namePlayer, nameTwoTeam);
                    if (!goalsOnMinute.containsKey(minute)) goalsOnMinute.put(minute, new HashMap<>());
                    goalsOnMinute.get(minute).put(namePlayer, goalsOnMinute.get(minute).getOrDefault(namePlayer, 0) + 1);
                    if (!goalsMinutesPayer.containsKey(namePlayer)) goalsMinutesPayer.put(namePlayer, new ArrayList<>());
                    goalsMinutesPayer.get(namePlayer).add(minute);

                    if (minMinute > minute){
                        minMinute = minute;
                        playerOpenScore = namePlayer;
                        commandOpenScore = nameTwoTeam;
                    }
                }

                commandsOpenScore.put(commandOpenScore, commandsOpenScore.getOrDefault(commandOpenScore, 0) + 1);
                playersOpenScore.put(playerOpenScore, playersOpenScore.getOrDefault(playerOpenScore, 0) + 1);
            }
        }
        writer.flush();
        writer.close();
    }
}
