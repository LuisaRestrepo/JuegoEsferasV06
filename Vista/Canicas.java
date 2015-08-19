package Vista;

import java.awt.*;

public class Canicas {
	MediaTracker mt;
	Image canicaRoja;
	Image canicaVerde;
	Image canicaAzul;
	Image canicaAmarilla;
	Image fondo;
	
	/**Constructor de Canicas*/
	public Canicas() {
		canicaRoja = Toolkit.getDefaultToolkit().getImage("roja.png");
		canicaVerde = Toolkit.getDefaultToolkit().getImage("verde.png");
		canicaAzul = Toolkit.getDefaultToolkit().getImage("azul.png");
		canicaAmarilla = Toolkit.getDefaultToolkit().getImage("amarilla.png");
	}
	
	/**Este metodo importa las imagenes del ordenador, para que puedan ser usadas despues*/
	public Canicas(Lienzo lienzo) {
		mt = new MediaTracker(lienzo);
		canicaRoja = Toolkit.getDefaultToolkit().getImage("roja.png");
		mt.addImage(canicaRoja, 0);
		canicaVerde = Toolkit.getDefaultToolkit().getImage("verde.png");
		mt.addImage(canicaRoja, 0);
		canicaAzul = Toolkit.getDefaultToolkit().getImage("azul.png");
		mt.addImage(canicaRoja, 0);
		canicaAmarilla = Toolkit.getDefaultToolkit().getImage("amarilla.png");
		mt.addImage(canicaRoja, 0);
		/*canon = Toolkit.getDefaultToolkit().getImage("canon.png");
		mt.addImage(canicaRoja, 0);*/
		fondo = Toolkit.getDefaultToolkit().getImage("fondo.png");
		mt.addImage(canicaRoja, 0);
	}
	
	public Image getRoja() {
		return canicaRoja;
	}

	public Image getVerde() {
		return canicaVerde;
	}

	public Image getAzul() {
		return canicaAzul;
	}
	
	public Image getAmarilla(){
		return canicaAmarilla;
		
	}
	
	public Image getfondo(){
		return fondo;
	}
}
