import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand = new ArrayList<Card>();
    private int points;
    private String name;


    public Player(String playerName)
    {
        name = playerName;
        points = 0;
    }
    public Player(String playerName, ArrayList<Card> playerHand)
    {
        name = playerName;
        hand = playerHand;
        points = 0;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public int sum()
    {
        boolean aceExists = false;
        int sum = 0;
        for(int i = 0; i < hand.size(); i++) {
            if (hand.get(i).getPoint() == 1)
            {
                aceExists = true;
            }
            sum += hand.get(i).getPoint();
        }
        if(sum < 12 && aceExists){
            sum += 10;
        }
        return sum;
    }
    public int numCards(){
        return hand.size();
    }
    public void addCard(Card cardName)
    {
        hand.add(cardName);
    }



    @Override
    public String toString(){
        return name + "’s cards: " + hand + " total: " + sum();
    }
}
