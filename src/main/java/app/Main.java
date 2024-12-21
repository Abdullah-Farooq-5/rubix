package app;

import vision.CameraHandler;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;

public class Main {
    public static void main(String[] args) {
        // Initialize CameraHandler
        CameraHandler cameraHandler = new CameraHandler();

        try {
            // Capture a frame from the camera
            Mat frame = cameraHandler.captureFrame();
            System.out.println("Frame captured: " + frame);

            // Display the captured frame in a window
            HighGui.imshow("Captured Frame", frame);
            System.out.println("Press any key to close the window...");

            // Wait for a key press
            HighGui.waitKey(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Release the camera resources
            cameraHandler.release();
        }
    }
}
