package gameobjects;


public class Room extends Thing {
    private Room north;
    private Room south;
    private Room west;
    private Room east;

    public Room(String aName, String aDesciption){
        super(aName,aDesciption);

    }

    public Room getNorth() {
        return north;
    }

    public void setNorth(Room north) {
        this.north = north;
        this.north.south = this;
    }

    public Room getSouth() {
        return south;
    }

    public void setSouth(Room south) {
        this.south = south;
        this.south.north = this;
    }

    public Room getEast() {
        return east;
    }

    public void setEast(Room east) {
        this.east = east;
        this.east.west = this;
    }

    public Room getWest() {
        return west;
    }

    public void setWest(Room west) {
        this.west = west;
        this.west.east = this;
    }

}
