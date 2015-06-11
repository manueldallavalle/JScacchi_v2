import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import struttura.Colore;
import struttura.Pezzi;

public class Alfiere extends Pezzo{
	private static final long serialVersionUID=1L;

	public Alfiere(Colore colore){
		super((colore.equals(Colore.BIANCO)) ? new ImageIcon("immagini/alfiere_bianca.gif") : new ImageIcon("immagini/alfiere_nera.gif"),colore );
	}
	@Override
	public Pezzi getPezzo(){
		return Pezzi.ALFIERE;
	}
	
	@Override
	public ArrayList<Point> getMovimento(Pezzo[][] scacchiera){
		movimenti = new ArrayList<Point>();
        int x = this.getLocation().y,
            y = this.getLocation().x;
        boolean stop = false;
        		
		for (int i = x, j = y;(i < 7 && j < 7) && !stop; i++, j++) {
		    stop = ((impostaPunto(scacchiera, new Point(i+1,j+1)) == -1) ? true : false);
		}
    	// RESET
    	stop = false;
		for (int i = x, j = y; (i > 0 && j < 7) && !stop; i--, j++) {
		    stop = ((impostaPunto(scacchiera, new Point(i-1,j+1)) == -1) ? true : false);
		}
    	// RESET
    	stop = false;
		for (int i = x, j = y; (i > 0 && j > 0) && !stop; i--, j--) {
			stop = ((impostaPunto(scacchiera, new Point(i-1,j-1)) == -1) ? true : false);
		}
    	// RESET
    	stop = false;
		for (int i = x, j = y; (i < 7 && j > 0) && !stop; i++, j--) {
		    stop = ((impostaPunto(scacchiera, new Point(i+1,j-1)) == -1) ? true : false);
		}
		return movimenti;
	}
}
