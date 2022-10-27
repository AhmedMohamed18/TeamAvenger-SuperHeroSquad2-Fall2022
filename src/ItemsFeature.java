import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ItemsFeature
{
    private Room root = null;

    public void getItemData (String itemsFile, String itemsCommandsFile)
    {
        try {
            Scanner itemData = new Scanner(new File(itemsFile));
            Scanner itemCommandsFiles = new Scanner(new File(itemsCommandsFile));

            List<Room> rooms = new ArrayList<>();
            List<Items> items = new ArrayList<>();
            try{
                while (itemData.hasNextLine())
                {
                    int id = Integer.parseInt(itemData.nextLine());
                    String name = itemData.nextLine();
                    String description = itemData.nextLine();

                    String line = itemData.nextLine();

                    while (!line.equals("----"))
                    {
                        description+=line+"\n";
                        line = itemData.nextLine();
                    }
                    items.add(new Items(id,name,description));
                }
            }
            catch (Exception e)
            {
                System.out.println("Error in items file");
            }
            try{
                while(itemCommandsFiles.hasNextLine())
                {
                    String[] connection = itemCommandsFiles.nextLine().split(" ");
                    int current = Integer.parseInt(connection[0]);
                    int next = Integer.parseInt(connection[2]);
                    String direction = connection[1];
                    if(root == null)
                        root = getRoomById(rooms,current);

                    getRoomById(rooms,current).setRoomAtDirection(direction,getRoomById(rooms,next));
                }
            }
            catch (Exception e)
            {
                System.out.println("Error in items commands file");
            }
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }

    }
    public Items getItemsById(List<Items> items, int ItemsID)
    {
        for(Items currentItems : items)
        {
            if(currentItems.getNumber() == ItemsID)
            {
                return currentItems;
            }
        }
        return null;
    }    /*
     * @author of method: Ahmed Mohamed
     *
     * */
    public Room getRoomById(List<Room> rooms, int id){
        for(Room currentRoom : rooms){
            if(currentRoom.getNumber() == id){
                return currentRoom;
            }
        }
        return null;
    }}