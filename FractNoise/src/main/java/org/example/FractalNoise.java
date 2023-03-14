package org.example;

import java.util.ArrayList;
import java.util.List;

public class FractalNoise {
    int baseScale;
    Random random;
    List<Noise> octaves = new ArrayList<>();

    public FractalNoise(int baseScale, Random random, int octavesCount) {
        this.baseScale = baseScale;
        this.random = random;

        int scale = baseScale;
        for (int i = 0; i < octavesCount; i++) {
            octaves.add(new Noise(scale, random));
            scale /= 2;
        }
    }

    public float getValue(int x, int y) {
        float sum = 0;
        float fraction = 0.5f;

        for (Noise noise : octaves
        ) {
            sum += noise.getValue(x, y) * fraction;
            fraction *= 0.5;
        }
        return sum;
    }
}
