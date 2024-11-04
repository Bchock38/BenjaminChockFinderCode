public class HashMap {
    private final int Default_Table_Size = 20;
    private int tablesize;
    private int num_keys;
    private duple[] map ;
    private final int radix = 256;

    public HashMap(){
        map = new duple[Default_Table_Size];
        num_keys =0;
        tablesize = Default_Table_Size;
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
        if (map[location] == null){
            map[location] = new duple(key, value);
        }
        else{
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
        }
    }

    public void resize(){

    }

    public duple get(String key){
        int location = hash(key);
        while (){

        }
        return null;

    }

}
