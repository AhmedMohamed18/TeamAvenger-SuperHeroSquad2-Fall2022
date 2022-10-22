public class Items
{
    private int itemID;
    private String name;
    private String description;
    private static String room;

    public Items(String tName, String tDescription, String tRoom)
    {
        this.name = tName;
        this.description = tDescription;
        this.room = tRoom;
    }
    public void Item(String name, String descrip, String room)
    {
        name = name;
        description = descrip;
        room = room;
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
    public int getID()
    {
        return itemID;
    }
    public void setID(int gID)
    {
        this.itemID = gID;
    }
}
