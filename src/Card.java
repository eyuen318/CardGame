import java.awt.*;

public class Card {
    private String rank;
    private String suit;
    private int point;

    private Image front;
    private Image back;

    public Card(String rank, String suit, int point, Image front, Image back) {
        this.rank = rank;
        this.suit = suit;
        this.point = point;
        this.front = front;
        this.back = back;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public int getPoint() {
        return point;
    }
    public Image getFront()
    {
        return front;
    }
    public Image getBack()
    {
        return back;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
