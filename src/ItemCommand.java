public class ItemCommand
{
    private String action;
    private int roomID;
    private int itemID;

    public ItemCommand(String action, int roomID, int itemID)
    {
        this.action = action;
        this.roomID = roomID;
        this.itemID = itemID;
    }

    public String getAction()
    {
        return action;
    }

    public void setAction(String action)
    {
        this.action = action;
    }

    public int getRoomId()
    {
        return roomID;
    }

    public void setRoomId(int roomiD)
    {
        this.roomID = roomiD;
    }

    public int getItemId()
    {
        return itemID;
    }
    public void setItemId(int itemiD)
    {
        this.itemID = itemiD;
    }
}
