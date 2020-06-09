import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import javax.imageio.*;
import java.awt.event.*;

class VentanaPuntaje extends JFrame implements ActionListener{

	JPanel panel;
	JLabel lblTitulo;

	JButton btnGuardar;
	JButton btnReiniciar;
	JButton btnMenu;

	JTextField txfJugador;
	JTextField txfJugador_2; //Es de calis por el momento

	JTextArea txaPuntajesTotales;
	
	ArrayList <String> puntajes;

	ControldePuntos cdp = new ControldePuntos();

	public VentanaPuntaje()
	{
		panel = new JPanel();
		panel.setLayout(null);
		lblTitulo = new JLabel("Puntajes");
		lblTitulo.setFont(new Font("Times New Roman",3,30));
		lblTitulo.setBounds(170, 20, 200, 30);

		txaPuntajesTotales = new JTextArea(); //Los puntajes
		txaPuntajesTotales.setBounds(50,65,350,300);
		leerPuntaje();
		txaPuntajesTotales.setEditable(false);

		txfJugador = new JTextField();
		txfJugador.setBounds(50, 380, 100, 30);

		//Calis por el momento
		txfJugador_2 = new JTextField();
		txfJugador_2.setBounds(180, 380, 100, 30);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Times New Roman",0,15));
		btnGuardar.setBackground(Color.BLACK);
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setBounds(325, 380, 100, 30);

		btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.setFont(new Font("Times New Roman",0,15));
		btnReiniciar.setBounds(120, 435, 100, 30);

		btnMenu = new JButton("Menu");
		btnMenu.setFont(new Font("Times New Roman",0,15));
		btnMenu.setBounds(260, 435, 100, 30);

		puntajes = new ArrayList<String>();

		panel.add(lblTitulo);

		panel.add(txfJugador);
		panel.add(txfJugador_2);

		panel.add(txaPuntajesTotales);

		panel.add(btnGuardar);
		panel.add(btnReiniciar);
		panel.add(btnMenu);

		this.add(panel);
		this.setTitle("PUNTAJES");
		this.setBounds(150,100,480, 545);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		this.setResizable(false); //Evitar que se puede hacer mas pequena la ventana
		this.setVisible(true);

		btnGuardar.addActionListener(this);
		btnReiniciar.addActionListener(this);
		btnMenu.addActionListener(this);
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