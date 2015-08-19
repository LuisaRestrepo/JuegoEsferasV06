package Vista;
import java.awt.*;
import java.util.*;

public class Lienzo extends Canvas implements Observer {
	
	private double anguloCanyon = 0d * Math.PI / 180d;
	private int largoCanyon = 100;
	private int ancho = 0;
	private int alto = 0;
	private Canicas canicas;
	private ContenedorBolas contenedorBolas;
	Bola bolaCanon;
	
	/**constructor de Lienzo*/
	public Lienzo() {
		super();
		canicas = new Canicas(this);
		contenedorBolas = new ContenedorBolas();
		sigBola();
	}
	
	/**observa el angulo del cañon, se actualiza con el nuevo angulo del cañon y lo pinta */
	public void update(Observable canyon, Object nuevoAngulo) {
		anguloCanyon = ((Double)nuevoAngulo).doubleValue();
		repaint();
	}
	
	/** Dibuja toto lo que hay dentro del Canvas*/
	public void paint(Graphics g) {
		g.clearRect(0, 0, getSize().width, getSize().height);
		ancho = getSize().width;
		alto = getSize().height;
		g.fillRect(0, 0, ancho ,alto );
		dibujarFondo(g);
		dibujarCanyon(g);		
		Bola[] bolas = contenedorBolas.getBolas();	
		for(int i = 0; i <  36; i++) {
			Bola bolaActual = bolas[i];
			if (bolaActual!=null){
				g.drawImage(bolaActual.getImage(),bolaActual.x(), bolaActual.y(), this);				
			}			
		}			
		for (int i = 0; i<bolas.length-1; i++){		
				int ancho = 744;
				int alto = 672;
				int h = (ancho/2), k = (alto/2);			
				g.drawImage(bolaCanon.getImage(), h-15, k-25,this);
		}
	}	
	
	/**Dibuja el cañon con su nuevo angulo*/
	private void dibujarCanyon(Graphics g) {
		g.setColor(Color.white);
		int x1 = ancho/2;
		int deltax = (int)(largoCanyon * Math.cos(anguloCanyon));
		int deltay = (int)(largoCanyon * Math.sin(anguloCanyon));
		
		g.drawLine(x1+10, 330, (x1+10) + deltax, 330 - deltay);	
	}
	
	/**Dibuja la imagen de fondo*/
	private void dibujarFondo (Graphics g){
		g.drawImage(canicas.getfondo(),0,0, this);	
	}
	
	/**crea las bola del cañon*/
	int bolaSup = 35;
	public void sigBola() {		
		int n = (int)(Math.random()*4);
		int x=0;
		int y=0;
		bolaCanon = new Bola(x,y,n);
		repaint();
		System.out.println("el color de la bola es el mismo que el de la bola en la pocision  " + n);
	}
	
	public ContenedorBolas getContenedor() {
		return contenedorBolas;
	}
	
	public double getAngulo() {
		return anguloCanyon;
	}

}
