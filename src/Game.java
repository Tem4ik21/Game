import javax.swing.*;

public class Game {
    public static void main(String[] args) {
        String rez = JOptionPane.showInputDialog(null, "Введите сложность игры от 1 до 7:", "Сложность игры", 1);
        int slogh = rez.charAt(0) - '0';
        if ((slogh >= 1) && (slogh <= 7)) {
            Window window = new Window(slogh);
        } else {
            System.out.println("Ошибка ввода");
        }
    }
}
