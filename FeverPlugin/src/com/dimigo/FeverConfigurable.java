package com.dimigo;

import com.intellij.openapi.options.ConfigurableUi;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Chan_Woo_Kim on 2016-12-22.
 */
public class FeverConfigurable extends ConfigurableUi<>{
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
