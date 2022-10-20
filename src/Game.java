import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


/*
 * @author of Class: Ahmed Mohamed
 *
 * */
public class Game {

    private Room root = null;

    /**
     * Method: getData
     * Method to load the rooms data into data structure and create the connection between all rooms.
     * Both room data and connections details should be provided separately.
     */
    /*
     * @author of method: Ahmed Mohamed
     *
     * */
    public void getData (String roomsFile, String connectionFile)
    {
        try {
            Scanner roomData = new Scanner(new File(roomsFile));
            Scanner connectionFiles = new Scanner(new File(connectionFile));

            List<Room> rooms = new ArrayList<>();

            while (roomData.hasNextLine())
            {
                int id = Integer.parseInt(roomData.nextLine());
                String name = roomData.nextLine();
                String description = "";

                String line = roomData.nextLine();

                while (!line.equals("----"))
                {
                    description+=line+"\n";
                    line = roomData.nextLine();
                }
                rooms.add(new Room(id,name,description));
            }

            while(connectionFiles.hasNextLine())
            {
                String[] connection = connectionFiles.nextLine().split(" ");
                int current = Integer.parseInt(connection[0]);
                int next = Integer.parseInt(connection[2]);
                String direction = connection[1];
                if(root == null)
                    root = getRoomById(rooms,current);

                getRoomById(rooms,current).setRoomAtDirection(direction,getRoomById(rooms,next));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
            /*
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
    }
    /**
     * Method: Start
     * Method to start the game. It handles all the operations and validations required in the game.
     */
    /*
     * @author of method: Ahmed Mohamed
     *
     * */
    public void play()
    {
        char input = 'y';
        System.out.println("Welcome to my adventure game. You will proceed through rooms based upon your entries.\n" +
                "You can navigate by using the entire direction or just the first letter.\n"  +
                "To exit(X) the game, enter X\n");


        Room current = root;
        Scanner scanner = new Scanner(System.in);
        System.out.println(current);
        current.isVisited();
        System.out.print("What would you like to do? ");
        input = scanner.next().toLowerCase().charAt(0);
        while(input != 'x')
        {

            Room room = current.getRoomAtDirection(input);

            while(room==null && input != 'x')
            {
                System.out.println("Invalid direction entered");
                System.out.print("\nWhat would you like to do? ");
                input = scanner.next().toLowerCase().charAt(0);

                room = current.getRoomAtDirection(input);

            }
            if(room!=null)
            {
                current = room;
                System.out.println(current);
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





}
