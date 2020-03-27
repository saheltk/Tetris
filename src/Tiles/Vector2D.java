package Tiles;

public class Vector2D {
    private int x,y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Vector2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void addX(Vector2D vector){
        x+=vector.getX();
    }
    public void addY(Vector2D vector){
        y+=vector.getY();
    }
    public void add(Vector2D vector){
        addX(vector);
        addY(vector);
    }
}
