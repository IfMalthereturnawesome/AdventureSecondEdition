import gameobjects.Room;
import gameobjects.Thing;

public class Player extends Thing {
    private Room room;

    public Player(String aName,String aDescription,Room aRoom) {
        super(aName,aDescription);
        this.room = aRoom;

    }

    public void setRoom(Room aRoom) {
        this.room = aRoom;
    }

    public Room getRoom() {
        return this.room;
    }
}

