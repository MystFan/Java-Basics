package com.company;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws ParseException{
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());
        String[] lines = new String[n];
        for (int i = 0; i < n; i++) {
            lines[i] = console.nextLine();
        }

        int length = lines.length;
        HashMap<Integer, TreeMap<String, User>> tracker = new HashMap<>();
        for (int i = 0; i < length; i++) {
            String[] data = lines[i].split(" ");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
            LocalDate date = LocalDate.parse(data[0], formatter);

            int month = date.getMonth().getValue();
            if(!tracker.containsKey(month)){
                tracker.put(month, new TreeMap<>());
            }

            if(!tracker.get(month).containsKey(data[1])){
                tracker.get(month).put(data[1], new User(data[1], 0));
            }

            int distance = Integer.parseInt(data[2]);
            tracker.get(month).get(data[1]).distance += distance;
        }

        for (int i = 1; i < 13; i++) {
            if(!tracker.containsKey(i)){
                continue;
            }

            TreeMap<String, User> monthUsers = tracker.get(i);
            List<String> result = new ArrayList<>();
            for (String key : monthUsers.keySet()) {
                result.add(monthUsers.get(key).name + "(" + monthUsers.get(key).distance + ")");
            }

            StringBuilder sb = new StringBuilder();
            sb.append(i + ": ");
            for (int j = 0; j < result.size(); j++) {
                if(j < result.size() - 1){
                    sb.append(result.get(j) + ", ");
                }else{
                    sb.append(result.get(j));
                }
            }

            System.out.println(sb.toString());
        }
    }
}

class User implements Comparable<User>{
    public int distance;
    public String name;

    public User(String name, int distance){
        this.name = name;
        this.distance = distance;
    }

    public int compareTo(User obj){
        return this.distance - obj.distance;
    }
}
