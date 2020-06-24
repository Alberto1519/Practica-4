import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;

class NivelDificil extends JFrame implements KeyListener{
	
	//Panel donde se trabajara
	JPanel panel;
	ImageIcon iFondo;//calle fondo
	JLabel jlFondo;
	
	//Creacion del personaje
	BufferedImage jugadorD;
	BufferedImage subjugadorD;
	SpriteDificil spriteD;

	//Creacion de los obstaculos 
	ImageIcon iPatrulla;
	JLabel jlPatrulla;
	
	//Coordenadas del personaje
	int indiceX=0;
	
	//Dimensiones de la pantalla
	int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	
	//Hilos utilizados
	Thread patrulla1;
	Thread sonidohp;

	//Para comparar posiciones

	public NivelDificil()
	{

		this.setTitle("NIVEL DIFICIL");
		this.setExtendedState(MAXIMIZED_BOTH); //Crear vetanana del tamano de la pantalla
		componentes();
		this.setVisible(true);
		this.setResizable(false); //Evitar que se puede hacer mas pequena la ventana
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		//Escuchar las acciones del teclado
		this.addKeyListener(this);

		crearPatrulla1();
	}

	private void componentes(){
		colocarPatrulla();
		colocarPersonaje();
		colocarFondo();
		
	}

	private void colocarFondo(){
		
		//Creacion del panel
		panel = new JPanel();
		panel.setLayout(null);
		this.getContentPane().add(panel);
		try{
			iFondo = new ImageIcon ("./imagenes/calle_nD.png");
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
		
		//Personaje policia
		try{
			jugadorD = ImageIO.read(new File("./imagenes/personaje_nD.png"));

		}catch(Exception e)
		{
			System.out.println("Error al cargar la imagen");
		}

		subjugadorD = jugadorD.getSubimage(0,150,150,150);
		spriteD = new SpriteDificil(subjugadorD);

		spriteD.setBounds(ancho/2,alto/2, 150, 150);		
		spriteD.setVisible(true);
		spriteD.setOpaque(true);
		
		this.add(spriteD);
	}

	private void colocarPatrulla(){

		//Primera Patrulla
		try{
			iPatrulla = new ImageIcon ("./imagenes/patrulla_nD.png");
			jlPatrulla = new JLabel();
			jlPatrulla.setBounds(0,0,509,262); //(x, y, w, h)
			jlPatrulla.setIcon(new ImageIcon(iPatrulla.getImage().getScaledInstance(jlPatrulla.getWidth(),jlPatrulla.getHeight(),Image.SCALE_SMOOTH)));
		}catch(Exception e){
			System.out.println("Error al cargar imagen.");
		} 
		jlPatrulla.setOpaque(true);
		this.add(jlPatrulla);
	}

	public void keyPressed(KeyEvent e)
	{
		int t = e.getKeyCode();
		Point pos = spriteD.getLocation();
		int x = (int)pos.getX();
		int y = (int)pos.getY();

		if(t==83)
		{
			y = y+10;
			if(indiceX>1199)
			{
				this.indiceX=0;
			}
			indiceX = indiceX + 150;
			spriteD.jugadorD = jugadorD.getSubimage(indiceX,150*2,150,150);
		}
		else if(t==87)
		{
			y = y-10;
			if(indiceX>1199)
			{
				this.indiceX=0;
			}
			indiceX = indiceX + 150;
			spriteD.jugadorD = jugadorD.getSubimage(indiceX,150*0,150,150);
		}
		spriteD.setLocation(0,y);
		if(x>ancho/2)
		{
			x=x-10;
		}
		else if(y>alto-200)
		{
			y=y-10;
		}
		else if(y<-90)
		{
			y=y+10;
		}
		spriteD.setLocation(x,y);
		//crearSonidoPasos(t); //Hilo para reproducir los pasos
	}

	public void keyReleased(KeyEvent e)
	{
		Point pos = spriteD.getLocation();
		int x = (int)pos.getX();
		int y = (int)pos.getY();
		x = x+5;
		indiceX = ((indiceX + 2) % 9) * 150;
		spriteD.jugadorD = jugadorD.getSubimage(indiceX,150*3,150,150);
		spriteD.setLocation(x,y);
		if(x>0)
		{
			x=x-5;
		}
		spriteD.setLocation(x,y);
	}

	public void keyTyped(KeyEvent e)
	{
	}

	public void crearPatrulla1()
	{
		Patrulla pat1 = new Patrulla(this.jlPatrulla, this.spriteD);
		patrulla1 = new Thread(pat1);
		patrulla1.start(); 
	}

	public void crearSonidoPasos(int t)
	{
		HiloPasos hp = new HiloPasos(t);
		sonidohp = new Thread(hp);
		sonidohp.start();
	}
}