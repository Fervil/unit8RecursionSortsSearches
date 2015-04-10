import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;

public class TREE extends JFrame{

    public TREE(){
        super("TREE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setVisible(true);
    }

    public void paint(Graphics g){
        super.paint(g);

        g.drawLine(500/2, 500, 500/2, 300);

        drawNode(g,500/2, 300,(float)-20,1,70);

    }

    public void drawNode(Graphics g,int x,int y,float theta,int n,int len){
        if(n>=6)return;

        //for (int i = 0; i < 6; i++) {
        float endPointX1 = x + len * (float)(-1*Math.cos(Math.toRadians(theta)));
        float endPointX2 = x - len * (float)(-1*Math.cos(Math.toRadians(theta)));
        float endPointY = y + len * (float)Math.tan(Math.toRadians(theta));
        g.drawLine(x, y, (int)endPointX1, (int)endPointY);
        g.drawLine(x, y, (int)endPointX2, (int)endPointY);

        drawNode(g,(int)endPointX1, (int)endPointY,theta-4,n+1,len-(new Random()).nextInt(10));
        drawNode(g,(int)endPointX2, (int)endPointY,theta-4,n+1,len-(new Random()).nextInt(10));

    }

    public int toRad(int deg){

        return (int) (deg*(Math.PI/180));
    }

    public int toDeg(int rad){
        return (int) (rad*(180/Math.PI));
    }

    public static void main(String[] args){
        new TREE();
    }

}