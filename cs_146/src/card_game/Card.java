package card_game;

import java.util.Random;

public class Card {

    int index = 0; //index
    String[] card = { "Ace of Hearts", "Two of Hearts", "Three of Hearts", "Four of Hearts", "Five of Hearts", "Six of Hearts", "Seven of Hearts", "Eight of Hearts", "Nine of Hearts", "Ten of Hearts", "Jack of Hearts", "Queen of Hearts", "King of Hearts",
            "Ace of Spades", "Two of Spades", "Three of Spades", "Four of Spades", "Five of Spades", "Six of Spades", "Seven of Spades", "Eight of Spades", "Nine of Spades", "Ten of Spades", "Jack of Spades", "Queen of Spades", "King of Spades",
            "Ace of Clubs", "2 of Clubs", "3 of Clubs", "4 of Clubs", "5 of Clubs", "6 of Clubs", "7 of Clubs", "8 of Clubs", "9 of Clubs", "10 of Clubs", "J of Clubs", "Q of Clubs", "K of Clubs",
            " Square A", "Square 2", "Square 3", "Square 4", "Square 5", "Square 6", "Square 7", "Square 8", "Square 9", "Square 10", "Square J", "Square Q", "Square K",};

    public void show() {
        for (int i = 0; i < 52; i++) {
            System.out.println(card[i]);
        }

    }

    // wash cards
    public void cutcards() {
        int index=0;
        Random rand = new Random();
        for (int i = 0; i < 52; i++) {
            int n = rand.nextInt(52);
            String temp;
            temp = card[n];
            card[n] = card[51 - n];
            card[51 - n] = temp;
        }

    }
//    send cards

    public String deal() {
        String c = card[index];
        index++;
        return c;
    }

}