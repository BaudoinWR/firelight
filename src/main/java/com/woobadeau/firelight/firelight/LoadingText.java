package com.woobadeau.firelight.firelight;

import com.woobadeau.firelight.firelight.main.Firelight;
import com.woobadeau.tinyengine.TinyEngine;
import com.woobadeau.tinyengine.things.physics.Vector2D;
import com.woobadeau.tinyengine.things.ui.Text;

public class LoadingText extends Text {
    int delay = 50;
    int dots = 0;

    public LoadingText() {
        super("Loading", TinyEngine.uiInterfaceProvider.getFont("Arial", 2, 50),
                TinyEngine.uiInterfaceProvider.getColorGreen(),
                new Vector2D(400, 300));
    }

    @Override
    public void update() {
        dots++;
        if (dots % 30 == 0) {
            this.string = "Loading";
        } else if (dots % 5 == 0){
            this.string += " .";
        }
        delay--;
        if (delay < 0) {
            TinyEngine.setup(Firelight::runGame);
            TinyEngine.restart();
        }
    }
}
