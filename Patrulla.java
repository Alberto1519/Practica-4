import javax.swing.*;
import java.util.Random;
import java.awt.*;

public class Patrulla implements Runnable{

	JLabel jlPatrulla;
	int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	int y;
	int x;
	Rectangle posPatrulla;

	public Patrulla(JLabel jlPatrulla)
	{
		this.jlPatrulla = jlPatrulla;
	}

	@Override
	public void run()
	{
		while(true)
			{
			Random rnd = new Random();
			y=(int)(rnd.nextDouble() * alto + 0);
			for (x=ancho; x>-380 ; x=x-10) 
			{
				this.jlPatrulla.setLocation(x,y);
				posPatrulla=jlPatrulla.getBounds();	
				//recibirPos(posPatrulla);
				//System.out.println(posPatrulla);
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