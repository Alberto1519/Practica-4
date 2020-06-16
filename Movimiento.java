import javax.swing.*;
import java.util.Random;
import java.awt.*;

class Movimiento implements Runnable{

	JLabel jlPared;
	int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

	public Movimiento(JLabel jlPared)
	{
		this.jlPared = jlPared;
	}
	
	@Override
	public void run()
	{
		while(true)
			{
			Random rnd = new Random();
			int y=(int)(rnd.nextDouble() * alto + 0);
			for (int x=ancho; x>0 ; x=x-10) {
				this.jlPared.setLocation(x,y);
				retardo(50);
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