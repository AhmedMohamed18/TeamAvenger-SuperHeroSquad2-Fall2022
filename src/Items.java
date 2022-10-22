public class Items {

    private int itemValue;
    private String name;
    private String description;
    private static String room;

    public Items(String gName, String gDescription, String gRoom)
    {
        this.name = gName;
        this.description = gDescription;
        this.room = gRoom;
    }

    public void Item(String name, String descrip, String location)
    {
        name = name;
        description = descrip;
        location = location;
    }
    public void look()
    {
        System.out.println(description);
    }
    public String getName()
    {
        return name;
    }
    public String getRoom()
    {
        return room;
    }
    public String getDescription()
    {
        return description;
    }
    public void setRoom(String room)
    {
        room = room;
    }
    public void setDescription(String description)
    {
        description = description;
    }
    public void setName(String name)
    {
        name = name;
    }
    public int getValue()
    {
        return itemValue;
    }
    public void setValue(int value)
    {
        itemValue = value;
    }
}
