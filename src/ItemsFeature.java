import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ItemsFeature
{
    private ArrayList<Items> items;
    private ArrayList<ItemCommand> itemCommands;
    private ArrayList<Items> itemInventory;
    private ArrayList<Items> sealants = new ArrayList<>();
    private boolean isCombined;
    private Items itemHeld;
    private Room root = null;
    private Game game;

    public ItemsFeature(String itemsFile, String itemsCommandsFile, Game game)
    {
        this.game = game;
        itemInventory = new ArrayList<>();
        getItemData(itemsFile, itemsCommandsFile);
    }

    public void getItemData(String itemsFile, String itemsCommandsFile)
    {
        try
        {
            Scanner itemData = new Scanner(new File(itemsFile));
            Scanner itemCommandsFiles = new Scanner(new File(itemsCommandsFile));
            items = new ArrayList<>();
            itemCommands = new ArrayList<>();
            try
            {
                itemData.nextLine();
                while (itemData.hasNextLine())
                {
                    int id = Integer.parseInt(itemData.nextLine());
                    String name = itemData.nextLine();
                    String description = itemData.nextLine();

                    String line = itemData.nextLine();

                    while (!line.equals("----"))
                    {
                        description += "\n" + line;
                        line = itemData.nextLine();
                    }
                    items.add(new Items(id, name, description));
                }
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                System.out.println("Error in itemsfile");
            }
            try
            {
                while (itemCommandsFiles.hasNextLine())
                {
                    String[] connection = itemCommandsFiles.nextLine().split(" ");
                    int id = Integer.parseInt(connection[0]);
                    int roomId = Integer.parseInt(connection[connection.length - 1]);
                    String description = "";
                    for (int i = 1; i < connection.length - 1; i++)
                    {
                        description = description + connection[i];
                    }
                    itemCommands.add(new ItemCommand(description, roomId, id));
                }

            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                System.out.println("Error in itemscommands file");
            }
            addActions();
            addItemType();
            addItemsToRooms();
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }
    private void addItemsToRooms()
    {
        ArrayList<Room> rooms = game.getRooms();
        for (Room room : rooms)
        {
            ArrayList<Items> items = getRoomItems(room);
            room.setItems(items);
        }
    }
    private void addActions()
    {
        for (Items item : items)
        {
            for (ItemCommand command : itemCommands)
            {
                if (item.getID() == command.getItemId())
                {
                    try
                    {
                        item.addAction(ItemActions.valueOf(command.getAction().toUpperCase()));
                    }
                    catch (IllegalArgumentException e)
                    {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }
    private void addItemType()
    {
        for (Items item : items)
        {
            if (item.getID() == 2 || item.getID() == 5 || item.getID() == 7)
            {
                item.setType(ItemType.RESOURCEFUL);
            }
            else if (item.getID() == 6)
            {
                item.setType(ItemType.CONSUMABLE);
            }
            else if (item.getID() == 3)
            {
                item.setType(ItemType.TRADABLE);
            }
            else if (item.getID() == 1 || item.getID() == 11 || item.getID() == 10)
            {
                item.setType(ItemType.WEAPON);
            }
            else
            {
                item.setType(ItemType.SEALANT);
            }
        }
    }
    public void showItemsFeature(Room room)
    {
        ArrayList<Items> rmItems = new ArrayList<>(room.getItems());
        if (rmItems.size() > 0)
        {
            System.out.println("       Items Found in the room         ");
        }
        else
        {
            return;
        }
        for (Items rmItem : rmItems)
        {
            System.out.println(rmItem);
            System.out.println("With these items you can: ");
            String s = showRoomCommand(room, rmItem);
            getCommand(rmItem);
            System.out.println(s);
        }
    }
    public void viewItemCommand(String choice, Items item)
    {
        if (choice.equalsIgnoreCase("PICK UP"))
        {
            pickUpItem(item);
        }
        else if (choice.equalsIgnoreCase("DROP"))
        {
            dropItem(item);
        }
        else if (choice.equalsIgnoreCase("EQUIP"))
        {
            equipItem(item);
        }
        else if (choice.equalsIgnoreCase("UNEQUIP"))
        {
            unequipItem(item);
        }
        else if (choice.equalsIgnoreCase("OPEN"))
        {
            openItem(item);
        }
        else if (choice.equalsIgnoreCase("COMBINE"))
        {
            combineItem(item);
        }
        else if (choice.equalsIgnoreCase("TRADE"))
        {
            tradeItem(item);
        }
        else if (choice.equalsIgnoreCase("CONSUME"))
        {
            consumeItem(item);
        }
        else if (choice.equalsIgnoreCase("INSPECT"))
        {
            System.out.println(item);
        }
        else
        {
            System.out.println("Unknown item command");
        }
    }
    private void consumeItem(Items item)
    {
        if (item.getActions().contains(ItemActions.CONSUME))
        {
            System.out.println("Player health has increased by 20%");
        }
        else
        {
            System.out.println("This item cannot be consumed");
        }
    }
    private void tradeItem(Items item)
    {
        if (item.getActions().contains(ItemActions.TRADE))
        {
            if (game.getCurrentRoom().getNumber() == 11)
            {
                Items itemS = getItemsById(5);
                itemInventory.remove(item);
                itemInventory.add(itemS);
                System.out.println("You have added " + itemS.getName() + " to the inventory."); ;
            }
            else if (game.getCurrentRoom().getNumber() == 3)
            {
                Items items2 = getItemsById(2);
                itemInventory.add(items2);
            }
            else if (game.getCurrentRoom().getNumber() == 19)
            {
                if (sealants.size() == 3)
                {
                    for (Items i : sealants)
                    {
                        itemInventory.remove(i);
                    }
                    itemInventory.add(getItemsById(12));
                    System.out.println("You have unlocked the combine action to make Sealant of Monsters");
                }
                else
                {
                    System.out.println("You need to have all three ingredients");
                }
            }
        }
    }
    private static void combineItem(Items item)
    {
    }
        {
            System.out.println("This item cannot perform the action COMBINE");
        }
    private void openItem(Items item)
    {
        if (item.getActions().contains(ItemActions.OPEN))
        {
            if (itemHeld.getName().equalsIgnoreCase("key") || item == itemHeld)
            {
                game.openDoor();
            }
            else
            {
                System.out.println("You need to equip the key first before you can open a door");
            }
        }
        else
        {
            System.out.println("This item cannot perform the OPEN action");
        }
    }
    private void unequipItem(Items item)
    {
        if (item.getActions().contains(ItemActions.UNEQUIP))
        {
            if (itemHeld == null || itemHeld != item)
            {
                System.out.println("You need to equip an item first before unequipping it");
            }
            else
            {
                itemHeld = null;
                System.out.println(item.getName() + " Unequipped Successfully");
            }
        }
        else
        {
            System.out.println("This specific item cannot be unequipped");
        }
    }
    private void equipItem(Items item)
    {
        if (item.getActions().contains(ItemActions.EQUIP))
        {
            if (items.contains(item))
            {
                itemHeld = item;
                System.out.println(item.getName() + " has been equipped");
            }
            else
            {
                System.out.println("You need to pick up the item first or you need to specify an item to equip");
            }
        }
    }
    private void pickUpItem(Items item)
    {
        if (item.getActions().contains(ItemActions.PICKUP))
        {
            if (item.getType() == ItemType.SEALANT)
            {
                sealants.add(item);
            }
            itemInventory.remove(item);
            itemInventory.add(item);
            game.getCurrentRoom().getItems().remove(item);
            System.out.println("Item added to inventory");
        }
        else
        {
            System.out.println("You can not picked up this item");
        }
    }
    private void dropItem(Items item)
    {
        if (item.getActions().contains(ItemActions.DROP))
        {
            if (itemHeld == null || itemHeld != item)
            {
                System.out.println("You need to equip the item first before dropping it");
            }
            else
            {
                if (item.getType() == ItemType.SEALANT)
                {
                    sealants.remove(item);
                }
                game.getCurrentRoom().getItems().add(item);
                itemInventory.remove(itemHeld);
                itemHeld = null;
            }
        }
    }
    private void getCommand(Items item)
    {
        System.out.print("Enter an Item command:");
        String choice = new Scanner(System.in).nextLine();
        while (!choice.equalsIgnoreCase("C"))
        {
            viewItemCommand(choice, item);
            choice = new Scanner(System.in).nextLine();
        }
        System.out.println("----------------------------------------------------");
    }
    private String showRoomCommand(Room room, Items item)
    {
        StringBuilder s = new StringBuilder();
        for (ItemCommand command : itemCommands)
        {
            if (command.getItemId() == item.getID() && command.getRoomId() == room.getNumber())
            {
                System.out.print(command.getAction() + " ");
                s.append(command.getAction());
            }
        }
        System.out.println("\n-----------------------------------\n");
        return s.toString();
    }
    private ArrayList<Items> getRoomItems(Room room)
    {
        ArrayList<Items> items = new ArrayList<Items>();
        for (ItemCommand command : itemCommands)
        {
            if (room.getNumber() == command.getRoomId())
            {
                Items item = getItemsById(command.getItemId());
                if (!items.contains(item))
                {
                    items.add(item);
                }
            }
        }
        return items;
    }
    private void showRoomItem(ItemCommand command)
    {
        System.out.print(command.getAction() + " ");
    }
    public Items getItemsById(int ItemsID)
    {
        for (Items currentItems : items)
        {
            if (currentItems.getNumber() == ItemsID)
            {
                return currentItems;
            }
        }
        return null;
    }
    /*
     * @author of method: Ahmed Mohamed
     *
     * */
    public Room getRoomById(List<Room> rooms, int id)
    {
        for (Room currentRoom : rooms)
        {
            if (currentRoom.getNumber() == id)
            {
                return currentRoom;
            }
        }
        return null;
    }
}