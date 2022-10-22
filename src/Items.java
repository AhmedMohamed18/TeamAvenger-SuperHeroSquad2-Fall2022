public class Items
{
    private int itemValue;
    private String name;
    private String description;
    private static String location;

    public Items(String gName, String gDescription, String glocation)
    {
        this.name = gName;
        this.description = gDescription;
        this.location = glocation;
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
    public String getLocation()
    {
        return location;
    }
    public String getDescription()
    {
        return description;
    }
    public void setLocation(String location)
    {
        location = location;
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
