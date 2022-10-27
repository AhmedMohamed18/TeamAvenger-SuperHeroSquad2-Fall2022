/*
 * @author of Class: Ahmed Mohamed
 *
 * */
public class TestGame {
    /*
     * @author of method: Ahmed Mohamed
     *
     * */
    public static void main(String[] args)
    {
        Game game = new Game();
        game.getData("DataFiles/rooms.txt","DataFiles/connections.txt","DataFiles/puzzle.txt");
        game.play();
    }
}
