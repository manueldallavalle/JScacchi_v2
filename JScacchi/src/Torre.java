import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import struttura.*;

public class Torre extends Pezzo{
	private static final long serialVersionUID = 1L;

	public Torre(Colore colore){
		super((colore.equals(Colore.BIANCO)) ? new ImageIcon("immagini/torre_bianca.gif") : new ImageIcon("immagini/torre_nera.gif"),colore );
	}
	@Override
	public Pezzi getPezzo(){
		return Pezzi.TORRE;
	}
	
	@Override
	public ArrayList<Point> getMovimento(){
		int i=0,check_bordo_dx=1,check_bordo_sx=0,check_bordo_down=1,check_bordo_up=0;
		ArrayList<Point> punti = new ArrayList<>();
		check_bordo_sx=(int)getLocation().getX();
		while(i<7){    //getX()+check_bordo_dx)<=7 && check_bordo_sx>=0
			if(getX()+check_bordo_dx<=7){
				punti.add(new Point((int)(getLocation().getY()),(int)((getLocation().getX())+(check_bordo_dx))));
				i++;
				check_bordo_dx++;
			}
			if((check_bordo_sx-1)>=0){
				punti.add(new Point((int)(getLocation().getY()),check_bordo_sx-1));
				i++;
				check_bordo_sx--;
			}
		}
		check_bordo_up=(int)getLocation().getY();
		i=0;
		while(i<7){    //getX()+check_bordo_dx)<=7 && check_bordo_sx>=0
			if(getY()+check_bordo_down<=7){
				punti.add(new Point((int)(getLocation().getY()+check_bordo_down),(int)(getLocation().getX())));
				i++;
				check_bordo_down++;
			}
			if((check_bordo_up-1)>=0){
				punti.add(new Point(check_bordo_up-1,(int)(getLocation().getX())));
				i++;
				check_bordo_up--;
			}
		}
		return punti;
	}
}
