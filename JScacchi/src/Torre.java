import java.awt.Point;

import javax.swing.ImageIcon;

import struttura.*;

public class Torre extends Pezzo{
	private static final long serialVersionUID = 1L;

	public Torre(Colore colore){
		super((colore.equals(Colore.BIANCO)) ? new ImageIcon("immagini/torre_bianca.gif") : new ImageIcon("immagini/torre_nera.gif"),colore );
	}
	
	public Pezzi getPezzo(){
		return Pezzi.TORRE;
	}
	
	//getX()=colonne
	//getY()=righe
	public Point[] getMovimento(){
		int i=0,check_bordo_dx=1,check_bordo_sx=0,check_bordo_down=1,check_bordo_up=0;
		Point punti[];
		check_bordo_sx=getX();
		punti=new Point[14];
		while(i<7){    //getX()+check_bordo_dx)<=7 && check_bordo_sx>=0
			if(getX()+check_bordo_dx<=7){
				punti[i].setLocation(getY(),(getX()+(check_bordo_dx)));
				i++;
				check_bordo_dx++;
			}
			if((check_bordo_sx-1)>=0){
				punti[i].setLocation(getY(),check_bordo_sx-1);
				i++;
				check_bordo_sx--;
			}
		}
		check_bordo_up=getY();
		while(i<14){    //getX()+check_bordo_dx)<=7 && check_bordo_sx>=0
			if(getY()+check_bordo_down<=7){
				punti[i].setLocation(getY()+check_bordo_down,getX());
				i++;
				check_bordo_down++;
			}
			if((check_bordo_up-1)>=0){
				punti[i].setLocation(check_bordo_up-1,getX());
				i++;
				check_bordo_up--;
			}
		}
		return punti;
	}
}
