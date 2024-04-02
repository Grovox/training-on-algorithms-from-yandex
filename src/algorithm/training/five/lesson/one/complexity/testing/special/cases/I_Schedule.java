package algorithm.training.five.lesson.one.complexity.testing.special.cases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class I_Schedule {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(reader.readLine());
        int year = Integer.parseInt(reader.readLine());
        Set[] holidays = new HashSet[13];
        for (int i = 0; i < 13; i++){
            holidays[i] = new HashSet<Integer>();
        }
        for (int i = 0; i < n; i++){
            String in[] = reader.readLine().split(" ");
            if (in[1].equals("January")){
                holidays[1].add(Integer.parseInt(in[0]));
            }else if (in[1].equals("February")){
                holidays[2].add(Integer.parseInt(in[0]));
            }else if (in[1].equals("March")){
                holidays[3].add(Integer.parseInt(in[0]));
            }else if (in[1].equals("April")){
                holidays[4].add(Integer.parseInt(in[0]));
            }else if (in[1].equals("May")){
                holidays[5].add(Integer.parseInt(in[0]));
            }else if (in[1].equals("June")){
                holidays[6].add(Integer.parseInt(in[0]));
            }else if (in[1].equals("July")){
                holidays[7].add(Integer.parseInt(in[0]));
            }else if (in[1].equals("August")){
                holidays[8].add(Integer.parseInt(in[0]));
            }else if (in[1].equals("September")){
                holidays[9].add(Integer.parseInt(in[0]));
            }else if (in[1].equals("October")){
                holidays[10].add(Integer.parseInt(in[0]));
            }else if (in[1].equals("November")){
                holidays[11].add(Integer.parseInt(in[0]));
            }else if (in[1].equals("December")){
                holidays[12].add(Integer.parseInt(in[0]));
            }
        }
        String dayOfWeek = reader.readLine();
        int dayStart = 0;
        if (dayOfWeek.equals("Monday")){
            dayStart = 1;
        }else if (dayOfWeek.equals("Tuesday")){
            dayStart = 2;
        }else if (dayOfWeek.equals("Wednesday")){
            dayStart = 3;
        }else if (dayOfWeek.equals("Thursday")){
            dayStart = 4;
        }else if (dayOfWeek.equals("Friday")){
            dayStart = 5;
        }else if (dayOfWeek.equals("Saturday")){
            dayStart = 6;
        }else if (dayOfWeek.equals("Sunday")){
            dayStart = 7;
        }


        int[] dayInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) dayInMonth[2] ++;

        int[] holidaysInDayOfWeek = new int[8];

        for (int month = 1; month < 13; month++){
            for (int day = 1; day <= dayInMonth[month]; day++){
                if (!holidays[month].contains(day)){
                    holidaysInDayOfWeek[dayStart]++;
                }
                dayStart++;
                if (dayStart == 8) dayStart = 1;
            }
        }

        int min = 500;
        int minAns = 0;
        int max = 0;
        int maxAns = 0;

        for (int i = 1; i < 8; i++){
            if (holidaysInDayOfWeek[i] < min){
                min = holidaysInDayOfWeek[i];
                minAns = i;
            }
            if (holidaysInDayOfWeek[i] >= max){
                max = holidaysInDayOfWeek[i];
                maxAns = i;
            }
        }


        if (maxAns == 1){
            System.out.print("Monday ");
        }else if (maxAns == 2){
            System.out.print("Tuesday ");
        }else if (maxAns == 3){
            System.out.print("Wednesday ");
        }else if (maxAns == 4){
            System.out.print("Thursday ");
        }else if (maxAns == 5){
            System.out.print("Friday ");
        }else if (maxAns == 6){
            System.out.print("Saturday ");
        }else if (maxAns == 7){
            System.out.print("Sunday ");
        }

        if (minAns == 1){
            System.out.print("Monday");
        }else if (minAns == 2){
            System.out.print("Tuesday");
        }else if (minAns == 3){
            System.out.print("Wednesday");
        }else if (minAns == 4){
            System.out.print("Thursday");
        }else if (minAns == 5){
            System.out.print("Friday");
        }else if (minAns == 6){
            System.out.print("Saturday");
        }else if (minAns == 7){
            System.out.print("Sunday");
        }

    }
}
