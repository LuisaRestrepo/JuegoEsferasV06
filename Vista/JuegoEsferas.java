package Vista;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import javax.swing.*;

import Mundo.Canyon;
import Mundo.ObjetosDelMundo;

public class JuegoEsferas extends JFrame {

	private PanelInfo panelInfo;
	private Lienzo lienzo;	
	private ObjetosDelMundo objetos;
	private ContenedorBolas contenedorBolas;
	private boolean empezar = true;
	static String nombre="";
	static int contPerdio=40;
	
	
	/**constructor de JuegoEsferas*/
	public JuegoEsferas() {
        this.setTitle("Juego de Esferas");
        this.setLocation(10, 10);
        this.setSize(750, 850);
        this.setResizable(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        contenedorBolas= new ContenedorBolas();
        setLayout(new BorderLayout());
        lienzo = new Lienzo();
        add(lienzo, BorderLayout.CENTER);        
        panelInfo = new PanelInfo(this);
        add(panelInfo, BorderLayout.SOUTH);        
        objetos = new ObjetosDelMundo();
        objetos.conectarCanyonLienzo(lienzo);
        setVisible(true);
    }
	
	/** pantalla de Bienvenida. Pide el nombre del jugador*/
	public static String nombre (){
			nombre = JOptionPane.showInputDialog(     		   
     		   "Por favor ingrese su nombre",
     		   "<Nombre_jugador>");
		if (nombre == null || nombre.equals(null)) System.exit(0);
     	        return nombre;     	        
	}
	
	public void giroIzquierda() {
		objetos.girarIzquierda();
	}
	
	public void giroDerecha() {
		objetos.girarDerecha();
	}
	
	 /**este metodo encaja el angulo del cañon entre dos numeros, dados por i+4 e i-4, que va aumentando de 10 en 10; numero que despues se divide por 10, se le suma 0.1 y se castea como 
	 *entero, dando como resultado un numero entre 0 y 36 (pocisiones del arreglo), acto seguido compara el color (n) de la bola del Cañon y la bola que se encuentra en la pocision del 
	 *arreglo dada por el angulo, tambien comprueba dos pocisiones hacia la izquierda y dos hacia la derecha y si son del mismo color (n) la pocision queda null
	 *Ademas, inicializa un int cont en 36, y cada que una bola es destruida (null) le resta uno, asi cuando cont = 0 es por que no hay bolas en el arreglo, en este caso, se muestra el letrero de "Ganaste!"
	 **y ene el caso de que el contPerdio llegue a 0, el usuari pierde y se muestra la ventana de "Usted perdio" */
    static int contGano = 36;
	public void disparar() {
		if (empezar==true){
	        timer.start();
	        empezar = false;
	        lienzo.repaint();
		}
		contPerdio--;
		panelInfo.txtEsferas.setText("Esferas restantes: "+Integer.toString(JuegoEsferas.contPerdio));
		double angulo = lienzo.getAngulo();
			for (double i=0; i<=360; i=i+10){			
				if ((angulo*180)/Math.PI <=  i+4 && (angulo*180)/Math.PI>=i-4){
					System.out.println("la bola destruida es  " +  (int) ((i/10)+0.1));
					if (lienzo.getContenedor().getBolas()[(int) ((i/10)+0.1)] == null)
						lienzo.sigBola();
					if ((angulo*180)/Math.PI >= 0.0 && (angulo*180)/Math.PI <= 4.0 && lienzo.getContenedor().getBolas()[0] != null && lienzo.getContenedor().getBolas()[0].n() == lienzo.bolaCanon.n()){
						lienzo.getContenedor().getBolas()[0]=null;
						lienzo.repaint();
						contGano--;
						if (lienzo.getContenedor().getBolas()[35] != null && lienzo.getContenedor().getBolas()[35].n() == lienzo.bolaCanon.n() ){
							lienzo.getContenedor().getBolas()[35]=null;
							lienzo.repaint();
							contGano--;
							if (lienzo.getContenedor().getBolas()[34] != null && lienzo.getContenedor().getBolas()[34].n() == lienzo.bolaCanon.n() ){
								lienzo.getContenedor().getBolas()[34]=null;
								lienzo.repaint();
								contGano--;
								if (lienzo.getContenedor().getBolas()[33] != null && lienzo.getContenedor().getBolas()[33].n() == lienzo.bolaCanon.n() ){
									lienzo.getContenedor().getBolas()[33]=null;
									lienzo.repaint();
									contGano--;
								}
							}
						}
						if (lienzo.getContenedor().getBolas()[1] != null && lienzo.getContenedor().getBolas()[1].n() == lienzo.bolaCanon.n() ){
							lienzo.getContenedor().getBolas()[1]=null;
							lienzo.repaint();
							contGano--;
							if (lienzo.getContenedor().getBolas()[2] != null && lienzo.getContenedor().getBolas()[2].n() == lienzo.bolaCanon.n() ){
								lienzo.getContenedor().getBolas()[2]=null;
								lienzo.repaint();
								contGano--;
								if (lienzo.getContenedor().getBolas()[3] != null && lienzo.getContenedor().getBolas()[3].n() == lienzo.bolaCanon.n() ){
									lienzo.getContenedor().getBolas()[3]=null;
									lienzo.repaint();
									contGano--;
								}
							}
						}
					}
					if ((angulo*180)/Math.PI >= 347.0 && (angulo*180)/Math.PI <= 360.0 && lienzo.getContenedor().getBolas()[35] != null && lienzo.getContenedor().getBolas()[35].n() == lienzo.bolaCanon.n()){
						lienzo.getContenedor().getBolas()[35]=null;
						lienzo.repaint();
						contGano--;
						if (lienzo.getContenedor().getBolas()[0] != null && lienzo.getContenedor().getBolas()[0].n() == lienzo.bolaCanon.n() ){
							lienzo.getContenedor().getBolas()[0]=null;
							lienzo.repaint();
							contGano--;
							if (lienzo.getContenedor().getBolas()[1] != null && lienzo.getContenedor().getBolas()[1].n() == lienzo.bolaCanon.n() ){
								lienzo.getContenedor().getBolas()[1]=null;
								lienzo.repaint();
								contGano--;
								if (lienzo.getContenedor().getBolas()[2] != null && lienzo.getContenedor().getBolas()[2].n() == lienzo.bolaCanon.n() ){
									lienzo.getContenedor().getBolas()[2]=null;
									lienzo.repaint();
									contGano--;
								}
							}
						}
						if (lienzo.getContenedor().getBolas()[34] != null && lienzo.getContenedor().getBolas()[34].n() == lienzo.bolaCanon.n() ){
							lienzo.getContenedor().getBolas()[34]=null;
							lienzo.repaint();
							contGano--;
							if (lienzo.getContenedor().getBolas()[33] != null && lienzo.getContenedor().getBolas()[33].n() == lienzo.bolaCanon.n() ){
								lienzo.getContenedor().getBolas()[33]=null;
								lienzo.repaint();
								contGano--;
								if (lienzo.getContenedor().getBolas()[32] != null && lienzo.getContenedor().getBolas()[32].n() == lienzo.bolaCanon.n() ){
									lienzo.getContenedor().getBolas()[33]=null;
									lienzo.repaint();
									contGano--;
								}
							}
						}
					}				
						
						if ( lienzo.getContenedor().getBolas()[(int) ((i/10)+0.1)] != null  && lienzo.getContenedor().getBolas()[(int) ((i/10)+0.1)].n() == lienzo.bolaCanon.n()){						
						lienzo.getContenedor().getBolas()[(int) (i/10)]=null;
						lienzo.repaint();
						contGano--;
						System.out.println(contGano);
							if (lienzo.getContenedor().getBolas()[(int) (((i+10)/10)+0.1)] != null && lienzo.getContenedor().getBolas()[(int) (((i+10)/10)+0.1)].n() == lienzo.bolaCanon.n()){
								lienzo.getContenedor().getBolas()[(int) ((i+10)/10)]=null;
								lienzo.repaint();
								contGano--;
								System.out.println(contGano);
									if (lienzo.getContenedor().getBolas()[(int) (((i+20)/10)+0.1)] != null && lienzo.getContenedor().getBolas()[(int) (((i+20)/10)+0.1)].n() == lienzo.bolaCanon.n()){
										lienzo.getContenedor().getBolas()[(int) ((i+20)/10)]=null;
										lienzo.repaint();
										contGano--;
										System.out.println(contGano);
									}
							}
						if (lienzo.getContenedor().getBolas()[(int) (((i-10)/10)+0.1)] != null && lienzo.getContenedor().getBolas()[(int) (((i-10)/10)+0.1)].n() == lienzo.bolaCanon.n()){
							lienzo.getContenedor().getBolas()[(int) ((i-10)/10)]=null;
							contGano--;
							System.out.println(contGano);
								if (lienzo.getContenedor().getBolas()[(int) (((i-20)/10)+0.1)] != null &&lienzo.getContenedor().getBolas()[(int) (((i-20)/10)+0.1)].n() == lienzo.bolaCanon.n()){
									lienzo.getContenedor().getBolas()[(int) ((i-20)/10)]=null;
									contGano--;	
									System.out.println(contGano);
									
								}
							}								
						}					
					}
				
				if (contGano == 0){
					JOptionPane.showMessageDialog (this, nombre + "  ¡FELICITACIONES! Has ganado!!");
					System.out.println ("idgjkldsjgiosdg");
					dispose();
					contGano++;
				}
				
				if (contPerdio == 0){
					mensajePerdio();
					System.exit(0);
				
				}
	}
			
			lienzo.sigBola();
	}
	
	/**Mensaje que se muestra cuando el usuario pierde*/
	public void mensajePerdio(){
			lienzo.repaint();
			JOptionPane.showMessageDialog (this, nombre +"  Lamento informarte que...Has Perdido!");
			dispose();
		
		
	}

	/** se crea un objeo de juegoEsferas*/
	public static void main(String[] args) {		
		JuegoEsferas juegoEsferas = new JuegoEsferas();
		
	}
	/**Metodo que se encarga de llevar el tiempo, cuando el tiempo ==0 se muestra la ventana de "Usted perdio"*/
	public static int tiempo = 65; 
	Timer timer = new Timer (1000, new ActionListener () 
	{ 
	    public void actionPerformed(ActionEvent e) 
	    { 
	        tiempo--;
	        panelInfo.txtTiempo.setText("  Tiempo restante  "+Integer.toString(JuegoEsferas.tiempo)+ "  segundos");
	        if (tiempo == 0){
	        	mensajePerdio();
	        }
	     }
	    
	    	

	});

	




}
