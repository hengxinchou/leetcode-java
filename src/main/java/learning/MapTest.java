package learning;

import java.util.Map;
import java.util.HashMap;

public class MapTest {
    
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>(){{
            put(1, 1);
            put(2, 3);
        }};
        for(Map.Entry<Integer, Integer> entry: map.entrySet() ){
            System.out.printf("key is %d,  value %d\n", entry.getKey(), entry.getValue());
        }

        System.out.println( "Hello World!" );
    }
}


