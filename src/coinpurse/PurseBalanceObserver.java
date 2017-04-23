package coinpurse;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Graphic user interface to show the balance of item in purse.
 *
 * @author Wanchanapon Thanwaranurak
 * @version 4/21/2017
 */
public class PurseBalanceObserver extends JFrame implements Observer {
    /**
     * Size of font that show in GUI
     */
    private static final int FONT_SIZE = 40;
    /**
     * The label to show balance.
     */
    private JLabel labelBalance;

    /**
     * Constructor for PurseBalanceObserver.
     */
    public PurseBalanceObserver() {
        super.setTitle("Purse Balance");
        setBounds(0, 10, 800, 600);
        super.setResizable(false);
        super.setSize(250, 90);
        initComponents();
    }

    /**
     * Components for GUI.
     */
    private void initComponents() {
        JPanel paneBalance = new JPanel();
        labelBalance = new JLabel("0 Baht", JLabel.CENTER);
        labelBalance.setFont(new Font(Font.DIALOG, Font.PLAIN, FONT_SIZE));
        paneBalance.add(labelBalance);
        super.add(paneBalance);
    }

    /**
     * Run this GUI.
     */
    public void run() {
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * For update the balance of this purse.
     */
    @Override
    public void update(Observable subject, Object info) {
        if (info != null) System.out.println(info);
        if (subject instanceof Purse) {
            Purse purse = (Purse) subject;
            labelBalance.setText((int) purse.getBalance() + " Baht");
        }
    }
}
