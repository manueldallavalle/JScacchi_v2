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
	public ArrayList<Point> getMovimento(){
		ArrayList<Point> punti=new ArrayList<>();
		final int[] posix_riga={1,1,0,-1,-1,-1,0,1};
		final int[] posix_colonna={0,1,1,1,0,-1,-1,-1};
		for(int i=0;i<8;i++){
			if(((int)getLocation().getY()+posix_riga[i]<=7 && (int)getLocation().getY()+posix_riga[i]>=0) && (int)getLocation().getX()+posix_colonna[i]<=7 && (int)getLocation().getX()+posix_colonna[i]>=0){
				punti.add(new Point((int)(getLocation().getY()+posix_riga[i]),(int)(getLocation().getX()+posix_colonna[i])));
			}
		}
		return punti;
	}
}
