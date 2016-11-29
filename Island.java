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
  public Island(){
    setLayout(null);
  setSize(width,height);
  setVisible(true);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setContentPane(new DrawPane());
  setResizable(false);
  validate();
  }
 
 
   class DrawPane extends JPanel{
     public void paintComponent(Graphics g){

       super.paintComponent(g);
       Color back = new Color(28,107,160);
       Color land = new Color(0,200,0);
       setBackground(back);
       int amount = 100000;
       //array of x = x val for 1
       //array of y = y val for 1
       //this is a comment
       placeHolderX = width/2;
       placeHolderY = height/2;
       int[] x = new int[amount];
       int[] y = new int[amount];
       Random random = new Random();
       int directionX = 1;
       int directionY = 1;
       int padding = 50;
         //g.setColor(Color.WHITE);
         //g.fillRect(placeHolderX, placeHolderY, 5, 5);
       for(int k = 0; k < amount; k++){
         if(placeHolderX >= width -padding|| placeHolderX <=0 + padding){
            placeHolderX = width/2;
            }
            if(placeHolderY >= height-padding || placeHolderY <=0 + padding){
            placeHolderX = width/2;
            }
         x[k] = placeHolderX;
          y[k] = placeHolderY;
          
           directionX = random.nextInt(7)-3;
           directionY = random.nextInt(7)-3;
            placeHolderX += directionX;
            placeHolderY += directionY;
            
            g.setColor(land);
           
         }
      
       g.setColor(land);
       for(int i = 0; i < amount; i++){
         /*int cityMaker = random.nextInt(100);
         if(cityMaker == 4){
         //g.setColor(Color.BLACK);
         }*/

         g.setColor(getColor());
         g.fillRect(x[i], y[i], 3,3);
       }
     
   }
     }
   int modifier = 0;
   public Color getColor(){
     Color water = new Color(28,107,160);
       Color grass = new Color(44,176,55);
       Color plains = new Color(255, 196, 0);
       Color mountain = new Color(167, 164, 157);
     Color newColor = Color.RED;
     Random random = new Random();
     int switchInt = random.nextInt(11)+1;
     //int modifier = random.nextInt(6);
     //5 settings: mountain, river, plains, snow, grass
     //mountains to snow to grass to rivers to plains
     
     switch(modifier){
       case 0:
          newColor = (mountain);
          if(switchInt < 8){
            modifier = random.nextInt(5);
          }
     break;
       case 1:
         newColor = (Color.WHITE);
         if(switchInt < 8){
            modifier = random.nextInt(5);
          }
         break;
       case 2:
         newColor = (grass);
          if(switchInt < 2){
            modifier = random.nextInt(5);
          }
         break;
       case 3:
         newColor = (water);
         if(switchInt < 5){
            modifier = random.nextInt(5);
          }
         break;
       case 4:
         newColor = (plains);
         if(switchInt < 3){
            modifier = random.nextInt(5);
          }
         break;
        
       default:
         newColor = grass;
         break;
    
     }
    
     return newColor;
   }
  
  
 public static void main(String[] args){
   javax.swing.SwingUtilities.invokeLater(() -> { new Island();});
  }
 
}