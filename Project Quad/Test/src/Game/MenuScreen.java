package Game;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Sakis
 */
public class MenuScreen {
    private JPanel menuPanel;
    private JLabel gameLogo;
    private JLabel gameStartButton;
    private JLabel player1_icon;
    private JLabel player2_icon;
    private JLabel menuOpenTutorialButton;
    
    public MenuScreen(){
        menuPanel = new JPanel();
        gameLogo = new JLabel();
        gameStartButton = new JLabel();
        player1_icon = new JLabel();
        player2_icon = new JLabel();
        menuOpenTutorialButton = new JLabel();
        
        menuPanel.setBackground(new Color(162, 192, 242));
        menuPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        gameLogo.setIcon(new ImageIcon(getClass().
                getResource("/Game/imgs/game_logo.png")));
        menuPanel.add(gameLogo, new org.netbeans.lib.
                awtextra.AbsoluteConstraints(230, 135, -1, -1));
        
        gameStartButton.setIcon(new ImageIcon(getClass().
                getResource("/Game/imgs/buttons/menu_s1.png")));
        menuPanel.add(gameStartButton, new org.netbeans.lib.
                awtextra.AbsoluteConstraints(230, 385, -1, -1));
        
        menuOpenTutorialButton.setIcon(new ImageIcon(getClass().
                getResource("/Game/imgs/buttons/menu_tutorial_s1.png")));
        menuPanel.add(menuOpenTutorialButton, new org.netbeans.lib.
                awtextra.AbsoluteConstraints(0, 0, -1, -1));
        
        menuOpenTutorialButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                menuOpenTutorialButton.setIcon(new ImageIcon(getClass().
                        getResource("/Game/imgs/buttons/menu_tutorial_s2.png")));
            }
            @Override
            public void mouseExited(MouseEvent e){
                menuOpenTutorialButton.setIcon(new ImageIcon(getClass().
                        getResource("/Game/imgs/buttons/menu_tutorial_s1.png")));
            }
            @Override
            public void mousePressed(MouseEvent e){
                menuOpenTutorialButton.setIcon(new ImageIcon(getClass().
                        getResource("/Game/imgs/buttons/menu_tutorial_s3.png")));
            }
            @Override
            public void mouseClicked(MouseEvent e){
                menuPanel.getParent().getComponent(0).setVisible(false);
                menuPanel.getParent().getComponent(1).setVisible(true);
            }
        });
        
    }
    JPanel getMenuComponent(){
        return this.menuPanel;
    }
}
