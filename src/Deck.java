import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
public class Deck {
    private ArrayList<Card> cards;
    private int cardsLeft;
    public Deck(String[] ranks, String[] suits, int[] values, Image[] cardImages) {
        cards = new ArrayList<Card>();
        for (int i = 0; i < suits.length; i++)
        {
            for(int j = 0; j < ranks.length; j++)
            {
                Card c = new Card(ranks[j], suits[i], values[j], cardImages[j + (13*i)], new ImageIcon("Resources/backOfCard.png").getImage());
                cards.add(c);
            }
        }
        this.cardsLeft = cards.size();
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
    public int getCardsLeft() {
        return cardsLeft;
    }

    public Card deal(){
        if(cardsLeft==0){
            shuffle();
        }
        cardsLeft--;
        return cards.get(cardsLeft);
    }

    public void shuffle(){
        for (int i = 0; i < cards.size(); i++)
        {
            int rand = (int)(Math.random() * cards.size());
            Card temp = cards.get(i);
            cards.set(i, cards.get(rand));
            cards.set(rand, temp);
        }
        cardsLeft = cards.size();
    }

}
