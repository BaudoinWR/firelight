package com.woobadeau.firelight.firelight;


import com.woobadeau.tinyengine.TinyEngine;
import com.woobadeau.tinyengine.things.Halo;
import com.woobadeau.tinyengine.things.physics.FollowBehavior;
import com.woobadeau.tinyengine.things.physics.Vector2D;
import com.woobadeau.tinyengine.things.sprites.Sprite;
import com.woobadeau.tinyengine.things.ui.Display;
import java.util.Random;

public class Lightbug extends Sprite {
    private int wavelength;

    private final Random random = new Random();
    private final int[] rgb;
    private Halo halo;

    public Lightbug() {
        super(TinyEngine.uiInterfaceProvider.getImage("/lightbug.png"), 10);
        wavelength = random.nextInt(400) + 380;
        System.out.println(wavelength);
        rgb = ColorManager.getRgb(wavelength);
        ColorManager.setupColor(this, rgb);
        scale(-50,50);
        move(new Vector2D(random.nextInt(1000), random.nextInt(580)));

    }

    @Override
    public void draw(Display display) {
        super.draw(display);
    }

    @Override
    public void update() {
        if (Math.abs(ColorManager.wavelength - wavelength) < 10) {
            ColorManager.activated = false;
            addHalo();
            this.destroy();
            TinyEngine.spawn(Lightbug::new, null);
        }
    }

    private void addHalo() {
        if (halo == null) {
            halo = new Halo(rgb[0], rgb[1], rgb[2], 75, 5);
            halo.getBehaviors().add(new FollowBehavior(this)::follow);
            this.getThings().add(halo);
        }
    }

}
