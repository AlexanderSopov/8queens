import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] arg) {

        Scanner sc = new Scanner(System.in);
        int i = 0;
        List<Queen> queens = new LinkedList<Queen>();

        while (sc.hasNext() && i<7) {
            //System.err.println("i: " + i);
            //Solution Code goes here:
            String s = sc.next();
            for (int j = 0; j< s.length(); j++)
                if (s.charAt(j) == '*' ){
                    Queen queen = new Queen(i,j);
                    queens.add(queen);
                }
            i++;
        }
        if (isValid(queens))
            System.out.println("valid");
        else
            System.out.println("invalid");
    }

    private static boolean isValid(List<Queen> queens) {

        //System.err.println("Queens in set:");
        //for (Queen queen: queens)
        //System.err.print(queen.toString());

        for (Queen queen: queens){
            int x = queen.x;
            int y = queen.y;
            if (verticalConflict(x,y,queens))
                return false;
            if (horizontalConflict(x, y, queens))
                return false;
            if (diagonalConflict(x,y,queens))
                return false;
        }
        return true;

    }

    public static boolean verticalConflict(int x, int y, List<Queen> queens) {
       /*System.err.println("\n\nVertical Conflict Test: (" +x+", " +y+")");
       //System.err.println("Queens in set:");
        for (Queen queen: queens)
           System.err.print(queen.toString());*/
        for (int i = 0; i<8; i++)
            if (i!=y){
                Queen queenMoved = new Queen(x, i);
                //System.err.println("tempQueen: " + queenMoved.toString());
                for (Queen queen: queens)
                    if(queenMoved.equals(queen))
                        return true;
            }
        return false;
    }
    public static boolean horizontalConflict(int x, int y, List<Queen> queens) {
       //System.err.println("\n\nHorizontal Conflict Test: (" +x+", " +y+")");
       //System.err.println("Queens in set:");
        //for (Queen queen: queens)
           //System.err.print(queen.toString());
        for (int i = 0; i<8; i++)
            if (i!=x){
                Queen queenMoved = new Queen(i, y);
                //System.err.println("tempQueen: " + queenMoved.toString());
                for (Queen queen: queens)
                    if(queenMoved.equals(queen))
                        return true;
            }
        return false;
    }

    public static boolean diagonalConflict(int x, int y, List<Queen> queens) {
        System.err.println("\n\nDiagonal Conflict Test: (" +x+", " +y+")");
        System.err.println("Queens in set:");
        for (Queen queen: queens)
           System.err.print(queen.toString());


        int x1 = x;
        int y1 = y;

        while (x1 != 0 && y1 != 0){
            x1--;y1--;
        }
        System.err.println("orgPos:("+x+", "+y+")");
        while ( x1 < 8 && y1 < 8) {
            if (x1 != x && y1 != y) {
                Queen queenMoved = new Queen(x1, y1);
                System.err.println("tempQueen: " + queenMoved.toString());
                for (Queen queen: queens)
                    if(queenMoved.equals(queen))
                        return true;
            }
            x1++;
            y1++;
        }

        x1 = x;
        y1 = y;

        while (x1 < 8 && y1 != 0){
            x1++;
            y1--;
        }

        System.err.println("orgPos:("+x+", "+y+")");
        while ( x1 != 0 && y1 < 8) {
            if (x1 != x && y1 != y) {
                Queen queenMoved = new Queen(x1, y1);
                System.err.println("tempQueen: " + queenMoved.toString());
                for (Queen queen: queens)
                    if(queenMoved.equals(queen))
                        return true;
            }
            x1--;
            y1++;
        }

        return false;
    }
}