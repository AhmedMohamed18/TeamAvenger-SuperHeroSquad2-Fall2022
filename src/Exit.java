
/*
 * @author of Class: Ahmed Mohamed
 *
 * */
public class Exit {

    private char direction;
    private Room room;
    /*
     * @author of method: Ahmed Mohamed
     *
     * */
    public Exit(char direction, Room room) {
        this.direction = direction;
        this.room = room;
    }
    /*
     * @author of method: Ahmed Mohamed
     *
     * */
    public char getDirection() {
        return direction;
    }
    /*
     * @author of method: Ahmed Mohamed
     *
     * */
    public void setDirection(char direction) {
        this.direction = direction;
    }
    /*
     * @author of method: Ahmed Mohamed
     *
     * */
    public Room getRoom() {
        return room;
    }
    /*
     * @author of method: Ahmed Mohamed
     *
     * */
    public void setRoom(Room room) {
        this.room = room;
    }
}
