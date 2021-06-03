package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class MyCanvas extends Canvas implements MouseListener, MouseMotionListener{
    public ArrayList<Tree> trees = new ArrayList<>();
    ArrayList<Color> colors = new ArrayList<>();
    Tree actualTree;
    int xPos, yPos;
    boolean drag = false;
    public boolean dragEnabled = false;
    public boolean drawEnabled = false;
    public int actualColor = 0;

    JButton strom = new JButton("Strom");
    JButton presun = new JButton("Presun");
    JButton dalsiaFarba = new JButton("Dalsia farba");
    JLabel vypis = new JLabel("Kreslenie: ");

    public MyCanvas() {
        super();
        colors.add(Color.RED);
        colors.add(Color.BLUE);
        colors.add(Color.GREEN);
        addMouseListener(this);
        addMouseMotionListener(this);
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        xPos = e.getX();
        yPos = e.getY();

        for(Tree t : trees){
            if((xPos > t.getX()) && (yPos > t.getY())){
                if((xPos < t.getX()+t.getWidth()) && (yPos < t.getY()+t.getHeight())){
                    if(dragEnabled) {
                        drag = true;
                        actualTree = t;
                    }
                }
            }
        }
        if(!drag && drawEnabled){
            actualTree = new Tree(xPos, yPos, 1, 1, colors.get(actualColor));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(!drag && actualTree != null) {
            trees.add(actualTree);
        }
        if(actualTree != null) {
            repaint();
        }
        actualTree = null;
        drag = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(actualTree != null){
            if(drag){
                actualTree.setX(e.getX());
                actualTree.setY(e.getY());
                repaint();
            }
            else if(drawEnabled) {
                actualTree.setWidth(e.getX() - xPos);
                actualTree.setHeight(e.getY() - yPos);
                repaint();
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public void paint(Graphics g){
        for(Tree t : trees){
            t.paintTree(g);
        }
        if(actualTree != null){
            actualTree.paintTree(g);
        }
    }
}
