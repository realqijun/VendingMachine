import javax.swing.*;

public class Main {
    public static void main(String[] args) {
//        JFrame frame = new JFrame();
//        JLabel label = new JLabel();
//        JPanel panel = new JPanel();
//        JButton button = new JButton();
        VendingMachine cocaCola = new VendingMachine("cocaCola");
        cocaCola.addStock(new Item("cocaCola", 10));
        cocaCola.display();
    }
}