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
public class MenuPanel {
    private JPanel menuPanel;
    private JLabel gameLogo;
    private JLabel gameStartButton;
    private JLabel player1_Color;
    private JLabel player2_Color;
    private JLabel menuOpenTutorialButton;
    private JLabel left_arrow;
    private JLabel right_arrow;
    private JLabel left_arrow2;
    private JLabel right_arrow2;
    private JLabel players;
    private static int clicks1 = 0;
    private static int clicks2 = 1;
    
    //private String[]


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
                menuPanel.getParent().getComponent(0).setVisible(false); //Menu panel
                menuPanel.getParent().getComponent(2).setVisible(true); //Tutorial panel
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
                menuPanel.getParent().getComponent(2).setVisible(false);
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
                changePlayerColorIcon(player1_Color, 1, clicks1, "left");
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
                changePlayerColorIcon(player1_Color, 1, clicks1, "right");
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
                changePlayerColorIcon(player2_Color, 2, clicks2, "left");
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
                changePlayerColorIcon(player2_Color, 2, clicks2, "right");
            }
            
        });    
    }
    private void changePlayerColorIcon(JLabel playerIcon, int player, int playerClick, String direction){
        //Check which player is changing
        if(player == 1)
            playerClick = clicks1;
        else if(player == 2)
            playerClick = clicks2;
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
        //Update indexes
        if(player == 1)
            clicks1 = playerClick;
        else if(player == 2)
            clicks2 = playerClick;
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
        System.out.println(clicks1+" "+clicks2+"\n");
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
    JPanel getMenuComponent(){
        return this.menuPanel;
    }
}
