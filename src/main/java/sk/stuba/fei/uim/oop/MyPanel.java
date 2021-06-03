package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel extends JPanel implements ActionListener {
    JButton strom = new JButton("Strom");
    JButton presun = new JButton("Presun");
    JButton dalsiaFarba = new JButton("Dalsia farba");
    JLabel vypis = new JLabel("Strom");

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
        vypis.setOpaque(true);
        vypis.setBackground(Color.RED);

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
            vypis.setText("Strom");
        }
        else if(e.getSource() == presun){
            canvas.drawEnabled = false;
            canvas.dragEnabled = true;
            vypis.setText("Presun");
        }
        else if(e.getSource() == dalsiaFarba){
            if(canvas.actualColor < 2) {
                canvas.actualColor++;
            }
            else{
                canvas.actualColor = 0;
            }
            vypis.setBackground(canvas.colors.get(canvas.actualColor));
            repaint();
        }
    }
}
