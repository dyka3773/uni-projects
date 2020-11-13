/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quad.Game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * ********** AGNOHSTE O,TI DEITE EDW MESA***********************
 * @author user
 */
public class DropButton extends JButton{
    
    int xLoc;
    JFrame frame;
    static String[][] valueHolder = new String[6][7];

    public DropButton(int xLoc, JFrame frame) {
        this.xLoc = xLoc;
        this.frame = frame;
        setPreferredSize(new Dimension(frame.getWidth()/8,100));
    }
    
    
}
