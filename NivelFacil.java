import java.awt.*;
import javax.swing.*;

class NivelFacil extends JFrame{
	
	JPanel panel;
	JLabel lblTexto1;


	public NivelFacil()
	{
		panel = new JPanel();
		panel.setLayout(null);
		lblTexto1 = new JLabel("Nivel Facil");
		lblTexto1.setBounds(50, 150, 100, 10); //(x, y, w, h)
	
		panel.add(lblTexto1);
		
		this.add(panel);
		this.setTitle("NIVEL FACIL");
		this.setSize(600, 400);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}