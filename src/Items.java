public class Items
{
    private int itemID;
    private String name;
    private String description;

    public Items(int itemID, String tName, String tDescription)
    {
        this.itemID = itemID;
        this.name = tName;
        this.description = tDescription;

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
    public String getDescription()
    {
        return description;
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

    public int getNumber()
    {
        return itemID;
    }
}
