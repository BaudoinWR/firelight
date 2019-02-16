package com.woobadeau.firelight.firelight;

import com.woobadeau.firelight.firelight.main.Firelight;
import com.woobadeau.tinyengine.TinyEngine;
import com.woobadeau.tinyengine.things.Thing;

public class BatteryDepleter extends Thing {
    @Override
    public void update() {
        Firelight.reduceBattery(0.003);
    }
}
