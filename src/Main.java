public class Main {
    public static void main(String[] args) {
        VendingMachine cocaCola = new VendingMachine("cocaCola");
        cocaCola.addStock(new Item("cocaCola", 10));
        cocaCola.display();
    }
}