import java.util.*;

public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> spare = new ArrayList<>();
        int r = 0;
        int t = 0;
        boolean begin = false;
        boolean begin2 = false;
        String per = sc.nextLine();
        list.add(per);
        while (!per.equals("FINISH")) {
            list.add(per);
            per = sc.nextLine();
        }
        for (int i = 0; i < list.size(); i++) {
            boolean isTrue = false;
            if (list.get(i).equals("BEGIN")) {
                r++;
                begin = true;
            }
            if (list.get(i).equals("END")) {
                t++;
                isTrue = true;
            }
            if (r > 3 && begin2) {
                if (isTrue) {
                    result.clear();
                    result.addAll(spare);
                    spare.add(list.get(i));
                } else {
                    if (t > 0) {
                        spare.add(list.get(i));
                    } else {
                        result.add(list.get(i));
                        spare.add(list.get(i));
                    }
                }
            }
            if (begin) {
                begin2 = true;
            }
            r++;
        }
        for (int i = result.size() - 1; i >= 0; i--) {
            System.out.println(result.get(i));
        }
    }
}
