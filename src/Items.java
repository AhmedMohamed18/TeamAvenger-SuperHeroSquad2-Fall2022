import java.util.ArrayList;
public class Items {
    private int itemID;
    private String name;
    private String description;
    private Room location;
    private ItemType type;
    private ArrayList<ItemActions> actions;
    private int attack;
    private int health;
    private int defense;
    private String roomItems = "";
    private String room;
    private Items weapon;

    public Items(int itemID, String tName, String tDescription)
    {
        this.itemID = itemID;
        this.name = tName;
        this.description = tDescription;
        actions = new ArrayList<>();
    }

    public int getAttack()
    {
        return attack;
    }

    public void setAttack(int attack)
    {
        this.attack = attack;
    }

    public int getHealth()
    {
        return health;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public int getDefense()
    {
        return defense;
    }

    public void setDefense(int defense)
    {
        this.defense = defense;
    }

    public int getItemID()
    {
        return itemID;
    }

    public void setItemID(int itemID)
    {
        this.itemID = itemID;
    }

    public Room getLocation()
    {
        return location;
    }

    public void setLocation(Room location)
    {
        this.location = location;
    }

    public ItemType getType()
    {
        return type;
    }

    public void setType(ItemType type)
    {
        this.type = type;
    }

    public ArrayList<ItemActions> getActions()
    {
        return actions;
    }

    public void setActions(ArrayList<ItemActions> actions)
    {
        this.actions = actions;
    }

    public void addAction(ItemActions action)
    {
        if (!actions.contains(action))
        {
            actions.add(action);
        }
    }

    public String getRoom()
    {
        return room;
    }

    public void setRoom(String room)
    {
        this.room = room;
    }

    public void Item(String name, String descrip, String room)
    {
        this.name = name;
        this.description = descrip;
        this.room = room;
    }

    public String getRoomItems()
    {
        return roomItems;
    }

    public void setRoomItems(String roomItems)
    {
        this.roomItems = roomItems;
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
        this.description = description;
    }

    public void setName(String name)
    {
        this.name = name;
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

    @Override
    public String toString()
    {
        return name + " " + description;
    }

    public int getDamage()
    {
        return attack;
    }

    public Items getWeapon()
    {
        return weapon;
    }
}