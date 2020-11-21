package Game;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.OverlayLayout;

/**
 *
 * @author Sakis
 */
public class Game {
    public Game(){
        JFrame window = new JFrame("Score 4!");
        MenuPanel menuPanel = new MenuPanel();
        TutorialPanel tutorialPanel = new TutorialPanel();
        GamePanel gamePanel = new GamePanel();
        window.setResizable(false);
        window.setSize(960, 720);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(d.width/2-window.getSize().width/2, 
                           d.height/2-window.getSize().height/2);
        window.setLayout(new OverlayLayout(window.getContentPane()));
        
        window.add(menuPanel.getMenuComponent());
        window.add(tutorialPanel.getTutorialComponent()); //Invisible by default. 
                                        //Visible when mouse clicked on book icon
        window.add(gamePanel.getGamePanelComponent());
        
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
    public static void main(String[] args) {
        Game g = new Game();
    }
}
