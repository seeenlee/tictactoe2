import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class TicMain extends JComponent implements Runnable{
    private TicMain game;
    private Board board;
    private boolean playerNumber1;
    public final static int FRAMESIZE = 900;
    private Image o;

    public TicMain() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                board.clicked(playerNumber1, calculateBox(e.getY()), calculateBox(e.getY()));
            }
        });
    }

    private int calculateBox(int input) {
        if (input < FRAMESIZE / 3) {
            return 0;
        } else if (input < FRAMESIZE * 2 / 3) {
            return 1;
        } else {
            return 2;
        }
    }

    public static void main (String[] args) {
        SwingUtilities.invokeLater(new TicMain());
    }

    public void run() {
        JFrame frame = new JFrame("tictactoe");
        frame.add(new TicMain());
        frame.setPreferredSize(new Dimension(FRAMESIZE,FRAMESIZE));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g) {
        setUpImages();
    }

    private void setUpImages() {
        if (o == null) {
            try {
                o = ImageIO.read(new File("o.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}