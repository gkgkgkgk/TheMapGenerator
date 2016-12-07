import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.*;
import java.awt.*;
import java.io.*;
import java.io.InputStream;
import java.awt.geom.Line2D;

public class Road {
 private int[] x;
 private int[] y;
 private int[] landX;
 private int[] landY;
 ArrayList < Integer > tempx = new ArrayList < Integer > ();
 ArrayList < Integer > tempy = new ArrayList < Integer > ();
 public Road(City c, City d, int landx[], int[] landy) {
  landX = landx;
  landY = landy;
  int startx = c.xGet();
  int starty = c.yGet();
  int endx = d.xGet();
  int endy = d.yGet();
  int placex = startx;
  int placey = starty;
  double distance = Math.sqrt(Math.pow((startx - endx), 2.0) + (double) Math.pow((starty - endy), 2.0));
  boolean stop = false;
  while (!stop) {
   //System.out.println("place x : " + placex + "end x : " + endx + "place y : " + placey + "end y : " + endy);
   if (placex == endx || placey == endy) {
    if (placex == endx) {
     if (Math.sqrt(Math.pow((placex - endx), 2.0) + (double) Math.pow((placey + 1 - endy), 2.0)) < distance) {
      placey += 1;
     } else if (Math.sqrt(Math.pow((placex - endx), 2.0) + (double) Math.pow((placey - 1 - endy), 2.0)) < distance) {
      placey -= 1;
     }
    }
   }
   if (placey == endy) {
    if (Math.sqrt(Math.pow((placex - 1 - endx), 2.0) + (double) Math.pow((placey - endy), 2.0)) < distance) {
     placex -= 1;
    } else if (Math.sqrt(Math.pow((placex + 1 - endx), 2.0) + (double) Math.pow((placey - endy), 2.0)) < distance) {
     placex += 1;
    }
   } else {

    if (Math.sqrt(Math.pow((placex + 1 - endx), 2.0) + (double) Math.pow((placey - 1 - endy), 2.0)) < distance 
          && Math.sqrt(Math.pow((placex + 1 - endx), 2.0) + (double) Math.pow((placey - 1 - endy), 2.0)) < Math.sqrt(Math.pow((placex - 1 - endx), 2.0) + (double) Math.pow((placey + 1 - endy), 2.0)) 
          && Math.sqrt(Math.pow((placex + 1 - endx), 2.0) + (double) Math.pow((placey - 1 - endy), 2.0)) < Math.sqrt(Math.pow((placex - 1 - endx), 2.0) + (double) Math.pow((placey - 1 - endy), 2.0)) 
          && Math.sqrt(Math.pow((placex + 1 - endx), 2.0) + (double) Math.pow((placey - 1 - endy), 2.0)) < Math.sqrt(Math.pow((placex + 1 - endx), 2.0) + (double) Math.pow((placey + 1 - endy), 2.0))) {
     placex += 1;
     placey -= 1;
    } else if (Math.sqrt(Math.pow((placex - 1 - endx), 2.0) + (double) Math.pow((placey + 1 - endy), 2.0)) < distance 
                 && Math.sqrt(Math.pow((placex - 1 - endx), 2.0) + (double) Math.pow((placey + 1 - endy), 2.0)) < Math.sqrt(Math.pow((placex + 1 - endx), 2.0) + (double) Math.pow((placey + 1 - endy), 2.0)) 
                 && Math.sqrt(Math.pow((placex - 1 - endx), 2.0) + (double) Math.pow((placey + 1 - endy), 2.0)) < Math.sqrt(Math.pow((placex - 1 - endx), 2.0) + (double) Math.pow((placey - 1 - endy), 2.0)) 
                 && Math.sqrt(Math.pow((placex - 1 - endx), 2.0) + (double) Math.pow((placey + 1 - endy), 2.0)) < Math.sqrt(Math.pow((placex + 1 - endx), 2.0) + (double) Math.pow((placey - 1 - endy), 2.0))) {
     placex -= 1;
     placey += 1;
    } else if (Math.sqrt(Math.pow((placex + 1 - endx), 2.0) + (double) Math.pow((placey + 1 - endy), 2.0)) < distance 
                 && Math.sqrt(Math.pow((placex + 1 - endx), 2.0) + (double) Math.pow((placey + 1 - endy), 2.0)) < Math.sqrt(Math.pow((placex - 1 - endx), 2.0) + (double) Math.pow((placey + 1 - endy), 2.0)) 
                 && Math.sqrt(Math.pow((placex + 1 - endx), 2.0) + (double) Math.pow((placey + 1 - endy), 2.0)) < Math.sqrt(Math.pow((placex - 1 - endx), 2.0) + (double) Math.pow((placey - 1 - endy), 2.0)) 
                 && Math.sqrt(Math.pow((placex + 1 - endx), 2.0) + (double) Math.pow((placey + 1 - endy), 2.0)) < Math.sqrt(Math.pow((placex + 1 - endx), 2.0) + (double) Math.pow((placey - 1 - endy), 2.0))) {
     placex += 1;
     placey += 1;
    } else if (Math.sqrt(Math.pow((placex - 1 - endx), 2.0) + (double) Math.pow((placey - 1 - endy), 2.0)) < distance 
                 && Math.sqrt(Math.pow((placex - 1 - endx), 2.0) + (double) Math.pow((placey - 1 - endy), 2.0)) < Math.sqrt(Math.pow((placex - 1 - endx), 2.0) + (double) Math.pow((placey + 1 - endy), 2.0)) 
                 && Math.sqrt(Math.pow((placex - 1 - endx), 2.0) + (double) Math.pow((placey - 1 - endy), 2.0)) < Math.sqrt(Math.pow((placex + 1 - endx), 2.0) + (double) Math.pow((placey + 1 - endy), 2.0)) 
                 && Math.sqrt(Math.pow((placex - 1 - endx), 2.0) + (double) Math.pow((placey - 1 - endy), 2.0)) < Math.sqrt(Math.pow((placex + 1 - endx), 2.0) + (double) Math.pow((placey - 1 - endy), 2.0))) {
     placex -= 1;
     placey -= 1;
    }
   }
   distance = Math.sqrt(Math.pow((placex - endx), 2.0) + (double) Math.pow((placey - endy), 2.0));
   tempx.add(placex);
   tempy.add(placey);
   if (placex == endx && placey == endy) {
    stop = true;
   }
  }
  x = new int[tempx.size()];
  y = new int[tempy.size()];
  for (int i = 0; i < tempx.size(); i++) {
   x[i] = tempx.get(i);
   y[i] = tempy.get(i);
  }

 }

 public int[] getX() {
  return x;
 }
 public int[] getY() {
  return y;
 }
}