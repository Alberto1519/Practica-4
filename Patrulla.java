import javax.swing.*;
import java.util.Random;
import java.awt.*;

public class Patrulla implements Runnable{

	JLabel jlPatrulla;
	SpriteDificil spriteD;
	int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	int y;
	int x;
	boolean a=true;
	int puntos;

	public Patrulla(JLabel jlPatrulla, SpriteDificil spriteD)
	{
		this.jlPatrulla = jlPatrulla;
		this.spriteD = spriteD;
	}

	@Override
	public void run()
	{
		while(a)
			{

			Random rnd = new Random();
			y=(int)(rnd.nextDouble() * alto + 0);

			for (x=ancho; x>-380 ; x=x-10) 
				{
					this.jlPatrulla.setLocation(x,y);
					retardo(50);

					if (jlPatrulla.getBounds().intersects(spriteD.getBounds()))
					{
						a = false;
						x = -400;
					}

					puntos=puntos+2;
				}
			}

		VentanaPuntaje vPP = new VentanaPuntaje(puntos);
	}

	public void retardo(int ms)
	{
		try
			{
				Thread.sleep(ms);
			}catch(Exception e){
				System.out.println("Error: al ejecutar el sleep");
			}
	}
}