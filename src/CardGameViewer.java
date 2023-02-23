import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
public class CardGameViewer extends JFrame{

    private Player dealer, p1;

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




}
