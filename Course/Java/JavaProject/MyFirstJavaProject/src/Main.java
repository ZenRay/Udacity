import javafx.geometry.Pos;

/**
 * Created at 2018/7/23
 */
public class Main {
    public static void main(String [] args){
         class Position {
            int row = 0;
            int column = 0;

            //constructor
            Position(int row, int column) {
                this.row = row;
                this.column = column;
            }
        }

        Position test = new Position(1, 2);
        System.out.println("hello world!");
        System.out.println(test.column);

    }
}
