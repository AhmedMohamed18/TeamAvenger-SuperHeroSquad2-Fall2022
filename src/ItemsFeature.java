import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ItemsFeature {

    private ArrayList<Items> items;

    public ItemsFeature() throws FileNotFoundException {
        items = new ArrayList<Items>();
        readItems("items.txt");
    }

    public void readItems(String itemFile) throws FileNotFoundException {
        FileReader fileReader;
        try {
            fileReader = new FileReader(itemFile);
            Scanner input = new Scanner(fileReader);

            input.nextLine();

            while (input.hasNextLine()) {
                String[] tokens = input.nextLine().trim().split("~");
                ArrayList<String> itemsList = new ArrayList<String>(Arrays.asList(tokens[4].trim().split(",")));

                if (itemsList.get(0).equals("0")) {
                    itemsList.clear();
                }

                String[] roomTokens = tokens[6].trim().split(",");


                items.add(new Room(tokens[0], Boolean.parseBoolean(tokens[1]), tokens[2], tokens[3], itemsList, tokens[5],

                        roomTokens[0], roomTokens[1], roomTokens[2], roomTokens[3]));

            }


            input.close();

            fileReader.close();


        } catch (IOException e) {

            throw new FileNotFoundException("Map file not found.");

        }
    }
}