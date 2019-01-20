package com.woobadeau.firelight.firelight;

import com.woobadeau.tinyengine.TinyEngine;
import com.woobadeau.tinyengine.things.Thing;
import com.woobadeau.tinyengine.things.ui.Color;
import com.woobadeau.tinyengine.things.ui.Image;

import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.LookupOp;
import java.awt.image.LookupTable;
import java.util.Arrays;
import java.util.function.Consumer;

public class ColorReplacer implements Consumer<Thing> {
    private int[] color;

    public ColorReplacer(WolfAnimation wolfAnimation, int[] color) {
        this.color = color;
    }

    @Override
    public void accept(Thing thing) {
        WolfAnimation wolf = (WolfAnimation) thing;
        Image image = wolf.getImage();
        Color from = TinyEngine.uiInterfaceProvider.getColor(color[0], color[1], color[2]);
        Color to = ColorManager.color;
        BufferedImageOp lookup = new LookupOp(new ColorMapper(from, to), null);
       // wolf.setImage(lookup.filter((BufferedImage)image, null));
    }



    public class ColorMapper
            extends LookupTable {

        private final int[] from;
        private final int[] to;

        public ColorMapper(Color from,
                           Color to) {
            super(0, 4);

            this.from = new int[] {
                    from.getRed(),
                    from.getGreen(),
                    from.getBlue(),
                    from.getAlpha(),
            };
            this.to = new int[] {
                    to.getRed(),
                    to.getGreen(),
                    to.getBlue(),
                    to.getAlpha(),
            };
        }

        @Override
        public int[] lookupPixel(int[] src,
                                 int[] dest) {
            if (dest == null) {
                dest = new int[src.length];
            }

            int[] newColor = (Arrays.equals(src, from) ? to : src);
            System.arraycopy(newColor, 0, dest, 0, newColor.length);

            return dest;
        }
    }
}
