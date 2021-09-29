
import java.util.Scanner;

import globals.Direction;

import java.util.*;

import gameobjects.Room;

public class Adventure {

    private ArrayList<Room> map;
    private Player person;

    public Adventure() {
        this.map = new ArrayList<Room>();
        // n , s , w , e
        map.add(new Room("Room 1 ", "The place you wish you could stay at",
                Direction.NOEXIT, 3, Direction.NOEXIT, 1));
        map.add(new Room("Room 2 ", "You will stay here " +
                "forever", Direction.NOEXIT, Direction.NOEXIT, 0, 2));
        map.add(new Room("Room 3 ", "I always liked this room, that is why you " +
                "should get OUT!", Direction.NOEXIT, 5, 1, Direction.NOEXIT));
        map.add(new Room("Room 4 ", "Welcome to the last door!," +
                " NOT!", 0, 6, Direction.NOEXIT, Direction.NOEXIT));
        map.add(new Room("Room 5 ", "Wait! How! You did it man!" +
                " no jokes!", Direction.NOEXIT, 7, Direction.NOEXIT, Direction.NOEXIT));
        map.add(new Room("Room 6 ", "Great, you are getting further" +
                " away. Just give it up!", 2, 8, Direction.NOEXIT, Direction.NOEXIT));
        map.add(new Room("Room 7 ", "Im telling you, the place you " +
                "are looking for is just a myth ", 3, Direction.NOEXIT, Direction.NOEXIT, 7));
        map.add(new Room("Room 8 ", "Loading query!", 4, Direction.NOEXIT, 6, 8));
        map.add(new Room("Room 9 ", "Im getting tired of this, just " +
                "give it up! Type Exit", 5, Direction.NOEXIT, 7, Direction.NOEXIT));

        person = new Player("Karsten ", "The Great", map.get(0));

    }

    public static void main(String[] args) {
        Adventure adventure = new Adventure();
        adventure.welcomeScreen();

        String output;
        do {

            output = adventure.userInput("START GAME!");
            System.out.println(output);

        } while (true);


    }

    ArrayList getMap() {
        return map;
    }

    void setMap(ArrayList aMap) {
        map = aMap;
    }

    public Player getPerson() {
        return person;
    }

    public void setPerson(Player aPerson) {
        person = aPerson;
    }


    void display(int numberOfRoom) {
        String str;

        if (Direction.NOEXIT == numberOfRoom) {
            str = "You cannot go that way";
        } else {
            Room rum = getPerson().getRoom();
            str = "You´re now in  " + rum.getName() + rum.getDescription();
        }
        System.out.println(str);
    }


    void moveActorTo(Player p, Room aRoom) {
        p.setRoom(aRoom);
    }


    int move(Player anPlayer, Direction dir) {
        Room rum = anPlayer.getRoom();

        int exit;

        switch (dir) {
            case NORTH:
                exit = rum.getN();
                break;
            case SOUTH:
                exit = rum.getS();
                break;
            case WEST:
                exit = rum.getW();
                break;
            case EAST:
                exit = rum.getE();
                break;
            default:
                exit = Direction.NOEXIT;
                break;

        }
        if (exit != Direction.NOEXIT) {
            moveActorTo(anPlayer, map.get(exit));
        }
        return exit;

    }

    public int currentRoom(Direction dir) {
        return move(person, dir);
    }

    public void welcomeScreen() {
        System.out.print("You are playing as ");
        System.out.print(getPerson().getName());
        System.out.println(getPerson().getDescription());
        System.out.println("Finally! Your help is required over here!\nWe had to put you in Room 1, for safety.\nYou " +
                "need to get out of here before its too late! You can either go north, south, west or east\n" +
                "Its time! Are you ready? Type 'yes' if you are! or 'no' if you wish to quit the game");
    }


    public String userInput(String dir) {
        Scanner input = new Scanner(System.in);
        String userIn = input.nextLine();

        if (userEast(userIn)) {
            return dir;
        } else if (userNorth(userIn)) {
            return dir;
        } else if (userSouth(userIn)) {
            return dir;
        } else if (userWest(userIn)) {
            return dir;
        } else if ("yes".equals(userIn)||"YES".equals(userIn)||"y".equals(userIn)||"Y".equals(userIn)) {
            return dir;
        }

            return "Try Again";
    }

    public boolean userNorth(String userIn) {


        switch (userIn) {
            case "n":
            case "N":
            case "go north":
            case "Go North":
            case "GO NORTH":
            case "goNorth":
            case "GoNorth":
            case "North":
            case "north":
            case "NORTH":
            case "gonorth":
                goN();
                break;
            case "exit":
            case "q":
            case "quit":
            case "Quit":
            case "Exit":
            case "EXIT":
            case "Q":
            case "NO":
            case "no":
                exit();
                break;
            case "help":
            case "HELP":
            case "h":
            case "H":
                help();
                break;
            case "look":
            case "LOOK":
            case "l":
            case "L":
                look();
                break;
            case "yes":
            case "YES":
            case "Yes":
            case "Y":
            case "y":
                ready();
                break;
            default:

        }
        return false;
    }

    public boolean userSouth(String userIn) {


        switch (userIn) {
            case "s":
            case "S":
            case "go south":
            case "Go South":
            case "GO SOUTH":
            case "gosouth":
            case "GoSouth":
            case "South":
            case "south":
            case "SOUTH":
            case "Gosouth":
                goS();
                break;
            case "exit":
            case "q":
            case "quit":
            case "Quit":
            case "Exit":
            case "EXIT":
            case "Q":
                exit();
                break;
            default:


        }
        return false;
    }

    public boolean userEast(String userIn) {


        switch (userIn) {
            case "e":
            case "E":
            case "go east":
            case "Go East":
            case "GO EAST":
            case "goEast":
            case "GoEast":
            case "East":
            case "east":
            case "EAST":
            case "goeast":
                goE();
                break;
            case "exit":
            case "q":
            case "quit":
            case "Quit":
            case "Exit":
            case "EXIT":
            case "Q":
                exit();
                break;
            default:


        }
        return false;
    }

    public boolean userWest(String userIn) {


        switch (userIn) {
            case "w":
            case "W":
            case "go west":
            case "Go West":
            case "GO WEST":
            case "goWest":
            case "GoWest":
            case "West":
            case "west":
            case "WEST":
            case "gowest":
            case "go w":
                goW();
                break;
            case "exit":
            case "q":
            case "quit":
            case "Quit":
            case "Exit":
            case "EXIT":
            case "Q":
                exit();
                break;
            default:


        }
        return false;
    }

    private void goN() {
        display(currentRoom(Direction.NORTH));
    }

    private void goE() {
        display(currentRoom(Direction.EAST));
    }

    private void goS() {
        display(currentRoom(Direction.SOUTH));
    }

    private void goW() {
        display(currentRoom(Direction.WEST));
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

    private void look() {
        showStr("Did you forget silly!\nAnyways, You are in " + getPerson().getRoom().getDescription());
        showStr("Okay then..." + getPerson().getRoom().getName());
    }

    private void ready(){
        System.out.println("For Directions Type: 'N' - 'S' - 'W' or 'E'" +
                "\nTo Look Which Room You Are In Type: 'Look'\n" +
                "For Help Type: 'Help'\nIf you want to exit the game Type: 'Exit'");
    }
}


