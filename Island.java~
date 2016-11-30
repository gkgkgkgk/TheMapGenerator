import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.*;
import java.awt.*;
public class Island extends JFrame {
    public int width = 1000;
    public final int height = 700;
    public int placeHolderX;
    public int placeHolderY;
    public Island() {
        setLayout(null);
        setSize(width, height);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new DrawPane());
        setResizable(false);
        validate();
    }


    class DrawPane extends JPanel {
        public void paintComponent(Graphics g) {

            super.paintComponent(g);
            Color back = new Color(28, 107, 160);
            Color land = new Color(0, 200, 0);
            setBackground(back);
            int amount = 100000;
            //array of x = x val for 1
            //array of y = y val for 1
            //this is a comment
            placeHolderX = width / 2;
            placeHolderY = height / 2;
            int[] x = new int[amount];
            int[] y = new int[amount];
            Random random = new Random();
            int directionX = 1;
            int directionY = 1;
            int padding = 50;
            //g.setColor(Color.WHITE);
            //g.fillRect(placeHolderX, placeHolderY, 5, 5);
            for (int k = 0; k < amount; k++) {
                if (placeHolderX >= width - padding || placeHolderX <= 0 + padding) {
                    placeHolderX = width / 2;
                }
                if (placeHolderY >= height - padding || placeHolderY <= 0 + padding) {
                    placeHolderX = height / 2;
                }
                x[k] = placeHolderX;
                y[k] = placeHolderY;

                directionX = random.nextInt(7) - 3;
                directionY = random.nextInt(7) - 3;
                placeHolderX += directionX;
                placeHolderY += directionY;

                g.setColor(land);

            }

            g.setColor(land);
            for (int i = 0; i < amount; i++) {
                g.setColor(getColor(x[i], y[i]));
                g.fillRect(x[i], y[i], 3, 3);
            }

        }
    }
    int modifier = 0;
    public Color getColor(int x, int y) {
        Color water = new Color(28, 107, 160);
        Color grass = new Color(44, 176, 55);
        Color plains = new Color(255, 196, 0);
        Color mountain = new Color(167, 164, 157);
        Color newColor = Color.RED;
        Random random = new Random();
        int switchInt = random.nextInt(101) + 1;
        //int modifier = random.nextInt(6);
        //5 settings: mountain, river, plains, snow, grass
        //mountains to snow to grass to rivers to plains
        if (y > height - (height/5) || y < (height/5)) {
            //northern regions- primarily snow, some mountains
            if (switchInt < 80) {
                newColor = Color.WHITE;
            } else {
                newColor = mountain;
            }
        } else if (y < height - (height/4) && y > height - (height/4) || y > (height/5) && y < (height/4)) {
            if (switchInt < 60) {
                newColor = Color.WHITE;
            } else if (switchInt >= 60 && switchInt <= 85) {
                newColor = grass;
            } else {
                newColor = mountain;
            }
        } else if (Math.abs(y - (height / 2)) <= 50) {
            //middle regions- primarily desert, some grassland
            if (switchInt < 90) {
                newColor = plains;
            } else {
                newColor = grass;
            }
        } else {
            //primarily grassland, some rivers and some plains
            if (switchInt < 50) {
                newColor = grass;
            } else {
                newColor = plains;
            } 
        }


        return newColor;
    }


    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {new Island();});
    }

}