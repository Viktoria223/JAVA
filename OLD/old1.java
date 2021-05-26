import java.util.*;

public class old1 {
    static class Customer {
        String name;
        String birthday;
        int discount;

        public Customer(String name, String birthday, int discount) {
            this.name = name;
            this.birthday = birthday;
            this.discount = discount;
        }

        String getBirthday() { return birthday; }

        String getName() {
            return name;
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

        String getOpening() {
            return opening;
        }

        String getName() {
            return name;
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

        String getDate() {
            return date;
        }

        String getItem() { return item; }

        String getShop() {
            return shop;
        }

        String getCustomer() {
            return customer;
        }
    }

    public static void solve(List<Purchase> purchases, HashMap<String, Customer> customers) {
        LinkedList<Purchase> answer = new LinkedList<>();
        String min = customers.get(purchases.get(0).getCustomer()).getBirthday();
        for (Purchase purchase : purchases) {
            if (customers.get(purchase.getCustomer()).getBirthday().compareTo(min) < 0) {
                min = customers.get(purchase.getCustomer()).getBirthday();
                answer.clear();
            }
            if (customers.get(purchase.getCustomer()).getBirthday().equals(min)) {
                answer.add(purchase);
            }
        }
        print(answer);
    }

    public static void print(LinkedList<Purchase> purchases) {
        for (Purchase purchase : purchases) {
            System.out.println("b " + purchase.getDate() + " " + purchase.getCustomer() + " " + purchase.getShop() + " " + purchase.getItem());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Item> items = new LinkedList<>();
        HashMap<String, Customer> customers = new HashMap<>();
        HashMap<String, Shop> shops = new HashMap<>();
        List<Purchase> purchases = new LinkedList<>();
        String[] words = sc.nextLine().split(" ");

        while (!words[0].equals("$")) {
            if (words[0].equals("b"))
                purchases.add(new Purchase(words[1], words[2], words[3], words[4]));
            else if (words[0].equals("c"))
                customers.put(words[1], new Customer(words[1], words[2], Integer.parseInt(words[3])));
            else if (words[0].equals("i"))
                items.add(new Item(words[1], words[2], Integer.parseInt(words[3])));
            else if (words[0].equals("s"))
                shops.put(words[1], new Shop(words[1], words[2], words[3]));
            words = sc.nextLine().split(" ");
        }
        solve(purchases, customers);
    }
}