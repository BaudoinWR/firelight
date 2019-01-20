package com.woobadeau.firelight.firelight;

import com.woobadeau.tinyengine.TinyEngine;
import com.woobadeau.tinyengine.things.physics.Vector2D;
import com.woobadeau.tinyengine.things.sprites.AnimatedSprite;
import com.woobadeau.tinyengine.things.ui.Display;
import com.woobadeau.tinyengine.things.ui.Image;

import java.io.IOException;

public class WolfAnimation extends AnimatedSprite {
    private boolean draw = false;
    public WolfAnimation() throws IOException {
        super(TinyEngine.uiInterfaceProvider.getImage("/wolfanim.png"), 4,6, 10);
        scale(100,100);
        move(new Vector2D(0,540));
        this.addBehavior(new ColorReplacer(this, new int[]{255,251,252}));
        draw = true;
    }

    public Image getImage() {
        return this.image;
    }

    @Override
    public void draw(Display display) {
        if (draw) {
            super.draw(display);
        }
    }
}
