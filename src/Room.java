import java.util.ArrayList;

public class Room {
	private int id;
	private String name;
	private String description;
	private Room north;
	private Room south;
	private Room east;
	private Room west;

	private ArrayList<Items> items;

	private String itemActions;

	private boolean isVisited;

	private boolean hasMonster;

	public Room(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
		items = new ArrayList<>();
	}

	public void setItems(ArrayList<Items> items) {
		this.items = items;
	}

	public void setRoomAtDirection(String direction, Room roomById) {
		if (direction.equalsIgnoreCase("North")) {
			north = roomById;
		} else if (direction.equalsIgnoreCase("South")) {
			south = roomById;
		} else if (direction.equalsIgnoreCase("East")) {
			east = roomById;
		} else if (direction.equalsIgnoreCase("West")) {
			west = roomById;
		}
	}

	public int getNumber()
	{
		return id;
	}

	public Room getRoomAtDirection(char input)
	{
		Room r;
		if (input == 'N' || input == 'n') {
			r = north;
		} else if (input == 'S' || input == 's') {
			r = south;
		} else if (input == 'E' || input == 'e') {
			r = east;
		} else {
			r = west;
		}
		return r;
	}

	public boolean isHasMonster()
	{
		return hasMonster;
	}

	public void setHasMonster(boolean hasMonster)
	{
		this.hasMonster = hasMonster;
	}

	public void setItemActions(String action)
	{
		itemActions = itemActions + " " + action;
	}

	public void setVisited() {
		isVisited = true;
	}

	public boolean isVisited() {
		return isVisited;
	}

	@Override
	public String toString() {
		return name + "\n" + description;
	}

	public void addItem(Items item)
	{
		if (item == null) return;
		this.items.add(item);
	}

	public boolean contains(Items item)
	{
		for (Items val: items)
		{
			if (val.getDescription().equals(item.getDescription()))
				return true;
		}
		return false;
	}

	public String getDescription()
	{
		return description;
	}

	public String getItemActions()
	{
		return itemActions;
	}

	public void setItemActions(String description, int id)
	{
		for (Items val: items)
		{
			if (val.getID() == id)
			{
				val.setRoomItems(val.getRoomItems() + " " +description);
				System.out.println("Room: " + this.id + " " + val.getRoomItems());
				return;
			}
		}
	}

	public ArrayList<Items> getItems()
	{
		return items;
	}

	public void removeItem(Items item)
	{
		items.remove(item);
	}
}