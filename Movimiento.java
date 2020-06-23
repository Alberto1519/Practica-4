import javax.swing.*;
import java.util.Random;
import java.awt.*;

public class Movimiento implements Runnable{

	JLabel jlPared;
	Sprites sprite;
	int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	int y;
	int x;
	boolean activador=true;
	int puntos;

	public Movimiento(JLabel jlPared, Sprites sprite)
	{
		this.jlPared = jlPared;
		this.sprite = sprite;
	}

	@Override
	public void run()
	{
		while(activador==true)
			{
			Random rnd = new Random();
			y=(int)(rnd.nextDouble() * alto + 0);
			for (x=ancho; x>-380 ; x=x-10) 
			{
				this.jlPared.setLocation(x,y);
				retardo(50);
				if (jlPared.getBounds().intersects(sprite.getBounds()))
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