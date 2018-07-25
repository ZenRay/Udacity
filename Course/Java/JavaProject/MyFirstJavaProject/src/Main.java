import javafx.geometry.Pos;

/**
 * Created at 2018/7/23
 */
public class Main {
    public static void main(String [] args){
         class Position {
            static int row = 0;
            static int column = 0;

            //constructor
            Position(int row, int column) {
                this.row = row;
                this.column = column;
            }
        }

        Position test = new Position(1, 2);
        int l;
        l = Position.row;
        System.out.println("hello world!");
        System.out.println(test.column);
        System.out.println(l);
    }
}
