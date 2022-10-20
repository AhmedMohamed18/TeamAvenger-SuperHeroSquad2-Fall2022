import java.util.ArrayList;

import java.util.List;


/*
 * @author of Class: Ahmed Mohamed
 *
 * */
public class Room {

    private int number;
    private String name;
    private String description;
    private boolean visited;

    List<Exit> exits;


    /*
     * @author of method: Ahmed Mohamed
     *
     * */
    public Room(int number, String name, String description )
    {
        this.number = number;
        this.name = name;
        this.description = description;
        this.visited = false;
        exits = new ArrayList<>();
    }

    /**
     * Method: isVisited
     * return current state of room was it already visited or not
     */
    /*
     * @author of method: Ahmed Mohamed
     *
     * */
    public boolean isVisited()
    {
        return visited;
    }

    /**
     * Method: setVisited
     * Set room status as it is already visited
     */
    /*
     * @author of method: Ahmed Mohamed
     *
     * */
    public void setVisited()
    {
        visited = true;
    }

    /**
     * Method: setRoomAtDirection
     * set the given room location at the given direction of current room
     */
    /*
     * @author of method: Ahmed Mohamed
     *
     * */
    public void setRoomAtDirection(String direction, Room room)
    {
        Exit newExit = new Exit(direction.toLowerCase().charAt(0), room);
        exits.add(newExit);
    }

    /**
     * Method: getRoomAtDirection
     * Get the room located at given direction
     */
    /*
     * @author of method: Ahmed Mohamed
     *
     * */
    public Room getRoomAtDirection(char direction)
    {
        for(Exit currentExit : exits){
            if(currentExit.getDirection() == direction){
                return currentExit.getRoom();
            }
        }
        return null;
    }


    /*
     * @author of method: Ahmed Mohamed
     *
     * */
    public int getNumber() {
        return number;
    }


    public void setNumber(int number) {
        this.number = number;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }



    public String getDescription() {
        return description;
    }



    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * Method: toString
     */
    /*
     * @author of method: Ahmed Mohamed
     *
     * */
    public String toString()
    {
        String str = name;
        if(!isVisited())
            str += " Not ";
        str+=" visited\n"+getDescription();

        return str;
    }


}
