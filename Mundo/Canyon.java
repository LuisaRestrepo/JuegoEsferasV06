package Mundo;
import java.util.Observable;

public class Canyon extends Observable {
	private double angulo;
	private double incremento = 10d * Math.PI / 180d;	
	private boolean DEBUG = false;
	
	/**Constructor de Canyon*/
	public Canyon() {
		angulo = 0d;
	}
	
	/**rota el ca�on a la izquierda*/
	public void girarIzquierda() {		
		angulo += incremento;
		if (angulo >= 2*Math.PI )
			angulo -= 2* Math.PI;
		if ((angulo*180)/Math.PI > 355)
			angulo=0.0;			
		notificar();
		System.out.println("angulo ca�on = " +(angulo*180)/Math.PI);
	}
	
/** rota el ca�on a la derecha*/
	public void girarDerecha() {
		angulo -= incremento;				
		if (angulo < 0.0)
			angulo+=2*Math.PI;
		if ((angulo*180)/Math.PI > 355)
			angulo=0.0;		
		notificar();
		System.out.println(("angulo ca�on = " + (angulo*180)/Math.PI)); 
	}
	
	/**le avisa a los observadores que el ca�on cambio de angulo, y les indica el valor del nuevo angulo*/
	private void notificar() {
		setChanged();
		notifyObservers(new Double(angulo));
		if (!DEBUG) System.out.println("En Canyon, angulo: " + angulo);		
	}
	public double getAngulo(){
		return angulo;
	}
}
