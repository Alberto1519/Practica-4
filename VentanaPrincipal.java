import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;

class VentanaPrincipal extends JFrame implements ActionListener{

	JPanel panel;

	//Primera ventana
	ImageIcon iTitulo_1;
	JLabel jlTitulo_1;
	
	ImageIcon iTitulo_2;
	JLabel jlTitulo_2;
	
	ImageIcon iStart;
	
	JButton btnInicio;
	
	ImageIcon iPatrulla;
	JLabel jlPatrulla;

	ImageIcon iNivel;
	JLabel jlNivel;

	JRadioButton btnFacil;
	JRadioButton btnDificil;
	ButtonGroup bgNiveles;

	public VentanaPrincipal(){

		this.setTitle("RUN AWAY ...");
		this.setSize(450,700); //Tamano de la ventana (x, y)
		this.setLocationRelativeTo(null); //Ventana en el centro

		componentes();//Agregar todos los componentes a la ventana

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false); //Evitar que se puede hacer mas pequena la ventana
		this.setVisible(true);
	}

	private void componentes(){

		colocarFondo();
		colocarEtiquetas();
		colocarBotones();
		colocarRadioBotones();

	}

	private void colocarFondo(){

		panel = new JPanel();
		panel.setLayout(null);
		this.getContentPane().add(panel);
	}

	private void colocarEtiquetas(){

		//Titulo de la primera ventana
		try{
			iTitulo_1 = new ImageIcon ("./imagenes/titulo_1.png");
			jlTitulo_1 = new JLabel();
			jlTitulo_1.setBounds(30,10,380,200); //(x, y, w, h)
			jlTitulo_1.setIcon(new ImageIcon(iTitulo_1.getImage().getScaledInstance(jlTitulo_1.getWidth(),jlTitulo_1.getHeight(),Image.SCALE_SMOOTH)));
			jlTitulo_1.setHorizontalAlignment(SwingConstants.CENTER);
		}catch(Exception e){
			System.out.println("Error al cargar imagen.");
		} 
		

		//2da parte titulo de la primera ventana
		try{
			iTitulo_2 = new ImageIcon ("./imagenes/police.png");
			jlTitulo_2 = new JLabel();
			jlTitulo_2.setBounds(150,240,150,40); //(x, y, w, h)
			jlTitulo_2.setIcon(new ImageIcon(iTitulo_2.getImage().getScaledInstance(jlTitulo_2.getWidth(),jlTitulo_2.getHeight(),Image.SCALE_SMOOTH)));
			jlTitulo_2.setHorizontalAlignment(SwingConstants.RIGHT);
		}catch(Exception e){
			System.out.println("Error al cargan imagen.");
		}

		//Imagen de la patrulla
		try{
			iPatrulla = new ImageIcon ("./imagenes/patrol.png");
			jlPatrulla = new JLabel();
			jlPatrulla.setBounds(130,300,180,150); //(x, y, w, h)
			jlPatrulla.setIcon(new ImageIcon(iPatrulla.getImage().getScaledInstance(jlPatrulla.getWidth(),jlPatrulla.getHeight(),Image.SCALE_SMOOTH)));
			jlPatrulla.setHorizontalAlignment(SwingConstants.RIGHT);
		}catch(Exception e){
			System.out.println("Error al cargan imagen.");
		}

		//Imagen del nivel
		try{
			iNivel = new ImageIcon ("./imagenes/levels.png");
			jlNivel = new JLabel();
			jlNivel.setBounds(125,430,200,100); //(x, y, w, h)
			jlNivel.setIcon(new ImageIcon(iNivel.getImage().getScaledInstance(jlNivel.getWidth(),jlNivel.getHeight(),Image.SCALE_SMOOTH)));
			jlNivel.setHorizontalAlignment(SwingConstants.RIGHT);
		}catch(Exception e){
			System.out.println("Error al cargan imagen.");
		}

		//Agregar al panel
		panel.add(jlTitulo_1);
		panel.add(jlTitulo_2);
		panel.add(jlPatrulla);
		panel.add(jlNivel);
	}

	private void colocarBotones(){
		
		//Boton de Start
		try{
			iStart = new ImageIcon("./imagenes/start.png");
			btnInicio = new JButton();
			btnInicio.setBounds(150,600,150,50); //(x, y, w, h)
			btnInicio.setOpaque(true);
			btnInicio.setBackground(Color.BLACK);
			btnInicio.setIcon(new ImageIcon(iStart.getImage().getScaledInstance(btnInicio.getWidth(),btnInicio.getHeight(),Image.SCALE_SMOOTH)));
		}catch(Exception e){
			System.out.println("Error al cargar imgaen de boton.");
		}

		//Agregar boton al panel
		panel.add(btnInicio); 

		//Escuchar las acciones del boton de inicio
		btnInicio.addActionListener(this);
	}

	public void colocarRadioBotones(){

		//Boton para nivel facil
		btnFacil = new JRadioButton();
		btnFacil.setBounds(50,510,200,30); //(x, y, w, h)
		btnFacil.setEnabled(true);
		btnFacil.setText("EASY");
		btnFacil.setFont(new Font("Times New Roman",3,18));
		
		panel.add(btnFacil);
		btnFacil.addActionListener(this);

		//Boton para nivel dificil
		btnDificil = new JRadioButton();
		btnDificil.setBounds(50,540,200,50); //(x, y, w, h)
		btnDificil.setEnabled(true);
		btnDificil.setText("HARD");
		btnDificil.setFont(new Font("Times New Roman",3,18));
		
		panel.add(btnDificil);
		btnDificil.addActionListener(this);

		//Crear un grupo de botones
		bgNiveles = new ButtonGroup();
		bgNiveles.add(btnFacil);
		bgNiveles.add(btnDificil);
	}

	//Escuchar las opciones
	public void actionPerformed(ActionEvent event){
		if(btnFacil.isSelected()==true && event.getSource() == this.btnInicio)
		{
			NivelFacil nF = new NivelFacil();
			this.setVisible(false);
		}

		if(btnDificil.isSelected()==true && event.getSource() == this.btnInicio)
		{
			NivelDificil nD = new NivelDificil();
			this.setVisible(false);
		}
	}
}	