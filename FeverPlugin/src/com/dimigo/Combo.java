package com.dimigo;

import java.awt.*;

/**
 * Created by Chan_Woo_Kim on 2016-12-22.
 */
public class Combo {

    private static int count = 0;
    private int x;
    private int y;
    private final int dx;
    private final int dy;
    private final int size;
    private int life;
    private final Color c;

    public Combo(int x, int y, int dx, int dy, int size, int life, Color c) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.size = size;
        this.life = life;
        this.c = c;
    }

    public static void resetConut()
    {
        count=0;
    }


    public boolean update() {
        x += dx;
        y += dy;
        life--;
        return life <= 0;
    }

    public void render(Graphics g) {
        if (life > 0) {
            Graphics2D g2d = (Graphics2D) g.create();
            if(count>100) {
                g2d.setColor(Color.RED);
            }
            if(count>200){
                g2d.setColor(Color.MAGENTA);
            }
            g2d.setFont(new Font("Starlight", Font.BOLD, 80));
            g2d.drawString(count++ +"",1100,100);
            ComboContainerManager.time =3000;
            g2d.setColor(c);
            //notify();
           // g2d.fillRect(x - (size / 2), y - (size / 2), size, size);
           // g2d.dispose();
        }
    }

    @Override
    public String toString() {
        return "Particle{" +
                "x=" + x +
                ", y=" + y +
                ", dx=" + dx +
                ", dy=" + dy +
                ", size=" + size +
                ", life=" + life +
                ", c=" + c +
                '}';
    }


}
