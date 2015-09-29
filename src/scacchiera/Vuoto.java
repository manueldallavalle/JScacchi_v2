package scacchiera;
import struttura.*;

/**
 * <p>Title: Vuoto</p>
 * <p>Description: classe che serve per impostare le caselle vuote della scacchiera</p>
 * @author Dalla Valle Manuel, Leone Davide, Benedetti Gianmarco
 * @version 1.0
 */

public class Vuoto extends Pezzo {
	private static final long serialVersionUID = 1L;
	/**
	 * questo metodo è il costruttore della classe Vuoto
	 */
	public Vuoto() {
		super(new javax.swing.ImageIcon(""));
	}
	/**
	 * questo metodo è il costruttore della classe Vuoto
	 * @param colore rappresenta il colore del pezzo (nero o bianco)
	 */
	public Vuoto(Colore colore) {
		super(new javax.swing.ImageIcon(""));
	}
	/**
	 * questo metodo ritorna il pezzo vuoto
	 * @return il pezzo vuoto
	 */
	public Pezzi getPezzo() {
		return Pezzi.VUOTO;
	}
}