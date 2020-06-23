import javax.swing.*;
import java.awt.image.*;
import java.awt.*;

public class Policia extends JPanel
{
	BufferedImage policia;

	public Policia(BufferedImage policia)
	{
		this.policia = policia;
	}

	@Override
	public void paintComponent(Graphics g1)
	{
		super.paintComponent(g1);
		g1.drawImage(policia,0, 0, 150, 150,null);
	}
}