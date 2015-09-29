package scacchiera;
import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 * <p>Title: Main</p>
 * <p>Description: la classe principale del progetto</p>
 * @author Dalla Valle Manuel, Leone Davide, Benedetti Gianmarco
 * @version 1.0
 */

public class Main {
	/**
	 * questo metodo è il main della classe Main
	 * @param arg rappresenta l'input
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			/**
			 * metodo che inizializza la scacchiera
			 */
			@Override
			public void run() {
				JFrame frame = new Scacchiera();
				frame.setTitle("Scacchi");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				frame.setResizable(false);
			}
		});
	}
}