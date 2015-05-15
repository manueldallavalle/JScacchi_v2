import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import struttura.Colore;
import struttura.Pezzi;

public class Re extends Pezzo{
	private static final long serialVersionUID = 1L;

	public Re(Colore colore){
		super((colore.equals(Colore.BIANCO)) ? new ImageIcon("immagini/re_bianca.gif") : new ImageIcon("immagini/re_nera.gif"),colore );
	}
	@Override
	public Pezzi getPezzo(){
		return Pezzi.RE;
	}
	
	//getX()=colonne
	//getY()=righe
	public ArrayList<Point> getMovimento(){
		ArrayList<Point> punti = new ArrayList<>();
		final int[] posix_riga={1,1,0,-1,-1,-1,0,1};
		final int[] posix_colonna={0,1,1,1,0,-1,-1,-1};
		for(int i=0;i<8;i++){
			if((getY()+posix_riga[i]<=7 && getY()+posix_riga[i]>=0) && getX()+posix_colonna[i]<=7 && getX()+posix_colonna[i]>=0){
				punti.add(new Point(getY()+posix_riga[i],getX()+posix_colonna[i]));
			}
		}
		return punti;
	}
}
