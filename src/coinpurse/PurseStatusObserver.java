package coinpurse;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by PaiizZ on 4/21/2017 AD.
 */
public class PurseStatusObserver extends JFrame implements Observer {
    private static final int FONT_SIZE = 40;
    private JTextArea textArea;
    private JProgressBar jProgressBar;

    public PurseStatusObserver(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents(){
        textArea = new JTextArea(1,5);
        textArea.setFont( new Font(Font.DIALOG,Font.PLAIN,FONT_SIZE ));
//        JScrollPane scrollPane = new JScrollPane(textArea);
//        scrollPane.setVerticalScrollBarPolicy();
        jProgressBar = new JProgressBar(0,10);
        this.add(textArea,BorderLayout.NORTH);
        this.add(jProgressBar,BorderLayout.SOUTH);
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
            if ( purse.isFull()){
                textArea.setText("FULL");
            }
            else {
                textArea.setText(purse.count()+"/"+purse.getCapacity());
            }
            jProgressBar.setValue(purse.count());
        }
    }
}
