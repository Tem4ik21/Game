import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.imageio.*;
import java.io.*;


public class Field extends JPanel {
    private Image shapka;
    private Image fon;
    public int x = 400;
    private int slogn;
    private Podar[] gamePodar;
    private Image endGame;
    public Timer timerUpdate;
    public Timer timerDraw;

    public Field(int slogn) {
        this.slogn = slogn;
        try {
            fon = ImageIO.read(new File("C:\\игра\\ice.jpg"));
            shapka = ImageIO.read(new File("C:\\игра\\shapka.png"));
            endGame = ImageIO.read(new File("C:\\игра\\endgame1.jpg"));
        } catch (Exception e) {
            System.out.println("Неправильный путь к картинке");
        }
        gamePodar = new Podar[3];
        for (int i = 0; i < 3; i++) {
            try {
                gamePodar[i] = new Podar(ImageIO.read(new File("C:\\игра\\ice" + i + ".jpg")));
            } catch (Exception e) {
                System.out.println("Ошибка загрузки подарков");
            }
        }
        timerUpdate = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateStart();
            }
        });
        timerUpdate.start();

        timerDraw = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timerDraw.start();

    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(fon, 0, 0, null);
        graphics.drawImage(shapka, x, 465, null);
        for (int i = 0; i < 3; i++) {
            gamePodar[i].draw(graphics);
            if (gamePodar[i].act == true) {
                if ((gamePodar[i].y + gamePodar[i].image.getHeight(null) >= 470)) {
                    if (Math.abs(gamePodar[i].x - x) > 75) {
                        graphics.drawImage(endGame, 0, 0, null);
                        timerDraw.stop();
                        timerUpdate.stop();
                        break;
                    } else {
                        gamePodar[i].act = false;
                    }
                }
            }
        }

    }

    private void updateStart() {
        int kol = 0;
        for (int i = 0; i < 7; i++) {
            if (gamePodar[i].act == false) {
                if (kol < slogn) {
                    gamePodar[i].start();
                    break;
                }
            } else {
                kol++;
            }

        }
    }
}
