package com.woobadeau.firelight.firelight.main;

import com.woobadeau.firelight.firelight.BatteryDepleter;
import com.woobadeau.firelight.firelight.ColorManager;
import com.woobadeau.firelight.firelight.Lightbug;
import com.woobadeau.firelight.firelight.SampleBackground;
import com.woobadeau.firelight.firelight.WolfAnimation;
import com.woobadeau.tinyengine.TinyEngine;
import com.woobadeau.tinyengine.things.ProgressBar;
import com.woobadeau.tinyengine.things.ui.swing.SwingUIInterfaceProvider;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Firelight {

    private static double batteryLevel = 1;

    public static void main(String[] args) {
        TinyEngine.debug = true;

        TinyEngine.setup(1024, 740, () -> {
            new SampleBackground();
            try {
                TinyEngine.spawn(ColorManager::new);
                CompletableFuture.allOf(TinyEngine.spawn(WolfAnimation::new),
                    TinyEngine.spawn(Lightbug::new),
                    TinyEngine.spawn(Lightbug::new),
                    TinyEngine.spawn(() -> new ProgressBar(TinyEngine.uiInterfaceProvider.getRectangle(10, 20, 200, 10),
                            TinyEngine.uiInterfaceProvider.getColorRed(), TinyEngine.uiInterfaceProvider.getColorGreen(),
                            () -> batteryLevel)))
                    .get();
                TinyEngine.spawn(BatteryDepleter::new);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }, new SwingUIInterfaceProvider());
        TinyEngine.start();
        TinyEngine.debug = false;
    }

    public static void increaseBattery(double amount) {
        batteryLevel += amount;
        if (batteryLevel > 1) {
            batteryLevel = 1;
        }
    }

    public static void reduceBattery(double amount) {
        batteryLevel -= amount;
        if (batteryLevel < 0) {
            batteryLevel = 1;
            TinyEngine.restart();
        }
    }
}
