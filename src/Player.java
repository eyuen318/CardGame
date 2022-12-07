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
        int sum = 0;
        for(int i = 0; i < hand.size(); i++) {
            sum += hand.get(i).getPoint();
        }
        System.out.println(sum);
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
        return name +" has " + points +"points\n" + name + "’s cards: " + hand;
    }
}
