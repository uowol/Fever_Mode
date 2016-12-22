package com.dimigo;

import java.awt.*;

/**
 * Created by Chan_Woo_Kim on 2016-12-22.
 */
public class Combo {

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

    public boolean update() {
        x += dx;
        y += dy;
        life--;
        return life <= 0;
    }

    public void render(Graphics g) {
        if (life > 0) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(c);
            g2d.fillRect(x - (size / 2), y - (size / 2), size, size);
            g2d.dispose();
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
