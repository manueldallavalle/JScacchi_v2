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
		
		final int[] posix_riga={2,-2,1,-1};
		final int[] posix_colonna={1,-1,2,-2};
		ArrayList<Point> punti = new ArrayList<>();
			for(int i=0;i<4;i++){
				for(int j=0;j<2;j++){
						if(getY()+posix_riga[i]<8 && getY()+posix_riga[i]>-1 && getX()+posix_colonna[j]<8 && getX()+posix_colonna[j]>-1){
							punti.add(new Point((int)(getLocation().getY()+posix_riga[i]),(int)(getLocation().getX()+posix_colonna[j])));
						}
				}
			}
		return punti;
	}
}
