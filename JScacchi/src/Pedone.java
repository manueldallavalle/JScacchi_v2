import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import struttura.Colore;
import struttura.Pezzi;

public class Pedone extends Pezzo{
	private static final long serialVersionUID = 1L;

	public Pedone(Colore colore){
		super((colore.equals(Colore.BIANCO)) ? new ImageIcon("immagini/pedone_bianca.gif") : new ImageIcon("immagini/pedone_nera.gif"),colore );
	}
	@Override
	public Pezzi getPezzo(){
		return Pezzi.PEDONE;
	}
	
	@Override
	public ArrayList<Point> getMovimento(Pezzo[][] scacchiera){
		movimenti = new ArrayList<Point>();
		
        int x = this.getLocation().y,
            y = this.getLocation().x; 
      
      if(x+1<8 || x-1>-1){        
        int xmod = ((this.getColore().equals(Colore.NERO)) ? x+1 : x-1);      
	      if(y+1<8 || y-1>-1){
	        impostaPunto(scacchiera,new Point(xmod,y+1));
	        impostaPunto(scacchiera,new Point(xmod,y-1));
	        impostaPunto(scacchiera,new Point(xmod,y));
	      }
	      impostaPunto(scacchiera,new Point(xmod,y));
      }	
		return movimenti;
	}

}
