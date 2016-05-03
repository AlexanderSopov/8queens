
public class Queen {
    public int x, y;
    public Queen(int x, int y){
        this.x=x;this.y=y;
    }

    public boolean equals(Queen q) {
        return x==q.x && y == q.y;
    }

    @Override
    public String toString() {
        return "(" +x+ ", " +y+")";
    }
}