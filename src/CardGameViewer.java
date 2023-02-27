import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
public class CardGameViewer extends JFrame{

    private Player dealer, p1;
    private Image pokerChips = new ImageIcon("Resources/pokerChips.png").getImage();

    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 500;

    private Game theGame;

    public CardGameViewer(Player dealer, Player p1, Game theGame)
    {
        this.theGame = theGame;
        this.setTitle("BlackJack");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
        this.dealer = dealer;
        this.p1 = p1;

    }
    public void paint(Graphics g)
    {

        g.setColor(Color.lightGray);
        g.fillRect(0,0,WINDOW_WIDTH, WINDOW_HEIGHT);
        g.setColor(new Color(13, 102, 44));
        g.fillArc(0,0,WINDOW_WIDTH,WINDOW_HEIGHT,0, -180);
        g.fillRect(0,0, WINDOW_WIDTH, WINDOW_HEIGHT/2);
        g.setFont(new Font("Serif", Font.PLAIN, 30));
        g.drawImage(pokerChips, 450, 400, 75, 100, this);

        drawCard(g);
    }
    public void drawCard(Graphics g){
        int nextDistance = 50;
        int startingPosition = 250;
        //class hierachy:
        //player->arrayList<Card> ->Card   ->Image
        //player. getHand().       get(i).getFront()
        //print this in a loop
        int x = startingPosition;
        for(Card c : p1.getHand()){
            g.drawImage(c.getFront(), x, 250, 60, 90, this);
            x += nextDistance;
        }
        //g.drawImage(p1.getHand().get(0).getFront(), 250, 250, 60, 90, this);

        //dealer is also a player
        //dealer.getHand().get(0).getFront() only show the first card of dealer
        //i = 1
        //dealer.getHand().get(i).getBack() print these in a loop
        x = startingPosition;
        g.drawImage(dealer.getHand().get(0).getFront(), x, 100, 60, 90, this);
        x+=nextDistance;
        for(int i = 1; i < dealer.getHand().size(); i++){
            Card c = dealer.getHand().get(i);
            g.drawImage(c.getBack(), x, 100, 60, 90, this);
            x += nextDistance;
        }
    }




}
