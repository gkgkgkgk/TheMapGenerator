import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.*;
import java.awt.*;
import java.io.*;
import java.io.InputStream;
import java.awt.geom.Line2D;
import java.awt.event.ActionListener;
public class Island extends JFrame implements ActionListener, MouseListener,  MouseMotionListener {
    public int placeHolderX;
    public int placeHolderY;
    numberBank bank = new numberBank();
    public int width = bank.getWidth();
    public final int height = bank.getHeight();
    public int x[] = bank.getX();
    public int y[] = bank.getY();
    public ArrayList < City > cities = bank.getCities();
    public ArrayList < Road > roads = bank.getRoads();
    public ArrayList <Rectangle> rectangles  = bank.getRect();

    Font font;
    Color roadColor = new Color(120,80,60);
    public Island() {
        setContentPane(new DrawPane());
        addMouseListener(this);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        validate();
        setVisible(true);
        setSize(width, height);
    }

    public void actionPerformed(ActionEvent event){
    
    }
    
    public void mouseDragged(MouseEvent evt)
    {}

    public void mouseMoved(MouseEvent evt){}

    public void mouseEntered(MouseEvent evt){}
    public void mouseExited(MouseEvent evt){}
    public void mousePressed(MouseEvent evt){}
    public void mouseReleased(MouseEvent evt){}

public void mouseClicked(MouseEvent e){
  System.out.println(rectangles.get(1));
  System.out.println(e.getPoint());
    if (rectangles.get(1).contains(e.getPoint())) {
System.out.print(cities.get(1));
    }
}
    public void drawCity(City c, Graphics g, int x, int y) {
        g.setColor(Color.BLACK);
        makeFonts();
        g.setFont(font);
       
        g.fillRect(x, y, c.sGetter(), c.sGetter());
        g.drawString(c.nGetter(), x, y - 3);
    }
 public void drawRoad(Road road, Graphics g) {
        g.setColor(roadColor);
        int[] x = road.getX();
        int[] y = road.getY();
        for(int i = 0; i <  x.length; i ++){
        g.fillRect(x[i], y[i], 2,2);
        }
    }
    class DrawPane extends JPanel {
        public void paintComponent(Graphics g) {
            System.out.println("paintComponent Ran");
            super.paintComponent(g);
            Color back = new Color(28, 107, 160);
            Color land = new Color(0, 200, 0);
            setBackground(back);
            int amount = bank.getAmount();
            for (int i = 0; i < amount; i++) {
                g.setColor(getColor(x[i], y[i]));
                g.fillRect(x[i], y[i], 3, 3);
            }
          for(Road r:roads){
          drawRoad(r, g);
          }
            Random rand = new Random();
            for (City c: cities) {
                int tempX = c.xGet();
                int tempY = c.yGet();
                //System.out.println("City Made! " + tempX + "  " +tempY + " " + c.nGetter() );
                drawCity(c, g, tempX, tempY);
            }
            //System.out.println("Size: " + cities.size());
        }
    }
    int modifier = 0;
    public void makeFonts() {
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("Mermaid.ttf"))).deriveFont(Font.PLAIN, 17);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
    
    int regulator = 1;
    Random randomNumber = new Random();
    public Color getColor(int x, int y) {
        Color water = new Color(10, 60, 160);
        Color grass = new Color(44, 176, 55);
        Color plains = new Color(255, 196, 0);
        Color mountain = new Color(167, 164, 157);
        Color mountain2 = new Color(107, 104, 107);
        Color newColor = Color.RED;
        Random random = new Random();
        int switchInt = random.nextInt(101) + 1;
        if(regulator <= 15){
          int randMountain = random.nextInt(2);
          if(randMountain == 1){
            newColor = mountain;}
          else{
            newColor =mountain2;
          }
        regulator = randomNumber.nextInt(17);
        }
        else{
        regulator = randomNumber.nextInt(10000);
        //int modifier = random.nextInt(6);
        //5 settings: mountain, river, plains, snow, grass
        //mountains to snow to grass to rivers to plains
        if (y > height - (height / 5) || y < (height / 5)) {
            //northern regions- primarily snow, some mountains
            if (switchInt < 80) {
                newColor = Color.WHITE;
            } else {
                newColor = mountain;
            }
        } else if (y < height - (height / 5) && y > height - (height / 4) || y > (height / 5) && y < (height / 4)) {
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
        } else {
            //primarily grassland, some rivers and some plains
            if (switchInt < 50) {
                newColor = grass;
            } else {
                newColor = plains;
            }
        }
        }

        return newColor;
    }


    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() ->{new Island();});
    }

}