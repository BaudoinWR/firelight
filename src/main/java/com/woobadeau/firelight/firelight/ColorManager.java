package com.woobadeau.firelight.firelight;

import com.woobadeau.tinyengine.things.Thing;
import com.woobadeau.tinyengine.things.ThingMouseListener;
import com.woobadeau.tinyengine.TinyEngine;
import com.woobadeau.tinyengine.things.physics.Vector2D;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.Date;

public class ColorManager extends Thing implements ThingMouseListener {

    public static Color color = Color.RED;
    private int previousPosition = 0;
    private long previousPeak = 0l;
    private boolean isGoingUp = true;
    private static ColorManager instance;
    public static float wavelength = 780f;
    public static boolean activated = true;

    public static final int pinkRGB = rgbToInt(new int[]{255,154,254});


    private ColorManager() {
        this.setShape(new Ellipse2D.Double(300, 640, 100, 100));
    }

    public static ColorManager getInstance() {
        if (instance == null) {
            instance = new ColorManager();
        }
        return instance;
    }

    static int rgbToInt(int[] color) {
        return (255 << 24) + ((color[0] & 0xFF) << 16) + ((color[1] & 0xFF) << 8) + (color[2] & 0xFF);
    }

    public static void setupColor(Lightbug lightbug, int[] color) {
        int col = rgbToInt(color);
        for (int i = 0; i < lightbug.getImage().getWidth(null); i++)
            for (int j = 0; j < lightbug.getImage().getHeight(null); j++) {
                int rgb = ((BufferedImage) lightbug.getImage()).getRGB(i, j);
                if (rgb == pinkRGB) {
                    ((BufferedImage) lightbug.getImage()).setRGB(i,j, col);
                }
            }
    }

    @Override
    protected void onCreate() {
        this.setPosition(new Vector2D(300, 640));
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillOval(this.getPosition().x, this.getPosition().y, 100, 100);
    }

    @Override
    public void update() {
        if (activated && TinyEngine.mouseDown) {
            updatePosition();
        }
    }

    private void updatePosition() {
        if (TinyEngine.mousePosition != null) {
            int y = TinyEngine.mousePosition.y;
            if ((isGoingUp && y < previousPosition) || (!isGoingUp && y > previousPosition)) {
                isGoingUp = !isGoingUp;
                long time = new Date().getTime();
                updateColor(time - previousPeak);
                previousPeak = time;
            }
            previousPosition = y;
        }
    }

    private void updateColor(long period) {
        wavelength = mapFloat(period, 55, 1000, 380, 780);
        int[] rgb = getRgb(wavelength);
        color = new Color(rgb[0], rgb[1], rgb[2]);
    }

    public static int[] getRgb(float wavelength) {
        float Gamma = 0.80f;
        float IntensityMax = 255;
        float factor, red, green, blue;
        if ((wavelength >= 380) && (wavelength < 440))
        {
            red = -(wavelength - 440) / (440 - 380);
            green = 0.0f;
            blue = 1.0f;
        }
        else if ((wavelength >= 440) && (wavelength < 490))
        {
            red = 0.0f;
            green = (wavelength - 440) / (490 - 440);
            blue = 1.0f;
        }
        else if ((wavelength >= 490) && (wavelength < 510))
        {
            red = 0.0f;
            green = 1.0f;
            blue = -(wavelength - 510) / (510 - 490);
        }
        else if ((wavelength >= 510) && (wavelength < 580))
        {
            red = (wavelength - 510) / (580 - 510);
            green = 1.0f;
            blue = 0.0f;
        }
        else if ((wavelength >= 580) && (wavelength < 645))
        {
            red = 1.0f;
            green = -(wavelength - 645) / (645 - 580);
            blue = 0.0f;
        }
        else if ((wavelength >= 645) && (wavelength < 781))
        {
            red = 1.0f;
            green = 0.0f;
            blue = 0.0f;
        }
        else
        {
            red = 0.0f;
            green = 0.0f;
            blue = 0.0f;
        };
        // Let the intensity fall off near the vision limits
        if ((wavelength >= 380) && (wavelength < 420))
        {
            factor = 0.3f + 0.7f * (wavelength - 380) / (420 - 380);
        }
        else if ((wavelength >= 420) && (wavelength < 701))
        {
            factor = 1.0f;
        }
        else if ((wavelength >= 701) && (wavelength < 781))
        {
            factor = 0.3f + 0.7f * (780 - wavelength) / (780 - 700);
        }
        else
        {
            factor = 0.0f;
        };
        if (red != 0f)
        {
            red = Math.round(IntensityMax * Math.pow(red * factor, Gamma));
        }
        if (green != 0f)
        {
            green = Math.round(IntensityMax * Math.pow(green * factor, Gamma));
        }
        if (blue != 0f)
        {
            blue = Math.round(IntensityMax * Math.pow(blue * factor, Gamma));
        }
        return new int[] { (int) red, (int) green, (int) blue };
    }

    private static float mapFloat(float init, float minSource, float maxSource, float minDest, float maxDest)
    {
        float i = (init - minSource) / (maxSource - minSource) * (maxDest - minDest) + minDest;
        return i;
    }

    @Override
    public void onClick() {
        System.out.println("activation switch");
        activated = !activated;
    }
}
