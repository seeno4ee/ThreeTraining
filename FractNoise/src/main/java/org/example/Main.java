package org.example;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Main {
    public static final int IMAGE_WIDTH = 1280;
    public static final int IMAGE_HEIGHT = 1024;

    public static void main(String[] args) {
            BufferedImage bufferedImage = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, BufferedImage.TYPE_INT_RGB);
            FractalNoise fractalNoise = new FractalNoise(512,
                    new Random(bufferedImage.getWidth(), 100000), 9);
            int[] pixel = ((DataBufferInt) bufferedImage.getRaster().getDataBuffer()).getData();
            int pixelIndex = 0;
            for (int i = 0; i < bufferedImage.getHeight(); i++) {
                for (int j = 0; j < bufferedImage.getWidth(); j++) {
                    int value = 0xff & (int) (fractalNoise.getValue(j, i) * 255);
                    pixel[pixelIndex++] = 0xff000000 | value << 16 | value << 8 | value;
                }
            }

            Utils.showImageWindow(bufferedImage, IMAGE_WIDTH, IMAGE_HEIGHT);
        }
}