
public class Pixel {

    int x;
    int y;
    
    public Pixel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void printPoint() {
        System.out.println(x + " " + y);
    }

    public Pixel subtract(Pixel v) {
        return new Pixel(this.x - v.x, this.y - v.y);
    }

    public double calculateArea(Pixel v) {
        return this.x * v.y - this.y * v.x;
    }

    public int scalarProduct(Pixel v) {
        return this.x * v.x + this.y * v.y;
    }
}