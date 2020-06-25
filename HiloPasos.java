import javax.swing.*;

class HiloPasos implements Runnable
{

	int t;
	Pasos ps =  new Pasos();

	public HiloPasos(int t)
	{
		this.t = t;
	}

	@Override
	public void run()
	{
		if(this.t==83)
		{
			ps.inicializar();
			ps.reproducirNota(72,1,10);
			ps.finalizar();
		}

		if(this.t==87)
		{
			ps.inicializar();
			ps.reproducirNota(76,1,10);
			ps.finalizar();
		}
		retardo(50);
	}
	public void retardo(int ms)
	{
		try
			{
				Thread.sleep(ms);
			}catch(Exception e){
				System.out.println("Error: al ejecutar el sleep");
			}
	}
}