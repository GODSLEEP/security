package lab;


import java.util.Random;
import java.util.Scanner;

public class Guess {
    public static void main(String[] args) {
        introduction();
        summary();
    }
    //    This is the introduction of the game.
    public static void introduction(){
        System.out.println("This program is going to play a game with you.");
        System.out.println("I'm going to produce a random number to make you guess.");
        System.out.println("According to your answer, I will give some hint until you give me an right answer.");
        System.out.println("The number is between 0-100.");
        System.out.println("Let's go");
    }

    //    This is the main code of the game.
    public static int game() {
        Scanner sc = new Scanner(System.in);
//            produce the random number
        Random r = new Random();
        int guessing_Times = 1;
        while(true) {
            int right_answer = r.nextInt(101); //create a random number from 0 - 100.
            System.out.println("Please enter your guessing number:");
//            Start the while loop until user guess the right number.
            while (true) {
                int input = sc.nextInt();
                if (input == right_answer) {
                    System.out.println("You are right!");
                    if (guessing_Times == 1) {
                        System.out.println("You got it right in 1 guess");
                    }
                    break;
                }
                else if (input < right_answer) {
                    System.out.println("The right answer is bigger.");
                }
                else {
                    System.out.println("The right answer is smaller.");
                }
                guessing_Times++;
            }
            System.out.println("You got it right in " + guessing_Times + " guesses");
            break;
        }
        return guessing_Times;
    }

    //    summarize
    public static void summary(){
        int round = 1;
        int sum[] = new int[99999]; //I need to find a way to identify the length of the array, but I don't know how.
        Scanner sc = new Scanner(System.in);
//        This loop is going to put each round of the guessing time in to the array.
        while (true){
            sum[round - 1] = game();
            System.out.println("Do you want to play again?");
            String opinion = sc.next();
            if (!opinion.equals("y")){
                break;
            }
            round++;
        }
//        This part is going to find out the minimum number of the guessing time in the array.
        int min = sum[0];
        for (int i = 1; i < sum[99999]; i++) {  /*I don't know how to limit the length of the array,
                                                This is a wrong data which makes the final answer "min" = 0;*/
            if (sum[i] < min){
                min = sum[i];
            }
        }
//        This part is going to calculate the sum of the all elements in the array.
        for (int i = 0; i < sum.length - 1; i++) {
            sum[i + 1] += sum[i];
        }
        double ratio = sum[round - 1] / round;
        System.out.println("Over all result:");
        System.out.println("Total guess = " + sum[round - 1]);
        System.out.println("Total game = " + round);
        System.out.println("guesses/game = " + ratio);
        System.out.println("Best game = " + min);
    }
}
