import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import struttura.Colore;
import struttura.Pezzi;

/**
 * <p>Title: Regina</p>
 * <p>Description: classe che gestisce gli aspetti fondamentali della regina</p>
 * @author Dalla Valle Manuel, Leone Davide, Benedetti Gianmarco
 * @version 1.0
 */

public class Regina extends Pezzo{
	private static final long serialVersionUID=1L;
	private Torre torre;
	private Alfiere alfiere;
	
	/**
	 * questo metodo è il costruttore della classe Regina
	 * @param colore rappresenta il colore del pezzo (nero o bianco)
	 */
	public Regina(Colore colore){
		super((colore.equals(Colore.BIANCO)) ? new ImageIcon("immagini/regina_bianca.gif") : new ImageIcon("immagini/regina_nera.gif"),colore );

	}
	/**
	 * questo metodo ritorna il pezzo regina
	 * @return il pezzo regina
	 */
	@Override
	public Pezzi getPezzo(){
		return Pezzi.REGINA;
	}
	/**
	 * questo metodo inserisce in un arrayList tutti i possibili movimenti della regina
	 * @param scacchiera rappresenta una casella della scacchiera da cui vengono calcolati i possibili movimenti della regina
	 * @return l'arrayList contenente le coordinate dei possibili movimenti
	 */
	@Override
	public ArrayList<Point> getMovimento(Pezzo[][] scacchiera){
		movimenti=new ArrayList<Point>();	
		
		torre = new Torre(this.getColore());
		alfiere = new Alfiere(this.getColore());
		
		alfiere.setLocation(this.getLocation());
		torre.setLocation(this.getLocation());
				
		movimenti.addAll(torre.getMovimento(scacchiera));
		movimenti.addAll(alfiere.getMovimento(scacchiera));
		return movimenti;
	}
	
	
}