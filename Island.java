import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.*;
import java.awt.*;
public class Island extends JFrame {
    public int placeHolderX;
    public int placeHolderY;
    numberBank bank = new numberBank();
    public int width = bank.getWidth();
    public final int height = bank.getHeight();
    public int x[] = bank.getX();
    public int y[] = bank.getY();
    public ArrayList<City> cities = bank.getCities();
    public Island() {
              setContentPane(new DrawPane());
        setLayout(null);
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        validate();
                setVisible(true);
    }
    
    
    public void drawCity(City c, Graphics g, int x, int y) {
      g.setColor(Color.BLACK);
      g.setFont(new Font("TimesRoman", Font.BOLD, 17));
      g.fillRect(x,y,c.sGetter(),c.sGetter());
      g.drawString(c.nGetter(), x,y-3);
    }
    
    class DrawPane extends JPanel {
        public void paintComponent(Graphics g) {
          //System.out.println("paintComponent Ran");
           super.paintComponent(g);
            Color back = new Color(28, 107, 160);
            Color land = new Color(0, 200, 0);
            setBackground(back);
           int amount = bank.getAmount();
            for (int i = 0; i < amount; i++) {
                g.setColor(getColor(x[i], y[i]));
                g.fillRect(x[i], y[i], 3, 3);
            }
            Random rand = new Random();
             for (City c : cities) {
               int tempX =c.xGet();
               int tempY = c.yGet();
               //System.out.println("City Made! " + tempX + "  " +tempY + " " + c.nGetter() );
               drawCity(c, g, tempX, tempY);
          }
         //System.out.println("Size: " + cities.size());

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
        } else if (y < height - (height/5) && y > height - (height/4) || y > (height/5) && y < (height/4)) {
            if (switchInt < 50) {
                newColor = Color.WHITE;
            } else if (switchInt >= 50 && switchInt <= 90) {
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
        } 
        
        else {
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