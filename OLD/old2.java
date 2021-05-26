import java.util.*;

public class old2 {
    static class Customer {
        String name;
        String birthday;
        int discount;

        public Customer(String name, String birthday, int discount) {
            this.name = name;
            this.birthday = birthday;
            this.discount = discount;
        }
    }

    static class Item {
        String name;
        String manufacturer;
        int price;

        public Item(String name, String manufacturer, int price) {
            this.name = name;
            this.manufacturer = manufacturer;
            this.price = price;
        }
    }

    static class Shop {
        String name;
        String opening;
        String workhours;

        public Shop(String name, String opening, String workhours) {
            this.name = name;
            this.opening = opening;
            this.workhours = workhours;
        }
    }

    static class Purchase {
        String date;
        String customer;
        String item;
        String shop;

        public Purchase(String date, String customer, String shop, String item) {
            this.date = date;
            this.customer = customer;
            this.item = item;
            this.shop = shop;
        }
    }

    public static void solve(List<Purchase> purchases, List<Customer> customers, List<Item> items, List<Shop> shops) {
        Map<Integer, Integer> map = new HashMap<>();
        Boolean b = false;

        for (Customer cust : customers) {
            map.put(cust.discount, 0);
        }

        for (Customer cust : customers) {
            map.put(cust.discount, map.get(cust.discount) + 1);
        }

        for (Customer cust : customers) {
            b = map.get(cust.discount) >= 2;
            if (b) break;
        }

        if (b)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Item> items = new LinkedList<>();
        List<Customer> customers = new LinkedList<>();
        List<Shop> shops = new LinkedList<>();
        List<Purchase> purchases = new LinkedList<>();

        String line = "";
        while (!line.equals("$")) {
            line = sc.nextLine();
            String[] words = line.split(" ");
            if (words[0].equals("b"))
                purchases.add(new Purchase(words[1], words[2], words[3], words[4]));
            else if (words[0].equals("c"))
                customers.add(new Customer(words[1], words[2], Integer.parseInt(words[3])));
            else if (words[0].equals("i"))
                items.add(new Item(words[1], words[2], Integer.parseInt(words[3])));
            else if (words[0].equals("s"))
                shops.add(new Shop(words[1], words[2], words[3]));
            else // last line
                solve(purchases, customers, items, shops);
        }
    }
}