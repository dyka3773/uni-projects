package Game;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;
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
    private static String player1ColorPath = "/Game/assets/players/player_red.jpg";
    private static String player2ColorPath = "/Game/assets/players/player_blue.jpg";
    private JLabel menuOpenTutorialButton;
    private JLabel left_arrow;
    private JLabel right_arrow;
    private JLabel left_arrow2;
    private JLabel right_arrow2;
    private JLabel players;
    private static int clicks1 = 0;
    private static int clicks2 = 1;
    static String imgPath[]= {
        "/Game/assets/players/player_red.jpg",      //0
        "/Game/assets/players/player_blue.jpg",     //1
        "/Game/assets/players/player_green.jpg",    //2
        "/Game/assets/players/player_orange.jpg",   //3
        "/Game/assets/players/player_pink.jpg",     //4
        "/Game/assets/players/player_yellow.jpg"    //5
    };
    private JLabel devsButton;

    public MenuPanel(){
        menuPanel = new JPanel();
        gameLogo = new JLabel();
        gameStartButton = new JLabel();
        player1_Color = new JLabel();
        player2_Color = new JLabel();
        menuOpenTutorialButton = new JLabel();
        gameStartButton = new JLabel();
        players = new JLabel();
        left_arrow = new JLabel();
        right_arrow = new JLabel();
        left_arrow2 = new JLabel();
        right_arrow2 = new JLabel();
        devsButton = new JLabel();
        
        /*
                        #### Menu panel ####
        */
        /*
        This call inits the config file with the default paths.
        */
        updateConfig(player1ColorPath, player2ColorPath);
        
        //Initialization
        menuPanel.setBackground(new Color(162, 192, 242));
        menuPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        //Inserting the game window
        gameLogo.setIcon(new ImageIcon(getClass().
                getResource("/Game/assets/general/menu_gameLogo.png"))); 
        menuPanel.add(gameLogo, new org.netbeans.lib.
                awtextra.AbsoluteConstraints(120, 50, -1, -1));
        
        //"Start Game" button
        gameStartButton.setIcon(new ImageIcon(getClass(). 
                getResource("/Game/assets/buttons/menu_startBtn_1.png")));
        menuPanel.add(gameStartButton, new org.netbeans.lib.
                awtextra.AbsoluteConstraints(230, 385, -1, -1));
        //Icon event handling
        gameStartButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){ 
                menuPanel.setVisible(false); //Menu panel
                menuPanel.getParent().add(new GamePanel().getGamePanelComponent());
            }
            @Override
            public void mouseEntered(MouseEvent e){
                gameStartButton.setIcon(new ImageIcon(getClass().
                        getResource("/Game/assets/buttons/menu_startBtn_2.png")));
            }
            @Override
            public void mouseExited(MouseEvent e){ 
                gameStartButton.setIcon(new ImageIcon(getClass().
                        getResource("/Game/assets/buttons/menu_startBtn_1.png")));
            }
        });
            
        
        //Tutorial Button
        menuOpenTutorialButton.setIcon(new ImageIcon(getClass(). 
                getResource("/Game/assets/buttons/menu_openTutorialBtn_1.png")));
        menuPanel.add(menuOpenTutorialButton, new org.netbeans.lib.
                awtextra.AbsoluteConstraints(750, 0, -1, -1));
        //Icon event handling
        menuOpenTutorialButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                menuOpenTutorialButton.setIcon(new ImageIcon(getClass().
                        getResource("/Game/assets/buttons/menu_openTutorialBtn_2.png")));
            }
            @Override
            public void mouseExited(MouseEvent e){
                menuOpenTutorialButton.setIcon(new ImageIcon(getClass().
                        getResource("/Game/assets/buttons/menu_openTutorialBtn_1.png")));
            }
            @Override
            public void mousePressed(MouseEvent e){
                menuOpenTutorialButton.setIcon(new ImageIcon(getClass().
                        getResource("/Game/assets/buttons/menu_openTutorialBtn_3.png")));
            }
            @Override
            public void mouseClicked(MouseEvent e){
                menuPanel.getParent().getComponent(0).setVisible(false);
                menuPanel.getParent().getComponent(1).setVisible(true);
            }
        });
        
        
        //Player One and Player Two above the choices
        players.setIcon(new ImageIcon(getClass(). 
                getResource("/Game/assets/general/players_tr.png")));
        menuPanel.add(players, new org.netbeans.lib.
                awtextra.AbsoluteConstraints(-15, 480, -1, -1));
        
        
        //Color of Player One
        player1_Color.setIcon(new ImageIcon(getClass(). 
                getResource("/Game/assets/players/player_red.jpg")));
        menuPanel.add(player1_Color, new org.netbeans.lib.
                awtextra.AbsoluteConstraints(55, 525, -1, -1));
        
        //Left Arrow Player One
        left_arrow.setIcon(new ImageIcon(getClass(). 
                getResource("/Game/assets/buttons/menu_playerIconSelection_left1.png")));
        menuPanel.add(left_arrow, new org.netbeans.lib.
                awtextra.AbsoluteConstraints(0, 550, -1, -1));
        
        left_arrow.addMouseListener(new MouseAdapter() { 
            @Override //Mouse off the image
            public void mouseEntered(MouseEvent e){
                left_arrow.setIcon(new ImageIcon(getClass().
                        getResource("/Game/assets/buttons/menu_playerIconSelection_left2.png")));
            }
            @Override //Mouse over the image
            public void mouseExited(MouseEvent e){
                left_arrow.setIcon(new ImageIcon(getClass().
                        getResource("/Game/assets/buttons/menu_playerIconSelection_left1.png")));
            }
            @Override //Goes over the characters for Player One
            public void mouseClicked(MouseEvent e){
                changinColors(player1_Color, 1, "L");
            }
        });
        
        //Right Arrow Player One
        right_arrow.setIcon(new ImageIcon(getClass(). 
                getResource("/Game/assets/buttons/menu_playerIconSelection_right1.png")));
        menuPanel.add(right_arrow, new org.netbeans.lib.
                awtextra.AbsoluteConstraints(280, 550, -1, -1));
        
        right_arrow.addMouseListener(new MouseAdapter() {
            @Override //Mouse off the image
            public void mouseEntered(MouseEvent e){
                right_arrow.setIcon(new ImageIcon(getClass().
                        getResource("/Game/assets/buttons/menu_playerIconSelection_right2.png")));
            }
            @Override //Mouse on the image
            public void mouseExited(MouseEvent e){
                right_arrow.setIcon(new ImageIcon(getClass().
                        getResource("/Game/assets/buttons/menu_playerIconSelection_right1.png")));
            }
            @Override //Goes over the characters for Player One
            public void mouseClicked(MouseEvent e){
                changinColors(player1_Color, 1, "R");
            }
        });        
        
        
        //Color of Player Two
        player2_Color.setIcon(new ImageIcon(getClass(). 
                getResource("/Game/assets/players/player_blue.jpg")));
        menuPanel.add(player2_Color, new org.netbeans.lib.
                awtextra.AbsoluteConstraints(700, 525, -1, -1));
        
        //Left Arrow Player Two
        left_arrow2.setIcon(new ImageIcon(getClass(). 
                getResource("/Game/assets/buttons/menu_playerIconSelection_left1.png")));
        menuPanel.add(left_arrow2, new org.netbeans.lib.
                awtextra.AbsoluteConstraints(645, 550, -1, -1));
        
        left_arrow2.addMouseListener(new MouseAdapter() { 
            @Override // Mouse of the image
            public void mouseEntered(MouseEvent e){
                left_arrow2.setIcon(new ImageIcon(getClass().
                        getResource("/Game/assets/buttons/menu_playerIconSelection_left2.png")));
            }
            @Override //Mouse on the image
            public void mouseExited(MouseEvent e){
                left_arrow2.setIcon(new ImageIcon(getClass().
                        getResource("/Game/assets/buttons/menu_playerIconSelection_left1.png")));
            }
            @Override //Goes over the characters for Player Two
            public void mouseClicked(MouseEvent e){
                changinColors(player2_Color, 2, "L");
            }
        });
        
        
        right_arrow2.setIcon(new ImageIcon(getClass(). //Right Arrow Player Two
                getResource("/Game/assets/buttons/menu_playerIconSelection_right1.png")));
        menuPanel.add(right_arrow2, new org.netbeans.lib.
                awtextra.AbsoluteConstraints(925, 550, -1, -1));
        
        right_arrow2.addMouseListener(new MouseAdapter() {
            
            @Override //Mouse off the image
            public void mouseEntered(MouseEvent e){
                right_arrow2.setIcon(new ImageIcon(getClass().
                        getResource("/Game/assets/buttons/menu_playerIconSelection_right2.png")));
            }
            @Override //Mouse on the image
            public void mouseExited(MouseEvent e){
                right_arrow2.setIcon(new ImageIcon(getClass().
                        getResource("/Game/assets/buttons/menu_playerIconSelection_right1.png")));
            }
            @Override //Goes over the characters for Player Two
            public void mouseClicked(MouseEvent e){  
                changinColors(player2_Color, 2, "R");
            }
            
        });
        
        devsButton.setIcon(new ImageIcon(getClass().
                getResource("/Game/assets/buttons/menu_devs_1.png")));
        menuPanel.add(devsButton, new org.netbeans.lib.
                awtextra.AbsoluteConstraints(0, 25, -1, -1));
        devsButton.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseEntered(MouseEvent e){
                devsButton.setIcon(new ImageIcon(getClass().
                        getResource("/Game/assets/buttons/menu_devs_2.png")));
            }
            @Override
            public void mouseExited(MouseEvent e){
                devsButton.setIcon(new ImageIcon(getClass().
                        getResource("/Game/assets/buttons/menu_devs_1.png")));
            }
            @Override
            public void mousePressed(MouseEvent e){  
                devsButton.setIcon(new ImageIcon(getClass().
                        getResource("/Game/assets/buttons/menu_devs_3.png")));
            }
            @Override
            public void mouseClicked(MouseEvent e){  
                menuPanel.getParent().getComponent(0).setVisible(false);
                menuPanel.getParent().getComponent(2).setVisible(true);
            }
            
        });
    }
    /**
     * Changes the player icons. Checks and prevents the players to choose the same
     * player color. Updates the configuration file for the changes that occurred.
     * @param playerIcon
     * @param player
     * @param playerClick
     * @param direction 
     */
    
    //Not used anymore
    private void changePlayerColorIcon(JLabel playerIcon, int player, int playerClick, String direction ){
        //Check which player is changing
        String path = "";
        if(player == 1){
            playerClick = clicks1;
            path = player1ColorPath;
        }
        else if(player == 2){
            path = player2ColorPath;
            playerClick = clicks2;
        }
        updateConfig(player1ColorPath, player2ColorPath);
        //Check direction
        if(direction.equals("left")){
            playerClick--;
        }
        else if(direction.equals("right")){
            playerClick++;
        }
        //Update indexes
        if(player == 1)
            clicks1 = playerClick;
        else if(player == 2)
            clicks2 = playerClick;
        //Check if indexes collide
        if(clicks1 == clicks2)
            if(direction.equals("left")){
                playerClick--;
            }   
            else if(direction.equals("right")){
                playerClick++;
            }
        //Update indexes
        if(player == 1)
            clicks1 = playerClick;
        else if(player == 2)
            clicks2 = playerClick;
        //Update player icon
        if(playerClick == 0){
            playerIcon.setIcon(new ImageIcon(getClass().
                    getResource("/Game/assets/players/player_red.jpg")));
            path = "/Game/assets/players/player_red.jpg";
        }
        else if(playerClick == 1){
            playerIcon.setIcon(new ImageIcon(getClass().
                    getResource("/Game/assets/players/player_blue.jpg")));
            path = "/Game/assets/players/player_blue.jpg";
        }
        else if(playerClick == 2){
            playerIcon.setIcon(new ImageIcon(getClass().
                    getResource("/Game/assets/players/player_green.jpg")));
            path = "/Game/assets/players/player_green.jpg";
        }
        else if(playerClick == 3){
            playerIcon.setIcon(new ImageIcon(getClass().
                    getResource("/Game/assets/players/player_orange.jpg")));
            path = "/Game/assets/players/player_orange.jpg";
        }
        else if(playerClick == 4){
            playerIcon.setIcon(new ImageIcon(getClass().
                    getResource("/Game/assets/players/player_pink.jpg")));
            path = "/Game/assets/players/player_pink.jpg";
        }
        else if(playerClick == 5){
            playerIcon.setIcon(new ImageIcon(getClass().
                    getResource("/Game/assets/players/player_yellow.jpg")));
            path = "/Game/assets/players/player_yellow.jpg";
        }
        else if(playerClick > 5){
            playerClick = 0;
            path = "/Game/assets/players/player_red.jpg";
        }
        else if(playerClick < 0){
            playerClick = 5;
            path = "/Game/assets/players/player_yellow.jpg";
        }
        //Update indexes
        if(player == 1){
            clicks1 = playerClick;
            player1ColorPath = path;
        }
        else if(player == 2){
            clicks2 = playerClick;
            player2ColorPath = path;
        }
        updateConfig(player1ColorPath, player2ColorPath);
        //Update player icon
        if(playerClick == 0){
            playerIcon.setIcon(new ImageIcon(getClass().
                    getResource("/Game/assets/players/player_red.jpg")));
            
        }
        else if(playerClick == 1){
            playerIcon.setIcon(new ImageIcon(getClass().
                    getResource("/Game/assets/players/player_blue.jpg")));
            
        }
        else if(playerClick == 2){
            playerIcon.setIcon(new ImageIcon(getClass().
                    getResource("/Game/assets/players/player_green.jpg")));
            
        }
        else if(playerClick == 3){
            playerIcon.setIcon(new ImageIcon(getClass().
                    getResource("/Game/assets/players/player_orange.jpg")));
            
        }
        else if(playerClick == 4){
            playerIcon.setIcon(new ImageIcon(getClass().
                    getResource("/Game/assets/players/player_pink.jpg")));
            
        }
        else if(playerClick == 5){
            playerIcon.setIcon(new ImageIcon(getClass().
                    getResource("/Game/assets/players/player_yellow.jpg")));
            
        }
        else if(playerClick > 5){
            playerClick = 0;
            
        }
        else if(playerClick < 0){
            playerClick = 5;
            
        }
        System.out.println(clicks1+" "+clicks2+"\n"+player1ColorPath+" "+player2ColorPath+"\n");
        updateConfig(player1ColorPath, player2ColorPath);
        /*
        Because of the limitations of the game engine's, players cannot choose
        player color at the same time.
        The basic idea:
        Because of that limitation we can check easily which player icon is 
        displayed each time. 
        At first, we check which direction (or which button
        was pressed), then we move the player icon index up or down (left is -1 
        and right is +1). 
        After all this we update the indexes stored in the program.
        (WE DO THIS VERY OFTEN). Then we check for the index collision: if there's any
        we just apply the direction check one more time! (up or down)
        At this point we check for the new icon according to the index.
        (special cases: index > 5 and index < 0, which we practically wrap around the
        indexes to 0 or 5 respectively)
        At last we update once more the indexes.
        This code is neither beautiful or efficient, it works well enough to release.
        Bugs yet to see! TODO: Find a better way to do all of this.
                                                                    - Sakis
        */
    }
    /**
     * Updates the configuration file with the new path names.
     * @param p1
     * @param p2 
     */
    void updateConfig(String p1, String p2){
        try{
            FileWriter writer = new FileWriter("src/Game/config.txt");
            writer.write(p1+"\n"+p2);
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    JPanel getMenuComponent(){
        return this.menuPanel;
    }
    
    
    void changinColors(JLabel playerIcon, int player,String direction ){
        if (player == 1){
            if (direction.equals("L")){ 
                clicks1--;
                if (clicks1<0) clicks1=5;
                if (clicks1==clicks2) clicks1--;
                if (clicks1<0) clicks1=5;
            }
            else{ 
                clicks1++;
                if (clicks1>5) clicks1=0;
                if (clicks1==clicks2) clicks1++;
                if (clicks1>5) clicks1=0;
            }
            player1ColorPath = imgPath[clicks1];
        }
        else{
            if (direction.equals("L")){ 
                clicks2--;
                if (clicks2<0) clicks2=5;
                if (clicks1==clicks2) clicks2--;
                if (clicks2<0) clicks2=5;
            }
            else{ 
                clicks2++;
                if (clicks2>5) clicks2=0;
                if (clicks1==clicks2) clicks2++;
                if (clicks2>5) clicks2=0;
            }
            player2ColorPath = imgPath[clicks2];
        }    
        
        updateConfig(player1ColorPath, player2ColorPath);
        
        System.out.println(clicks1+" "+clicks2+"\n"+player1ColorPath+" "+player2ColorPath+"\n");
        
        if (player==1)
            playerIcon.setIcon(new ImageIcon(getClass().getResource(player1ColorPath)));
        else playerIcon.setIcon(new ImageIcon(getClass().getResource(player2ColorPath)));
    }
}
