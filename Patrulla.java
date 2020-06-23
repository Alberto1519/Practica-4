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
	boolean activador=true;
	int puntos;

	public Patrulla(JLabel jlPatrulla, SpriteDificil spriteD)
	{
		this.jlPatrulla = jlPatrulla;
		this.spriteD = spriteD;
	}

	@Override
	public void run()
	{
		while(activador == true)
			{
			Random rnd = new Random();
			y=(int)(rnd.nextDouble() * alto + 0);
			for (x=ancho; x>-380 ; x=x-10) 
			{
				this.jlPatrulla.setLocation(x,y);
				retardo(50);
				if (jlPatrulla.getBounds().intersects(spriteD.getBounds()))
				{
					System.out.println("choco");
					activador = false;
				}
				if(activador==true){
				puntos=puntos+1;
				System.out.println(puntos);
			}
			}						
		}
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