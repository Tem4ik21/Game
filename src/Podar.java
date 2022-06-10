import javax.swing.*;//для работы с окнами
import java.awt.*;//для работы с графикой
import java.awt.event.*;//для обработки событий

public class Podar {
    public Image image;
    public int x;
    public int y;
    public boolean act;
    private Timer timerUpdate;

    public Podar(Image image) {
        timerUpdate = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vniz();
            }
        });
        this.image = image;
        act = false;
    }

    public void start() {
        timerUpdate.start();
        y = 0;
        x = (int) (Math.random() * 700);
        act = true;

    }

    public void vniz() {
        if (act == true) {
            y = y + 21;
        }
        if ((y + image.getHeight(null)) >= 470) {
            timerUpdate.stop();
        }
    }

    public void draw(Graphics graphics) {
        if (act == true) {
            graphics.drawImage(image, x, y, null);
        }
    }
}
