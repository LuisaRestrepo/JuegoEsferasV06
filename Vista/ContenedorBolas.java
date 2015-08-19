package Vista;

public class ContenedorBolas {	
	private Bola[] bolas;	
	
	/** constructor de ContenedorBolas*/
	public ContenedorBolas (){
		bolas = new Bola[36];	
		crearBolas(); 			
	}
	
	/**Crea la imagen de las bolas mediante un random, introduce las bolas en un arreglo y las acomoda en un circulo*/
	public void crearBolas(){
		int ancho = 744;
		 int alto = 672;
		int h = (ancho/2), k = (alto/2), r =285;
		int x=0; //= h-r;	
		double incrementoBolas = 10d * Math.PI / 180d;
		for (int i = 0; x <= h+r && i < 36; i++) {			
			int n = (int)(Math.random() * 4);
			double angulo = -(incrementoBolas * Math.PI)/180.0;			
			System.out.println("Angulo = " + (angulo *180)/Math.PI);
			 x = (int) ((r * Math.cos (angulo))+h-25);
			 int y = (int) ((r * Math.sin (angulo))+k-25);
			incrementoBolas+=10;			
			bolas[i] = new Bola(x,y,n);			
		}		
	}
	
	public Bola[] getBolas() {
		return bolas;
	}
	
}
