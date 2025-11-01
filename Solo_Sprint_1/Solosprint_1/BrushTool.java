import java.awt.*;
import java.awt.event.MouseEvent;

public class BrushTool implements Tool, ResizableTool {
    private int lastX, lastY;
    private float brushSize = 8f;

    @Override
    public void mouseDown(CanvasPanel canvas, MouseEvent e) {
        lastX = e.getX();
        lastY = e.getY();
        draw(canvas, lastX, lastY, lastX, lastY);
    }

    @Override
    public void mouseDrag(CanvasPanel canvas, MouseEvent e) {
        int curX = e.getX();
        int curY = e.getY();
        draw(canvas, lastX, lastY, curX, curY);
        lastX = curX;
        lastY = curY;
    }

    @Override
    public void mouseUp(CanvasPanel canvas, MouseEvent e) {
        // no special release action
    }

    private void draw(CanvasPanel canvas, int x1, int y1, int x2, int y2) {
        Graphics2D g2 = canvas.getLayerGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(canvas.getCurrentColor());
        g2.setStroke(new BasicStroke(brushSize, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2.drawLine(x1, y1, x2, y2);
        g2.dispose();
    }

    @Override
    public void setSize(int size) {
        this.brushSize = size;
    }
}
