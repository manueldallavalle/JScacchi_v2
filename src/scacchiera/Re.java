package scacchiera;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import struttura.*;

/**
 * <p>Title: Re</p>
 * <p>Description: classe che gestisce gli aspetti fondamentali del Re</p>
 * @author Dalla Valle Manuel, Leone Davide, Benedetti Gianmarco
 * @version 1.0
 */

public class Re extends Pezzo {
	private static final long serialVersionUID = 1L;
	/**
	 * questo metodo è il costruttore della classe Re
	 * @param colore rappresenta il colore del pezzo (nero o bianco)
	 */
	public Re(Colore colore) {
		super((colore.equals(Colore.BIANCO)) ? new ImageIcon("immagini/re_bianca.gif") : new ImageIcon("immagini/re_nera.gif"), colore);
	}
	/**
	 * questo metodo ritorna il pezzo re
	 * @return il pezzo re
	 */@Override
	public Pezzi getPezzo() {
		return Pezzi.RE;
	}
	/**
	 * questo metodo inserisce in un arrayList tutti i possibili movimenti del re
	 * @param scacchiera rappresenta una casella della scacchiera da cui vengono calcolati i possibili movimenti del re
	 * @return l'arrayList contenente le coordinate dei possibili movimenti
	 */@Override
	public ArrayList < Point > getMovimento(Pezzo[][] scacchiera) {
		int x = this.getLocation().y,
		y = this.getLocation().x;

		movimenti = new ArrayList < Point > ();

		impostaPunto(scacchiera, new Point(x, y + 1));
		impostaPunto(scacchiera, new Point(x, y - 1));

		impostaPunto(scacchiera, new Point(x + 1, y));
		impostaPunto(scacchiera, new Point(x - 1, y));

		impostaPunto(scacchiera, new Point(x - 1, y + 1));
		impostaPunto(scacchiera, new Point(x - 1, y - 1));

		impostaPunto(scacchiera, new Point(x + 1, y + 1));
		impostaPunto(scacchiera, new Point(x + 1, y - 1));

		return movimenti;
	}
}