package org.example;

public class Noise {
    int scale;
    Random random;

    public Noise(int scale, Random random) {
        this.scale = scale;
        this.random = random;
    }

    public float getValue(int x, int y) {
        int xGrid = x / scale;
        int yGrid = y / scale;
        int xGridNext = xGrid + 1;
        int yGridNext = yGrid + 1;


        int xStart = xGrid * scale;
        int xEnd = xGridNext * scale;
        int yStart = yGrid * scale;
        int yEnd = yGridNext * scale;

        float value12 = random.getRandomValue(xGrid,yGrid);
        float value22 = random.getRandomValue(xGridNext,yGrid);
        float value21 = random.getRandomValue(xGridNext,yGridNext);
        float value11 = random.getRandomValue(xGrid,yGridNext);
    }
}
