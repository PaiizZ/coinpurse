package coinpurse;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by PaiizZ on 4/21/2017 AD.
 */
public class PurseBalanceObserver extends JFrame implements Observer {
    private static final int FONT_SIZE = 40;
    private JTextArea textArea;

    public PurseBalanceObserver(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents(){
        textArea = new JTextArea(1,5);
        textArea.setFont( new Font(Font.DIALOG,Font.PLAIN,FONT_SIZE ));
//        JScrollPane scrollPane = new JScrollPane(textArea);
//        scrollPane.setVerticalScrollBarPolicy();
        this.add(textArea);
        this.pack();
    }

    public void run(){
        initComponents();
        this.setVisible(true);
    }

    @Override
    public void update(Observable subject, Object info) {
//        if (info != null)  textArea.append(info+"\n");
        if (subject instanceof Purse){
            Purse purse = (Purse) subject;
            textArea.setText((int)purse.getBalance()+" Baht");
        }
    }
}
