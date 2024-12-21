package vision;
import org.opencv.highgui.HighGui;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

public class CameraHandler {
    private VideoCapture camera;

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);  // Automatically maps to OpenCV
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
    public void showFrame(Mat frame) {
        HighGui.imshow("Captured Frame", frame);
        HighGui.waitKey(0); // Wait for a key press to close the window
    }
}
