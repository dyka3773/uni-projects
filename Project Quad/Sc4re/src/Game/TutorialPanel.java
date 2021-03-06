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
public class TutorialPanel {
    private JPanel tutorialPanel;
    private JLabel tutorialButton;
    private JLabel tutorialBackground;
    
    public TutorialPanel(){
        tutorialPanel = new JPanel();
        tutorialButton = new JLabel();
        tutorialBackground = new JLabel();
        
        tutorialPanel.setBackground(new Color(162, 192, 242));
        tutorialPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        tutorialButton.setIcon(new ImageIcon(getClass().
                getResource("/Game/assets/buttons/tutorial_okBtn_1.png")));
        tutorialPanel.add(tutorialButton, new org.netbeans.lib.
                awtextra.AbsoluteConstraints(10, 650, -1, -1));
        
        tutorialBackground.setIcon(new ImageIcon(getClass().
                getResource("/Game/assets/general/tutorial_book.png")));
        tutorialPanel.add(tutorialBackground, new org.netbeans.
                lib.awtextra.AbsoluteConstraints(65, 10, -1, -1));
        tutorialPanel.setVisible(false);
        
        tutorialButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                tutorialPanel.getParent().getComponent(0).setVisible(true);
                tutorialPanel.setVisible(false);
            }
            @Override
            public void mousePressed(MouseEvent e){
                tutorialButton.setIcon(new ImageIcon(getClass().
                        getResource("/Game/assets/buttons/tutorial_okBtn_2.png")));     //Button image missing
            }
            @Override
            public void mouseReleased(MouseEvent e){
                tutorialButton.setIcon(new ImageIcon(getClass().
                        getResource("/Game/assets/buttons/tutorial_okBtn_1.png")));     //Button image missing
            }
        });
    }
    JPanel getTutorialComponent(){
        return this.tutorialPanel;
    }
}
