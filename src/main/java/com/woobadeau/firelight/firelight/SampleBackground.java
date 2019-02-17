package com.woobadeau.firelight.firelight;

import com.woobadeau.tinyengine.ScrollingBackground;
import com.woobadeau.tinyengine.TinyEngine;

public class SampleBackground {
    public SampleBackground()  {
        TinyEngine.spawn(SampleBackground::bg0, bg -> bg.scale(1024,740));
        TinyEngine.spawn(SampleBackground::bg1, bg -> bg.scale(1024,740));
        TinyEngine.spawn(SampleBackground::bg2, bg -> bg.scale(1024,740));
        TinyEngine.spawn(SampleBackground::bg3, bg -> bg.scale(1024,740));
        TinyEngine.spawn(SampleBackground::bg4, bg -> bg.scale(1024,740));
    }

    private static ScrollingBackground bg0() {
        return new ScrollingBackground(TinyEngine.uiInterfaceProvider.getImage("/Hills__0000.png"), 6);
    }

    private static ScrollingBackground bg1() {
        return new ScrollingBackground(TinyEngine.uiInterfaceProvider.getImage("/Hills__0001.png"), 4);
    }

    private static ScrollingBackground bg2() {
        return new ScrollingBackground(TinyEngine.uiInterfaceProvider.getImage("/Hills__0002.png"), 2);
    }

    private static ScrollingBackground bg3() {
        return new ScrollingBackground(TinyEngine.uiInterfaceProvider.getImage("/Hills__0003.png"), 1);
    }

    public static ScrollingBackground bg4() {
        return new ScrollingBackground(TinyEngine.uiInterfaceProvider.getImage("/Hills__0004_Sky.png"), 0);
    }
}
