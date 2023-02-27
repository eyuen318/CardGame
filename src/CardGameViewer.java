import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
public class CardGameViewer extends JFrame{

    private Player dealer, p1;
    private Image pokerChips = new ImageIcon("Resources/pokerChips.png").getImage();

    private Image dealerImage = new ImageIcon("Resources/blackjackDealer.png").getImage();

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

        g.setColor(Color.white);
        g.fillRect(0,0,WINDOW_WIDTH, WINDOW_HEIGHT);
        g.setColor(new Color(13, 102, 44));
        g.fillArc(0,0,WINDOW_WIDTH,WINDOW_HEIGHT,0, -180);
        g.fillRect(0,WINDOW_HEIGHT/4 + 25, WINDOW_WIDTH, WINDOW_HEIGHT/4);
        g.setColor(Color.white);
        g.setFont(new Font("Serif", Font.PLAIN, 15));
        g.drawString("Welcome to Ethan's BlackJack!", 550, 225);
        g.drawString("To hit or stand, enter your choice ", 550, 250);
        g.drawString("into the back-end terminal.", 550, 275);
        g.drawImage(pokerChips, 450, 350, 75, 100, this);
        g.drawImage(pokerChips, 525, 350, 75, 100, this);
        g.drawImage(dealerImage, 325, 25, 175, 125, this);


        drawCard(g);
    }
    public void drawCard(Graphics g){
        int nextDistance = 50;
        int startPos = 200;
        //player->arrayList<Card> ->Card   ->Image
        //player. getHand().       get(i).getFront()

        for(Card c : p1.getHand()){
            g.drawImage(c.getFront(), startPos, 325, 60, 90, this);
            startPos += nextDistance;
        }

        g.drawImage(dealer.getHand().get(0).getFront(), startPos + 25, 175, 60, 90, this);
        startPos +=nextDistance;
        for(int i = 1; i < dealer.getHand().size(); i++){
            g.drawImage(dealer.getHand().get(i).getBack(), startPos + 25, 175, 60, 90, this);
            startPos += nextDistance;
        }
    }




}
