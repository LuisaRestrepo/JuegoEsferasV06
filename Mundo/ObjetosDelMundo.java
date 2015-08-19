package Mundo;
import java.util.Observer;

public class ObjetosDelMundo {
	private Canyon canyon;
	/**Constructor de ObjetosDelMundo*/
	public ObjetosDelMundo() {
		canyon = new Canyon();
	}
	/**conecta el cañon y el lienzo*/
	public void conectarCanyonLienzo(Observer lienzo) {
		canyon.addObserver(lienzo);
	}
	
	public void girarIzquierda() {
		canyon.girarIzquierda();
	}

	public void girarDerecha() {
		canyon.girarDerecha();
	}

}
