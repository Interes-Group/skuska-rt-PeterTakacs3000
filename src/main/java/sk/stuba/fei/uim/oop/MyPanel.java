package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel extends JPanel implements ActionListener {
    JButton strom = new JButton("Strom");
    JButton presun = new JButton("Presun");
    JButton dalsiaFarba = new JButton("Dalsia farba");
    JLabel vypis = new JLabel("Kreslenie: ");

    public MyPanel(){
        super();
        setLayout(new GridBagLayout());
        strom.setPreferredSize(new Dimension(75,30));
        presun.setPreferredSize(new Dimension(75,30));
        dalsiaFarba.setPreferredSize(new Dimension(75,30));
        vypis.setPreferredSize(new Dimension(75,30));
        add(strom);
        add(presun);
        add(dalsiaFarba);
        add(vypis);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
