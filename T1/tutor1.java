import com.sun.jdi.IntegerValue;

import java.util.*;

public class tutor1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*Map<String, String> map = new TreeMap<>();
        for (int i = 0; i < 3; i++) {
            String name = sc.nextLine();
            String product = sc.nextLine();
            map.put(name, product);
        }*/
        /*Map<String, Map<String, Integer>> map = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            String name = sc.nextLine();
            String product = sc.nextLine();
            int f = Integer.parseInt(sc.nextLine());
            Map<String, Integer> map1 = new HashMap<>();
            map1.put(product, f);
            map.put(name, map1);
        }*/
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i, i);
        }
        for (int i = 0; i < map.size(); i++) {
            
        }
        //System.out.print(map);
    }
}
