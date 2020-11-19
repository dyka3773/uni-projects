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
    private JLabel menuOpenGameButton;
    private JLabel left_arrow;
    private JLabel right_arrow;
    private JLabel left_arrow2;
    private JLabel right_arrow2;
    private JLabel players;
    private static int clicks1 = 0;
    private static int clicks2 = 0;




    
    public MenuPanel(){
        menuPanel = new JPanel();
        gameLogo = new JLabel();
        gameStartButton = new JLabel();
        player1_Color = new JLabel();
        player2_Color = new JLabel();
        menuOpenTutorialButton = new JLabel();
        menuOpenGameButton = new JLabel();
        players = new JLabel();
        left_arrow = new JLabel();
        right_arrow = new JLabel();
        left_arrow2 = new JLabel();
        right_arrow2 = new JLabel();
        
        menuPanel.setBackground(new Color(162, 192, 242));
        menuPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        //new Logo entered
        gameLogo.setIcon(new ImageIcon(getClass().
                getResource("/Game/imgs/logo.png"))); 
        menuPanel.add(gameLogo, new org.netbeans.lib.
                awtextra.AbsoluteConstraints(120, 50, -1, -1));
        
        
        //Play the Game Button
        menuOpenGameButton.setIcon(new ImageIcon(getClass(). 
                getResource("/Game/imgs/Play_blank.jpg")));
        menuPanel.add(menuOpenGameButton, new org.netbeans.lib.
                awtextra.AbsoluteConstraints(230, 385, -1, -1));

        menuOpenGameButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                menuOpenGameButton.setIcon(new ImageIcon(getClass().
                        getResource("/Game/imgs/Play_over.jpg")));
            }
            @Override
            public void mouseExited(MouseEvent e){ 
                menuOpenGameButton.setIcon(new ImageIcon(getClass().
                        getResource("/Game/imgs/Play_blank.jpg")));
            }
            
            // The path to the GamePanel
            /*@Override
            public void mouseClicked(MouseEvent e){
                if (player1_Color == player2_Color)
                {
                    The players have the same character;
                }
                else
                {
                menuOpenTutorialButton.setIcon(new ImageIcon(getClass().
                        getResource("/Game/imgs/Play_over.jpg")));
                menuPanel.getParent().getComponent(0).setVisible(false);
                menuPanel.getParent().getComponent(1).setVisible(true);
                }
            
            } */
                    //Will be fixed when the game panel is ok
        });
            
        
        //Tutorial Button
        menuOpenTutorialButton.setIcon(new ImageIcon(getClass(). 
                getResource("/Game/imgs/menu_tutorial_s1.png")));
        menuPanel.add(menuOpenTutorialButton, new org.netbeans.lib.
                awtextra.AbsoluteConstraints(750, 0, -1, -1));
        
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
        
        
        //Player One and Player Two above the choices
        players.setIcon(new ImageIcon(getClass(). 
                getResource("/Game/imgs/players_tr.png")));
        menuPanel.add(players, new org.netbeans.lib.
                awtextra.AbsoluteConstraints(-15, 480, -1, -1));
        
        
        //Color of Player One
        player1_Color.setIcon(new ImageIcon(getClass(). 
                getResource("/Game/imgs/red.jpg")));
        menuPanel.add(player1_Color, new org.netbeans.lib.
                awtextra.AbsoluteConstraints(55, 525, -1, -1));
        
        //Left Arrow Player One
        left_arrow.setIcon(new ImageIcon(getClass(). 
                getResource("/Game/imgs/left_blank.png")));
        menuPanel.add(left_arrow, new org.netbeans.lib.
                awtextra.AbsoluteConstraints(0, 550, -1, -1));
        
        left_arrow.addMouseListener(new MouseAdapter() { 
            @Override //Mouse off the image
            public void mouseEntered(MouseEvent e){
                left_arrow.setIcon(new ImageIcon(getClass().
                        getResource("/Game/imgs/left_over.png")));
            }
            @Override //Mouse over the image
            public void mouseExited(MouseEvent e){
                left_arrow.setIcon(new ImageIcon(getClass().
                        getResource("/Game/imgs/left_blank.png")));
            }
            @Override //Goes over the characters for Player One
            public void mouseClicked(MouseEvent e){
                System.out.println(clicks1);     //Debug Comment
                if (clicks1 == 1)
                    {
                    player1_Color.setIcon(new ImageIcon(getClass().
                    getResource("/Game/imgs/blue.jpg")));
                    }
                else if(clicks1 == 2)
                    {
                    player1_Color.setIcon(new ImageIcon(getClass().
                    getResource("/Game/imgs/green.jpg")));
                    }
                else if (clicks1 == 3)
                    {
                    player1_Color.setIcon(new ImageIcon(getClass().
                    getResource("/Game/imgs/orange.jpg")));
                    }
                else if(clicks1 == 4)
                    {
                    player1_Color.setIcon(new ImageIcon(getClass().
                    getResource("/Game/imgs/pink.jpg")));
                    }
                else if (clicks1 >= 5)
                    {
                    player1_Color.setIcon(new ImageIcon(getClass().
                    getResource("/Game/imgs/yellow.jpg")));
                    clicks1 = 0;
                    }   
                else if (clicks1 == 0)
                    {
                    player1_Color.setIcon(new ImageIcon(getClass().
                    getResource("/Game/imgs/red.jpg")));
                    } 
                clicks1++;
            }
        });
        
        //Right Arrow Player One
        right_arrow.setIcon(new ImageIcon(getClass(). 
                getResource("/Game/imgs/right_blank.png")));
        menuPanel.add(right_arrow, new org.netbeans.lib.
                awtextra.AbsoluteConstraints(280, 550, -1, -1));
        
        right_arrow.addMouseListener(new MouseAdapter() {
            @Override //Mouse off the image
            public void mouseEntered(MouseEvent e){
                right_arrow.setIcon(new ImageIcon(getClass().
                        getResource("/Game/imgs/right_over.png")));
            }
            @Override //Mouse on the image
            public void mouseExited(MouseEvent e){
                right_arrow.setIcon(new ImageIcon(getClass().
                        getResource("/Game/imgs/right_blank.png")));
            }
            @Override //Goes over the characters for Player One
            public void mouseClicked(MouseEvent e){
                System.out.println(clicks1);       //Debug comment
                if (clicks1 == 0)
                    {
                    player1_Color.setIcon(new ImageIcon(getClass().
                    getResource("/Game/imgs/blue.jpg")));
                    }
                else if(clicks1 == 1)
                    {
                    player1_Color.setIcon(new ImageIcon(getClass().
                    getResource("/Game/imgs/green.jpg")));
                    }
                else if (clicks1 == 2)
                    {
                    player1_Color.setIcon(new ImageIcon(getClass().
                    getResource("/Game/imgs/orange.jpg")));
                    }
                else if(clicks1 == 3)
                    {
                    player1_Color.setIcon(new ImageIcon(getClass().
                    getResource("/Game/imgs/pink.jpg")));
                    }
                else if (clicks1 == 4)
                    {
                    player1_Color.setIcon(new ImageIcon(getClass().
                    getResource("/Game/imgs/yellow.jpg")));
                    }   
                else if (clicks1 < 0)
                    {
                    player1_Color.setIcon(new ImageIcon(getClass().
                    getResource("/Game/imgs/red.jpg")));
                    clicks1 = 5;
                    } 
                clicks1--;
            }
        });        
        
        
        //Color of Player Two
        player2_Color.setIcon(new ImageIcon(getClass(). 
                getResource("/Game/imgs/blue.jpg")));
        menuPanel.add(player2_Color, new org.netbeans.lib.
                awtextra.AbsoluteConstraints(700, 525, -1, -1));
        
        //Left Arrow Player Two
        left_arrow2.setIcon(new ImageIcon(getClass(). 
                getResource("/Game/imgs/left_blank.png")));
        menuPanel.add(left_arrow2, new org.netbeans.lib.
                awtextra.AbsoluteConstraints(645, 550, -1, -1));
        
        left_arrow2.addMouseListener(new MouseAdapter() { 
            @Override // Mouse of the image
            public void mouseEntered(MouseEvent e){
                left_arrow2.setIcon(new ImageIcon(getClass().
                        getResource("/Game/imgs/left_over.png")));
            }
            @Override //Mouse on the image
            public void mouseExited(MouseEvent e){
                left_arrow2.setIcon(new ImageIcon(getClass().
                        getResource("/Game/imgs/left_blank.png")));
            }
            @Override //Goes over the characters for Player Two
            public void mouseClicked(MouseEvent e){
                if (clicks2 == 1)
                    {
                    player2_Color.setIcon(new ImageIcon(getClass().
                    getResource("/Game/imgs/green.jpg")));
                    }
                else if(clicks2 == 2)
                    {
                    player2_Color.setIcon(new ImageIcon(getClass().
                    getResource("/Game/imgs/orange.jpg")));
                    }
                else if (clicks2 == 3)
                    {
                    player2_Color.setIcon(new ImageIcon(getClass().
                    getResource("/Game/imgs/pink.jpg")));
                    }
                else if(clicks2 == 4)
                    {
                    player2_Color.setIcon(new ImageIcon(getClass().
                    getResource("/Game/imgs/yellow.jpg")));
                    }
                else if (clicks2 >= 5)
                    {
                    player2_Color.setIcon(new ImageIcon(getClass().
                    getResource("/Game/imgs/red.jpg")));
                    clicks2 = 0;
                    }   
                else if (clicks2 == 0)
                    {
                    player2_Color.setIcon(new ImageIcon(getClass().
                    getResource("/Game/imgs/blue.jpg")));
                    } 
                clicks2++;
            }
        });
        
        
        right_arrow2.setIcon(new ImageIcon(getClass(). //Right Arrow Player Two
                getResource("/Game/imgs/right_blank.png")));
        menuPanel.add(right_arrow2, new org.netbeans.lib.
                awtextra.AbsoluteConstraints(925, 550, -1, -1));
        
        right_arrow2.addMouseListener(new MouseAdapter() {
            
            @Override //Mouse off the image
            public void mouseEntered(MouseEvent e){
                right_arrow2.setIcon(new ImageIcon(getClass().
                        getResource("/Game/imgs/right_over.png")));
            }
            @Override //Mouse on the image
            public void mouseExited(MouseEvent e){
                right_arrow2.setIcon(new ImageIcon(getClass().
                        getResource("/Game/imgs/right_blank.png")));
            }
            @Override //Goes over the characters for Player Two
            public void mouseClicked(MouseEvent e){ 
                if (clicks2 == 0)
                    {
                    player2_Color.setIcon(new ImageIcon(getClass().
                    getResource("/Game/imgs/blue.jpg")));
                    }
                else if(clicks2 == 1)
                    {
                    player2_Color.setIcon(new ImageIcon(getClass().
                    getResource("/Game/imgs/green.jpg")));
                    }
                else if (clicks2 == 2)
                    {
                    player2_Color.setIcon(new ImageIcon(getClass().
                    getResource("/Game/imgs/orange.jpg")));
                    }
                else if(clicks2 == 3)
                    {
                    player2_Color.setIcon(new ImageIcon(getClass().
                    getResource("/Game/imgs/pink.jpg")));
                    }
                else if (clicks2 == 4)
                    {
                    player2_Color.setIcon(new ImageIcon(getClass().
                    getResource("/Game/imgs/yellow.jpg")));
                    }   
                else if (clicks2 < 0)
                    {
                    player2_Color.setIcon(new ImageIcon(getClass().
                    getResource("/Game/imgs/red.jpg")));
                    clicks2=4;
                    } 
                clicks2--;
            }
            
        });
        
        

        
        
    }
    JPanel getMenuComponent(){
        return this.menuPanel;
    }
}
