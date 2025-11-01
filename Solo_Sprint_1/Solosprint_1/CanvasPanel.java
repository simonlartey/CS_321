import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class CanvasPanel extends JPanel {
    private Tool currentTool;
    private BufferedImage layer;
    private final History history = new History();

    public CanvasPanel() {
        setBackground(Color.WHITE);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                ensureLayer();
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                saveState(); // save BEFORE action
                if (currentTool != null) {
                    currentTool.mouseDown(CanvasPanel.this, e);
                }
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (currentTool != null) {
                    currentTool.mouseUp(CanvasPanel.this, e);
                }
                saveState(); //save AFTER action (important for shapes)
                repaint();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (currentTool != null) {
                    currentTool.mouseDrag(CanvasPanel.this, e);
                }
                repaint();
            }
        });
    }

    public Tool getCurrentTool() {
        return currentTool;
    }

    public void setTool(Tool tool) {
        this.currentTool = tool;
    }


    private Color currentColor = Color.BLACK;

    public void setCurrentColor(Color c) {
        this.currentColor = c;
    }

    public Color getCurrentColor() {
        return currentColor;
    }


    public void saveState() {
        if (layer != null) {
            BufferedImage copy = new BufferedImage(layer.getWidth(), layer.getHeight(), layer.getType());
            Graphics g = copy.getGraphics();
            g.drawImage(layer, 0, 0, null);
            g.dispose();
            history.saveState(new EditorState(copy));
        }
    }

    public void undo() {
        EditorState state = history.undo();
        if (state != null) {
            layer = state.getSnapshot();
            repaint();
        }
    }

    public void redo() {
        EditorState state = history.redo();
        if (state != null) {
            layer = state.getSnapshot();
            repaint();
        }
    }

    public Graphics2D getLayerGraphics() {
        ensureLayer();
        return layer.createGraphics();
    }

    private void ensureLayer() {
        int w = Math.max(1, getWidth());
        int h = Math.max(1, getHeight());
        if (layer == null || layer.getWidth() != w || layer.getHeight() != h) {
            BufferedImage newLayer = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = newLayer.createGraphics();
            if (layer != null) {
                g2.drawImage(layer, 0, 0, null);
            } else {
                g2.setColor(Color.WHITE);
                g2.fillRect(0, 0, w, h);
            }
            g2.dispose();
            layer = newLayer;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ensureLayer();
        g.drawImage(layer, 0, 0, null);
    }
}
