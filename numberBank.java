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
class numberBank {
    private ArrayList < City > cities = new ArrayList < > ();
    private ArrayList < Road > roads = new ArrayList < > ();
        public ArrayList <Rectangle> rectangles  = new ArrayList<Rectangle>();
    int amount = 500000;
    int[] x = new int[amount];
    int[] y = new int[amount];
    int width = 1000;
    int height = 700;
    int placeHolderX = width / 2;
    int placeHolderY = height / 2;
    int padding = 50;
    int directionX = 0;
    int directionY = 0;
    Random random = new Random();
    public numberBank() {
        for (int k = 0; k < amount; k++) {
            if (placeHolderX >= (width - padding) || placeHolderX <= padding) {
                placeHolderX = width / 2;
            }
            if (placeHolderY >= (height - padding) || placeHolderY <= padding) {
                placeHolderY = height / 2;
            }
            x[k] = placeHolderX;
            y[k] = placeHolderY;

            /*directionX = random.nextInt(7) - 3;
            directionY = random.nextInt(7) - 3;
            */
            directionX = random.nextInt(3) - 1;
            directionY = random.nextInt(3) - 1;
            
            placeHolderX += directionX;
            placeHolderY += directionY;
            if(k % (amount/10) == 0){
            int tempY = random.nextInt(amount);
            int tempX = random.nextInt(amount);
            cities.add(new City(x[k], y[k], 5, new cityNameGenerator().nameGetter(5)));
            rectangles.add(new Rectangle(x[k], y[k],5, 5));
            }
        }
        
        roads.add(new Road(cities.get(0), cities.get(0), x, y));
        roads.add(new Road(cities.get(3), cities.get(2), x, y));
        roads.add(new Road(cities.get(5), cities.get(4), x, y));
    }

    public int getAmount() {
        return amount;
    }

    public int[] getX() {
        return x;
    }
    public int[] getY() {
        return y;
    }

    public ArrayList < City > getCities() {
        return cities;
    }
public ArrayList < Road > getRoads() {
        return roads;
    }
public ArrayList < Rectangle > getRect() {
        return rectangles;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
  
}