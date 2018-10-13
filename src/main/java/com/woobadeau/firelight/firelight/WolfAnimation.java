package com.woobadeau.firelight.firelight;

import com.woobadeau.firelight.firelight.main.Firelight;
import com.woobadeau.tinyengine.things.physics.Vector2D;
import com.woobadeau.tinyengine.things.sprites.AnimatedSprite;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class WolfAnimation extends AnimatedSprite {
    private boolean draw = false;
    public WolfAnimation() throws IOException {
        super(ImageIO.read(Firelight.class.getResourceAsStream("/wolfanim.png")), 4,6, 10);
        scale(100,100);
        move(new Vector2D(0,540));
        this.addBehavior(new ColorReplacer(this, new int[]{255,251,252}));
        draw = true;
    }

    public Image getImage() {
        return this.image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    @Override
    public void draw(Graphics graphics) {
        if (draw) {
            super.draw(graphics);
        }
    }
}
