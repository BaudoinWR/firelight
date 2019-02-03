package com.woobadeau.firelight.firelight;

import com.woobadeau.tinyengine.ScrollingBackground;
import com.woobadeau.tinyengine.TinyEngine;

import java.io.IOException;

public class SampleBackground {
    public SampleBackground() throws IOException {
        new ScrollingBackground(TinyEngine.uiInterfaceProvider.getImage("/Hills__0000.png"), 6).scale(1024,740);
        new ScrollingBackground(TinyEngine.uiInterfaceProvider.getImage("/Hills__0001.png"), 4).scale(1024,740);
        new ScrollingBackground(TinyEngine.uiInterfaceProvider.getImage("/Hills__0002.png"), 2).scale(1024,740);
        new ScrollingBackground(TinyEngine.uiInterfaceProvider.getImage("/Hills__0003.png"), 1).scale(1024,740);
        new ScrollingBackground(TinyEngine.uiInterfaceProvider.getImage("/Hills__0004_Sky.png"), 0).scale(1024,740);
    }

}
