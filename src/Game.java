import java.util.ArrayList;
import java.util.Scanner;
public class Game {
    Scanner scan = new Scanner(System.in);
    Deck deck;
    Player dealer;
    Player p1;
    public Game(){
        String[] ranks = {
                "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"
        };
        int[] values = {
                 1 ,  2 ,  3 ,  4 ,  5 ,  6 ,  7 ,  8 ,  9 ,  10 , 10 , 10 , 10
        };
        String[] suits = {
                "Hearts", "Spades", "Clubs", "Diamonds"
        };
        deck = new Deck(ranks, suits, values);
        dealer = new Player("dealer");
        p1 = new Player("p1");


    }

    public void printInstructions(){
        System.out.println("instructions go here");
    }

    public void playGame(){
        //plays the game.
        //we need to decide on a game
        printInstructions();
        deck.shuffle();

        p1.addCard(deck.deal());
        dealer.addCard(deck.deal());
        p1.addCard(deck.deal());
        dealer.addCard(deck.deal());

        System.out.println(p1);
        System.out.println(dealer);

        while(p1.sum() < 21){//game loop
            //print player and dealer's hands
            //dealer.printDealer();
            //scanner to ask if they wanna hit or stand
            System.out.println("Would you like to hit or stand? Type 'hit' or 'stand'.");
            String str = scan.nextLine();
            if (str.equals("hit"))
            {
                p1.addCard(deck.deal());
                System.out.println(p1);


            } else{
                //get out of if statement
                break;
            }

            //make dealer draw a card
        }
        while(dealer.sum() < 17)
        {
            //draws any additional cards after player stopped
            dealer.addCard(deck.deal());
            System.out.println(dealer);
        }

        //check card values and see who wins
        //check ties
        if (dealer.sum() == p1.sum())
        {
            System.out.println("Tie.");
        }
        else if (dealer.sum() > 21) {
            if (p1.sum() > 21) {
                System.out.println("Dealer and player went over 21. Tie.");
            }
            else if (p1.sum() == 21){
                System.out.println("Player got a BlackJack. Player wins.");
            } else {
                System.out.println("Dealer went over 21. Player wins.");
            }
        } else if (dealer.sum() == 21)
        {
            System.out.println("Dealer got a BlackJack. Dealer wins.");
        } else {
            if (p1.sum() > 21)
            {
                System.out.println("Dealer wins.");
            } else if (p1.sum() == 21)
            {
                System.out.println("Player got a BlackJack. Player wins.");
            } else {
                if (dealer.sum() > p1.sum())
                {
                    System.out.println("Dealer wins.");
                } else {
                    System.out.println("Player wins.");
                }
            }

        }

        //both under 21
        //  check which is bigger, that one wins
        //only one at 21, that person wins
        //only one over 21, other person wins
        //both are 21, tie
        //both are over 21, tie
        // if p1 == dealer
        //      tie
        // else if p1 > 21 and dealer > 21
        //      tie
        // else if p1 < 21 and dealer < 21
        //      if p1 > dealer
        //          p1 win
        //      else
        //          dealer win
        // else if p1 == 21
        //      p1 win
        // else if dealer == 21
        //      dealer win
        // else if p1 > 21
        //      dealer win
        // else //dealer > 21
        //      p1 win
    }

    public static void main(String[] args){
        Game game = new Game();
        game.playGame();
    }
}
