package gameobjects;


public class Room extends Thing {
    private Room n;
    private Room s;
    private Room w;
    private Room e;

    public Room(String aName, String aDesciption){
        super(aName,aDesciption);

    }


    public Room getN() {
        return n;
    }

    public void setN(Room n) {
        this.n = n;
        this.n.s = (this);
    }

    public Room getS() {
        return s;
    }

    public void setS(Room s) {
        this.s = s;
        this.s.n = (this);
    }

    public Room getE() {
        return e;
    }

    public void setE(Room e) {
        this.e = e;
        this.e.w = (this);
    }

    public Room getW() {
        return w;
    }

    public void setW(Room w) {
        this.w = w;
        this.w.e = (this);
    }

}
