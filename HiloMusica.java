import javax.swing.*;

class HiloPasos implements Runnable{
	int t;
	Pasos ps =  new Pasos();

	public HiloPasos(int t){
		this.t = t;
	}

	@Override
	public void run(){
		if(this.t==83){
			ps.inicializar();
			ps.reproducirNota(72,1,200);
			ps.finalizar();
		}

		if(this.t==87){
			ps.inicializar();
			ps.reproducirNota(79,1,200);
			ps.finalizar();
		}

	}
}