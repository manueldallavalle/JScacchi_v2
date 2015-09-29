import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.JButton;
import struttura.*;

/**
 * <p>Title: Pezzo</p>
 * <p>Description: classe che serve per la costruzione e gestione di un pezzo generico</p>
 * @author Dalla Valle Manuel, Leone Davide, Benedetti Gianmarco
 * @version 1.0
 */

public abstract class Pezzo extends JButton {
	private static final long serialVersionUID = 1L;
	private Colore colore;
	private Point location;
	protected ArrayList < Point > movimenti;
	/**
	 * questo metodo è il costruttore della classe Pezzo
	 * @param img è l'immagine del pezzo da costruire
	 */
	protected Pezzo(Icon img) {
		this(img, Colore.VUOTO);
		setPreferredSize(new Dimension(70, 70));
	}
	/**
	 * questo metodo è il costruttore della classe Pezzo
	 * @param img è l'immagine del pezzo da costruire
	 * @param col è il colore del pezzo da costruire
	 */
	protected Pezzo(Icon img, Colore col) {
		super(img);
		setPreferredSize(new Dimension(70, 70));
		this.colore = col;
	}
	/**
	 * questo metodo ritorna il colore del pezzo
	 * @return il colore del pezzo
	 */
	public final Colore getColore() {
		return this.colore;
	}
	/**
	 * questo metodo setta le coordinate del pezzo nella scacchiera
	 * @param x la posizione x del pezzo
	 * @param y la posizione y del pezzo
	 */
	public final void setLocation(int x, int y) {
		this.location = new Point(x, y);
	}
	/**
	 * questo metodo setta le coordinate del pezzo nella scacchiera
	 * @param p un oggetto di classe Point che rappresenta la posizione
	 */
	public final void setLocation(Point p) {
		this.location = p;
	}
	/**
	 * questo metodo ritorna le coordinate del pezzo
	 * @return un oggetto di classe Point che rappresenta la posizione del pezzo
	 */
	public final Point getLocation() {
		return this.location;
	}
	/**
	 * questo metodo ritorna il pezzo vuoto
	 * @return il pezzo vuoto
	 */
	public Pezzi getPezzo() {
		return Pezzi.VUOTO;
	}
	/**
	 * questo metodo ritorna l'arrayList con i movimenti del pezzo
	 * @return l'arrayList con le coordinate dei possibili movimenti
	 */
	public ArrayList < Point > getMovimento(Pezzo[][] scacchiera) {
		return new ArrayList < Point > ();
	}
	/**
	 * questo metodo aggiorna l'icona del pezzo
	 * @param img rappresenta l'icona del nuovo pezzo da sostituire
	 */
	public void aggiornaIcona(Icon img) {
		this.setIcon(img);
	}
	/**
	 * questo metodo controlla lo state delle caselle di destinazione del pezzo (fuori dalla scacchiera, vuota, occupata da un avversario o occupata da un pezzo amico)
	 * @param scacchiera rappresenta il pezzo
	 * @param setP rappresenta il punto dei destinazione del pezzo da controllare
	 * @return un valore numerico (-1 o 0) che mi distingue i vari casi
	 */
	protected int impostaPunto(Pezzo[][] scacchiera, Point setP) {
		// CONTROLLO LIMITI SCACCHIERA
		if (setP.x < 0 || setP.x > 7 || setP.y < 0 || setP.y > 7) {
			return -1;
		} else if ((!this.getColore().equals(scacchiera[setP.x][setP.y].getColore()) && !(scacchiera[setP.x][setP.y].getColore().equals(Colore.VUOTO)))) {
			// TROVO AVVERSARIO
			movimenti.add(new Point(setP.x, setP.y));
			return -1;
		} else if (this.getColore().equals(scacchiera[setP.x][setP.y].getColore())) {
			// TROVO MIO ALLEATO
			return -1;
		} else {
			movimenti.add(new Point(setP.x, setP.y));
			return 0;
		}
	}
}