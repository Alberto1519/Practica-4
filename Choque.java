import javax.swing.*;
import java.awt.*;

class Choque 
{
	Rectangle posPatrulla;
	Rectangle posJugadorD;

	public void patrulla(Rectangle posicionP){
		posPatrulla = posicionP;
	}

	public void jugador(Rectangle posicionJ){
		posJugadorD = posicionJ;
	}

	public Choque()
	{
		if(posJugadorD.intersects(posPatrulla))
		{
			System.out.println("Chocan");
		}
	}
}
