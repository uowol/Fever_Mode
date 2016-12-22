package com.dimigo;

import com.intellij.openapi.options.ConfigurableUi;
import com.intellij.openapi.options.ConfigurationException;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * Created by Chan_Woo_Kim on 2016-12-22.
 */
public class FeverModeConfigurableUI implements ConfigurableUi<FeverMode> {
    private JCheckBox feverCheckBox;
    private JPanel mainPanel;
    public FeverModeConfigurableUI(FeverMode FeverMode){
        feverCheckBox.setSelected(FeverMode.isEnabled());
    }


    @Override
    public void reset(@NotNull FeverMode FeverMode) {
        feverCheckBox.setSelected(FeverMode.isEnabled());
    }

    @Override
    public boolean isModified(@NotNull FeverMode FeverMode) {
        return feverCheckBox.isSelected() != FeverMode.isEnabled();
    }

    @Override
    public void apply(@NotNull FeverMode FeverMode) throws ConfigurationException {
        FeverMode.setEnabled(feverCheckBox.isSelected());
    }

    @NotNull
    @Override
    public JComponent getComponent() {
        return mainPanel;
    }
}
