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

    private static final int radix = 256;

    private static final int p = 10007;

    private static final String INVALID = "INVALID KEY";

    private static ArrayList<ArrayList> hashMap;

    private HashMap map;

    public Finder() {}

    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        // TODO: Complete the buildTable() function!
        int currentHash;
        String[] splitString;
        map = new HashMap();
        hashMap = new ArrayList<ArrayList>();
        while (br.readLine() != null){
            splitString = br.readLine().split(",");
            map.insert(splitString[keyCol],splitString[valCol]);
        }
        br.close();
    }

    public String query(String key){
        // TODO: Complete the query() function!

        if (map.get(key) != null){
            return map.get(key);
        }
        return INVALID;
    }

    private static int hash(String STR, int patLen){
        int StrHash = 0;
        for (int i = 0; i < patLen; i++){
            StrHash = (radix * StrHash + STR.charAt(i)) % p;
        }
        return StrHash;
    }

    public void hashMap(){

    }
}