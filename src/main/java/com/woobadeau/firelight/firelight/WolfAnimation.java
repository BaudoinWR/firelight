package com.woobadeau.firelight.firelight;

import com.woobadeau.tinyengine.TinyEngine;
import com.woobadeau.tinyengine.things.physics.Vector2D;
import com.woobadeau.tinyengine.things.sprites.AnimatedSprite;
import com.woobadeau.tinyengine.things.ui.Display;
import com.woobadeau.tinyengine.things.ui.Image;

public class WolfAnimation extends AnimatedSprite {
    public WolfAnimation() {
        super(TinyEngine.uiInterfaceProvider.getImage("/wolfanim.png"), 4,6, 10);
        scale(100,100);
        move(new Vector2D(0,540));
    }

    public Image getImage() {
        return this.image;
    }

    @Override
    public void draw(Display display) {
        super.draw(display);
    }
}
