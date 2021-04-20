import java.util.*;
import java.util.stream.*;

public class P7 {
    static class Transaction {

        private String from;

        public String getFrom() {
            return from;
        }

        private String to;

        public String getTo() {
            return to;
        }

        String currency;

        public String getCurrency() {
            return currency;
        }

        private int amount;

        public int getAmount() {
            return amount;
        }

        public Transaction(String from, String to, String currency, int amount) {
            this.from = from;
            this.to = to;
            this.currency = currency;
            this.amount = amount;
        }
    }

    public static void print(TreeMap<String, Integer> balances) {
        for (Map.Entry<String, Integer> entry : balances.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        List<Transaction> list = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        while (!s.equals("$")) {
            String[] str = s.split(" ");
            if (str[0].equals("c")) {
                map.put(str[1], Integer.parseInt(str[2]));
            }
            if (str[0].equals("t")) {
                list.add(new Transaction(str[1], str[2], str[3], Integer.parseInt(str[4])));
            }
            s = sc.nextLine();
        }
        TreeMap<String, Integer> balances = new TreeMap<>(list.stream()
                .flatMap(t -> Stream.of(
                        new AbstractMap.SimpleEntry<String, Integer>(t.getFrom(), map.containsKey(t.getCurrency()) ? -t.getAmount() * map.get(t.getCurrency()) : 0),
                        new AbstractMap.SimpleEntry<String, Integer>(t.getTo(), map.containsKey(t.getCurrency()) ? t.getAmount() * map.get(t.getCurrency()) : 0)))
                .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey,
                        AbstractMap.SimpleEntry::getValue,
                        (a, b) -> a + b)));
        print(balances);
    }
}
