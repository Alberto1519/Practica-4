import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;

class NivelDificil extends JFrame implements KeyListener{
	
	JPanel panel;
	BufferedImage imagen;
	BufferedImage subImagen;
	Sprites sprite;
	int indiceX=0;
	Obstaculos pared;

	public NivelDificil()
	{
		panel = new JPanel();
		panel.setLayout(null);
	
		try{
			imagen = ImageIO.read(new File("./imagenes/professor_walk.png"));

		}catch(Exception e)
		{
			System.out.println("Error al cargar la imagen");
		}

		subImagen = imagen.getSubimage(0,64*3,64,64);
		sprite = new Sprites(subImagen);
		sprite.setBounds(0, 0, 50, 64);		
		sprite.setVisible(true);

		pared = new Obstaculos();
		pared.setBounds(150, 70, 50, 70);
		pared.setVisible(true);

		this.add(sprite);
		this.add(pared);
		
		this.setTitle("NIVEL DIFICL");
		this.setSize(600, 400);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);

		this.addKeyListener(this);
		this.setVisible(true);
	}
	public void keyPressed(KeyEvent e)
	{
		//System.out.println("Tecla presionada = "+e.getKeyCode());
		int t = e.getKeyCode();

		Point pos = sprite.getLocation();
		int x = (int)pos.getX();
		int y = (int)pos.getY();
		System.out.println( (int) pos.getX() );
		System.out.println( (int) pos.getY() );

		if(t==68)
		{
			x = x+5;
			indiceX = ((indiceX + 2) % 9) * 64;
			sprite.imagen = imagen.getSubimage(indiceX,64*3,64,64);
			//mr.reproducirNota(67, 1, 500);//sol
			//mr.finalizar();
		}

		else if(t==65)
		{
			x = x-5;
			indiceX = ((indiceX + 2) % 9) * 64;
			sprite.imagen = imagen.getSubimage(indiceX,64*1,64,64);
			//mr.reproducirNota(67, 1, 500);//sol
			//mr.finalizar();
		}

		else if(t==83)
		{
			y = y+5;
			indiceX = ((indiceX + 1) % 9) * 64;
			sprite.imagen = imagen.getSubimage(indiceX,64*2,64,64);
			//mr.reproducirNota(67, 1, 500);//sol
			//mr.finalizar();
		}
		else if(t==87)
		{
			y = y-5;
			indiceX = ((indiceX + 1) % 9) * 64;
			sprite.imagen = imagen.getSubimage(indiceX,64*0,64,64);
			//mr.reproducirNota(67, 1, 500);//sol
			//mr.finalizar();
		}
		sprite.setLocation(x,y);
		if(x>110 && x<155 && y==5)
		{
			System.out.println("Colision");
			y=y-5;
		}
		else if(x>110 && x<155 && y==125)
		{
			System.out.println("Colision");
			y=y+5;
		}
		else if(x>100 && x<155 && y>5 && y<125)
		{
			System.out.println("Colision");
			x=x-5;
		}
		else if(x==160 && y>5 && y<125)
		{
			System.out.println("Colision");
			x=x+5;
		}
		sprite.setLocation(x,y);
	}

	public void keyReleased(KeyEvent e)
	{
		//System.out.println("Tecla liberada.");
	}

	public void keyTyped(KeyEvent e)
	{
		//System.out.println("Tecla en el buffer.");
	}
}