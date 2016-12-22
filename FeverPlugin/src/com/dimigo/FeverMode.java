package com.dimigo;

import com.intellij.openapi.Disposable;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.EditorFactory;
import com.intellij.openapi.editor.actionSystem.EditorActionManager;
import com.intellij.openapi.editor.actionSystem.TypedAction;
import com.intellij.openapi.editor.actionSystem.TypedActionHandler;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by Chan_Woo_Kim on 2016-12-22.
 */
@State(
        name = "FeverMode",
        storages = {@Storage(
                file = "$APP_CONFIG$/fever.mode.xml"
        )}
)

public class FeverMode implements ApplicationComponent, PersistentStateComponent<FeverMode> {

    @com.intellij.util.xmlb.annotations.Transient
    private ComboContainerManager comboContainerManager;

    private boolean enabled = true;

    public static FeverMode getInstance() {
        return ApplicationManager.getApplication().getComponent(FeverMode.class);
    }

    @Override
    public void initComponent() {
        final EditorActionManager editorActionManager = EditorActionManager.getInstance();
        final EditorFactory editorFactory = EditorFactory.getInstance();
        comboContainerManager = new ComboContainerManager();
        editorFactory.addEditorFactoryListener(comboContainerManager, new Disposable() {
            @Override
            public void dispose() {

            }
        });
        final TypedAction typedAction = editorActionManager.getTypedAction();
        final TypedActionHandler rawHandler = typedAction.getRawHandler();
        typedAction.setupRawHandler(new TypedActionHandler() {
            @Override
            public void execute(@NotNull Editor editor, char c, @NotNull DataContext dataContext) {
                updateEditor(editor);
                rawHandler.execute(editor, c, dataContext);
            }
        });
    }

    private void updateEditor(@NotNull final Editor editor) {
        //TODO configurable
        comboContainerManager.update(editor);
    }

    @Override
    public void disposeComponent() {
        comboContainerManager.dispose();
        comboContainerManager = null;
    }

    @NotNull
    @Override
    public String getComponentName() {
        return "PowerMode";
    }

    @Nullable
    @Override
    public FeverMode getState() {
        return this;
    }

    @Override
    public void loadState(FeverMode state) {
        XmlSerializerUtil.copyBean(state, this);
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
