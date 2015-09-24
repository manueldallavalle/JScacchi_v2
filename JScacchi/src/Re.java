import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import struttura.Colore;
import struttura.Pezzi;

public class Re extends Pezzo{
	private static final long serialVersionUID=1L;

	public Re(Colore colore){
		super((colore.equals(Colore.BIANCO)) ? new ImageIcon("immagini/re_bianca.gif") : new ImageIcon("immagini/re_nera.gif"),colore );
	}
	@Override
	public Pezzi getPezzo(){
		return Pezzi.RE;
	}
	
	@Override	
    public ArrayList<Point> getMovimento(Pezzo[][] scacchiera){
        int x = this.getLocation().y,
            y = this.getLocation().x; 
        
        movimenti = new ArrayList <Point>();
        
        impostaPunto(scacchiera, new Point(x,y+1));
        impostaPunto(scacchiera, new Point(x,y-1));
        
        impostaPunto(scacchiera, new Point(x+1,y));
        impostaPunto(scacchiera, new Point(x-1,y));
        
        impostaPunto(scacchiera, new Point(x-1,y+1));
        impostaPunto(scacchiera, new Point(x-1,y-1));
        
        impostaPunto(scacchiera, new Point(x+1,y+1));
        impostaPunto(scacchiera, new Point(x+1,y-1));
       
        return movimenti;
    }
}
