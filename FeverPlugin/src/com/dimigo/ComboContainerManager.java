package com.dimigo;

import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.ScrollingModel;
import com.intellij.openapi.editor.VisualPosition;
import com.intellij.openapi.editor.event.EditorFactoryAdapter;
import com.intellij.openapi.editor.event.EditorFactoryEvent;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chan_Woo_Kim on 2016-12-22.
 */
public class ComboContainerManager extends EditorFactoryAdapter{
    private Thread thread;
    private Map<Editor, ComboContainer> comboContainers = new HashMap<>();

    public ComboContainerManager() {
//        thread = new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                while (true) {
//                    for (ComboContainer comboContainer : comboContainers.values()) {
//                        comboContainer.updateCombos();
//                    }
//                    try {
//                        Thread.sleep(1000 / 60);
//                    } catch (InterruptedException ignored) {
//                        //thread interrupted, shutdown
//                    }
//                }
//            }
//
//        });
//        thread.start();
    }

    @Override
    public void editorCreated(@NotNull EditorFactoryEvent event) {
        final Editor editor = event.getEditor();
        comboContainers.put(editor, new ComboContainer(editor));
    }

    @Override
    public void editorReleased(@NotNull EditorFactoryEvent event) {
        comboContainers.remove(event.getEditor());
    }

    public void update(final Editor editor) {
        if (FeverMode.getInstance().isEnabled())
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    updateInUI(editor);
                }
            });
    }

    private void updateInUI(Editor editor) {
        VisualPosition visualPosition = editor.getCaretModel().getVisualPosition();
        Point point = editor.visualPositionToXY(visualPosition);
        ScrollingModel scrollingModel = editor.getScrollingModel();
        System.out.println("Before" + point.x + " " + point.y);
        System.out.println("get" + scrollingModel.getHorizontalScrollOffset() + " " + scrollingModel.getVerticalScrollOffset());

        point.x = 1100;
//        point.x = point.x - scrollingModel.getHorizontalScrollOffset();
//        point.y = point.y - scrollingModel.getVerticalScrollOffset();
        point.y = 30;
        System.out.println("After" + point.x + " " + point.y);
        final ComboContainer comboContainer = comboContainers.get(editor);
        if (comboContainer != null) {
            comboContainer.update(point);
        }
    }

    public void dispose() {
        thread.interrupt();
        comboContainers.clear();
    }
}
