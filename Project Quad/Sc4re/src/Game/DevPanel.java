/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class DevPanel {
    private JPanel devPanel;
    private JLabel devCloseButton;
    private JLabel devBackground;
    public DevPanel() {
        devPanel = new JPanel();
        devCloseButton = new JLabel();
        devBackground = new JLabel();
        
        devPanel.setBackground(new Color(162, 192, 242));
        devPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        devCloseButton.setIcon(new ImageIcon(getClass().getResource("/Game/assets/buttons/opt_closeOpt_1.png")));
        devPanel.add(devCloseButton, new org.netbeans.lib.
                awtextra.AbsoluteConstraints(15, 15, -1, -1));
        devCloseButton.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseEntered(MouseEvent e){
                devCloseButton.setIcon(new ImageIcon(getClass().
                        getResource("/Game/assets/buttons/opt_closeOpt_2.png")));
            }
            @Override
            public void mouseExited(MouseEvent e){
                devCloseButton.setIcon(new ImageIcon(getClass().
                        getResource("/Game/assets/buttons/opt_closeOpt_1.png")));
            }
            @Override
            public void mouseClicked(MouseEvent e){  
                devPanel.getParent().getComponent(0).setVisible(true);
                devPanel.setVisible(false);
            }
            
        });
        devBackground.setIcon(new ImageIcon(getClass().
                getResource("/Game/assets/general/super_secret.png")));
        devPanel.add(devBackground, new org.netbeans.lib.
                awtextra.AbsoluteConstraints(100, 25, -1, -1));
        devPanel.setVisible(false);
    }
    
    public JPanel getDevComponent(){
        return devPanel;
    }
    
}
