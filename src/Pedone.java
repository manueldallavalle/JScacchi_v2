import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import struttura.Colore;
import struttura.Pezzi;

/**
 * <p>Title: Pedone</p>
 * <p>Description: classe che gestisce gli aspetti fondamentali del pedone</p>
 * @author Dalla Valle Manuel, Leone Davide, Benedetti Gianmarco
 * @version 1.0
 */

public class Pedone extends Pezzo{
	private static final long serialVersionUID = 1L;
	/**
	 * questo metodo è il costruttore della classe Pedone
	 * @param colore rappresenta il colore del pezzo (nero o bianco)
	 */
	public Pedone(Colore colore){
		super((colore.equals(Colore.BIANCO)) ? new ImageIcon("immagini/pedone_bianca.gif") : new ImageIcon("immagini/pedone_nera.gif"),colore );
	}
	/**
	 * questo metodo ritorna il pezzo pedone
	 * @return il pezzo pedone
	 */
	@Override
	public Pezzi getPezzo(){
		return Pezzi.PEDONE;
	}
	/**
	 * questo metodo inserisce in un arrayList tutti i possibili movimenti del pedone
	 * @param scacchiera rappresenta una casella della scacchiera da cui vengono calcolati i possibili movimenti del pedone
	 * @return l'arrayList contenente le coordinate dei possibili movimenti
	 */
	@Override
	public ArrayList<Point> getMovimento(Pezzo[][] scacchiera){
		movimenti = new ArrayList<Point>();
		
        int x = this.getLocation().y,
            y = this.getLocation().x; 
      
        int xmod = ((this.getColore().equals(Colore.NERO)) ? x+1 : x-1);      
		impostaPunto(scacchiera,new Point(xmod,y+1));
		impostaPunto(scacchiera,new Point(xmod,y-1));
		impostaPunto(scacchiera,new Point(xmod,y));	      	
		
		return movimenti;
	}

}
