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

        if (n == 1) {
            System.out.println(j);
        } else {
            if (n == 2) {
                list.add(3);
                for (Integer i : list) {
                    System.out.print(i + " ");
                }
            } else {
                list.add(3);
                y++;
                j = 3;
                while (y != n) {
                    j += 2;
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
    }
}

