package app;

import vision.CameraHandler;
import vision.ColorDetector;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.highgui.HighGui;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CameraHandler cameraHandler = new CameraHandler();
        ColorDetector colorDetector = new ColorDetector();

        try {
            while (true) {
                // Capture a frame
                Mat frame = cameraHandler.captureFrame();

                // Convert to HSV and detect cube colors
                Mat hsvImage = colorDetector.convertToHSV(frame);
                Mat mask = colorDetector.detectRubiksCubeColors(hsvImage);

                // Detect tiles
                List<Rect> tiles = colorDetector.detectCubeTiles(mask);

                // Draw tiles on the frame
                colorDetector.drawTiles(frame, tiles);

                // Display the frame
                HighGui.imshow("Rubik's Cube Detection", frame);

                // Wait for key press
                int key = HighGui.waitKey(30);
                if (key == 27) { // Esc key to exit
                    break;
                }
            }
        } finally {
            // Cleanup
            cameraHandler.release();
            HighGui.destroyAllWindows();
        }
    }
}
