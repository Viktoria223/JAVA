import java.util.*;

public class P4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> treeMap = new TreeMap<>();
        int n = sc.nextInt();
        int count = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (treeMap.containsKey(x)) {
                treeMap.put(x, treeMap.get(x)+1);
            } else {
                treeMap.put(x, 1);
            }
        }
        for (Map.Entry<Integer, Integer> i : treeMap.entrySet()) {
            if (i.getValue() > count) {
                count = i.getValue();
                result = i.getKey();
            }
            if (i.getValue() == count) {
                if (i.getKey() < result) {
                    result = i.getKey();
                }
            }
        }
        System.out.print(result);
    }
}