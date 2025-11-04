import java.awt.*;
import java.awt.event.MouseEvent;

public class SelectionTool implements Tool {
    private int startX, startY, curX, curY;
    private boolean dragging = false;

    @Override
    public void mouseDown(CanvasPanel canvas, MouseEvent e) {
        startX = e.getX();
        startY = e.getY();
        dragging = true;
    }

    @Override
    public void mouseDrag(CanvasPanel canvas, MouseEvent e) {
        curX = e.getX();
        curY = e.getY();
    }

    @Override
    public void mouseUp(CanvasPanel canvas, MouseEvent e) {
        dragging = false;
        drawSelection(canvas, e.getX(), e.getY());
    }

    private void drawSelection(CanvasPanel canvas, int x2, int y2) {
        Graphics2D g2 = canvas.getLayerGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        float[] dash = {6f, 6f};
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(1.5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10f, dash, 0f));
        g2.drawRect(Math.min(startX, x2), Math.min(startY, y2),
                    Math.abs(x2 - startX), Math.abs(y2 - startY));
        g2.dispose();
    }
}
