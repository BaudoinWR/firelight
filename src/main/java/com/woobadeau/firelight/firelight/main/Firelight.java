package com.woobadeau.firelight.firelight.main;

import com.woobadeau.firelight.firelight.BatteryDepleter;
import com.woobadeau.firelight.firelight.ColorManager;
import com.woobadeau.firelight.firelight.Lightbug;
import com.woobadeau.firelight.firelight.LoadingText;
import com.woobadeau.firelight.firelight.SampleBackground;
import com.woobadeau.firelight.firelight.WolfAnimation;
import com.woobadeau.tinyengine.TinyEngine;
import com.woobadeau.tinyengine.things.ProgressBar;
import com.woobadeau.tinyengine.things.ui.swing.SwingUIInterfaceProvider;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Firelight {

    public static final int WIDTH = 1024;
    public static final int HEIGHT = 740;
    private static double batteryLevel = 1;

    public static void main(String[] args) throws InterruptedException {
        TinyEngine.debug = true;
        TinyEngine.setup(WIDTH, HEIGHT, Firelight::transition, new SwingUIInterfaceProvider());
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
            try {
                restart();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void restart() throws InterruptedException {
        TinyEngine.setup(Firelight::transition);
        TinyEngine.restart();
    }

    public static void runGame() {
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
    }

    private static void transition() {
        try {
            TinyEngine.spawn(LoadingText::new).get();
            TinyEngine.spawn(SampleBackground::bg4, bg -> bg.scale(1024, 740)).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

}
