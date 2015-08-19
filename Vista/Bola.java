package Vista;

//import java.awt.Graphics;
import java.awt.Image;

public class Bola {
	Image canica;
	private int x;
	private int y;
	private int n;
	private Canicas canicas;
	
	public Image getImage(){
		return canica;
		
	}
	public int x (){
		return x;
		
	}
	public int y (){
		return y;
		
	}
	public int n (){
		return n;
	}
	/**Constructor de Bola, recive tres enteros 
	 * (x, y, n) donde X y Y son coordenadas y n es el color de la imagen, para poder crear la bola*/
	public Bola(int x, int y, int n){
		this.n = n;
		this.y = y;
		this.x = x;		
			canicas = new Canicas();
			switch(n) {
			case 0:
				canica = canicas.getRoja();
				break;
			case 1:
				canica = canicas.getVerde();
				break;
			case 2:
				canica = canicas.getAzul();
				break;
				
			case 3:
				canica = canicas.getAmarilla();
				break;
			}
			
		}
	}

