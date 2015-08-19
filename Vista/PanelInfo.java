package Vista;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelInfo extends JPanel implements ActionListener {	
	private JLabel lblNombre;
	public JTextField txtTiempo;
	public JTextField txtEsferas;
	private JButton butIzquierda;
	private JButton butDisparar;
	private JButton butDerecha;
	public static String IZQUIERDA = "izquierda";
	public static String DISPARAR = "disparar";
	public static String DERECHA = "derecha";	
	private JuegoEsferas juegoEsferas;
	
	/**constructor de panelInfo*/
	public PanelInfo(JuegoEsferas juegoEsferas) {
		this.juegoEsferas = juegoEsferas;
		
		setLayout(new GridLayout(2,3));
		setPreferredSize(new Dimension(0, 50));
		
		lblNombre = new JLabel("  Bienvenido:   " + JuegoEsferas.nombre());
		
		txtEsferas = new JTextField("  Esferas restantes  "+Integer.toString(JuegoEsferas.contPerdio));
		txtEsferas.setEditable(false);
		
		txtTiempo = new JTextField("  Tiempo restante  " + Integer.toString(JuegoEsferas.tiempo)+ "  segundos");
		txtTiempo.setEditable(false);
		
		butIzquierda = new JButton("Izquierda");
		butDisparar = new JButton("Disparar");
		butDerecha = new JButton("Derecha");
		
		butIzquierda.setActionCommand(IZQUIERDA);
		butDisparar.setActionCommand(DISPARAR);
		butDerecha.setActionCommand(DERECHA);
		
		butIzquierda.addActionListener(this);
		butDisparar.addActionListener(this);
		butDerecha.addActionListener(this);
		
		add(lblNombre);
		add(txtEsferas);
		add(txtTiempo);
		add(butIzquierda);
		add(butDisparar);
		add(butDerecha);
	}
	/**identifica cual boton es el que presiono el usuario y ejecuta una accion*/
	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();
		
		if(comando.equals(IZQUIERDA)) {
			juegoEsferas.giroIzquierda();
		} else if (comando.equals(DERECHA)) {
			juegoEsferas.giroDerecha();
		} else if (comando.equals(DISPARAR)) {
			juegoEsferas.disparar();
		}
	}
}
