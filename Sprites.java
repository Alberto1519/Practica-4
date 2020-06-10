import javax.swing.*;
import java.awt.image.*;
import java.awt.*;

public class Sprites extends JPanel{

	BufferedImage jugador;

	public Sprites(BufferedImage jugador)
	{
		this.jugador = jugador;
	}

	@Override
	public void paintComponent(Graphics g)
	{

		super.paintComponent(g);
		g.drawImage(jugador,0,0,64,64,null);
	}
}