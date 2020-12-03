package Game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GamePanel {
    private JPanel gamePanel;
    //Gameplay panel
    private JPanel gameplayPanel;
    private JPanel tableGrid;
    private JButton[][] buttons;
    private JLabel player1;
    private String player1Color;
    private String player1Pawn;
    private JLabel player2;
    private String player2Color;
    private String player2Pawn;
    private JLabel optionsButton;
    //Win panel
    private JPanel winPanel;
    private JLabel winBackground;
    private JLabel retryButton;
    private JLabel quitButton;
    //Option panel
    private JPanel optionPanel;
    private JLabel optionBackground;
    private JLabel tutorialButton;
    private JLabel restartButton;
    private JLabel optQuitButton;
    private JLabel optCloseButton;
    //Game logic
    private int playerOrder = 0;
    private static int livingCellNumber=0;
    private Cell gameBoard[][];
    
    public GamePanel() {
        
        //Initialization of all the components
        
        gamePanel = new JPanel();
        //Gameplay panel
        gameplayPanel = new JPanel();
        tableGrid = new JPanel();
        buttons = new JButton[7][7];
        player1 = new JLabel();
        player2 = new JLabel();
        optionsButton = new JLabel();
        //Win panel
        winPanel = new JPanel();
        winBackground = new JLabel();
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
        tableGrid.setLayout(new java.awt.GridLayout(7, 7));
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
        
        setPlayerColors(data[0], data[1]);
        
        dynamicAllocation();
        initialBoard();
        
        player1.setIcon(new ImageIcon(getClass().
                getResource("/Game/assets/players/transparent/player_"+player1Color+"_t.png")));
        player2.setIcon(new ImageIcon(getClass().
                getResource("/Game/assets/players/transparent/player_"+player2Color+"_t.png")));
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

        gameplayPanel.add(tableGrid, new org.netbeans.
                lib.awtextra.AbsoluteConstraints(125, 125, -1, -1));
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
        winBackground.setIcon(new ImageIcon(getClass().
                getResource("/Game/assets/general/prompt_bg.png")));
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
                Runtime.getRuntime().exit((0));
            }
            @Override
            public void mousePressed(MouseEvent e){
                quitButton.setIcon(new ImageIcon(getClass().
                getResource("/Game/assets/buttons/opt_quitBtn_2.png")));
            }
            @Override
            public void mouseReleased(MouseEvent e){
                quitButton.setIcon(new ImageIcon(getClass().
                getResource("//Game/assets/buttons/opt_quitBtn_1.png")));
            }
        });
        
        winPanel.add(quitButton, new org.netbeans.
                lib.awtextra.AbsoluteConstraints(450, 400, -1, -1));
        winPanel.add(retryButton, new org.netbeans.
                lib.awtextra.AbsoluteConstraints(450, 290, -1, -1));
        winPanel.add(winBackground, new org.netbeans.
                lib.awtextra.AbsoluteConstraints(280, 70, -1, -1));
        
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
    
    void setPlayerColors(String p1, String p2){
        player1Color = p1;
        player2Color = p2;
        player1Pawn = "/Game/assets/pawns/pawn_"+player1Color+".png";
        player2Pawn = "/Game/assets/pawns/pawn_"+player2Color+".png";
    }
    
    public void dynamicAllocation()
    {
      // Create dynamic Cell array to game board
        gameBoard = new Cell[7][7];
        for (int i = 0; i < 7; i++)
        {
            for (int j = 0; j < 7; j++)
            {
                gameBoard [i][j]=new Cell();
            }
        }
    }
    
    public void initialBoard()
    {
        for (int i=5; i>= 0; --i) 
        {
            for (int j = 6; j>=0; --j)
            {
                gameBoard[i][j].setCellState(-99);
            }
        }    
       initiateBoard(); // Add buttons and listener
    }
    
    void initiateBoard(){
        for(int i=0;i<7;++i){
            for(int j=0;j<7;++j){
                buttons[i][j] = new JButton(new ImageIcon(getClass().
                        getResource("/Game/assets/pawns/emptycell.png")));
                buttons[i][j].addActionListener(new listenButtonTwoPlayers());
                tableGrid.add(buttons[i][j]);
            }
        }
    }
    
    public void winnerPlayer(int winner)
    {
        for(int i=0; i<7; ++i)
        {         
            for(int j=0; j<7; ++j)
            {     
                if(gameBoard[i][j].getCellState() == winner)
                {    
                    // CHECK UP TO DOWN POSITIONS
                    if(i+3<7)
                    {
                        if(gameBoard[i+1][j].getCellState() == winner 
                                && gameBoard[i+2][j].getCellState() == winner 
                                && gameBoard[i+3][j].getCellState() == winner)  
                        {
                            if(winner==1)
                                showResult(1);
                            else
                                showResult(2);
                        }
                    }
                    // CHECK LEFT TO RIGHT POSITION
                    if(j + 3 <7)
                    { 
                        if(gameBoard[i][j+1].getCellState() == winner 
                                && gameBoard[i][j+2].getCellState() == winner 
                                && gameBoard[i][j+3].getCellState() == winner)
                        { 
                            if(winner==1)
                                showResult(1);
                            else
                                showResult(2);
                        }
                    }

                    // CHECK DIAGONAL LEFT TO RIGHT POSITION
                    if(i  < 4 && j< 4)
                    {
                        if(gameBoard[i+1][j+1].getCellState() == winner 
                                && gameBoard[i+2][j+2].getCellState() == winner 
                                && gameBoard[i+3][j+3].getCellState() == winner)
                        {  
                            if(winner==1)
                                showResult(1);
                            else
                                showResult(2);
                        }   
                    }

                    // CHECK DIAGONAL RIGHT TO LEFT POSITION
                    if(i  < 4 && j - 3 >= 0 )
                    {
                        if(gameBoard[i+1][j-1].getCellState() == winner 
                                && gameBoard[i+2][j-2].getCellState() == winner 
                                && gameBoard[i+3][j-3].getCellState() == winner)
                        {
                            if(winner==1)
                                showResult(1);
                            else
                                showResult(2);
                        } 
                    }                           
                }         
            }             
        } 
    }
    
    public void showResult(int winnerPlayer)
   {
       if(winnerPlayer==1)
       {
           gameplayPanel.setVisible(false);
           winPanel.setVisible(true);
       }
       else
       {
           gameplayPanel.setVisible(false);
           winPanel.setVisible(true);
       }
   }
    
    public void setUpperCellToEmpty(int rowPos, int columnPos)
    {
        try 
        {
            gameBoard[rowPos-1][columnPos].setCellState(0);    
        }   
        catch (Exception ex) 
        { }      
    }
    
   /*public void startAgain()
   {
       
        for(int i=0; i<7; ++i)
        {         
            for(int j=0; j<7; ++j)
            {
                gameBoard[i][j].setCellState(-99);  // Initial Value
                buttons[i][j].setIcon(empty);       // Put the empty cell icon
            }
        }
        
        frame.setVisible(false);                            // Unvisible previous game board
        ConnectFour newGame = new ConnectFour();           // New Game Object
   }*/
    
    JPanel getGamePanelComponent()
    {
        return this.gamePanel;
    }
    private class listenButtonTwoPlayers implements ActionListener
    {           
        @Override
        public void actionPerformed(ActionEvent e)
        {            
            try {
                int eventFlag = 0;
                int flagPlayerOrder=0;

                for(int i=6; i>=0; --i)
                {
                    for(int j=0; j<=6; ++j)
                    {
                        if(eventFlag==0 && buttons[i][j]== e.getSource()) // Get the button component that was clicked
                        {  
                           if(flagPlayerOrder==0 && playerOrder%2==0) 
                           { 
                               // Player 1 Operations                           
                               // Fill the board from down to up
                                for(int k=0; k<=7; ++i)    
                                {
                                    if(gameBoard[i-k][j].getCellState()==0 && playerOrder%2==0)
                                    {
                                       buttons[i-k][j].setIcon(new ImageIcon(getClass().
                                               getResource(player1Pawn)));          // Set new icon to player 1 
                                       gameBoard[i-k][j].setAllPosition('X', i);  // Set cell parameters
                                       gameBoard[i-k][j].setCellState(1);
                                       ++livingCellNumber;  // Increase living cell number
                                       winnerPlayer(1);     // Check player 1 winning state
                                       flagPlayerOrder=1;   
                                       eventFlag=1;
                                       break; 
                                    } 
                                }

                                setUpperCellToEmpty(i,j);   // Set upper cell to empty 
                                System.out.println("... Player 1 played ... ");
                                ++playerOrder; // Change order from player 1 to player 2
                                break;
                            }

                            // Player 2 operations
                            if(flagPlayerOrder==0 && playerOrder%2==1) 
                            { 
                                for(int k=0; k<=7; ++i)
                                {
                                    if(gameBoard[i-k][j].getCellState()==0 && playerOrder%2==1)
                                    {
                                       buttons[i-k][j].setIcon(new ImageIcon(getClass().
                                               getResource(player2Pawn)));            // Set new icon to player 2
                                       gameBoard[i-k][j].setAllPosition('O', i);    // Set cell parameters    
                                       gameBoard[i-k][j].setCellState(2);           // Set cell state
                                       ++livingCellNumber;
                                       winnerPlayer(2);
                                       flagPlayerOrder=1;
                                       eventFlag=1;
                                       break;
                                    } 
                                }
                                setUpperCellToEmpty(i,j);
                                System.out.println("... Player 2 played ... ");
                                ++playerOrder;
                                break;
                            }
                        }
                    }   
                }   
        }catch(Exception ex) 
        { 
            ex.printStackTrace();
        }     
       
        } // END ACTIONPERFORMED    
    } // END listenButtonTwoPlayers CLASS
}
