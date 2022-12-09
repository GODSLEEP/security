package card_game;
import java.util.Scanner;

public class CardTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int win = 0;
        int lose = 0;

        while (true) {
            System.out.println("Which character you want to be?Banker/Player?(choose 1/2)");
            int num = sc.nextInt();
            if (num == 1) {
                System.out.println("You choose to be Banker");

                Ruler r = new Ruler();
                int n=r.play();
                if(n==0) {
                    //Dealer win
                    win++;
                }
                else
                    lose++;
            } else if (num == 2) {
                System.out.println("You choose to be player");
                Player p = new Player();
                int n= p.play();
                if(n==1) {
                    //Player win
                    win++;
                }
                else
                    lose++;
            } else {
                System.out.println("Error, please enter it again");
            }

            System.out.println("Continue?Y/N");
            if (sc.next().charAt(0) == 'Y')
                continue;
            else {
                System.out.println("Game over");
                System.out.println("Win:"+win);
                System.out.println("Lose:"+lose);
                break;
            }

        }

    }

}