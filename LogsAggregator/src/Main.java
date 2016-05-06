package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int linesCount = Integer.parseInt(console.nextLine());

        List<String> lines = new ArrayList<>();
        for (int i = 0; i < linesCount; i++) {
            String line = console.nextLine();
            lines.add(line);
        }

        TreeMap<String, Log> userLogs = new TreeMap<>();

        for (int i = 0; i < lines.size(); i++) {
            String[] userData = lines.get(i).split(" ");
            String username = userData[1];
            String ip = userData[0];
            Integer logDuration = Integer.parseInt(userData[2]);

            if (!userLogs.containsKey(username)) {
                userLogs.put(username, new Log());
            }

            int userLogDuration = userLogs.get(username).getDuration();
            userLogs.get(username).setDuration(userLogDuration + logDuration);
            userLogs.get(username).addIp(ip);
        }

        for (Map.Entry<String, Log> stringLogEntry : userLogs.entrySet()) {
            String keyName = stringLogEntry.getKey();
            Integer logDuration = stringLogEntry.getValue().getDuration();
            String ips = stringLogEntry.getValue().getIps().toString();
            System.out.printf("%s: %d %s%n", keyName, logDuration, ips);
        }
    }
}

class Log implements Comparable<Log>{
    private Integer duration;
    private TreeSet<String> ips;

    public Log(){
        this.ips = new TreeSet<>();
        this.setDuration(0);
    }

    public Integer getDuration(){
        return this.duration;
    }

    public void setDuration(Integer value){
        this.duration = value;
    }

    public TreeSet<String> getIps(){
        return new TreeSet<>(this.ips);
    }

    public void addIp(String ip){
        this.ips.add(ip);
    }

    @Override
    public int compareTo(Log otherLog) {
        return this.duration.compareTo(otherLog.getDuration());
    }
}
