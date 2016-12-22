package com.pabix.flowermode;

import com.intellij.openapi.options.ConfigurableUi;
import com.intellij.openapi.options.ConfigurationException;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * Created by Chan_Woo_Kim on 2016-12-21.
 */
public class FlowerModeConfigurableUI implements ConfigurableUi<FlowerMode> {
    private JPanel mainPanel;
    private JCheckBox flowerModeEnabled;

    public FlowerModeConfigurableUI(FlowerMode flowerMode){
        flowerModeEnabled.setSelected(flowerMode.isEnabled());
    }


    @Override
    public void reset(@NotNull FlowerMode flowerMode) {
        flowerModeEnabled.setSelected(flowerMode.isEnabled());
    }

    @Override
    public boolean isModified(@NotNull FlowerMode flowerMode) {
        return flowerModeEnabled.isSelected() != flowerMode.isEnabled();
    }

    @Override
    public void apply(@NotNull FlowerMode flowerMode) throws ConfigurationException {
        flowerMode.setEnabled(flowerModeEnabled.isSelected());
    }

    @NotNull
    @Override
    public JComponent getComponent() {
        return mainPanel;
    }
}
