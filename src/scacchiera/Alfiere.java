package scacchiera;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import struttura.*;

/**
 * <p>Title: Alfiere</p>
 * <p>Description: classe che gestisce gli aspetti fondamentali dell'alfiere</p>
 * @author Dalla Valle Manuel, Leone Davide, Benedetti Gianmarco
 * @version 1.0
 */

public class Alfiere extends Pezzo {
	private static final long serialVersionUID = 1L;
	/**
	 * questo metodo è il costruttore della classe Alfiere
	 * @param colore rappresenta il colore del pezzo (nero o bianco)
	 */
	public Alfiere(Colore colore) {
		super((colore.equals(Colore.BIANCO)) ? new ImageIcon("immagini/alfiere_bianca.gif") : new ImageIcon("immagini/alfiere_nera.gif"), colore);
	}
	/**
	 * questo metodo ritorna il pezzo alfiere
	 * @return il pezzo alfiere
	 */
	@Override
	public Pezzi getPezzo() {
		return Pezzi.ALFIERE;
	}
	/**
	 * questo metodo inserisce in un arrayList tutti i possibili movimenti dell alfiere
	 * @param scacchiera rappresenta una casella della scacchiera da cui vengono calcolati i possibili movimenti dell alfiere
	 * @return l'arrayList contenente le coordinate dei possibili movimenti
	 */
	@Override
	public ArrayList < Point > getMovimento(Pezzo[][] scacchiera) {
		movimenti = new ArrayList < Point > ();
		int x = this.getLocation().y,
		y = this.getLocation().x;
		boolean stop = false;

		for (int i = x, j = y;
		(i < 7 && j < 7) && !stop; i++, j++) {
			stop = ((impostaPunto(scacchiera, new Point(i + 1, j + 1)) == -1) ? true : false);
		}
		// RESET
		stop = false;
		for (int i = x, j = y;
		(i > 0 && j < 7) && !stop; i--, j++) {
			stop = ((impostaPunto(scacchiera, new Point(i - 1, j + 1)) == -1) ? true : false);
		}
		// RESET
		stop = false;
		for (int i = x, j = y;
		(i > 0 && j > 0) && !stop; i--, j--) {
			stop = ((impostaPunto(scacchiera, new Point(i - 1, j - 1)) == -1) ? true : false);
		}
		// RESET
		stop = false;
		for (int i = x, j = y;
		(i < 7 && j > 0) && !stop; i++, j--) {
			stop = ((impostaPunto(scacchiera, new Point(i + 1, j - 1)) == -1) ? true : false);
		}
		return movimenti;
	}
}