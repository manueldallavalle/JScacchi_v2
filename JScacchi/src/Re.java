import java.awt.Point;

import javax.swing.ImageIcon;

import struttura.Colore;
import struttura.Pezzi;

public class Re extends Pezzo{
	private static final long serialVersionUID = 1L;

	public Re(Colore colore){
		super((colore.equals(Colore.BIANCO)) ? new ImageIcon("immagini/re_bianca.gif") : new ImageIcon("immagini/re_nera.gif"),colore );
	}
	
	public Pezzi getPezzo(){
		return Pezzi.RE;
	}
	
	//getX()=colonne
	//getY()=righe
	public Point[] getMovimento(){
		Point[] punti;
		punti=new Point[8];
		final int[] posix_riga={1,1,0,-1,-1,-1,0,1};
		final int[] posix_colonna={0,1,1,1,0,-1,-1,-1};
		for(int i=0;i<8;i++){
			if((getY()+posix_riga[i]<=7 && getY()+posix_riga[i]>=0) && getX()+posix_colonna[i]<=7 && getX()+posix_colonna[i]>=0){
				punti[i].setLocation(getY()+posix_riga[i],getX()+posix_colonna[i]);
			}
			else{
				punti[i].setLocation(null);
			}
		}
		return punti;
	}
}
