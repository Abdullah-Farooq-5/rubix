package vision;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import org.opencv.highgui.HighGui;

public class CameraHandler {
    private VideoCapture camera;

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME); // Load OpenCV
    }

    public CameraHandler() {
        camera = new VideoCapture(0); // Open default camera
        if (!camera.isOpened()) {
            throw new RuntimeException("Camera not accessible");
        }
    }

    public Mat captureFrame() {
        Mat frame = new Mat();
        if (camera.read(frame)) {
            return frame;
        } else {
            throw new RuntimeException("Failed to capture frame");
        }
    }

    public void release() {
        if (camera.isOpened()) {
            camera.release();
        }
    }
}
