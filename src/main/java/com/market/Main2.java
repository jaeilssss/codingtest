package com.market;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {


    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        int P = scanner.nextInt();
        int M = scanner.nextInt();
        ArrayList<User> userArrayList = new ArrayList<>();
        ArrayList<Room> rooms = new ArrayList<>();
        int roomNumber = 1;
        for(int i = 0; i<P; i++) {
            int level = scanner.nextInt();
            String nickname = scanner.next();
            if(rooms.isEmpty()) {
                ArrayList<User> nicknames = new ArrayList<>();
                nicknames.add(new User(level, nickname));
                rooms.add(new Room(nicknames,roomNumber++, level));
            }else {
                boolean enter = false;

                for(int k = 0; k<rooms.size(); k++) {
                    Room room = rooms.get(k);
                    if(room.level <= level+10 && room.level >= level-10) {
                        if(room.nickNameList.size() != M) {
                            room.nickNameList.add(new User(level, nickname));
                            rooms.set(k, room);
                            enter = true;
                            break;
                        }

                    }

                }
                if(!enter) {
                    ArrayList<User> nicknames = new ArrayList<>();
                    nicknames.add(new User(level, nickname));
                    rooms.add(new Room(nicknames, roomNumber++, level));

                }


            }
        }

        for(int i = 0 ; i < rooms.size(); i++) {
            Room room = rooms.get(i);

            if(room.nickNameList.size() ==M) {
                System.out.println("Started!");
                Collections.sort(room.nickNameList);
                room.nickNameList.forEach(user -> {
                    System.out.println(user.level + " " + user.nickname);
                });
            }else {
                System.out.println("Waiting!");
                Collections.sort(room.nickNameList);
                room.nickNameList.forEach(user -> {
                    System.out.println(user.level + " " + user.nickname);
                });
            }
        }
    }

    static class Room {
        public ArrayList<User> nickNameList;
        public int RoomNumber;
        public int level;

        public Room(ArrayList<User> nickNameList, int roomNumber, int level) {
            this.nickNameList = nickNameList;
            RoomNumber = roomNumber;
            this.level = level;
        }
    }

    static class User implements Comparable<User> {
        public int level;
        public String nickname;

        public User(int level, String nickname) {
            this.level = level;
            this.nickname = nickname;
        }

        @Override
        public int compareTo(User o) {
            return this.nickname.compareTo(o.nickname);
        }
    }
}