package coinpurse;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Graphic user interface to show the status of item in purse.
 *
 * @author Wanchanapon Thanwaranurak
 * @version 4/21/2017
 */
public class PurseStatusObserver extends JFrame implements Observer {
    /**
     * Size of font that show in GUI
     */
    private static final int FONT_SIZE = 40;
    /**
     * The label to show status.
     */
    private JLabel labelStatus;
    /**
     * ProgressBar to show bar by percent of item.
     */
    private JProgressBar jProgressBar;

    /**
     * Constructor for PurseStatusObserver.
     */
    public PurseStatusObserver() {
        super.setTitle("Purse Status");
        setBounds(0, 150, 800, 600);
        super.setResizable(false);
        super.setSize(250, 90);
        initComponents();
    }

    /**
     * Componets for GUI.
     */
    private void initComponents() {
        JPanel panelStatus = new JPanel();
        panelStatus.setLayout(new BoxLayout(panelStatus, BoxLayout.Y_AXIS));
        labelStatus = new JLabel("EMPTY", JLabel.CENTER);
        labelStatus.setFont(new Font(Font.DIALOG, Font.PLAIN, FONT_SIZE));
        jProgressBar = new JProgressBar(0, 10);
        panelStatus.add(labelStatus);
        panelStatus.add(jProgressBar);
        super.add(panelStatus);
    }

    /**
     * Run this GUI.
     */
    public void run() {
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * For update the status of this purse.
     */
    @Override
    public void update(Observable subject, Object info) {
        if (info != null) System.out.println(info);
        if (subject instanceof Purse) {
            Purse purse = (Purse) subject;
            if (purse.count() == 0) {
                labelStatus.setText("EMPTY");
            } else if (purse.isFull()) {
                labelStatus.setText("FULL");
            } else {
                labelStatus.setText(purse.count() + "");
            }
            jProgressBar.setValue(purse.count());
        }
    }
}
