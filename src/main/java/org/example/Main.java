package org.example;

import nu.pattern.OpenCV;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Main {
    public static Mat loadImage(String path) {
        Imgcodecs imageCodecs = new Imgcodecs();
        return imageCodecs.imread(path);
    }

    public static double YELLOW = 25;
    public static double lowS = 60;
    // The high saturation point for color identification
    public static double highS = 255;
    // The low value for color ID
    public static double lowV = 50;
    // The high value for color ID
    public static double highV = 255;

    public static void main(String[] args) {


        // This dumps the 'home' directory of the program
        System.out.println(System.getProperty("user.dir"));
        OpenCV.loadLocally();
        Mat im = loadImage("sample.jpg");
        Mat hsv = new Mat();
        // To make this fast, we could actually do this line-by-line,
        // instead of converting the whole image...
        Imgproc.cvtColor(im, hsv, Imgproc.COLOR_RGB2HSV);
        int count = 0;
        // hsv is now the matrix for the image
        // Start looking at the *bottom* and search for some number of
        // consecutive yellow pixels to determine if that's a junction
        // From the sample image, you'll notice that there's a reflection to be careful about...

        for (int j = hsv.height() - 1; j > 0; j--) {
            for (int i = hsv.width() - 1; i > 0; i--) {
                double[] color = hsv.get(j, i);
                if (color[0] < YELLOW + 10 && color[0] > YELLOW - 10 && color[0] > lowS - 10 && color[0] < highS +10 &&
                color[0] > lowV - 10 && color[0] < highV) {
                    count++;
                }

                    // Draw a dot on the image at this point - input was put into img
                    // The color choice makes things stripey, which makes it easier to identif
                }
            }
        }
    }
}