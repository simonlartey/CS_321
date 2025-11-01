import java.awt.*;
import java.awt.event.MouseEvent;

public class LineTool implements Tool, ResizableTool {
    private int startX, startY, endX, endY;
    private float strokeSize = 2f; // default thickness

    @Override
    public void mouseDown(CanvasPanel canvas, MouseEvent e) {
        startX = e.getX();
        startY = e.getY();
    }

    @Override
    public void mouseDrag(CanvasPanel canvas, MouseEvent e) {
        // live preview optional, we only draw on release
        endX = e.getX();
        endY = e.getY();
    }

    @Override
    public void mouseUp(CanvasPanel canvas, MouseEvent e) {
        endX = e.getX();
        endY = e.getY();

        Graphics2D g2 = canvas.getLayerGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(canvas.getCurrentColor());
        g2.setStroke(new BasicStroke(strokeSize));
        g2.drawLine(startX, startY, endX, endY);
        g2.dispose();
    }

    @Override
    public void setSize(int size) {
        this.strokeSize = size;
    }
}
