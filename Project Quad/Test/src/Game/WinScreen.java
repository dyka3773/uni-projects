package Game;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Sakis
 */
public class WinScreen {
    private JPanel winScreen;
    private JLabel winnerBackground;
    private JLabel retryButton;
    private JLabel quitButton;
    public WinScreen(){
        
    }
    public JPanel getWinScreenComponent(){
        return winScreen;
    }
}
