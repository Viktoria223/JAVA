import java.util.*;

public class P5 {
    static class Transaction {
        private String var;
        public String getTime() { return var; }
        private String from;
        public String getFrom() { return from; }
        private String to;
        public String getTo() { return to; }
        private String currency;
        public String getCurrency() { return currency; }
        private int amount;
        public int getAmount() { return amount; }
        public Transaction(String var, String from, String to, String currency, int amount) {
            this.var = var;
            this.from = from;
            this.to = to;
            this.currency = currency;
            this.amount = amount;
        }
    }
    static class Price {
        private String var;
        public String getTime() { return var; }
        private String currency;
        public String getCurrency() { return currency; }
        private int price;
        public int getPrice() { return price; }
        public Price(String var, String currency, int price) {
            this.var = var;
            this.currency = currency;
            this.price = price;
        }
    }
    public static void printPositive(Map<String,Integer> balances) {
        for (Map.Entry<String,Integer> entry : balances.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
    public static Map<String,Map<String,Integer>> computeBalancesCur(List<Transaction> transactions) {
        HashMap<String,Map<String,Integer>> hm = new HashMap<>();
        for (Transaction txn : transactions) {
            String cur = txn.getCurrency();
            String f = txn.getFrom();
            if (!hm.containsKey(f)) {
                hm.put(f, new HashMap<>());
            }
            Map<String,Integer> famt = hm.get(f);
            if (!famt.containsKey(cur)) {
                famt.put(cur, 0);
            }
            famt.put(cur, famt.get(cur) - txn.getAmount());
            hm.put(f,famt);

            String t = txn.getTo();
            if (!hm.containsKey(t)) {
                hm.put(t, new HashMap<>());
            }
            Map<String,Integer> tamt = hm.get(t);
            if (!tamt.containsKey(cur)) {
                tamt.put(cur,0);
            }
            tamt.put(cur, tamt.get(cur) + txn.getAmount());
            hm.put(t,tamt);
        }
        return hm;
    }
    public static Map<String, Integer> computeBalance(List<Transaction> txns, List<Price> price) {
        Map<String, Integer> map = new HashMap<>();
        Map<String,Map<String,Integer>> bals = computeBalancesCur((List<Transaction>) txns);
        for (Map.Entry<String,Map<String,Integer>> entry : bals.entrySet()) {
            map.put(entry.getKey(), 0);
            Map<String,Integer> amts = entry.getValue();
            for (Map.Entry<String,Integer> amt : amts.entrySet()) {
                System.out.print(amt.getKey() + " " + amt.getValue() + "; ");
                for (Price pr : price) {
                    if (amt.getKey() == pr.getCurrency()) {
                        map.put(entry.getKey(), map.get(entry.getKey()) + (amt.getValue() * pr.getPrice()));
                    }
                }

            }
            System.out.println();
        }
        return map;
    }
    public static void main(String[] args) {
        List<Transaction> txns = new LinkedList<Transaction>();
        List<Price> price = new LinkedList<>();
        txns.add(new Transaction("t", "Alice","Bob",   "USD",  10));
        txns.add(new Transaction("t", "Bob","Charlie", "USD",   5));
        txns.add(new Transaction("t","Dave","Alice","EUR",   5));
        txns.add(new Transaction("t","Bob","Alice","EUR",   5));
        txns.add(new Transaction("t","Dave","Bob","EUR",   5));
        txns.add(new Transaction("t","Charlie","Eve","USD",   5));
        txns.add(new Transaction("t","Dave","Eve",   "WTF", 10000));
        price.add(new Price("c", "USD", 75));
        price.add(new Price("c", "EUR", 100));
        System.out.println("Посчитать баланс с валютами");
        Map<String,Map<String,Integer>> bals = computeBalancesCur(txns);
        for (Map.Entry<String,Map<String,Integer>> entry : bals.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            Map<String,Integer> amts = entry.getValue();
            for (Map.Entry<String,Integer> amt : amts.entrySet()) {
                System.out.print(amt.getKey() + " " + amt.getValue() + "; ");
            }
            System.out.println();
        }

        Map<String, Integer> result = computeBalance(txns, price);
        System.out.println(result);
    }
}


/*
// 1
        System.out.println(computeBalance(txns, "Bob"));
                // 2
                Map<String,Integer> balances = computeBalances(txns);
        for (Map.Entry<String,Integer> entry : balances.entrySet()) {
        System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        // 3
        System.out.println("Who increased balance:");
        printPositive(balances);
        // 4
        System.out.println("Посчитать баланс с валютами");
        Map<String,Map<String,Integer>> bals = computeBalancesCur(txns);
        for (Map.Entry<String,Map<String,Integer>> entry : bals.entrySet()) {
        System.out.print(entry.getKey() + ": ");
        Map<String,Integer> amts = entry.getValue();
        for (Map.Entry<String,Integer> amt : amts.entrySet()) {
        System.out.print(amt.getKey() + " " + amt.getValue() + "; ");
        }
        System.out.println();
        }
        // 5
        System.out.println("Какие валюты встречаются?");
        Set<String> currencies = computeCurrencies(txns);
        for (String cur : currencies) {
        System.out.println(cur);
        }*/