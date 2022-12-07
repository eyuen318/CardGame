import java.util.ArrayList;
import java.util.Collections;
public class Deck {
    private ArrayList<Card> cards;
    private int cardsLeft;
    public Deck(String[] ranks, String[] suits, int[] values) {
        cards = new ArrayList<Card>();
        for (int i = 0; i < suits.length; i++)
        {
            for(int j = 0; j < ranks.length; j++)
            {
                Card c = new Card(ranks[j], suits[i], values[j]);
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
            //Collections.swap(cards, i, (int)Math.random() * cards.size());
            Card temp = cards.get(i);
            int rand = (int)Math.random() * cards.size();
            cards.set(i, cards.get(rand));
            cards.set(rand, temp);
        }
        cardsLeft = cards.size();
    }

    public void printDeck() {
        System.out.println(cards);
    }
}
