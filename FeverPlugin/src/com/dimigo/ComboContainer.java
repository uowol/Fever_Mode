package com.dimigo;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.editor.Editor;
import com.intellij.ui.JBColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Chan_Woo_Kim on 2016-12-22.
 */
public class ComboContainer extends JComponent implements ComponentListener {

    private final JComponent parent;
    private final Editor editor;
//    private boolean shakeDir;
    private ArrayList<Combo> combos = new ArrayList<>();

    public ComboContainer(Editor editor) {
        this.editor = editor;
        parent = this.editor.getContentComponent();
        parent.add(this);
        updateBounds();
        setVisible(true);
        parent.addComponentListener(this);
    }

//    private void shakeEditor(JComponent parent, int dx, int dy, boolean dir) {
//        final Rectangle bounds = parent.getBounds();
//        parent.setBounds(bounds.x + (dir ? -dx : dx), bounds.y + (dir ? -dy : dy), bounds.width, bounds.height);
//    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        renderCombos(g);
    }

    public void updateCombos() {
//        if (!combos.isEmpty()) {
//            ArrayList<Combo> tempCombos = new ArrayList<>(combos);
//            final Iterator<Combo> particleIterator = tempCombos.iterator();
//            while (particleIterator.hasNext()) {
//                if (particleIterator.next().update()) {
//                    particleIterator.remove();
//                }
//            }
//            combos = tempCombos;
        combos = new ArrayList<>();
        addCombo(1100, 100);
        this.repaint();
//        }

    }

    public void addCombo(int x, int y) {
        //TODO configurable
        int dx, dy;
        dx = (int) (Math.random() * 4) * (Math.random() > 0.5 ? -1 : 1);
        dy = (int) (Math.random() * -3 - 1);

        int size = (int) (Math.random() * 3 + 1);
        int life = 15;
        final Combo e = new Combo(x, y, dx, dy, size, life, JBColor.darkGray);
        combos.add(e);
    }

    public void renderCombos(Graphics g) {
        for (Combo combo : combos) {
            combo.render(g);
            System.out.println("꺄하하하하하하하");
        }
        combos = new ArrayList<>();
    }

    public void update(Point point) {
        //TODO configurable
//        for (int i = 0; i < 1; i++) {
//            addCombo(point.x, point.y);
//            System.err.println(point.x + " " + point.y);
//        }
//        shakeEditor(parent, 5, 5, shakeDir);
//        shakeDir = !shakeDir;
        addCombo(point.x, point.y);
        this.repaint();
    }

    @Override
    public void componentResized(ComponentEvent e) {
        updateBounds();

        Logger.getInstance(this.getClass()).info("Resized");

    }

    private void updateBounds() {
        ComboContainer.this.setBounds(editor.getScrollingModel().getVisibleArea().getBounds());
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        updateBounds();
        Logger.getInstance(this.getClass()).info("Moved");

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }
}
