package com.woobadeau.firelight.firelight;


import com.woobadeau.tinyengine.things.physics.Vector2D;
import com.woobadeau.tinyengine.things.sprites.Sprite;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Random;

public class Lightbug extends Sprite {
    private boolean draw = false;
    private int wavelength;

    private final Random random = new Random();

    public Lightbug() throws IOException {
        super(ImageIO.read(Lightbug.class.getResourceAsStream("/lightbug.png")), 10);
        move(new Vector2D(random.nextInt(1000), random.nextInt(580)));
        wavelength = random.nextInt(400) + 380;
        System.out.println(wavelength);
        int[] rgb = ColorManager.getRgb(wavelength);
        ColorManager.setupColor(this, rgb);
        scale(-50,50);

        draw = true;
    }

    @Override
    public void draw(Graphics graphics) {
        if (draw) {
            super.draw(graphics);
        }
    }

    @Override
    public void update() {
        if (Math.abs(ColorManager.wavelength - wavelength) < 10) {
            ColorManager.activated = false;

            /*
                TinyEngine.remove(this);
                try {
                    new Lightbug();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            */
        }
    }

}
