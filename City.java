class City {
    private int size;
    private String name;
    private int x = 0;
    private int y = 0;
    private City cityOne;
    private City cityTwo;
    public City(int xPos, int yPos, int aS, String aN){
        size = aS;
        name = aN;
        x = xPos;
        y = yPos;
    }
    public int sGetter() {
        return size;
    }
    public int xGet() {
        return x;
    }
    public int yGet() {
        return y;
    }

    public String nGetter() {
        return name;
    }
    
}