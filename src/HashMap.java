public class HashMap {
    private final int Default_Table_Size = 20;
    private int tablesize;
    private int num_keys;
    private duple[] map;
    private final int radix = 256;

    public HashMap(int tablesize) {
        map = new duple[tablesize];
        num_keys = 0;
        this.tablesize = tablesize;
    }

    //hash key
    public int hash(String key) {
        int StrHash = 0;
        for (int i = 0; i < key.length(); i++) {
            StrHash = (radix * StrHash + key.charAt(i)) % tablesize;
        }
        return StrHash;
    }

    //insert key into hashmap
    public void insert(String key, String value) {
        boolean isInserted = false;
        //location is equal to the hash of the key
        int location = hash(key);
        //while the location spot is full go to the neighbor till the spot is empty
        while (location < map.length && !isInserted) {
            if (map[location] != null) {
                location++;
            } else {
                map[location] = new duple(key, value);
                isInserted = true;
            }
        }
        //if made it to end of array with no empty spots go back to the begining to keep looking
        if (!isInserted) {
            location = 0;
            while (!isInserted) {
                if (map[location] != null) {
                    location++;
                } else {
                    map[location] = new duple(key, value);
                    isInserted = true;
                }
            }
        }
        //add another key
        num_keys++;
        //if total keys is greatter then half of table size resize the array with double the spaces
        if (num_keys > tablesize / 2) {
            resize();
        }
    }

    //resize an array with double the spaces
    public void resize() {
        //double tablesize
        tablesize = tablesize * 2;
        //make a new hash map double the length to add new hash values to
        HashMap newMap = new HashMap(tablesize);
        for (int i = 0; i < map.length; i++) {
            if (map[i] != null) {
                newMap.insert(map[i].getKey(), map[i].getValue());
            }
        }
        //set orginal map to new map
        map = newMap.map;
    }

    //get value from corresponding key of the amp
    public String get(String key) {
        int location = hash(key);
        int orgLocation = location;

        while(location < map.length) {
            //check is location is null
            if (map[location] == null) {
                location++;
            }
            //if location key equals key were looking for return that keys value
            else if (map[location].getKey().equals(key)) {
                return map[location].getValue();
            } else {
                //otherwise go to the neighbor
                location++;
            }
        }
        //if get to end without finding key check from the beggining
        while (location != orgLocation) {
            if (location == map.length) {
                location = 0;
            } else if (map[location] != null && map[location].getKey().equals(key)) {
                return map[location].getValue();
            } else {
                location++;
            }
        }
        //if never find key return null
                return null;


        }
    }

