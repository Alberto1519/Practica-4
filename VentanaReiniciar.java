import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import javax.imageio.*;
import java.awt.event.*;

class VentanaReiniciar extends JFrame implements ActionListener{

	JPanel panel;
	
	//Titulos utilizados
	JLabel jlTitulo_1;
	ImageIcon iTitulo_1;

	JLabel jlEtiqueta;

	//Botones
	ImageIcon iFacil;
	JButton btnFacil;
	ImageIcon iDificil;
	JButton btnDificil;

	public VentanaReiniciar()
	{
		this.setTitle("RESTART");
		this.setBounds(300,20,300, 220);

		componentes();

		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setResizable(false); //Evitar que se puede hacer mas pequena la ventana
		this.setVisible(true);

		//Escuchar los botones
		btnFacil.addActionListener(this);
		btnDificil.addActionListener(this);
	}

	private void componentes(){

		colocarFondo();
		colocarEtiquetas();
		colocarBotones();
	}

	private void colocarFondo(){

		panel = new JPanel();
		panel.setLayout(null);
		this.getContentPane().add(panel);
	}

 	private void colocarEtiquetas(){

 		//Titulo de la ventana
 		try{
			iTitulo_1 = new ImageIcon ("./imagenes/levels.png");
			jlTitulo_1 = new JLabel();
			jlTitulo_1.setBounds(50,10,200,100); //(x, y, w, h)
			jlTitulo_1.setIcon(new ImageIcon(iTitulo_1.getImage().getScaledInstance(jlTitulo_1.getWidth(),jlTitulo_1.getHeight(),Image.SCALE_SMOOTH)));
			jlTitulo_1.setHorizontalAlignment(SwingConstants.CENTER);
		}catch(Exception e){
			System.out.println("Error al cargar imagen.");
		} 

		//Elegir nivel
		jlEtiqueta = new JLabel("Choose");
		jlEtiqueta.setBounds(110,100,80,18);
		jlEtiqueta.setFont(new Font("Times New Roman",3,18));
		jlEtiqueta.setHorizontalAlignment(SwingConstants.CENTER);

		//Agregar al panel
		panel.add(jlTitulo_1);
		panel.add(jlEtiqueta);
 	}

 	private void colocarBotones(){

 		//Boton para reiniciar el nivel Dificil
 		try{
			iFacil = new ImageIcon("./imagenes/facil.png");
			btnFacil = new JButton();
			btnFacil.setBounds(50, 125, 80, 50); //(x, y, w, h)
			btnFacil.setOpaque(true);
			btnFacil.setBackground(Color.BLUE);
			btnFacil.setIcon(new ImageIcon(iFacil.getImage().getScaledInstance(btnFacil.getWidth(),btnFacil.getHeight(),Image.SCALE_SMOOTH)));
		}catch(Exception e){
			System.out.println("Error al cargar imgaen de boton.");
		}

		//Boton para reiniciar el nivel Dificil
		try{
			iDificil = new ImageIcon("./imagenes/dificil.png");
			btnDificil = new JButton();
			btnDificil.setBounds(170, 125, 80, 50); //(x, y, w, h)
			btnDificil.setOpaque(true);
			btnDificil.setBackground(Color.BLUE);
			btnDificil.setIcon(new ImageIcon(iDificil.getImage().getScaledInstance(btnDificil.getWidth(),btnDificil.getHeight(),Image.SCALE_SMOOTH)));
		}catch(Exception e){
			System.out.println("Error al cargar imgaen de boton.");
		}

		//Agregar botones al panel
		panel.add(btnFacil);
		panel.add(btnDificil);
 	}

 	public void actionPerformed(ActionEvent event){

		if(event.getSource() == this.btnFacil){
			NivelFacil nF = new NivelFacil();
			dispose();
		}

		if(event.getSource() == this.btnDificil){
			NivelDificil nD = new NivelDificil();
			dispose();
		}
	}

}	