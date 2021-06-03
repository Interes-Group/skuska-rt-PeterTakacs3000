package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame(){
        MyCanvas canvas = new MyCanvas();
        MyPanel panel = new MyPanel();
        setSize(500, 500);
        setVisible(true);
        setLayout(new BorderLayout());
        add(canvas, BorderLayout.CENTER);
        add(panel, BorderLayout.PAGE_END);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
