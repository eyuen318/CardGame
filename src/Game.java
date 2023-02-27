import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.*;
public class Game {
    Scanner scan = new Scanner(System.in);
    Deck deck;
    Player dealer;
    Player p1;

    private CardGameViewer window;

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


        Image[] cardImages = {
                new ImageIcon("Resources/ace_of_hearts.png").getImage(),
                new ImageIcon("Resources/2_of_hearts.png").getImage(),
                new ImageIcon("Resources/3_of_hearts.png").getImage(),
                new ImageIcon("Resources/4_of_hearts.png").getImage(),
                new ImageIcon("Resources/5_of_hearts.png").getImage(),
                new ImageIcon("Resources/6_of_hearts.png").getImage(),
                new ImageIcon("Resources/7_of_hearts.png").getImage(),
                new ImageIcon("Resources/8_of_hearts.png").getImage(),
                new ImageIcon("Resources/9_of_hearts.png").getImage(),
                new ImageIcon("Resources/10_of_hearts.png").getImage(),
                new ImageIcon("Resources/jack_of_hearts2.png").getImage(),
                new ImageIcon("Resources/queen_of_hearts2.png").getImage(),
                new ImageIcon("Resources/king_of_hearts2.png").getImage(),

                new ImageIcon("Resources/ace_of_spades2.png").getImage(),
                new ImageIcon("Resources/2_of_spades.png").getImage(),
                new ImageIcon("Resources/3_of_spades.png").getImage(),
                new ImageIcon("Resources/4_of_spades.png").getImage(),
                new ImageIcon("Resources/5_of_spades.png").getImage(),
                new ImageIcon("Resources/6_of_spades.png").getImage(),
                new ImageIcon("Resources/7_of_spades.png").getImage(),
                new ImageIcon("Resources/8_of_spades.png").getImage(),
                new ImageIcon("Resources/9_of_spades.png").getImage(),
                new ImageIcon("Resources/10_of_spades.png").getImage(),
                new ImageIcon("Resources/jack_of_spades2.png").getImage(),
                new ImageIcon("Resources/queen_of_spades2.png").getImage(),
                new ImageIcon("Resources/king_of_spades2.png").getImage(),

                new ImageIcon("Resources/ace_of_clubs.png").getImage(),
                new ImageIcon("Resources/2_of_clubs.png").getImage(),
                new ImageIcon("Resources/3_of_clubs.png").getImage(),
                new ImageIcon("Resources/4_of_clubs.png").getImage(),
                new ImageIcon("Resources/5_of_clubs.png").getImage(),
                new ImageIcon("Resources/6_of_clubs.png").getImage(),
                new ImageIcon("Resources/7_of_clubs.png").getImage(),
                new ImageIcon("Resources/8_of_clubs.png").getImage(),
                new ImageIcon("Resources/9_of_clubs.png").getImage(),
                new ImageIcon("Resources/10_of_clubs.png").getImage(),
                new ImageIcon("Resources/jack_of_clubs2.png").getImage(),
                new ImageIcon("Resources/queen_of_clubs2.png").getImage(),
                new ImageIcon("Resources/king_of_clubs2.png").getImage(),

                new ImageIcon("Resources/ace_of_diamonds.png").getImage(),
                new ImageIcon("Resources/2_of_diamonds.png").getImage(),
                new ImageIcon("Resources/3_of_diamonds.png").getImage(),
                new ImageIcon("Resources/4_of_diamonds.png").getImage(),
                new ImageIcon("Resources/5_of_diamonds.png").getImage(),
                new ImageIcon("Resources/6_of_diamonds.png").getImage(),
                new ImageIcon("Resources/7_of_diamonds.png").getImage(),
                new ImageIcon("Resources/8_of_diamonds.png").getImage(),
                new ImageIcon("Resources/9_of_diamonds.png").getImage(),
                new ImageIcon("Resources/10_of_diamonds.png").getImage(),
                new ImageIcon("Resources/jack_of_diamonds2.png").getImage(),
                new ImageIcon("Resources/queen_of_diamonds2.png").getImage(),
                new ImageIcon("Resources/king_of_diamonds2.png").getImage()
        };
        deck = new Deck(ranks, suits, values, cardImages);
        dealer = new Player("Dealer");
        p1 = new Player("Player 1");
        window = new CardGameViewer(dealer, p1, this);


    }

    public void printInstructions(){
        System.out.println("Welcome to Ethan's Black Jack! The rules are pretty much like Black Jack with the" +
                "exception of anything I may have forgot about. After each hand, click the re-run button to play"  +
                "again. You are 'Player 1' and you are playing against the dealer. ");
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
            //scanner to ask if they wanna hit or stand
            System.out.println("Would you like to hit or stand? Type 'hit' or 'stand'.");
            String str = scan.nextLine();
            if (str.equals("hit"))
            {
                p1.addCard(deck.deal());
                System.out.println(p1);
                this.window.repaint(); //this calls paint() again
            } else{
                //get out of if statement
                break;
            }
            //md

        }
        while(dealer.sum() < 17)
        {
            //draws any additional cards after player stopped
            dealer.addCard(deck.deal());
            System.out.println(dealer);
        }


        //check ties
        if (dealer.sum() == p1.sum())
        {
            System.out.println("Dealer and player hand equal each other. Tie.");
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
            if (p1.sum() > 21) {
                System.out.println("Player went over 21. Dealer wins.");
            } else if (p1.sum() == 21) {
                System.out.println("Player got a BlackJack. Player wins.");
            } else {
                if (dealer.sum() > p1.sum()) {
                    System.out.println("Dealer had higher value hand. Dealer wins.");
                } else {
                    System.out.println("Player had higher value hand. Player wins.");
                }
            }

        }
    }

    public static void main(String[] args){
        Game game = new Game();
        game.playGame();
    }
}
