import java.awt.Point;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import struttura.*;

/**
 * <p>Title: Cavallo</p>
 * <p>Description: classe che gestisce gli aspetti fondamentali del cavallo</p>
 * @author Dalla Valle Manuel, Leone Davide, Benedetti Gianmarco
 * @version 1.0
 */

public class Cavallo extends Pezzo {
	private static final long serialVersionUID = 1L;
	/**
	 * questo metodo è il costruttore della classe Cavallo
	 * @param colore rappresenta il colore del pezzo (nero o bianco)
	 */
	public Cavallo(Colore colore) {
		super((colore.equals(Colore.BIANCO)) ? new ImageIcon("immagini/cavallo_bianca.gif") : new ImageIcon("immagini/cavallo_nera.gif"), colore);
	}
	/**
	 * questo metodo ritorna il pezzo cavallo
	 * @return il pezzo cavallo
	 */
	@Override
	public Pezzi getPezzo() {
		return Pezzi.CAVALLO;
	}
	/**
	 * questo metodo inserisce in un arrayList tutti i possibili movimenti del cavallo
	 * @param scacchiera rappresenta una casella della scacchiera da cui vengono calcolati i possibili movimenti del cavallo
	 * @return l'arrayList contenente le coordinate dei possibili movimenti
	 */
	@Override
	public ArrayList < Point > getMovimento(Pezzo[][] scacchiera) {

		final int[] posix_riga = {
	 	-1, -1, -2, -2, 1, 1, 2, 2
		};
		final int[] posix_colonna = {
			2, -2, 1, -1, 2, -2, 1, -1
		};
		ArrayList < Point > punti = new ArrayList < > ();
		for (int i = 0; i < 8; i++) {
			if ((getLocation().y) + posix_riga[i] < 8 && (getLocation().y) + posix_riga[i] > -1 && (getLocation().x) + posix_colonna[i] < 8 && (getLocation().x) + posix_colonna[i] > -1) {
				punti.add(new Point((getLocation().y + posix_riga[i]), (getLocation().x + posix_colonna[i])));
			}
		}
		return punti;
	}
}