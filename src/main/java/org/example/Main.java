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
    public static void main(String[] args) {
        System.out.println("Hello world!");
        OpenCV.loadShared();
        Mat im = loadImage(args[0]);
        Mat hsv = new Mat();
        // To make this fast, we could actually do this line-by-line,
        // instead of converting the whole image...
        Imgproc.cvtColor(im, hsv, Imgproc.COLOR_RGB2HSV);
        // hsv is now the matrix for the image
        // Start looking at the *bottom* and search for some number of
        // consecutive yellow pixels to determine if that's a junction
    }
}