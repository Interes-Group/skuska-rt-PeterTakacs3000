package sk.stuba.fei.uim.oop;

import java.awt.*;

public class Tree {
    private int x, y, width, height;
    Color color;

    public Tree(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void paintTree(Graphics g){
        g.setColor(color);
        g.drawOval(x, y, width, (2/3)*height);
        g.drawRect((1/3)*width,(2/3)*height, (2/3)*width, height);
    }
}
