package Game;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Sakis
 */
public class MenuPanel {
    private JPanel menuPanel;
    private JLabel gameLogo;
    private JLabel gameStartButton;
    private JLabel player1_Color;
    private JLabel player2_Color;
    private JLabel menuOpenTutorialButton;
    
    public MenuPanel(){
        menuPanel = new JPanel();
        gameLogo = new JLabel();
        gameStartButton = new JLabel();
        player1_Color = new JLabel();
        player2_Color = new JLabel();
        menuOpenTutorialButton = new JLabel();
        
        menuPanel.setBackground(new Color(162, 192, 242));
        menuPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        gameLogo.setIcon(new ImageIcon(getClass().
                getResource("/Game/imgs/game_logo.png")));
        menuPanel.add(gameLogo, new org.netbeans.lib.
                awtextra.AbsoluteConstraints(230, 135, -1, -1));
        
        gameStartButton.setIcon(new ImageIcon(getClass().
                getResource("/Game/imgs/menu_play.png")));
        menuPanel.add(gameStartButton, new org.netbeans.lib.
                awtextra.AbsoluteConstraints(230, 385, -1, -1));
        
        menuOpenTutorialButton.setIcon(new ImageIcon(getClass().
                getResource("/Game/imgs/menu_tutorial_s1.png")));
        menuPanel.add(menuOpenTutorialButton, new org.netbeans.lib.
                awtextra.AbsoluteConstraints(750, 0, -1, -1));
        
        menuOpenTutorialButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                menuOpenTutorialButton.setIcon(new ImageIcon(getClass().
                        getResource("/Game/imgs/menu_tutorial_s2.png")));
            }
            @Override
            public void mouseExited(MouseEvent e){
                menuOpenTutorialButton.setIcon(new ImageIcon(getClass().
                        getResource("/Game/imgs/menu_tutorial_s1.png")));
            }
            @Override
            public void mouseClicked(MouseEvent e){
                menuOpenTutorialButton.setIcon(new ImageIcon(getClass().
                        getResource("/Game/imgs/menu_tutorial_s3.png")));
                menuPanel.getParent().getComponent(0).setVisible(false);
                menuPanel.getParent().getComponent(1).setVisible(true);
            }
        });
        
    }
    JPanel getMenuComponent(){
        return this.menuPanel;
    }
}
