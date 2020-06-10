import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import javax.imageio.*;
import java.awt.event.*;

class VentanaPuntaje extends JFrame implements ActionListener{

	JPanel panel;
	
	//Titulos utilizados
	JLabel jlTitulo_1;
	ImageIcon iTitulo_1;

	//Botones
	ImageIcon iSave;
	JButton btnGuardar;
	ImageIcon iRestart;
	JButton btnReiniciar;
	ImageIcon iMenu;
	JButton btnMenu;

	//Nombre del jugador y puntos 
	JTextField txfJugador;
	JTextField txfJugador_2; //Es de calis por el momento

	//Area del puntaje
	JTextArea txaPuntajesTotales;
	ArrayList <String> puntajes;

	ControldePuntos cdp = new ControldePuntos();

	public VentanaPuntaje()
	{
		puntajes = new ArrayList<String>();

		this.setTitle("SCORES");
		this.setBounds(150,100,480, 545);

		componentes();

		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		this.setResizable(false); //Evitar que se puede hacer mas pequena la ventana
		this.setVisible(true);

		//Escuchar los botones
		btnGuardar.addActionListener(this);
		btnReiniciar.addActionListener(this);
		btnMenu.addActionListener(this);
	}

	private void componentes(){

		colocarFondo();
		colocarEtiquetas();
		colocarBotones();
		colocarAreas();
		
	}

	private void colocarFondo(){

		panel = new JPanel();
		panel.setLayout(null);
		this.getContentPane().add(panel);
	}

 	private void colocarEtiquetas(){

 		//Titulo de la ventana
 		try{
			iTitulo_1 = new ImageIcon ("./imagenes/titulo_2.png");
			jlTitulo_1 = new JLabel();
			jlTitulo_1.setBounds(50, 10, 380, 80); //(x, y, w, h)
			jlTitulo_1.setIcon(new ImageIcon(iTitulo_1.getImage().getScaledInstance(jlTitulo_1.getWidth(),jlTitulo_1.getHeight(),Image.SCALE_SMOOTH)));
			jlTitulo_1.setHorizontalAlignment(SwingConstants.CENTER);
		}catch(Exception e){
			System.out.println("Error al cargar imagen.");
		} 

		//Agregar al panel
		panel.add(jlTitulo_1);

 	}

 	private void colocarBotones(){

 		//Boton para guardar
 		try{
			iSave = new ImageIcon("./imagenes/save.png");
			btnGuardar = new JButton();
			btnGuardar.setBounds(325, 400, 85, 40); //(x, y, w, h)
			btnGuardar.setOpaque(true);
			btnGuardar.setBackground(Color.GRAY);
			btnGuardar.setIcon(new ImageIcon(iSave.getImage().getScaledInstance(btnGuardar.getWidth(),btnGuardar.getHeight(),Image.SCALE_SMOOTH)));
		}catch(Exception e){
			System.out.println("Error al cargar imgaen de boton.");
		}

		//Boton para reiniciar el juego
		try{
			iRestart = new ImageIcon("./imagenes/restart.png");
			btnReiniciar = new JButton();
			btnReiniciar.setBounds(120, 450, 100, 40); //(x, y, w, h)
			btnReiniciar.setOpaque(true);
			btnReiniciar.setBackground(Color.BLUE);
			btnReiniciar.setIcon(new ImageIcon(iRestart.getImage().getScaledInstance(btnReiniciar.getWidth(),btnReiniciar.getHeight(),Image.SCALE_SMOOTH)));
		}catch(Exception e){
			System.out.println("Error al cargar imgaen de boton.");
		}

		//Boton para ir al menu
		try{
			iMenu = new ImageIcon("./imagenes/menu.png");
			btnMenu = new JButton();
			btnMenu.setBounds(260, 450, 100, 40); //(x, y, w, h)
			btnMenu.setOpaque(true);
			btnMenu.setBackground(Color.WHITE);
			btnMenu.setIcon(new ImageIcon(iMenu.getImage().getScaledInstance(btnMenu.getWidth(),btnMenu.getHeight(),Image.SCALE_SMOOTH)));
		}catch(Exception e){
			System.out.println("Error al cargar imgaen de boton.");
		}
		
		//Agregar botones al panel
		panel.add(btnGuardar);
		panel.add(btnReiniciar);
		panel.add(btnMenu);
 	}

 	private void colocarAreas(){

 		//Mostras los puntajes obtenidos
 		txaPuntajesTotales = new JTextArea(); //Los puntajes
		txaPuntajesTotales.setBounds(50,90,380,300);
		leerPuntaje();
		txaPuntajesTotales.setFont(new Font("Times New Roman",3,18));
		txaPuntajesTotales.setForeground(Color.WHITE);
		txaPuntajesTotales.setBackground(Color.BLACK);
		txaPuntajesTotales.setEditable(false);

		//Nombre del jugador
		txfJugador = new JTextField();
		txfJugador.setBounds(50,400,100,40);

		//Puntos del jugador (CALIS)
		txfJugador_2 = new JTextField();
		txfJugador_2.setBounds(180,400,100,40);

		//Agregar al panel
		panel.add(txfJugador);
		panel.add(txfJugador_2);
		panel.add(txaPuntajesTotales);
 	}


	public void leerPuntaje(){

		puntajes = cdp.leerPuntaje();
			
		String pts = "";

		for (int i=0; i<puntajes.size(); i++) 
		{
			pts = pts + puntajes.get(i) + "\n";
		}

		txaPuntajesTotales.setText(pts);
		txaPuntajesTotales.setEditable(false);	
	}

	public void actionPerformed(ActionEvent event){

		if(event.getSource() == this.btnGuardar){
			try{
			String jugador = txfJugador.getText();
			String punt = txfJugador_2.getText();
			cdp.guardarPuntos(jugador,punt);
			}catch(Exception e){
				System.out.println("Error al cargar jugador o puntos.");
			}
			btnGuardar.setEnabled(false);
			leerPuntaje();
		}

		if(event.getSource() == this.btnReiniciar){
			this.setVisible(false);
			//Codigo para volver a iniciar la ventana
		}

		if(event.getSource() == this.btnMenu){
			//this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			//RunAway.setVisible(true);
		}
	}

}