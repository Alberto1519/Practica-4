import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;

class NivelFacil extends JFrame implements KeyListener{
	
	JPanel panel;
	BufferedImage jugador;
	BufferedImage subjugador;
	Sprites sprite;
	Obstaculos pared;
	int indiceX=0;
	int alto;

	public NivelFacil()
	{
		this.setTitle("NIVEL FACIL");
		this.setExtendedState(MAXIMIZED_BOTH); //Crear vetanana del tamano de la pantalla
		componentes();
		this.setVisible(true);
		this.setResizable(false); //Evitar que se puede hacer mas pequena la ventana
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		//Escuchar las acciones del teclado
		this.addKeyListener(this);
	}

	private void componentes(){

		colocarFondo();
		colocarPersonaje();
	}

	private void colocarFondo(){
		
		//Creacion del panel
		panel = new JPanel();
		panel.setLayout(null);
		this.getContentPane().add(panel);
	}

	private void colocarPersonaje(){

		int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		
		//Personaje policia
		try{
			jugador = ImageIO.read(new File("./imagenes/professor_walk.png"));

		}catch(Exception e)
		{
			System.out.println("Error al cargar la jugador");
		}

		subjugador = jugador.getSubimage(0,64*3,64,64);
		sprite = new Sprites(subjugador);

		sprite.setBounds(70, (alto / 2) - (this.getHeight() / 2), 50, 64);		
		sprite.setVisible(true);

		//Agregar al panel
		this.add(sprite);
	}

	private void colocarPared(){

		//Primera pared
		pared = new Obstaculos();
		pared.setBounds(150, 70, 50, 70);
		pared.setVisible(true);

		//Agregar al panel
		this.add(pared);
	}

	public void keyPressed(KeyEvent e)
	{

	}

	public void keyReleased(KeyEvent e)
	{
		

	}

	public void keyTyped(KeyEvent e)
	{

	}
}