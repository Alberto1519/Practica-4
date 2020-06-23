import javax.swing.*;
import java.awt.image.*;
import java.awt.*;

public class SpriteDificil extends JPanel{

	BufferedImage jugadorD;

	public SpriteDificil(BufferedImage jugadorD)
	{
		this.jugadorD = jugadorD;
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(jugadorD,0, 0, 150, 150,null);
	}
}