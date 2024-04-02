package algorithm.training.one.lesson.four.dictionaries.and.sorting.by.counting;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class G_BankAccounts {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        Map<String, Long> bankAccounts = new HashMap<>();
        String line;
        PrintWriter writer = new PrintWriter("output.txt");
        while ((line = reader.readLine()) != null && !line.equals("")){
            String[] request = line.split(" ");
            if (request[0].equals("DEPOSIT")){
                bankAccounts.put(request[1], bankAccounts.getOrDefault(request[1],0l) + Long.parseLong(request[2]));
            } else if (request[0].equals("WITHDRAW")){
                bankAccounts.put(request[1], bankAccounts.getOrDefault(request[1],0l) - Long.parseLong(request[2]));
            } else if (request[0].equals("BALANCE")){
                if (bankAccounts.get(request[1]) == null){
                    writer.println("ERROR");
                } else writer.println(bankAccounts.get(request[1]));
            } else if (request[0].equals("TRANSFER")){
                bankAccounts.put(request[1], bankAccounts.getOrDefault(request[1],0l) - Long.parseLong(request[3]));
                bankAccounts.put(request[2], bankAccounts.getOrDefault(request[2],0l) + Long.parseLong(request[3]));
            }else if (request[0].equals("INCOME")){
                for (String name : bankAccounts.keySet()){
                    if (bankAccounts.get(name) > 0) {
                        bankAccounts.put(name, bankAccounts.get(name) + ((Long.parseLong(request[1]) * bankAccounts.get(name)) / 100));
                    }
                }
            }
        }
        writer.flush();
        writer.close();
    }
}
