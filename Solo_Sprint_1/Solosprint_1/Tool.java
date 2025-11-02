import java.awt.event.MouseEvent;

public interface Tool {
    void mouseDown(CanvasPanel canvas, MouseEvent e);
    void mouseDrag(CanvasPanel canvas, MouseEvent e);
    void mouseUp(CanvasPanel canvas, MouseEvent e);
}
