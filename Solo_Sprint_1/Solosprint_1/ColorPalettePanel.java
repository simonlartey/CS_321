import java.awt.*;
import javax.swing.*;

public class ColorPalettePanel extends JPanel {
    public ColorPalettePanel(CanvasPanel canvas) {
        setLayout(new FlowLayout());

        // Predefined quick colors
        Color[] colors = { Color.BLACK, Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE, Color.MAGENTA };

        for (Color c : colors) {
            JButton btn = new JButton();
            btn.setBackground(c);
            btn.setOpaque(true);               // force background painting
            btn.setBorderPainted(false);       // remove default border
            btn.setContentAreaFilled(true);    // make sure color fills button
            btn.setPreferredSize(new Dimension(30, 30));
            btn.addActionListener(e -> canvas.setCurrentColor(c));
            add(btn);
        }
        

        // Color chooser button
        JButton picker = new JButton("More...");
        picker.addActionListener(e -> {
            Color chosen = JColorChooser.showDialog(this, "Pick a Color", canvas.getCurrentColor());
            if (chosen != null) {
                canvas.setCurrentColor(chosen);
            }
        });
        add(picker);
    }
}
