import java.awt.Point;

import javax.swing.ImageIcon;

import struttura.Colore;
import struttura.Pezzi;

public class Regina extends Pezzo{
	private static final long serialVersionUID = 1L;

	public Regina(Colore colore){
		super((colore.equals(Colore.BIANCO)) ? new ImageIcon("immagini/regina_bianca.gif") : new ImageIcon("immagini/regina_nera.gif"),colore );
	}
	
	public Pezzi getPezzo(){
		return Pezzi.REGINA;
	}
	
	//getX()=colonne
	//getY()=righe
	public Point[] getMovimento(){
		Point[] punti;
		punti=new Point[27];
		getMovimentoTorre(punti);
		getMovimentoAlfiere(punti);
		return punti;
	}
	
	public void getMovimentoTorre(Point[] punti){
		int i=0,check_bordo_dx=1,check_bordo_sx=0,check_bordo_down=1,check_bordo_up=0;
		check_bordo_sx=getX();
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
	}
	
	public Point[] getMovimentoAlfiere(Point[] punti){
		int index=14;
		for(int i=getY(),j=getX();(i<=7 && j<=7);i++,j++){
			punti[index].setLocation(i+1,j+1);
			index++;
		}
		for(int i=getY(),j=getX();(i>=0 && j<=7);i--,j++){
			punti[index].setLocation(i-1,j+1);
			index++;
		}
		for(int i=getY(),j=getX();(i>=0 && j>=0);i--,j--){
			punti[index].setLocation(i-1,j-1);
			index++;
		}
		for(int i=getY(),j=getX();(i<=7 && j>=0);i++,j--){
			punti[index].setLocation(i+1,j-1);
			index++;
		}
		for(;index<27;index++){
			punti[index].setLocation(null);
		}
		return punti;
	}
}
