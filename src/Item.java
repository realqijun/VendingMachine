public class Item {
    private final String name;
    private Integer amount;
    private double price = 999999;

    public Item(String name, Integer amount) {
        this.name = name;
        this.amount = amount;
    }

    public boolean decreaseItem(Integer amount) {
        if (this.amount - amount >= 0) {
            this.amount -= amount;
            return (true);
        }
        return (false);
    }

    public boolean increaseItem(Integer amount) {
        if (this.amount + amount < this.amount) {
            return (false);
        }
        this.amount += amount;
        return (true);
    }

    public Integer getAmount() {
        return (this.amount);
    }

    public boolean setPrice(double price) {
        if (price < 0) {
            System.out.println("Invalid price");
            return (false);
        } else {
            this.price = price;
            return (true);
        }
    }

    public double getPrice() {
        return (this.price);
    }

    public String getName() {
        return (this.name);
    }

    @Override
    public String toString() {
        if (this.amount > 0)
            return (String.format("%s, $%.2f", this.name, this.price));
        return (String.format("%s, out of stock!", name));
    }
}
