import java.util.*;

public class P5 {
    static class Transaction {
        private char var;

        public char getVar() {
            return var;
        }

        private String from;

        public String getFrom() {
            return from;
        }

        private String to;

        public String getTo() {
            return to;
        }

        private String currency;

        public String getCurrency() {
            return currency;
        }

        private int amount;

        public int getAmount() {
            return amount;
        }

        public Transaction(char var, String from, String to, String currency, int amount) {
            this.var = var;
            this.from = from;
            this.to = to;
            this.currency = currency;
            this.amount = amount;
        }
    }

    static class Price {
        private char var;

        public char getVar() {
            return var;
        }

        private String currency;

        public String getCurrency() {
            return currency;
        }

        private int price;

        public int getPrice() {
            return price;
        }

        public Price(char var, String currency, int price) {
            this.var = var;
            this.currency = currency;
            this.price = price;
        }
    }

    public static Map<String, Map<String, Integer>> computeBalancesCur(List<Transaction> transactions) {
        HashMap<String, Map<String, Integer>> hm = new HashMap<>();
        for (Transaction txn : transactions) {
            String cur = txn.getCurrency();
            String f = txn.getFrom();
            if (!hm.containsKey(f)) {
                hm.put(f, new HashMap<>());
            }
            Map<String, Integer> famt = hm.get(f);
            if (!famt.containsKey(cur)) {
                famt.put(cur, 0);
            }
            famt.put(cur, famt.get(cur) - txn.getAmount());
            hm.put(f, famt);

            String t = txn.getTo();
            if (!hm.containsKey(t)) {
                hm.put(t, new HashMap<>());
            }
            Map<String, Integer> tamt = hm.get(t);
            if (!tamt.containsKey(cur)) {
                tamt.put(cur, 0);
            }
            tamt.put(cur, tamt.get(cur) + txn.getAmount());
            hm.put(t, tamt);
        }
        return hm;
    }

    public static Map<String, Integer> computeBalance(List<Transaction> txns, List<Price> price) {
        Map<String, Integer> map = new TreeMap<>();
        Map<String, Map<String, Integer>> bals = computeBalancesCur((List<Transaction>) txns);
        for (Map.Entry<String, Map<String, Integer>> entry : bals.entrySet()) {
            map.put(entry.getKey(), 0);
            Map<String, Integer> amts = entry.getValue();
            for (Map.Entry<String, Integer> amt : amts.entrySet()) {
                for (Price pr : price) {
                    if (amt.getKey().equals(pr.getCurrency())) {
                        map.put(entry.getKey(), map.get(entry.getKey()) + (amt.getValue() * pr.getPrice()));
                    }
                }
            }
        }
        return map;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Transaction> txns = new LinkedList<>();
        List<Price> price = new LinkedList<>();
        String enter = sc.nextLine();
        char p = enter.charAt(0);
        while (p != '$') {
            String[] words = enter.split(" ");
            String[] mas = new String[5];
            for (int i = 0; i < 5; i++) {
                mas[i] = String.valueOf(0);
            }
            for (int i = 0; i < words.length; i++) {
                mas[i] = words[i];
            }
            /*for (int i = 0; i < words.length; i++) {
                mas[i] = words[i];
            }*/
            if (p == 'c') {
                int i = Integer.parseInt(mas[2]);
                price.add(new Price(p, mas[1], i));
            }
            if (p == 't') {
                int i = Integer.parseInt(mas[4]);
                txns.add(new Transaction(p, mas[1], mas[2], mas[3], i));
            }
            enter = sc.nextLine();
            p = enter.charAt(0);
        }

        Map<String, Integer> map = new TreeMap<>(computeBalance(txns, price));
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ' ' + entry.getValue());
        }
    }
}
