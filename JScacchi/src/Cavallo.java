import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import struttura.Colore;
import struttura.Pezzi;

public class Cavallo extends Pezzo{
	private static final long serialVersionUID = 1L;
	public Cavallo(Colore colore){
		super((colore.equals(Colore.BIANCO)) ? new ImageIcon("immagini/cavallo_bianca.gif") : new ImageIcon("immagini/cavallo_nera.gif"),colore );
	}
	@Override
	public Pezzi getPezzo(){
		return Pezzi.CAVALLO;
	}
	
	@Override
	public ArrayList<Point> getMovimento(){
		
		final int[] posix_riga={-1,-1,-2,-2,1,1,2,2};
		final int[] posix_colonna={2,-2,1,-1,2,-2,1,-1};
		ArrayList<Point> punti = new ArrayList<>();
			for(int i=0;i<8;i++){
				if((int)(getLocation().getY())+posix_riga[i]<8 && (int)(getLocation().getY())+posix_riga[i]>-1 && (int)(getLocation().getX())+posix_colonna[i]<8 && (int)(getLocation().getX())+posix_colonna[i]>-1){
						punti.add(new Point((int)(getLocation().getY()+posix_riga[i]),(int)(getLocation().getX()+posix_colonna[i])));
				}
			    
			}
		return punti;
	}
}
