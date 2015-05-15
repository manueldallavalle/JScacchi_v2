import java.awt.Point;

import javax.swing.ImageIcon;

import struttura.Colore;
import struttura.Pezzi;

public class Alfiere extends Pezzo{
	private static final long serialVersionUID = 1L;

	public Alfiere(Colore colore){
		super((colore.equals(Colore.BIANCO)) ? new ImageIcon("immagini/alfiere_bianca.gif") : new ImageIcon("immagini/alfiere_nera.gif"),colore );
	}
	
	public Pezzi getPezzo(){
		return Pezzi.ALFIERE;
	}
	
	//getX()=colonne
	//getY()=righe
	public Point[] getMovimento(){
		Point[] punti;
		punti=new Point[13];
		int index=0;
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
		for(;index<12;index++){
			punti[index].setLocation(null);
		}
		return punti;
	}
}
