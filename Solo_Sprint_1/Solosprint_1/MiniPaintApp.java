import java.awt.*;
import javax.swing.*;

public class MiniPaintApp extends JFrame {

    public MiniPaintApp() {
        setTitle("Mini Paint — Refactored with Undo/Redo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 650);
        setLocationRelativeTo(null);

        CanvasPanel canvas = new CanvasPanel();

        // 🔹 Toolbar with tools
        JPanel tools = new JPanel();
        JButton selection = new JButton("Selection");
        JButton brush = new JButton("Brush");
        JButton eraser = new JButton("Eraser");
        JButton line = new JButton("Line");
        JButton rectangle = new JButton("Rectangle");
        JButton undo = new JButton("Undo");
        JButton redo = new JButton("Redo");
        JButton circle = new JButton("Circle");

        selection.addActionListener(e -> canvas.setTool(new SelectionTool()));
        brush.addActionListener(e -> canvas.setTool(new BrushTool()));
        eraser.addActionListener(e -> canvas.setTool(new EraserTool()));
        line.addActionListener(e -> canvas.setTool(new LineTool()));
        rectangle.addActionListener(e -> canvas.setTool(new RectangleTool()));
        undo.addActionListener(e -> canvas.undo());
        redo.addActionListener(e -> canvas.redo());
        circle.addActionListener(e -> canvas.setTool(new CircleTool()));

        tools.add(selection);
        tools.add(brush);
        tools.add(eraser);
        tools.add(line);
        tools.add(rectangle);
        tools.add(undo);
        tools.add(redo);
        tools.add(circle);

        // Slider for tool size
        JSlider sizeSlider = new JSlider(1, 50, 8); // min=1, max=50, default=8
        sizeSlider.setBorder(BorderFactory.createTitledBorder("Tool Size"));
        sizeSlider.addChangeListener(e -> {
            if (canvas.getCurrentTool() instanceof ResizableTool resizable) {
                resizable.setSize(sizeSlider.getValue());
            }
        });
        tools.add(sizeSlider);

        // Add color palette panel
        ColorPalettePanel colorPalette = new ColorPalettePanel(canvas);
        tools.add(colorPalette);

        add(tools, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MiniPaintApp().setVisible(true));
    }
}
