import javax.swing.*;
import java.awt.image.*;
import java.awt.*;

public class Obstaculos extends JPanel
{
	public void paint (Graphics g3)
    {
        super.paint(g3);
        g3.setColor (Color.BLACK);
        g3.fillRect (150, 70, 30, 70);
    }
}