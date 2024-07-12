import java.util.HashMap;
import java.util.Map;

public class VendingMachine {

    private static class VendingItem {
        int row;
        int col;
        Item item;
        VendingItem(int row, int col, Item item) {
            this.row = row;
            this.col = col;
            this.item = item;
        }
    }

    private final String name;
    private final int length = 7;
    private final int width = 5;
    private Map<String, VendingItem> stock;
    private Item[][] slots;
    private static double balance = 0;
    private static double earnings = 0;

    public VendingMachine(String name) {
        this.name = name;
        this.slots = new Item[length][width];
        this.stock = new HashMap<>();
    }

    public boolean addStock(Item item) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (slots[i][j] == null) {
                    slots[i][j] = item;
                    stock.put(item.getName(), new VendingItem(i, j, item));
                    return (true);
                }
            }
        }
        return (false);
    }

    public boolean setPrice(Item item, double price) {
        VendingItem product = this.stock.get(item.getName());
        return (product.item.setPrice(price));
    }

    public boolean insertCash(double amount) {
        if (amount < 0) {
            System.out.println("Invalid insert amount");
            return (false);
        } else {
            balance += amount;
            return (true);
        }
    }

    private int[] convertInput(String input) {
        if (input.length() != 2) {
            System.out.println("Wrong input format");
            return (null);
        } else if (Character.isAlphabetic(input.charAt(0)) || Character.isDigit(input.charAt(1))) {
            System.out.println("Input location does not exist");
            return (null);
        } else {
            int y = (int)input.charAt(0) - 64;
            int x = (int)input.charAt(1) - 48;
            if (y < 0 || y > length || x < 0 || x > width) {
                System.out.println("Input location does not exist");
                return (null);
            }
            return new int[]{x, y};
        }
    }

    public boolean purchaseItem(String input, int quantity) {
        int[] query = convertInput(input);
        if (query == null)
            return (false);
        Item item = this.slots[query[1]][query[0]];
        if (item == null) {
            System.out.println("Item not in stock");
            return (false);
        }
        double sum = item.getPrice() * quantity;
        if (sum <= balance) {
            balance -= sum;
            earnings += sum;
            item.decreaseItem(quantity);
            return (true);
        } else {
            System.out.printf("Insufficient amount, please insert %.2f%n", sum - balance);
            return (false);
        }
    }

    public void display() {
        System.out.printf("%s: %n", toString());
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (slots[i][j] == null)
                    System.out.print("empty");
                else
                    System.out.print(slots[i][j].toString());
                if (j < width - 1)
                    System.out.print(", ");
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return (String.format("%s vending machine", name));
    }
}
