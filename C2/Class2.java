import java.util.*;
import java.util.LinkedList;

public class Class2 {
    // Дан список, состоящий из упорядоченных по возрастанию списков
    // Вернуть результат их слияния
    public static List<Integer> f1(List<List<Integer>> list) {
        return new LinkedList<>();
    }

    public static void printList(List<Integer> list) {
        for (Integer el : list) {
            System.out.print(el + " ");
        }
        System.out.println();
    }

    public static LinkedList<Integer> mergeList(List<List<Integer>> list) {
        LinkedList<Integer> list1 = new LinkedList<>();
        for (List<Integer> i : list) {
            list1.addAll(i);
        }

        return list1;
    }

    public static void main(String [] args) {
        Random r = new Random();
        int n = r.nextInt(10);
        List<List<Integer>> outer = new LinkedList<>();
        for (int i=0; i<n; i++) {
            List<Integer> inner = new LinkedList<>();
            int k = r.nextInt(10);
            int p = r.nextInt(10);
            for (int j=0; j<k; j++) {
                inner.add(p);
                p = p + r.nextInt(10);
            }
            outer.add(inner);
        }

        System.out.println("List:");
        for (List<Integer> i : outer) {
            printList(i);
        }

        System.out.println("Joined:");
        List<Integer> joined = f1(outer);
        printList(joined);

        System.out.println("ghj");

        System.out.print(mergeList(outer));
    }
}
