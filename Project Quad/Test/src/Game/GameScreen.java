package Game;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Sakis
 */
public class GameScreen {
    private JPanel gamePanel;
    //Gameplay panel
    private JPanel gameplayPanel;
    private JLabel player1;
    private JLabel player2;
    private JLabel optionsButton;
    //Win panel
    private JPanel winPanel;
    private JLabel retryButton;
    private JLabel quitButton;
    //Option panel
    private JPanel optionPanel;
    private JLabel tutorialButton;
    private JLabel restartButton;
    private JLabel optQuitButton;
    
    public GameScreen() {
        gamePanel = new JPanel();
        //Gameplay panel
        gameplayPanel = new JPanel();
        player1 = new JLabel();
        player2 = new JLabel();
        optionsButton = new JLabel();
        //Win panel
        winPanel = new JPanel();
        retryButton = new JLabel();
        quitButton = new JLabel();
        //Option panel
        optionPanel = new JPanel();
        tutorialButton = new JLabel();
        restartButton = new JLabel();
        optQuitButton = new JLabel();
        
        gamePanel.setLayout(new javax.swing.OverlayLayout(gamePanel));
        gameplayPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        winPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        optionPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        //Gameplay panel
        player1.setIcon(new ImageIcon(getClass().getResource("")));
        player2.setIcon(new ImageIcon(getClass().getResource("")));
        optionsButton.setIcon(new ImageIcon(getClass().
                getResource("/Game/imgs/buttons/opt_s1.png")));
        
        //Win panel
        retryButton.setIcon(new ImageIcon(getClass().
                getResource("/Game/imgs/buttons/win_r_s1.png")));
        quitButton.setIcon(new ImageIcon(getClass().
                getResource("/Game/imgs/buttons/menu_q_s1.png")));
        retryButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                
            }
            @Override
            public void mousePressed(MouseEvent e){
                
            }
        });
        quitButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                
            }
            @Override
            public void mousePressed(MouseEvent e){
                
            }
        });
        
        //Option panel
        tutorialButton.setIcon(new ImageIcon(getClass().
                getResource("/Game/imgs/buttons/t_s1.png")));
        restartButton.setIcon(new ImageIcon(getClass().
                getResource("/Game/imgs/buttons/r_s1.png")));
        optQuitButton.setIcon(new ImageIcon(getClass().
                getResource("/Game/imgs/buttons/q_s1.png")));
        tutorialButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                
            }
            @Override
            public void mousePressed(MouseEvent e){
                
            }
        });
        restartButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                
            }
            @Override
            public void mousePressed(MouseEvent e){
                
            }
        });
        tutorialButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                
            }
            @Override
            public void mousePressed(MouseEvent e){
                
            }
        });
        
        //Gameplay panel
        optionPanel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                
            }
            @Override
            public void mousePressed(MouseEvent e){
                
            }
        }); 
        tutorialButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                
            }
            @Override
            public void mousePressed(MouseEvent e){
                
            }
        });
        restartButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                
            }
            @Override
            public void mousePressed(MouseEvent e){
                
            }
        });
        optQuitButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                
            }
            @Override
            public void mousePressed(MouseEvent e){
                
            }
        });
    }
    
}
