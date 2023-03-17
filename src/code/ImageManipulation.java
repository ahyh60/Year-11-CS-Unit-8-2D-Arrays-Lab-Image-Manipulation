package code;

import image.APImage;
import image.Pixel;

public class ImageManipulation {

    /** CHALLENGE 0: Display Image
     *  Write a statement that will display the image in a window
     */

    public static void main(String[] args) {
        APImage image = new APImage("/Users/amandaho/IdeaProjects/Year-11-CS-Unit-8-2D-Arrays-Lab-Image-Manipulation/src/image/cyberpunk2077.jpg");
        image.draw();
        edgeDetection("/Users/amandaho/IdeaProjects/Year-11-CS-Unit-8-2D-Arrays-Lab-Image-Manipulation/src/image/cyberpunk2077.jpg",20);


        
    }

    /** CHALLENGE ONE: Grayscale
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: a grayscale copy of the image
     *
     * To convert a colour image to grayscale, we need to visit every pixel in the image ...
     * Calculate the average of the red, green, and blue components of the pixel.
     * Set the red, green, and blue components to this average value. */
    public static void grayScale(String pathOfFile) {
        APImage image = new APImage(pathOfFile);
        for(int i = 0; i< image.getWidth(); i++){
            for(int j = 0; j< image.getHeight(); j++){
                int red= image.getPixel(i,j).getRed();
                int blue= image.getPixel(i,j).getBlue();
                int green= image.getPixel(i,j).getGreen();
                int average = (red+blue+green)/3;
                Pixel pixel = new Pixel(average, average, average);
                image.setPixel(i,j,pixel);
            }

        }
        image.draw();
    }

    /** A helper method that can be used to assist you in each challenge.
     * This method simply calculates the average of the RGB values of a single pixel.
     * @param pixel
     * @return the average RGB value
     */
    private static int getAverageColour(Pixel pixel) {
        int red= pixel.getRed();
        int blue= pixel.getBlue();
        int green= pixel.getGreen();
        int average = (red+blue+green)/3;
        return average;
    }

    /** CHALLENGE TWO: Black and White
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: a black and white copy of the image
     *
     * To convert a colour image to black and white, we need to visit every pixel in the image ...
     * Calculate the average of the red, green, and blue components of the pixel.
     * If the average is less than 128, set the pixel to black
     * If the average is equal to or greater than 128, set the pixel to white */
    public static void blackAndWhite(String pathOfFile) {
        APImage image = new APImage(pathOfFile);
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                int red = image.getPixel(i, j).getRed();
                int blue = image.getPixel(i, j).getBlue();
                int green = image.getPixel(i, j).getGreen();
                int average = (red + blue + green) / 3;
                Pixel pixel = new Pixel(0,0,0);
                if(average >= 128) {
                    Pixel pix = new Pixel(255,255,255);
                    image.setPixel(i, j, pix);
                }
                else
                    image.setPixel(i,j,pixel);
            }

        }
        image.draw();
    }

    /** CHALLENGE Three: Edge Detection
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: an outline of the image. The amount of information will correspond to the threshold.
     *
     * Edge detection is an image processing technique for finding the boundaries of objects within images.
     * It works by detecting discontinuities in brightness. Edge detection is used for image segmentation
     * and data extraction in areas such as image processing, computer vision, and machine vision.
     *
     * There are many different edge detection algorithms. We will use a basic edge detection technique
     * For each pixel, we will calculate ...
     * 1. The average colour value of the current pixel
     * 2. The average colour value of the pixel to the left of the current pixel
     * 3. The average colour value of the pixel below the current pixel
     * If the difference between 1. and 2. OR if the difference between 1. and 3. is greater than some threshold value,
     * we will set the current pixel to black. This is because an absolute difference that is greater than our threshold
     * value should indicate an edge and thus, we colour the pixel black.
     * Otherwise, we will set the current pixel to white
     * NOTE: We want to be able to apply edge detection using various thresholds
     * For example, we could apply edge detection to an image using a threshold of 20 OR we could apply
     * edge detection to an image using a threshold of 35
     *  */
    public static void edgeDetection(String pathToFile, int threshold) {
        APImage image = new APImage(pathToFile);

        int height = image.getHeight();
        int width = image.getWidth();

        for (int w = width-1; w > 0; w--){
            for (int h = height -1; h > 0; h--){

                int red = image.getPixel(w, h).getRed();
                int blue = image.getPixel(w, h).getBlue();
                int green = image.getPixel(w, h).getGreen();
                int avg = (red + blue + green) / 3;

                int redLeft = image.getPixel(w-1, h).getRed();
                int blueLeft = image.getPixel(w-1, h).getBlue();
                int greenLeft = image.getPixel(w-1, h).getGreen();
                int avgLeft = (redLeft + blueLeft + greenLeft) / 3;

                int redBottom = image.getPixel(w, h-1).getRed();
                int blueBottom = image.getPixel(w, h-1).getBlue();
                int greenBottom = image.getPixel(w, h-1).getGreen();
                int avgBottom = (redBottom + blueBottom + greenBottom) / 3;

                int leftDifference = java.lang.Math.abs(avg-avgLeft);
                int belowDifference = java.lang.Math.abs(avg-avgBottom);

                red = blue = green = 255;
                if(leftDifference >= threshold || belowDifference >= threshold) {
                    red = blue = green = 0;
                }

                Pixel pixel= new Pixel(red, blue, green);
                image.setPixel(w, h, pixel);
            }
        }
        image.draw();
    }

    /** CHALLENGE Four: Reflect Image
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: the image reflected about the y-axis
     *
     */
    public static void reflectImage(String pathToFile) {

    }

    /** CHALLENGE Five: Rotate Image
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: the image rotated 90 degrees CLOCKWISE
     *
     *  */
    public static void rotateImage(String pathToFile) {

    }

}
