package com.dimigo;

import com.intellij.openapi.options.ConfigurableBase;
import com.intellij.openapi.options.ConfigurableUi;
import org.intellij.lang.regexp.psi.RegExpQuantifier;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Chan_Woo_Kim on 2016-12-22.
 */
public class FeverConfigurable extends ConfigurableBase<FeverModeConfigurableUI, FeverMode> {
    private final FeverMode settings;
    public static int time = 3000;
    private static boolean isCombo = true;
    public FeverConfigurable(@NotNull FeverMode settings) {
        super("Flower.mode", "Flower mode", "Flower.mode");
        this.settings = settings;
         Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                while (true){
                    try {
                        while (time > -1) {
                            Thread.sleep(100);
                            time-=100;
                            System.out.println(time);
                        }
                    }catch (InterruptedException e){
                    }
                    finally {
                        Combo.resetConut();
                    }
                }
            }
        });

        thread.start();
    }
    public FeverConfigurable() {
        this(FeverMode.getInstance());
    }

    @NotNull
    @Override
    protected FeverMode getSettings() {
        if (settings == null) {
            throw new IllegalStateException("Flower mode is null");
        }
        return settings;
    }

    @Override
    protected FeverModeConfigurableUI createUi() {
        return new FeverModeConfigurableUI(settings);
    }

}
