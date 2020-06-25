import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;

class NivelFacil extends JFrame implements KeyListener{
	
	//Panel donde se trabajara
	JPanel panel;
	ImageIcon iFondo;//calle fondo
	JLabel jlFondo;
	
	//Creacion del personaje
	BufferedImage jugador;
	BufferedImage subjugador;
	Sprites sprite;
	
	//Creacion del policia
	BufferedImage policia;
	BufferedImage subpolicia;
	Policia pol1;

	//Creacion de los obstaculos 
	ImageIcon iPared;
	JLabel jlPared;
	
	//Coordenadas del personaje
	int indiceX=0;
	int indiceX_Policia=0;
	//Dimensiones de la pantalla
	int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	
	//Hilos utilizados
	Thread movimiento1;
	Thread sonidohp;

	//Puntos
	int puntos;
	boolean activador=false;

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
		colocarPersonaje();
		colocarPolicia();
		colocarFondo();		
		crearMovimiento1();
	}

	private void colocarFondo(){
		
		//Creacion del panel
		panel = new JPanel();
		panel.setLayout(null);
		this.getContentPane().add(panel);
		try{
			iFondo = new ImageIcon ("./imagenes/calle_nF.png");
			jlFondo = new JLabel();
			jlFondo.setBounds(0,0,ancho, alto); //(x, y, w, h)
			jlFondo.setIcon(new ImageIcon(iFondo.getImage().getScaledInstance(jlFondo.getWidth(),jlFondo.getHeight(),Image.SCALE_SMOOTH)));
		}catch(Exception e){
			System.out.println("Error al cargar imagen.");
		} 
		jlFondo.setOpaque(false);
		this.add(jlFondo);
	}

	private void colocarPersonaje(){
		
		//Personaje
		try{
			jugador = ImageIO.read(new File("./imagenes/personaje_nF.png"));

		}catch(Exception e)
		{
			System.out.println("Error al cargar la imagen");
		}

		subjugador = jugador.getSubimage(0,150*2,150,150);
		sprite = new Sprites(subjugador);

		sprite.setBounds(0, 0, 150, 150);		
		sprite.setVisible(true);
		sprite.setOpaque(false);
		sprite.setLocation((ancho/2)-10,alto/2);
		//Agregar al panel
		//movimientSprite
		this.add(sprite);
	}

	private void colocarPolicia()
	{
		//Policia
		try{
			policia = ImageIO.read(new File("./imagenes/policia_nF.png"));

		}catch(Exception e)
		{
			System.out.println("Error al cargar la imagen");
		}

		subpolicia = policia.getSubimage(0,150*2,150,150);
		pol1 = new Policia(subpolicia);

		pol1.setBounds(0, 0, 150, 150);		
		pol1.setVisible(true);
		pol1.setOpaque(false);
		pol1.setLocation((ancho/2)-160,alto/2);
		//Agregar al panel
		this.add(pol1);
	}

	private void colocarPared(){

		//Primera pared
		try{
			iPared = new ImageIcon ("./imagenes/pared.png");
			jlPared = new JLabel();
			jlPared.setBounds(0,0,60,336); //(x, y, w, h)
			jlPared.setIcon(new ImageIcon(iPared.getImage().getScaledInstance(jlPared.getWidth(),jlPared.getHeight(),Image.SCALE_SMOOTH)));
		}catch(Exception e){
			System.out.println("Error al cargar imagen.");
		} 
		jlPared.setOpaque(false);
		this.add(jlPared);
	}

	public void keyPressed(KeyEvent e)
	{
		int t = e.getKeyCode();
		Point pos = sprite.getLocation();
		int x = (int)pos.getX();
		int y = (int)pos.getY();
		Point posPolicia = pol1.getLocation();
		int x_policia = (int)posPolicia.getX();
		int y_policia = (int)posPolicia.getY();

		if(t==83)//abajo
		{
			y = y+5;
			y_policia = y_policia+5;
		
			indiceX = indiceX + 150;			
			sprite.jugador = jugador.getSubimage(indiceX,150*0,150,150);

			indiceX = indiceX_Policia + 150;
			pol1.policia = policia.getSubimage(indiceX_Policia,150*0,150,150);
		}
		else if(t==87)//arriba
		{
			y = y-5;
			y_policia = y_policia-5;
			
			indiceX = indiceX + 150;
			indiceX = indiceX_Policia + 150;
			sprite.jugador = jugador.getSubimage(indiceX,150*3,150,150);
			pol1.policia = policia.getSubimage(indiceX_Policia,150*3,150,150);
		}
		sprite.setLocation(x,y);
		pol1.setLocation(x_policia,y_policia);
		if(x>ancho/2)
		{
			x=x-5;
			x_policia=x_policia-5;
		}
		else if(y>alto-200)
		{
			y=y-5;
			y_policia=y_policia-5;
		}
		else if(y<-30)
		{
			y=y+5;
			y_policia=y_policia+5;
		}
		sprite.setLocation(x,y);
		pol1.setLocation(x_policia,y_policia);
		
		crearSonidoPasos(t); //Hilo para reproducir los pasos
	}

	public void keyReleased(KeyEvent e)
	{
		Point pos = sprite.getLocation();
		int x = (int)pos.getX();
		int y = (int)pos.getY();
		Point posPolicia = pol1.getLocation();
		int x_policia = (int)posPolicia.getX();
		int y_policia = (int)posPolicia.getY();
		
		x = x+5;
		x_policia=x_policia+5;
		indiceX = indiceX_Policia + 150;
		sprite.jugador = jugador.getSubimage(indiceX,150*2,150,150);
		pol1.policia = policia.getSubimage(indiceX_Policia,150*2,150,150);
		sprite.setLocation(x,y);
		pol1.setLocation(x_policia,y_policia);
		if(x>0)
		{
		x=x-5;
		x_policia=x_policia-5;
		}
		sprite.setLocation(x,y);
		pol1.setLocation(x_policia,y_policia);
	}

	public void keyTyped(KeyEvent e)
	{

	}

	public void crearMovimiento1()
	{
		Movimiento mov1 = new Movimiento(this.jlPared, this.sprite);
		movimiento1 = new Thread(mov1);
		movimiento1.start(); 
	}

	public void crearSonidoPasos(int t)
	{
		HiloPasos hp = new HiloPasos(t);
		sonidohp = new Thread(hp);
		sonidohp.start();
	}
}