package card_game;

import java.util.Scanner;

public class Ruler {
    Scanner sc = new Scanner(System.in);

    public int play() {
        int playernum = 0;
        int rulernum = 0;
        String player1;
        String player2;

        String ruler1;
        String ruler2;

        JudgeNum judge = new JudgeNum();
        Card c = new Card();
        c.cutcards();
        player1 = c.deal();
        player2 = c.deal();

        System.out.println("Deal card time:");
        System.out.println("Player:" + player1 + " " + player2);
        playernum = judge.judgeString(player1) + judge.judgeString(player2);

        ruler1 = c.deal();
        ruler2 = c.deal();
        System.out.println("Banker:" + ruler1 + " " + ruler2);
        rulernum = judge.judgeString(ruler1) + judge.judgeString(ruler2);
        System.out.println("Player points：" + playernum);

        System.out.println("Banker points：" + rulernum);

        System.out.println("Player hit time:");

        while (true) {
            String player3;
            if (playernum <rulernum) {
                System.out.println("Player hit");
                player3 = c.deal();
                System.out.println("Player:" + player3);
                playernum = playernum + judge.judgeString(player3);
            } else if (playernum > 21) {
                System.out.println("Player points：" + playernum);

                System.out.println("Player burst，Banker wins");
                return 0;

            } else if (playernum >= 15) {
                System.out.println("Player doesn't hit");
                System.out.println("Player points:" + playernum);
                break;

            }else {

                System.out.println("Player hit");
                String player4 = c.deal();
                System.out.println("Player:" + player4);

                playernum=playernum+judge.judgeString(player4);


                if (playernum > 21) {
                    System.out.println("Player points:" + playernum);

                    System.out.println("Player Burst，Banker wins");
                    return 0;
                }

            }
        }


        // Banker hit time
        System.out.println("Banker hit time：");

        while (true) {
            System.out.println("Does banker hit?(Y/N)");
            char w = sc.next().charAt(0);
            if (w == 'Y') {
                System.out.println("Banker keep hitting");
                String ruler3 = c.deal();
                System.out.println("Banker: " + ruler3);

                rulernum = rulernum + judge.judgeString(ruler3);
                System.out.println("Banker points：" + rulernum);
                if (rulernum > 21) {
                    System.out.println("Banker burst，Player wins");
                    return 1;
                }

            } else if (w == 'N') {
                System.out.println("Banker doesn't hit，Banker points:" + rulernum);
                break;
            }

        }

        if (rulernum >= playernum) {
            System.out.println("Banker wins");
            return 0;
        } else {

            System.out.println("Player wins");

            return 1;
        }


    }

}

