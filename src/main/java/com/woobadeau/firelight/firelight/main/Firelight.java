package com.woobadeau.firelight.firelight.main;

import com.woobadeau.firelight.firelight.ColorManager;
import com.woobadeau.firelight.firelight.Lightbug;
import com.woobadeau.firelight.firelight.SampleBackground;
import com.woobadeau.firelight.firelight.WolfAnimation;
import com.woobadeau.tinyengine.*;
import com.woobadeau.tinyengine.things.ui.swing.SwingUIInterfaceProvider;

public class Firelight {

    public static void main(String[] args) {
        TinyEngine.debug = true;

        new TinyEngine(1024, 740, () -> {
            new SampleBackground();
            TinyEngine.spawn(WolfAnimation::new, null);
            TinyEngine.spawn(Lightbug::new, null);
            TinyEngine.spawn(Lightbug::new, null);
        }, new SwingUIInterfaceProvider()).start();
        TinyEngine.debug = false;
        ColorManager.getInstance();
    }
}
