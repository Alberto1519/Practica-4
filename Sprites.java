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
		int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		super.paintComponent(g);
		g.drawImage(jugador,ancho/2, (alto/ 2), 64, 64,null);
	}
}