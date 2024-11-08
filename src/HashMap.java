public class HashMap {
    private final int Default_Table_Size = 20;
    private int tablesize;
    private int num_keys;
    private duple[] map ;
    private final int radix = 256;

    public HashMap(int tablesize){
        map = new duple[tablesize];
        num_keys =0;
        this.tablesize = tablesize;
    }

    public int hash(String key){
        int StrHash = 0;
        for (int i = 0; i < key.length(); i++){
            StrHash = (radix * StrHash + key.charAt(i)) % tablesize;
        }
        return StrHash;
    }

    public void insert(String key, String value){
        boolean isInserted = false;
        int location = hash(key);
        while (location < map.length && !isInserted){
            if (map[location] !=null){
                location++;
            }
            else{
                map[location] = new duple(key,value);
                isInserted = true;
            }
        }
        if (!isInserted){
            location = 0;
            while (!isInserted){
                if (map[location] !=null){
                    location++;
                }
                else{
                    map[location] = new duple(key,value);
                    isInserted = true;
                }
            }
        }
        num_keys++;
        if (num_keys > tablesize/2){
            resize();
        }
    }

    public void resize(){
        tablesize = tablesize*2;
        HashMap newMap = new HashMap(tablesize);
        for (int i =0; i < map.length; i++){
            if (map[i] != null){
                newMap.insert(map[i].getKey(),map[i].getValue());
            }
        }
        map = newMap.map;
    }

    public String get(String key){
        int location = hash(key);
        int orgLocation = location;
        if (map[location] == null){
            location++;
        }
        else if (map[location].getKey().equals(key)){
            return map[location].getValue();
        }
        else{
            location++;
                while (location != orgLocation){
                    if (location == map.length){
                        location = 0;
                    }
                    else if (map[location] != null && map[location].getKey().equals(key)){
                        return map[location].getValue();
                    }
                    else{
                        location++;
                    }
                }
            }
        return null;

    }

}
