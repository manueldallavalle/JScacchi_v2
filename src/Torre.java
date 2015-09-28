import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import struttura.*;

/**
 * <p>Title: Torre</p>
 * <p>Description: classe che gestisce gli aspetti fondamentali della torre</p>
 * @author Dalla Valle Manuel, Leone Davide, Benedetti Gianmarco
 * @version 1.0
 */

public class Torre extends Pezzo {
    private static final long serialVersionUID = 1L;
    
    /**
	 * questo metodo è il costruttore della classe Torre
	 * @param colore rappresenta il colore del pezzo (nero o bianco)
	 */
    public Torre(Colore colore) {
        super((colore.equals(Colore.BIANCO)) ? new ImageIcon("immagini/torre_bianca.gif") : new ImageIcon("immagini/torre_nera.gif"), colore);
    }
    /**
	 * questo metodo ritorna il pezzo torre
	 * @return il pezzo torre
	 */
    @Override
    public Pezzi getPezzo() {
        return Pezzi.TORRE;
    }
    /**
	 * questo metodo inserisce in un arrayList tutti i possibili movimenti della torre
	 * @param scacchiera rappresenta una casella della scacchiera da cui vengono calcolati i possibili movimenti della torre
	 * @return l'arrayList contenente le coordinate dei possibili movimenti
	 */
    @Override
    public ArrayList <Point> getMovimento(Pezzo[][] scacchiera){
        int x = this.getLocation().y,
            y = this.getLocation().x; 
        
        movimenti = new ArrayList <Point>();
        boolean stop = false;
        
    	for(int i=x+1;i<8 && !stop;i++){
    		stop = ((impostaPunto(scacchiera, new Point(i,y)) == -1) ? true : false);
    	}
    	
    	// RESET
    	stop = false;
    	for(int i=x-1;i>-1 && !stop;i--){
    		stop = ((impostaPunto(scacchiera, new Point(i,y)) == -1) ? true : false);
    	}
    	
    	// RESET
    	stop = false;
    	for(int i=y+1;i<8 && !stop;i++){
    		stop = ((impostaPunto(scacchiera, new Point(x,i)) == -1) ? true : false);
    	}
    	
    	// RESET
    	stop = false;
    	for(int i=y-1;i>-1 && !stop;i--){
    		stop = ((impostaPunto(scacchiera, new Point(x,i)) == -1) ? true : false);
    	}
    	
        return movimenti;
    }
}
