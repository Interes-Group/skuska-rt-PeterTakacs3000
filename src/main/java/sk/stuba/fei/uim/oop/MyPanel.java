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

    MyCanvas canvas;

    public MyPanel(MyCanvas canvas){
        super();
        this.canvas = canvas;
        setLayout(new GridBagLayout());
        strom.setPreferredSize(new Dimension(75,30));
        presun.setPreferredSize(new Dimension(75,30));
        dalsiaFarba.setPreferredSize(new Dimension(75,30));
        vypis.setPreferredSize(new Dimension(75,30));
        strom.addActionListener(this);
        presun.addActionListener(this);
        dalsiaFarba.addActionListener(this);

        add(strom);
        add(presun);
        add(dalsiaFarba);
        add(vypis);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == strom){
            canvas.drawEnabled = true;
            canvas.dragEnabled = false;
        }
        else if(e.getSource() == presun){
            canvas.drawEnabled = false;
            canvas.dragEnabled = true;
        }
        else if(e.getSource() == dalsiaFarba){

        }
    }
}
