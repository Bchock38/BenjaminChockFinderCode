import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Finder
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: Benjamin Chock
 **/

public class Finder {


    private final int Default_Table_Size = 50000;

    private static final String INVALID = "INVALID KEY";

    private HashMap map;

    public Finder() {}

    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        // TODO: Complete the buildTable() function!

        String[] splitString;
        String readLine = br.readLine();
        map = new HashMap(Default_Table_Size);
        //while there are more keys to add to hash add them
        while (readLine != null) {
                splitString = readLine.split(",");
                map.insert(splitString[keyCol], splitString[valCol]);
                readLine = br.readLine();
        }
        br.close();
    }

    public String query(String key){
        // TODO: Complete the query() function!
        //if key has a matching value in map return it otherwise return false
        if (map.get(key) != null){
            return map.get(key);
        }
        return INVALID;
    }

}