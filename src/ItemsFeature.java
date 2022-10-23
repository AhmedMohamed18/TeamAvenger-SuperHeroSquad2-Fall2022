import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ItemsFeature
{
    String[] add;
    private ArrayList<Items> items;

    public ItemsFeature() throws FileNotFoundException
    {
        items = new ArrayList<Items>();
        readItems("items.txt");
    }

    public void readItems(String itemFile) throws FileNotFoundException
    {
        FileReader fileReader;
        try {
            fileReader = new FileReader(itemFile);
            Scanner input = new Scanner(fileReader);

            input.nextLine();

            while (input.hasNextLine()) {
                String[] add = input.nextLine().trim().split("~");
                ArrayList<String> itemsList = new ArrayList<String>(Arrays.asList(add[4].trim().split(",")));

                if (itemsList.get(0).equals("0")) {
                    itemsList.clear();
                }

                String[] roomAdd = add[12].trim().split(",");

                items.add(new Room(add[1], Boolean.parseBoolean(add[1]), add[2], add[3], items, add[5],add[6]));
                roomAdd[0], roomAdd[1], roomAdd[2], roomAdd[3], roomAdd[4], roomAdd[5], roomAdd[6], roomAdd[7], roomAdd[8], roomAdd[9], roomAdd[10], roomAdd[11], roomAdd[12]));
            }
            input.close();
            fileReader.close();
        }
        catch (IOException e)
        {
            throw new FileNotFoundException("file not found.");
        }
    }
}