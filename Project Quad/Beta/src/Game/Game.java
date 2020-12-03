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
        JFrame window = new JFrame("Score 4! - [playable beta] 0.1.1b");
        
        MenuPanel menuPanel = new MenuPanel();
        TutorialPanel tutorialPanel = new TutorialPanel();
        
        window.setResizable(false);
        window.setSize(960, 720);
        /*
        Get the screen dimensions of the machine and display the game window
        in the middle of the screen. Independant of screen resolution.
        */
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(d.width/2-window.getSize().width/2, 
                           d.height/2-window.getSize().height/2);
        window.setLayout(new OverlayLayout(window.getContentPane()));
        
        window.add(menuPanel.getMenuComponent());
        /*
        The tutorial panel is set to invisible on startup.
        */
        window.add(tutorialPanel.getTutorialComponent());
        
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
    public static void main(String[] args) {
        Game g = new Game();
    }
}
