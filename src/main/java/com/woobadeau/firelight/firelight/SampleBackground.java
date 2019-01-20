package com.woobadeau.firelight.firelight;

import com.woobadeau.tinyengine.ScrollingBackground;
import com.woobadeau.tinyengine.TinyEngine;

import java.io.IOException;

public class SampleBackground {
    public SampleBackground() throws IOException {
        new ScrollingBackground(TinyEngine.uiInterfaceProvider.getImage("/Hills__0000.png"), 6);
        new ScrollingBackground(TinyEngine.uiInterfaceProvider.getImage("/Hills__0001.png"), 4);
        new ScrollingBackground(TinyEngine.uiInterfaceProvider.getImage("/Hills__0002.png"), 2);
        new ScrollingBackground(TinyEngine.uiInterfaceProvider.getImage("/Hills__0003.png"), 1);
        new ScrollingBackground(TinyEngine.uiInterfaceProvider.getImage("/Hills__0004_Sky.png"), 0);
    }

}
