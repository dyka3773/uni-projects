package Game;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel {
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
    private JLabel optionBackground;
    private JLabel tutorialButton;
    private JLabel restartButton;
    private JLabel optQuitButton;
    private JLabel optCloseButton;
    
    public GamePanel() {
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
        optionBackground = new JLabel();
        tutorialButton = new JLabel();
        restartButton = new JLabel();
        optQuitButton = new JLabel();
        optCloseButton = new JLabel();
        
        gamePanel.setBackground(new Color(162, 192, 242));
        gamePanel.setLayout(new javax.swing.OverlayLayout(gamePanel));
        gameplayPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        winPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        optionPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        
        //Gameplay panel
        //Player icon's depends on what the players' chose at the menu panel
        
        player1.setIcon(new ImageIcon(getClass().getResource("")));
        player2.setIcon(new ImageIcon(getClass().getResource("")));
        optionsButton.setIcon(new ImageIcon(getClass().
                getResource("/Game/assets/buttons/game_openOptionsBtn_1.png")));
        optionsButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                gameplayPanel.setVisible(false);
                winPanel.setVisible(false);
                optionPanel.setVisible(true);
            }
            @Override
            public void mousePressed(MouseEvent e){
                optionsButton.setIcon(new ImageIcon(getClass().
                getResource("/Game/assets/buttons/game_openOptionsBtn_2.png")));
            }
            @Override
            public void mouseReleased(MouseEvent e){
                optionsButton.setIcon(new ImageIcon(getClass().
                getResource("/Game/assets/buttons/game_openOptionsBtn_1.png")));
            }
        });
        
        gameplayPanel.add(player1, new org.netbeans.
                lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        gameplayPanel.add(player2, new org.netbeans.
                lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        gameplayPanel.add(optionsButton, new org.netbeans.
                lib.awtextra.AbsoluteConstraints(345, 0, -1, -1));
        
        //Win panel
        winPanel.setOpaque(false);
        retryButton.setIcon(new ImageIcon(getClass().
                getResource("/Game/assets/buttons/win_retryBtn_1.png")));
        quitButton.setIcon(new ImageIcon(getClass().
                getResource("/Game/assets/buttons/menu_quitBtn_1.png")));
        retryButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                
            }
            @Override
            public void mousePressed(MouseEvent e){
                retryButton.setIcon(new ImageIcon(getClass().
                getResource("/Game/assets/buttons/game_openOptionsBtn_2.png")));
            }
            @Override
            public void mouseReleased(MouseEvent e){
                retryButton.setIcon(new ImageIcon(getClass().
                getResource("/Game/assets/buttons/game_openOptionsBtn_1.png")));
            }
        });
        quitButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                
            }
            @Override
            public void mousePressed(MouseEvent e){
                quitButton.setIcon(new ImageIcon(getClass().
                getResource("/Game/assets/buttons/game_openOptionsBtn_2.png")));
            }
            @Override
            public void mouseReleased(MouseEvent e){
                quitButton.setIcon(new ImageIcon(getClass().
                getResource("/Game/assets/buttons/game_openOptionsBtn_1.png")));
            }
        });
        
        winPanel.add(retryButton, new org.netbeans.
                lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        winPanel.add(quitButton, new org.netbeans.
                lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        winPanel.add(retryButton, new org.netbeans.
                lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        
        //Option panel
        optionPanel.setOpaque(false);
        optionBackground.setIcon(new ImageIcon(getClass().
                getResource("/Game/assets/general/prompt_bg.png")));
        tutorialButton.setIcon(new ImageIcon(getClass().
                getResource("/Game/assets/buttons/opt_openTutorialBtn_1.png")));
        restartButton.setIcon(new ImageIcon(getClass().
                getResource("/Game/assets/buttons/opt_restartBtn_1.png")));
        optQuitButton.setIcon(new ImageIcon(getClass().
                getResource("/Game/assets/buttons/opt_quitBtn_1.png")));
        optCloseButton.setIcon(new ImageIcon(getClass().
                getResource("/Game/assets/buttons/opt_closeOptionsBtn_1.png")));
        tutorialButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                /*
                TODO: Find a way to return to the screen where the tutorial
                was called from!
                */
            }
            @Override
            public void mousePressed(MouseEvent e){
                tutorialButton.setIcon(new ImageIcon(getClass().
                getResource("/Game/assets/buttons/opt_openTutorialBtn_2.png")));
            }
            @Override
            public void mouseReleased(MouseEvent e){
                tutorialButton.setIcon(new ImageIcon(getClass().
                getResource("/Game/assets/buttons/opt_openTutorialBtn_1.png")));
            }
        });
        restartButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                gamePanel.setVisible(false);
                gamePanel.getParent().getComponent(0).setVisible(true);
            }
            @Override
            public void mousePressed(MouseEvent e){
                restartButton.setIcon(new ImageIcon(getClass().
                getResource("/Game/assets/buttons/opt_restartBtn_2.png")));
            }
            @Override
            public void mouseReleased(MouseEvent e){
                restartButton.setIcon(new ImageIcon(getClass().
                getResource("/Game/assets/buttons/opt_restartBtn_1.png")));
            }
        });
        optQuitButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                Runtime.getRuntime().exit((0));
            }
            @Override
            public void mousePressed(MouseEvent e){
                optQuitButton.setIcon(new ImageIcon(getClass().
                getResource("/Game/assets/buttons/opt_quitBtn_2.png")));
            }
            @Override
            public void mouseReleased(MouseEvent e){
                optQuitButton.setIcon(new ImageIcon(getClass().
                getResource("/Game/assets/buttons/opt_quitBtn_1.png")));
            }
        });
        optCloseButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                optionPanel.setVisible(false);
                gameplayPanel.setVisible(true);
            }
            @Override
            public void mousePressed(MouseEvent e){
                optCloseButton.setIcon(new ImageIcon(getClass().
                getResource("/Game/assets/buttons/opt_closeOptionsBtn_2.png")));
            }
            @Override
            public void mouseReleased(MouseEvent e){
                optCloseButton.setIcon(new ImageIcon(getClass().
                getResource("/Game/assets/buttons/opt_closeOptionsBtn_1.png")));
            }
        });
        optionPanel.add(tutorialButton, new org.netbeans.
                lib.awtextra.AbsoluteConstraints(350, 140, -1, -1));
        optionPanel.add(restartButton, new org.netbeans.
                lib.awtextra.AbsoluteConstraints(350, 250, -1, -1));
        optionPanel.add(optQuitButton, new org.netbeans.
                lib.awtextra.AbsoluteConstraints(350, 360, -1, -1));
        optionPanel.add(optCloseButton, new org.netbeans.
                lib.awtextra.AbsoluteConstraints(675, 90, -1, -1));
        optionPanel.add(optionBackground, new org.netbeans.
                lib.awtextra.AbsoluteConstraints(280, 70, -1, -1));
        
        gamePanel.add(gameplayPanel);
        gamePanel.add(winPanel);
        gamePanel.add(optionPanel);
        
        gamePanel.setVisible(false);
    }
    JPanel getGamePanelComponent()
    {
        return this.gamePanel;
    }
    
}
