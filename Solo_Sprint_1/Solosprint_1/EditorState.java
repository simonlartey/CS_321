import java.awt.image.BufferedImage;

public class EditorState {
    private final BufferedImage snapshot;

    public EditorState(BufferedImage snapshot) {
        this.snapshot = snapshot;
    }

    public BufferedImage getSnapshot() {
        return snapshot;
    }
}
