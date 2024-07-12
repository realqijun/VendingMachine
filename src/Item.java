public class Item {
    private final String name;
    private Integer amount;

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

    public String getName() {
        return (this.name);
    }

    @Override
    public String toString() {
        if (this.amount > 0)
            return (String.format("%s, amount: %d", name, amount));
        return (String.format("%s, out of stock!", name));
    }
}
