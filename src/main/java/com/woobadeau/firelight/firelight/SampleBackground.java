package com.woobadeau.firelight.firelight;

import com.woobadeau.tinyengine.ScrollingBackground;

import java.io.IOException;

public class SampleBackground {
    public SampleBackground() throws IOException {
        new ScrollingBackground("/Hills__0000.png", 6);
        new ScrollingBackground("/Hills__0001.png", 4);
        new ScrollingBackground("/Hills__0002.png", 2);
        new ScrollingBackground("/Hills__0003.png", 1);
        new ScrollingBackground("/Hills__0004_Sky.png", 0);
    }

}
