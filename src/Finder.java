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

    public Finder() {}

    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        // TODO: Complete the buildTable() function!
        int currentHash;
        String[] splitString;
        hashMap = new ArrayList<ArrayList>();
        while (br.readLine() != null){
            splitString = br.readLine().split(",");
            currentHash = hash(splitString[keyCol], splitString[keyCol].length());
            if (hashMap.get(currentHash) == null){
                hashMap.add(currentHash, new ArrayList<duple>());
            }
            hashMap.get(currentHash).add(new duple(splitString[keyCol], splitString[valCol]));
        }
        br.close();
    }

    public String query(String key){
        // TODO: Complete the query() function!
        int keyHash = hash(key, key.length());
        for (int i = 0; i < hashMap.get(keyHash).size();i++){

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