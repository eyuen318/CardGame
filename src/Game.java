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
        printInstructions();
        deck.shuffle();
        p1.addCard(deck.deal());
        p1.sum();
        dealer.addCard(deck.deal());
        dealer.sum();
        p1.addCard(deck.deal());
        p1.sum();
        dealer.addCard(deck.deal());
        dealer.sum();

        while(p1.sum() < 21){
            //print player and dealer's hands
            //dealer.printDealer();
            //scanner to ask if they wanna hit or stand
            System.out.println("Would you like to hit or stand? Type 'hit' or 'stand'.");
            String str = scan.nextLine();
            if (str.equals("hit"))
            {
                p1.addCard(deck.deal());

            } else{
                //get out of if statement
                break;
            }

        }
        while(dealer.sum() < 17)
        {
            //draws any additional cards after player stopped
            dealer.addCard(deck.deal());
        }
    }

    public void printInstructions(){
        System.out.println("instructions go here");
    }

    public void playGame(){
        //plays the game.
        //we need to decide on a game
        System.out.println("playing game");

    }

    public static void main(String[] args){
        Game game = new Game();
        game.playGame();
    }
}
