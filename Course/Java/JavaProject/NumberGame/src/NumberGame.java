/**
 * Date:2018/8/20
 * Project: Guess the number
 */

// load the scanner
import java.util.Scanner;

public class NumberGame {

    public static void main(String [] args) {
        int randomNumer = (int) (Math.random() * 100) + 1;
        boolean haswin = false;

        System.out.println("I have randomly choose a number between 1 and 100.");
        System.out.println("Try to guess the number");

        // Scanner instance
        Scanner scanner = new Scanner(System.in);

        // loop the guess
        for (int i=0; i<10; i++){
            System.out.println("You have "+i+" guess(es). Continue!");
            int guess = scanner.nextInt();

            if(randomNumer < guess){
                System.out.println("Number is smaller than " + guess);
            }else if(randomNumer > guess){
                System.out.println("Number is greater than " + guess);
            }else{
                haswin = true;
                break;
            }
        }

        // print the result
        if (haswin){
            System.out.println("Correct... You win");
        } else {
            System.out.println("Game over... You lose!!");
            System.out.print("The number is : " + randomNumer);
        }
    }
}
