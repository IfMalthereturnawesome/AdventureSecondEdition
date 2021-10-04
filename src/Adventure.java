
import java.util.Scanner;

import gameobjects.Room;

public class Adventure {

    public static void main(String[] args) {
        Adventure adventure = new Adventure();
        adventure.welcomeScreen();
        adventure.ready();
        Room room1 = new Room("Room 1 ", "The place you wish you could stay at");
        Room room2 = new Room("Room 2 ", "You will stay here forever");
        Room room3 = new Room("Room 3 ", "I always liked this room, that is why you should get OUT!");
        Room room4 = new Room("Room 4 ", "Welcome to the last door! NOT!");
        Room room5 = new Room("Room 5 ", "Wait! How! You did it man! no jokes!");
        Room room6 = new Room("Room 6 ", "Great, you are getting further away. Just give it up!");
        Room room7 = new Room("Room 7 ", "Im telling you, the place you are looking for is just a mytht");
        Room room8 = new Room("Room 8 ", "Loading query!");
        Room room9 = new Room("Room 9 ", "Im getting tired of this, just give it up! Type Exit");


        room1.setEast(room2);
        room2.setEast(room3);
        room3.setSouth(room6);
        room4.setNorth(room1);
        room5.setSouth(room8);
        room6.setNorth(room3);
        room7.setEast(room8);
        room8.setEast(room9);
        room9.setNorth(room6);
        room4.setSouth(room7);

        Room currentRoom = room1;
        int count = 0;
        while (true) {
            String userin = adventure.userInput();

            if (userin.equalsIgnoreCase("go north")||userin.equalsIgnoreCase("n")) {
                if (currentRoom.getNorth() != null) {
                    currentRoom = currentRoom.getNorth();
                    System.out.println("You are now in " + currentRoom);
                    count++;
                } else {
                    System.out.println("you cant go this way");
                    count++;
                }

            }

            if (userin.equalsIgnoreCase("go south")||userin.equalsIgnoreCase("s")) {
                if (currentRoom.getSouth() != null) {
                    currentRoom = currentRoom.getSouth();
                    System.out.println("You are now in " + currentRoom);
                    count++;
                } else {
                    System.out.println("You cant go this way");
                    count++;
                }

            }

            if (userin.equalsIgnoreCase("go east")||userin.equalsIgnoreCase("e")) {
                if (currentRoom.getEast() != null) {
                    currentRoom = currentRoom.getEast();
                    System.out.println("You are now in " + currentRoom);
                    count++;
                } else {
                    System.out.println("You cant go this way");
                    count++;
                }

            }

            if (userin.equalsIgnoreCase("go west") || userin.equalsIgnoreCase("w")) {
                if (currentRoom.getWest() != null) {
                    currentRoom = currentRoom.getWest();
                    System.out.println("You are now in " + currentRoom);
                    count++;
                } else {
                    System.out.println("You cant got this way");
                    count++;
                }

            }

            if (currentRoom == room5) {
                System.out.println("You won bitch");
                if (count > 5) {
                    System.out.println("Are your parrents decending from turtles? - Becasue that was slooooow \n"
                            + "it took you " + count
                            + "  tries to get to the last room");
                    System.out.println("Bye bye!");
                    System.exit(1);
                } else
                    System.out.println("That was quick! You only took " + count + " attemps");
                System.out.println("Bye bye!");
                System.exit(1);
            }
            if (userin.equalsIgnoreCase("exit") || userin.equalsIgnoreCase("quit")) {
                System.out.println("why give up now? ");
                System.exit(2);
            }
            if (userin.equalsIgnoreCase("help")) {
                adventure.help();
            }
            if (userin.equalsIgnoreCase("look")) {
                System.out.println("Well, I think you might be in " + currentRoom);

            }

        }

    }

    public void welcomeScreen() {
        System.out.println("Finally! Your help is required over here!\nWe had to put you in Room 1, for safety.\nYou " +
                "need to get out of here before its too late! You can either go north, south, west or east");
    }

    public String userInput() {
        Scanner input = new Scanner(System.in);

        return input.nextLine();

    }

    private void help() {
        System.out.println("We all need help sometimes\nFor Directions Type: 'N' - 'S' - 'W' - 'E'\nTo Look Which Room You Are In Type: 'Look'\n" +
                "Keep On Going!\nIf you want to exit the game Type 'Exit'");

    }

    private String exit() {
        String quit = "q";
        System.exit(0);

        return quit;
    }

    private void showStr(String str) {

        System.out.println(str);
    }


    private void ready() {
        System.out.println("For Directions Type: 'N' - 'S' - 'W' or 'E'" +
                "\nTo Look Which Room You Are In Type: 'Look'\n" +
                "For Help Type: 'Help'\nIf you want to exit the game Type: 'Exit'");
    }
}


