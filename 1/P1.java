import java.util.Scanner;
import java.util.ArrayList;

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        int y = 1;
        int j = 2;
        while (y != n) {
            j++;
            boolean f = true;
            for (Integer i : list) {
                if (j % i == 0) {
                    f = false;
                }
            }
            if (f) {
                list.add(j);
                y++;
            }
        }
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }
}

