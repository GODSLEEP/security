package card_game;

import java.util.Random;
import java.util.Scanner;

public class Player {
    Scanner sc= new Scanner(System.in);


    public int play() {
        int playernum=0;
        int rulernum=0;
        String player1;
        String player2;

        String ruler1;
        String ruler2;


        JudgeNum judge = new JudgeNum();
        Card c = new Card();
        c.cutcards();
        player1 = c.deal();
        player2 = c.deal();

        System.out.println("Deal cards time:");
        System.out.println("Player Cards:" + player1 + " " + player2);
        playernum=judge.judgeString(player1)+judge.judgeString(player2);



        ruler1 = c.deal();
        ruler2 = c.deal();
        System.out.println("Banker Cards:" + ruler1 + " " + ruler2);
        rulernum=judge.judgeString(ruler1)+judge.judgeString(ruler2);
        System.out.println("Player points："+playernum);

        System.out.println("Banker points:"+rulernum);


        System.out.println("Player twist time： " );



//        Hit stage
        while(true) {
            System.out.println("Player twist?(Y/N)? " );

            char w = sc.next().charAt(0);
            if(w=='Y') {
                System.out.println("Player twist");
                String player3=c.deal();
                System.out.println("Player:"+player3 );

                playernum=playernum+judge.judgeString(player3);
                System.out.println("Player points："+playernum);
                if(playernum>21)
                {
                    System.out.println("player bust, Banker wins");
                    return 0;
                }

            }
            else if(w=='N') {
                System.out.println("Player doesn't hit，Player points:"+playernum);
                break;
            }



        }



        System.out.println("Banker hit time");

        while(true) {
            if(rulernum>=playernum) {
                System.out.println("Banker doesn't hit，Banker wins");
                return 0;
            }
            else {
                System.out.println("Banker hit time:");
                String ruler3=c.deal();
                System.out.println("Banker:"+ruler3);
                rulernum=rulernum+judge.judgeString(ruler3);
                if(rulernum>21) {
                    System.out.println("Banker points"+rulernum);
                    System.out.println("Banker bust，Player wins");
                    return 1;
                }
                else if(rulernum>=playernum) {

                    System.out.println("Banker points"+rulernum+" Player points:"+playernum);
                    System.out.println("Banker wins");
                    return 0;
                }

            }

        }

    }

}
