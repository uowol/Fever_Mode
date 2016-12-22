package com.pabix.flowermode;

import com.intellij.openapi.options.ConfigurableBase;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Chan_Woo_Kim on 2016-12-21.
 */
public class FlowerModeConfigurable extends ConfigurableBase<FlowerModeConfigurableUI, FlowerMode> {
    private final FlowerMode settings;

    public FlowerModeConfigurable(@NotNull FlowerMode settings) {
        super("Flower.mode", "Flower mode", "Flower.mode");
        this.settings = settings;
    }
    public FlowerModeConfigurable() {
        this(FlowerMode.getInstance());
    }

    @NotNull
    @Override
    protected FlowerMode getSettings() {
        if (settings == null) {
            throw new IllegalStateException("Flower mode is null");
        }
        return settings;
    }

    @Override
    protected FlowerModeConfigurableUI createUi() {
        return new FlowerModeConfigurableUI(settings);
    }

}
