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
        dealer = new Player("Dealer");
        p1 = new Player("Player 1");


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
