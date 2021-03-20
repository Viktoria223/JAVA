import java.util.*;

public class Class1 {
    // Напишите функцию, которая возвращает список из длин списков
    public static List<Integer> f1(List<List<Integer>> list) {
        return new LinkedList<>();
    }

    public static void printList(List<Integer> list) {
        for (Integer el : list) {
            System.out.print(el + " ");
        }
        System.out.println();
    }

    public static void printList2(List<List<Integer>> list) {
        for (List<Integer> el : list) {
            for (Integer i : el) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static ArrayList<Integer> f2(List<List<Integer>> list) {
        ArrayList<Integer> summa = new ArrayList<>();
        for(List<Integer> i : list) {
            int k = 0;
            for (Integer j : i) {
                k += j;
            }
            summa.add(k);
        }
        return summa;
    }

    public static List<List<Integer>> f3(List<List<Integer>> list, int n) {
        List<List<Integer>> list2 = new LinkedList<>();
        int num = 0;
        for (List<Integer> i : list) {
            List<Integer> list3 = new LinkedList<>();
            for(Integer j : i) {
                list3.add(j);
            }
        }
        return list2;
    }

    public static void main(String[] args) {
        Random r = new Random();
        int n = 10;
        List<List<Integer>> outer = new LinkedList<>();
        for (int i=0; i<n; i++) {
            List<Integer> inner = new LinkedList<>();
            int k = r.nextInt(10);
            for (int j=0; j<k; j++) {
                inner.add(r.nextInt(100));
            }
            outer.add(inner);
        }

        System.out.println("List:");
        for (List<Integer> i : outer) {
            printList(i);
        }

        System.out.println("Lengths:");
        List<Integer> lens = f1(outer);
        printList(lens);

        ArrayList<Integer> result = new ArrayList<>();

        for (List<Integer> i : outer) {
            System.out.println(i.size());
        }

        List<List<Integer>> lens2 = f3(outer, 10);
        System.out.println("ghkj");
        printList2(lens2);

  //      List<Integer> els = f3(outer);
       // printList(els);

    }
}
