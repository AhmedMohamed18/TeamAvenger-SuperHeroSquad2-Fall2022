import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


/*
 * @author of Class: Ahmed Mohamed
 *
 * */
public class Game {

    private Room root = null;
    private PuzzleFeature puzzleFeature;
    /**
     * Method: getData
     * Method to load the rooms data into data structure and create the connection between all rooms.
     * Both room data and connections details should be provided separately.
     */
    /*
     * @author of method: Ahmed Mohamed
     *
     * */
    public void getData (String roomsFile, String connectionFile, String puzzleFile)
    {
        try {
            Scanner roomData = new Scanner(new File(roomsFile));
            Scanner connectionFiles = new Scanner(new File(connectionFile));
            Scanner puzzleData = new Scanner(new File(puzzleFile));

            List<Room> rooms = new ArrayList<>();
            List<Puzzle> puzzles = new ArrayList<>();

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

            puzzleFeature=new PuzzleFeature(puzzles);

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

//        showPuzzleOfRoom(5);
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
                showPuzzleOfRoom(current.getNumber());
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

    void showPuzzleOfRoom(int room){
        if(room==5){
            puzzleFeature.showPuzzle("Solve puzzle to kill monster");
        } else if (room==7) {
            puzzleFeature.showPuzzle("Solve puzzle to boost health");
        } else if (room==9) {
            puzzleFeature.showPuzzle("Solve puzzle to dodge fire trap");
        } else if (room==11) {
            puzzleFeature.showPuzzle("Solve puzzle for dark room");
        } else if (room==13) {
            puzzleFeature.showPuzzle("Solve puzzle for extra life");
        } else if (room==17) {
            puzzleFeature.showPuzzle("Solve puzzle to pick up item");
        } else if (room==18) {
            puzzleFeature.showPuzzle("Solve puzzle to dodge arrow trap");
        } else if (room==20) {
            puzzleFeature.showPuzzle("Solve puzzle to kill final monster");
        }
    }



}

