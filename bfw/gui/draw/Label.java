package bfw.gui.draw;

import java.awt.Graphics;
import java.awt.Color;

import javax.swing.JPanel;

public class Label extends JPanel{
    
    public Graphics button(Graphics g2d, LabelType labelType, int x, int y, int width, int height){
        
        if (labelType == LabelType.Rounded_LEFT){
        g2d = roundedL(g2d, x, y, width, height);
        } else if (labelType == LabelType.Rounded_RIGHT){
            g2d = roundedR(g2d, x, y, width, height);
        } else if (labelType == LabelType.Rounded_BOTH){
            g2d = roundedB(g2d, x, y, width, height);
        } else if (labelType == LabelType.Mark_OUT){
            g2d = markO(g2d, x, y, width, height);
        } else if (labelType == LabelType.Mark_IN){
            g2d = markI(g2d, x, y, width, height);
        } 

        return g2d;
    }

    public Graphics button(Graphics g2d, LabelType labelType, int x, int y, int width, int height, Color A, Color B){
        
        if (labelType == LabelType.Rounded_LEFT){
        g2d = roundedL(g2d, x, y, width, height);
        } else if (labelType == LabelType.Rounded_RIGHT){
            g2d = roundedR(g2d, x, y, width, height);
        } else if (labelType == LabelType.Rounded_BOTH){
            g2d = roundedB(g2d, x, y, width, height);
        } else if (labelType == LabelType.Mark_OUT){
            g2d = markO(g2d, x, y, width, height, A, B);
        } else if (labelType == LabelType.Mark_IN){
            g2d = markI(g2d, x, y, width, height, A, B);
        } 

        return g2d;
    }

    public Graphics roundedL(Graphics g2d, int x, int y, int width, int height){

        g2d.fillRect(x, y, width, height);
        g2d.fillOval(x - x / 2, y - 1, width, height + 1);

        return g2d;
    }

    public Graphics roundedR(Graphics g2d, int x, int y, int width, int height){

        g2d.fillRect(x, y, width, height);
        g2d.fillOval(x + x / 2, y - 1, width, height + 1);

        return g2d;
    }

    public Graphics roundedB(Graphics g2d, int x, int y, int width, int height){

        g2d.fillRect(x, y, width, height);
        g2d.fillOval(x - x / 2, y - 1, width, height + 1);
        g2d.fillOval(x + x / 2, y - 1, width, height + 1);

        return g2d;
    }

    public Graphics markO(Graphics g2d, int x, int y, int width, int height){

        g2d.fillRect(x, y, width, height / 15);
        g2d.fillArc(x, y - (height / 12), width, height / 4, 180, 180);
        g2d.fillRect(x + (width/10), y, width - (width/5), height);
        g2d.fillPolygon(new int[] {x + width / 10, x + width / 2, x + width - width / 10}, new int[] {y + height, y + height / 10 * 14, y + height}, 3);
        

        return g2d;
    }

    public Graphics markO(Graphics g2d, int x, int y, int width, int height, Color A, Color B){

        g2d.setColor(A);
        g2d.fillRect(x, y, width, height / 15);
        g2d.fillArc(x, y - (height / 12), width, height / 4, 180, 180);
        g2d.setColor(B);
        g2d.fillRect(x + (width/10), y, width - (width/5), height);
        g2d.fillPolygon(new int[] {x + width / 10, x + width / 2, x + width - width / 10}, new int[] {y + height, y + height / 10 * 14, y + height}, 3);  

        return g2d;
    }

    public Graphics markI(Graphics g2d, int x, int y, int width, int height){

        g2d.fillRect(x, y, width, height / 15);
        g2d.fillArc(x, y - (height / 12), width, height / 4, 180, 180);
        g2d.fillRect(x + (width/10), y, width - (width/5), height / 100 * 60);
        g2d.fillPolygon(new int[] {x + width / 10, x + width / 2, x + width / 10}, new int[] {y + height / 10, y + height / 10 * 6, y + height}, 3);
        g2d.fillPolygon(new int[] {x + width - width / 10, x + width / 2, x + width - width / 10}, new int[] {y + height / 10, y + height / 10 * 6, y + height}, 3);
        

        return g2d;
    }

    public Graphics markI(Graphics g2d, int x, int y, int width, int height, Color A, Color B){

        g2d.setColor(A);
        g2d.fillRect(x, y, width, height / 15);
        g2d.fillArc(x, y - (height / 12), width, height / 4, 180, 180);
        g2d.setColor(B);
        g2d.fillRect(x + (width/10), y, width - (width/5), height / 100 * 60);
        g2d.fillPolygon(new int[] {x + width / 10, x + width / 2, x + width / 10}, new int[] {y + height / 10, y + height / 10 * 6, y + height}, 3);
        g2d.fillPolygon(new int[] {x + width - width / 10, x + width / 2, x + width - width / 10}, new int[] {y + height / 10, y + height / 10 * 6, y + height}, 3);  

        return g2d;
    }

}