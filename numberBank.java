import java.util.*;
class numberBank {
    private ArrayList < City > cities = new ArrayList < > ();
    int amount = 75000; //default 75000
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

            directionX = random.nextInt(7) - 3;
            directionY = random.nextInt(7) - 3;
            placeHolderX += directionX;
            placeHolderY += directionY;
            if(k % 7500 == 0){
            int tempY = random.nextInt(amount);
            int tempX = random.nextInt(amount);
        cities.add(new City(x[k], y[k], 5, new cityNameGenerator().nameGetter(5)));
            }
        }
        
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

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }

}