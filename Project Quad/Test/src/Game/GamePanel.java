package Game;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel {
    private JPanel gamePanel;
    //Gameplay panel
    private JLabel gameTable;
    private JPanel gameplayPanel;
    private JLabel player1;
    private static String player1ColorPath;
    private JLabel player2;
    private static String player2ColorPath;
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
        
        //Initialization of all the components
        
        gamePanel = new JPanel();
        //Gameplay panel
        gameplayPanel = new JPanel();
        gameTable = new JLabel();
        player1 = new JLabel();
        player2 = new JLabel();
        optionsButton = new JLabel();
        //Win panel
        winPanel = new JPanel();
        retryButton = new JLabel();
        quitButton = new JLabel();
        //Option panel
        boolean optIsOpen = false;
        optionPanel = new JPanel();
        optionBackground = new JLabel();
        tutorialButton = new JLabel();
        restartButton = new JLabel();
        optQuitButton = new JLabel();
        optCloseButton = new JLabel();
        
        
        //Setting all the essential attributes for the panels.
        gamePanel.setBackground(new Color(162, 192, 242));
        gamePanel.setLayout(new javax.swing.OverlayLayout(gamePanel));
        gameplayPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        winPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        optionPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        gameplayPanel.setBackground(new Color(162, 192, 242));
        
        /*
                        #### Game panel ####
        */

        /*
        Reading the configuration file created and updated by the MenuPanel, t
        then extracting, by analyzing the string, the color name of the player 
        color icon path. At last, apply the
        color name to fetch the transparent player icon.
        */
        String data[] = fetchColorNameFromConfig();
        
        
        gameTable.setIcon(new ImageIcon(getClass().
                getResource("/Game/assets/general/game_table.png")));
        player1.setIcon(new ImageIcon(getClass().
                getResource("/Game/assets/players/transparent/player_"+data[0]+"_t.png")));
        player2.setIcon(new ImageIcon(getClass().
                getResource("/Game/assets/players/transparent/player_"+data[1]+"_t.png")));
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
        gameplayPanel.add(gameTable, new org.netbeans.
                lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        gameplayPanel.add(player1, new org.netbeans.
                lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        gameplayPanel.add(player2, new org.netbeans.
                lib.awtextra.AbsoluteConstraints(850, 0, -1, -1));
        gameplayPanel.add(optionsButton, new org.netbeans.
                lib.awtextra.AbsoluteConstraints(345, 0, -1, -1));
        
        /*
                        #### Win panel ####
        */
        winPanel.setVisible(false);
        winPanel.setBackground(new Color(162, 192, 242));
        retryButton.setIcon(new ImageIcon(getClass().
                getResource("/Game/assets/buttons/win_retryBtn_1.png")));
        quitButton.setIcon(new ImageIcon(getClass().
                getResource("/Game/assets/buttons/menu_quitBtn_1.png")));
        retryButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                gamePanel.setVisible(false);
                optionPanel.setVisible(false);
                gamePanel.getParent().getComponent(0).setVisible(true);
                /*
                De-refrence the game panel so that the garbage collector can
                collect the game panel. This practically removes it from the JVM Heap,
                thus restarting and the game panel. (This affectively initializes
                the game panel with whatever new updates made from the players in
                the menu panel.
                */
                gamePanel = null;
            }
            @Override
            public void mousePressed(MouseEvent e){
                retryButton.setIcon(new ImageIcon(getClass().
                getResource("/Game/assets/buttons/win_retryBtn_2.png")));
            }
            @Override
            public void mouseReleased(MouseEvent e){
                retryButton.setIcon(new ImageIcon(getClass().
                getResource("/Game/assets/buttons/win_retryBtn_1.png")));
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
        
        /*
                        #### Options panel ####
        */
        optionPanel.setVisible(false);
        optionPanel.setBackground(new Color(162, 192, 242));
        optionBackground.setIcon(new ImageIcon(getClass().
                getResource("/Game/assets/general/prompt_bg.png")));
        tutorialButton.setIcon(new ImageIcon(getClass().
                getResource("/Game/assets/buttons/opt_openTutorialBtn_1.png")));
        restartButton.setIcon(new ImageIcon(getClass().
                getResource("/Game/assets/buttons/opt_restartBtn_1.png")));
        optQuitButton.setIcon(new ImageIcon(getClass().
                getResource("/Game/assets/buttons/opt_quitBtn_1.png")));
        optCloseButton.setIcon(new ImageIcon(getClass().
                getResource("/Game/assets/buttons/opt_closeOpt_1.png")));
        tutorialButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                gameplayPanel.setVisible(false);
                optionPanel.setVisible(false);
                TutorialPanel tp = new TutorialPanel();
                gamePanel.add(tp.getTutorialComponent());
                tp.getTutorialComponent().setVisible(true);
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
                optionPanel.setVisible(false);
                gamePanel.getParent().getComponent(0).setVisible(true);
                /*
                De-refrence the game panel so that the garbage collector can
                collect the game panel. This practically removes it from the JVM Heap,
                thus restarting and the game panel. (This affectively initializes
                the game panel with whatever new updates made from the players in
                the menu panel.
                */
                gamePanel = null;
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
                getResource("/Game/assets/buttons/opt_closeOpt_2.png")));
            }
            @Override
            public void mouseReleased(MouseEvent e){
                optCloseButton.setIcon(new ImageIcon(getClass().
                getResource("/Game/assets/buttons/opt_closeOpt_1.png")));
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
        
        
        /*
        Finally adding all the sub-components of the game panel, into it.
        */
        gamePanel.add(gameplayPanel);
        gamePanel.add(winPanel);
        gamePanel.add(optionPanel);
        
        /*
        Tha game panel is created on runtime, so it is not need to be invisible
        (like the tutorial panel)
        */
        gamePanel.setVisible(true);
    }
    /**
     * Fetches and extracts the color name from the configuration file.
     * 
     * @return An array of Strings containing the color name data from the 
     * configuration file. 
     */
    String[] fetchColorNameFromConfig(){
        File config = new File("src/Game/config.txt");
        String data[] = new String[2];
        try {
            Scanner configReader = new Scanner(config);
            int i = 0;
            while(configReader.hasNextLine()){
                data[i] = configReader.nextLine();
                i++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        String splitted[] = data;
        String playerColor[] = new String[2];
        String player1color[];
        String player2color[];
        
        player1color = splitted[0].split("_");
        player2color = splitted[1].split("_");
        
        player1color = player1color[1].split(".jpg");
        player2color = player2color[1].split(".jpg");
        playerColor[0] = player1color[0];
        playerColor[1] = player2color[0];
        return playerColor;
    }
    
    JPanel getGamePanelComponent()
    {
        return this.gamePanel;
    }
    
}
