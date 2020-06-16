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
	ImageIcon iPared;
	JLabel jlPared;
	int indiceX=0;
	int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	Thread movimiento1;

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
		colocarPared();
		colocarFondo();
		colocarPersonaje();
		crearMovimiento1();
	}

	private void colocarFondo(){
		
		//Creacion del panel
		panel = new JPanel();
		panel.setLayout(null);
		this.getContentPane().add(panel);
	}

	private void colocarPersonaje(){
		
		//Personaje policia
		try{
			jugador = ImageIO.read(new File("./imagenes/professor_walk.png"));

		}catch(Exception e)
		{
			System.out.println("Error al cargar la jugador");
		}

		subjugador = jugador.getSubimage(0,64*3,64,64);
		sprite = new Sprites(subjugador);

		sprite.setBounds(ancho/2, alto/ 2, 50, 64);		
		sprite.setVisible(true);

		//Agregar al panel
		this.add(sprite);
	}

	private void colocarPared(){

		//Primera pared
		try{
			iPared = new ImageIcon ("./imagenes/pared.png");
			jlPared = new JLabel();
			jlPared.setBounds(30,10,380,200); //(x, y, w, h)
			jlPared.setIcon(new ImageIcon(iPared.getImage().getScaledInstance(jlPared.getWidth(),jlPared.getHeight(),Image.SCALE_SMOOTH)));
		}catch(Exception e){
			System.out.println("Error al cargar imagen.");
		} 
		
		this.add(jlPared);
	}

	public void actualizar()
	{

	}

	public void keyPressed(KeyEvent e)
	{
		int t = e.getKeyCode();
		Point pos = sprite.getLocation();
		int x = (int)pos.getX();
		int y = (int)pos.getY();
		//System.out.println( (int) pos.getX() );
		//System.out.println( (int) pos.getY() );
		//System.out.println("ancho="+ancho);

		if(t==68)
		{
			x = x+5;
			indiceX = ((indiceX + 2) % 9) * 64;
			sprite.jugador = jugador.getSubimage(indiceX,64*3,64,64);
		}
		else if(t==83)
		{
			y = y+5;
			indiceX = ((indiceX + 1) % 9) * 64;
			sprite.jugador = jugador.getSubimage(indiceX,64*2,64,64);
		}
		else if(t==87)
		{
			y = y-5;
			indiceX = ((indiceX + 1) % 9) * 64;
			sprite.jugador = jugador.getSubimage(indiceX,64*0,64,64);
		}
		sprite.setLocation(x,y);
		if(x>0)
		{
			x=x-5;
		}
		sprite.setLocation(x,y);
	}

	public void keyReleased(KeyEvent e)
	{
		Point pos = sprite.getLocation();
		int x = (int)pos.getX();
		int y = (int)pos.getY();
		x = x+5;
		indiceX = ((indiceX + 2) % 9) * 64;
		sprite.jugador = jugador.getSubimage(indiceX,64*3,64,64);
		sprite.setLocation(x,y);
		if(x>0)
		{
			x=x-5;
		}
		sprite.setLocation(x,y);
	}

	public void keyTyped(KeyEvent e)
	{

	}
	public void crearMovimiento1()
	{
		Movimiento mov1 = new Movimiento(this.jlPared);
		movimiento1 = new Thread(mov1);
		movimiento1.start();
	}
}