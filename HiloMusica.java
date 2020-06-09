import javax.swing.*;

class HiloMusica implements Runnable{
	int t;
	Musica ms =  new Musica();

	public HiloMusica(int t){
		this.t = t;
	}

	@Override
	public void sonar(){
		if(this.t==83){
			ms.inicializar();
			ms.reproducirNota(72,1,200);
			ms.finalizar();
		}

		if(this.t==87){
			ms.inicializar();
			ms.reproducirNota(79,1,200);
			ms.finalizar();
		}
	}
}