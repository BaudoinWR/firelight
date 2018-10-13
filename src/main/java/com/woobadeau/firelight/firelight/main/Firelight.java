package com.woobadeau.firelight.firelight.main;

import com.woobadeau.firelight.firelight.ColorManager;
import com.woobadeau.firelight.firelight.Lightbug;
import com.woobadeau.firelight.firelight.SampleBackground;
import com.woobadeau.firelight.firelight.WolfAnimation;
import com.woobadeau.tinyengine.*;

import java.io.IOException;

public class Firelight {

    public static void main(String[] args) throws IOException {
        TinyEngine.debug = true;
        ColorManager.getInstance();
        new SampleBackground();
        new WolfAnimation();
        new Lightbug();
        new Lightbug();
        new TinyEngine(1024, 740);
    }
}
