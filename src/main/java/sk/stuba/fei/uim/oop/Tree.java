package sk.stuba.fei.uim.oop;

import lombok.Data;

import java.awt.*;

@Data
public class Tree {
    int x, y, width, height;
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
        g.fillOval(x, y, width, (height/3)*2);
        g.fillRect(x+(width/3), y+((height/3))*2, width/3, height/3);
    }
}
