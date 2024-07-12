import java.util.HashMap;

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
    private HashMap<String, VendingItem> stock;
    private Item[][] slots;

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
