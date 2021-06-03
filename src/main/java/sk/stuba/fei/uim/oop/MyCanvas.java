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
    private boolean drag = false;

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
        for(Tree t : trees){
            if((xPos > t.getX()) && (yPos > t.getY())){
                if((xPos < t.getX()+t.getWidth()) && (yPos < t.getY()+t.getHeight())){
                    drag = true;
                    actualTree = t;
                }
            }
        }
        if(!drag){
            actualTree = new Tree(xPos, yPos, 1, 1, Color.RED);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(!drag) {
            trees.add(actualTree);
        }
        repaint();
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
            else {
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
