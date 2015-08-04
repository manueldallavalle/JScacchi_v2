import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import struttura.*;

public class Torre extends Pezzo {
    private static final long serialVersionUID = 1L;
    

    public Torre(Colore colore) {
        super((colore.equals(Colore.BIANCO)) ? new ImageIcon("immagini/torre_bianca.gif") : new ImageIcon("immagini/torre_nera.gif"), colore);
    }

    @
    Override
    public Pezzi getPezzo() {
        return Pezzi.TORRE;
    }
    
    @
    Override
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
