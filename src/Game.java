import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/*
 * @author of Class: Ahmed Mohamed
 *
 * */
public class Game {

    private Room root = null;
    private PuzzleFeature puzzleFeature;
    private ItemsFeature itemsFeature;

    private Room currentRoom = null;

    private ArrayList<Room> rooms;


    /**
     * Method: getData
     * Method to load the rooms data into data structure and create the connection between all rooms.
     * Both room data and connections details should be provided separately.
     */
    /*
     * @author of method: Ahmed Mohamed
     *
     * */
    public void getData(String roomsFile, String connectionFile, String puzzleFile, String itemsFile, String itemsCommandsFile) {
        try {
            Scanner roomData = new Scanner(new File(roomsFile));
            Scanner connectionFiles = new Scanner(new File(connectionFile));
            Scanner puzzleData = new Scanner(new File(puzzleFile));

            rooms = new ArrayList<>();
            List<Puzzle> puzzles = new ArrayList<>();

            while (roomData.hasNextLine()) {
                int id = Integer.parseInt(roomData.nextLine());
                String name = roomData.nextLine();
                String description = "";

                String line = roomData.nextLine();

                while (!line.equals("----")) {
                    description += line + "\n";
                    line = roomData.nextLine();
                }
                rooms.add(new Room(id, name, description));
            }

            setMonsters();

            while (connectionFiles.hasNextLine()) {
                String[] connection = connectionFiles.nextLine().split(" ");
                int current = Integer.parseInt(connection[0]);
                int next = Integer.parseInt(connection[2]);
                String direction = connection[1];
                if (root == null)
                    root = getRoomById(rooms, current);

                getRoomById(rooms, current).setRoomAtDirection(direction, getRoomById(rooms, next));
            }


            while (puzzleData.hasNext()) {
                int roomId = Integer.parseInt(puzzleData.nextLine());
                String puzzleQue = puzzleData.nextLine();
                String puzzleAns = puzzleData.nextLine();
                String puzzleHint = puzzleData.nextLine();
                int room = Integer.parseInt(puzzleData.nextLine());
                String difficulty = puzzleData.nextLine();
                Puzzle puzzle = new Puzzle(roomId, puzzleQue, puzzleAns, puzzleHint, room, difficulty);
                puzzles.add(puzzle);
            }

            puzzleFeature = new PuzzleFeature(puzzles);
            itemsFeature = new ItemsFeature(itemsFile, itemsCommandsFile, this);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private void setMonsters()
    {
        for (Room room : rooms)
        {
            room.setHasMonster(room.getNumber() == 2 || room.getNumber() == 5 || room.getNumber() == 12 || room.getNumber() == 14 || room.getNumber() == 15 || room.getNumber() == 16 || room.getNumber() == 20);
        }
    }
    /*
     * @author of method: Ahmed Mohamed
     *
     * */
    public Room getRoomById(List<Room> rooms, int id) {
        for (Room currentRoom : rooms) {
            if (currentRoom.getNumber() == id) {
                return currentRoom;
            }
        }
        return null;
    }

    /*
     * @author of method: Nero Dunmoye and Jessie Martin
     *
     * */
    public Items getItemsById(List<Items> items, int ItemsID)
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

    public ArrayList<Room> getRooms()
    {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms)
    {
        this.rooms = rooms;
    }

    public void getItemData(String itemsFile, String itemsCommandsFile, List<Room> rooms)
    {
        try
        {
            Scanner itemData = new Scanner(new File(itemsFile));
            Scanner itemCommandsFiles = new Scanner(new File(itemsCommandsFile));


            List<Items> items = new ArrayList<>();
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
            catch (Exception e) {
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
                        description = description + " " + connection[i];
                    }

                    Room room = getRoomById(rooms, roomId);

                    if (!room.contains(getItemsById(items, id)))
                    {
                        Items item = getItemsById(items, id);
                        System.out.println(description + " " + room.getNumber() + " ");
                        room.addItem(item);
                        room.setItemActions(description, id);
                    }
                    else
                    {
                        System.out.println(description + " " + room.getNumber() + " ");
                        room.setItemActions(description, id);
                    }
                }
            }
            catch (Exception e)
            {
                System.out.println("Error in items commands file");
                System.out.println(e.getMessage());

            }
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }
    /**
     * Method: Start
     * Method to start the game. It handles all the operations and validations required in the game.
     */
    /*
     * @author of method: Ahmed Mohamed
     *
     * */
    public void play() {
        char input = 'y';
        System.out.println("Welcome to my adventure game. You will proceed through rooms based upon your entries.\n" +
                "You can navigate by using the entire direction or just the first letter.\n" +
                "To exit(X) the game, enter X\n");

//        showPuzzleOfRoom(5);
        Room current = root;
        Scanner scanner = new Scanner(System.in);
        currentRoom = current;
        System.out.println(current);
        if (!current.isHasMonster())
        {
            itemsFeature.showItemsFeature(current);
        }
        else
        {
            System.out.println("You have encountered a monster. You have to fight it to proceed.");
        }

        showPuzzleOfRoom(current.getNumber());
        current.setVisited();

        System.out.print("Where would you like to go? ");
        input = scanner.next().toLowerCase().charAt(0);
        while (input != 'x') {

            Room room = current.getRoomAtDirection(input);


            while (room == null && input != 'x') {

                System.out.println("Invalid direction entered");
                System.out.print("\nWhere would you like to go? ");
                input = scanner.next().toLowerCase().charAt(0);

                room = current.getRoomAtDirection(input);
            }
            if (room != null)
            {
                current = room;
                currentRoom = current;
                System.out.println(current);
                if (!current.isHasMonster()) {
                    itemsFeature.showItemsFeature(current);
                }
                else
                {
                    System.out.println("");
                }
                showPuzzleOfRoom(current.getNumber());

                current.setVisited();
                System.out.print("What would you like to do? ");
                input = scanner.next().toLowerCase().charAt(0);
            }
        }

        System.out.println("Exit\n" +
                "\n" +
                "\n" +
                "Thank you for playing my Game.\n");
    }

    public Room getCurrentRoom()
    {
        return currentRoom;
    }
    public void setCurrentRoom(Room currentRoom)
    {
        this.currentRoom = currentRoom;
    }
    private void showItemsOfRoom(Room room)
    {
        ArrayList<Items> items = room.getItems();

        for (Items item : items)
        {
            System.out.println(item);
            System.out.println("In this Room you can only");
            System.out.println(item.getRoomItems());
        }
    }

    void showPuzzleOfRoom(int room) {
        if (room == 5) {
            puzzleFeature.showPuzzle("Solve puzzle to kill monster");
        } else if (room == 7) {
            puzzleFeature.showPuzzle("Solve puzzle to boost health");
        } else if (room == 9) {
            puzzleFeature.showPuzzle("Solve puzzle to dodge fire trap");
        } else if (room == 11) {
            puzzleFeature.showPuzzle("Solve puzzle for dark room");
        } else if (room == 13) {
            puzzleFeature.showPuzzle("Solve puzzle for extra life");
        } else if (room == 17) {
            puzzleFeature.showPuzzle("Solve puzzle to pick up item");
        } else if (room == 18) {
            puzzleFeature.showPuzzle("Solve puzzle to dodge arrow trap");
        } else if (room == 20) {
            puzzleFeature.showPuzzle("Solve puzzle to kill final monster");
        }
    }
    public void openDoor()
    {
        if (currentRoom.getNumber() == 4)
        {
            System.out.println("You have opened the door");
            currentRoom.setHasMonster(false);
        }
    }
    public void closeDoor()
    {
        if (currentRoom.getNumber() == 4)
        {
            System.out.println("You have closed the door");
            currentRoom.setHasMonster(true);
        }
    }
}