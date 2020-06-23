import javax.swing.*;
import java.awt.image.*;
import java.awt.*;

public class Sprites extends JPanel{

	BufferedImage jugador;
	int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;

	public Sprites(BufferedImage jugador)
	{
		this.jugador = jugador;
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(jugador,0, 0, 150, 141,null);
	}
}