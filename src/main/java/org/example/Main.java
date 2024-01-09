package org.example;

// Java Program to Convert PNG Image to JPEG Image

// Importing BufferedImage class from java.awt package
// to describe an image with accessible buffer of image
import java.awt.image.BufferedImage;
// Importing all input output classes
import java.io.*;
// Importing an interface
// to determine the setting of IIOParam object
import javax.imageio.ImageIO;

// Class 1
// helper class
class HelperClass {

    // Method
    // To convert image format
    public static boolean convertImg(String inputImgPath,
                                     String outputImgPath,
                                     String formatType)

            throws IOException
    {

        // Creating an object  of FileInputStream to read
        FileInputStream inputStream
                = new FileInputStream(inputImgPath);

        // Creating an object  of FileOutputStream to write
        FileOutputStream outputStream
                = new FileOutputStream(outputImgPath);

        // Reading the  input image from file
        BufferedImage inputImage
                = ImageIO.read(inputStream);

        // Writing to the output image in specified format
        boolean result = ImageIO.write(
                inputImage, formatType, outputStream);

        // Closing the streams in order to avoid read write
        // operations
        outputStream.close();
        inputStream.close();

        return result;
    }
}

// Class 2
// Main class
public class Main {

    // Main class
    public static void main(String[] args)
    {

        // Here, the local directories from machine
        //  is passed as in strings

        // Creating a string to store the path of image
        // to be converted
        String inputImage
                = "/Users/daksh/Desktop/demoImage.png";

        // Creating a string to
        // store path of converted image
        String outputImage
                = "/Users/daksh/Desktop/demoImage.jpeg";
        // Creating another string that will be
        // store format of converted image

        // Simply  creating just to hold the format
        // type
        String formatType = "JPEG";

        // Try block to check for exceptions
        try {
            // result will store boolean value whether image
            // is converted successfully or not

            boolean result = HelperClass.convertImg(
                    inputImage, outputImage, formatType);

            if (result) {

                // Display message when image is converted
                // successfully
                System.out.println(
                        "Image converted to jpeg successfully.");
            }
            else {

                // Display message when image is not
                // converted successfully
                System.out.println(
                        "Could not convert image.");
            }
        }

        // Catch block to handle the exceptions
        catch (IOException ex) {

            // Display message when exception is thrown
            System.out.println(
                    "Error during converting image.");

            // Print the line number
            // where the exception occurred
            ex.printStackTrace();
        }
    }
}