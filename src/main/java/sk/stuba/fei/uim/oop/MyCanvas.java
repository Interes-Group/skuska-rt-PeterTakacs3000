package sk.stuba.fei.uim.oop;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class MyCanvas extends Canvas implements MouseListener, MouseMotionListener {
    public ArrayList<Tree> trees = new ArrayList<>();
    private Tree actualTree;
    int xPos, yPos;

    public MyCanvas() {
        super();
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
        actualTree = new Tree(xPos, yPos, 1, 1, Color.RED);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        trees.add(actualTree);
        repaint();
        actualTree = null;
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
            actualTree.setWidth(e.getX() - xPos);
            actualTree.setHeight(e.getY() - yPos);
            repaint();
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
