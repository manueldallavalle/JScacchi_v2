import java.awt.Point;

import javax.swing.ImageIcon;

import struttura.Colore;
import struttura.Pezzi;

public class Pedone extends Pezzo{
	private static final long serialVersionUID = 1L;

	public Pedone(Colore colore){
		super((colore.equals(Colore.BIANCO)) ? new ImageIcon("immagini/pedone_bianca.gif") : new ImageIcon("immagini/pedone_nera.gif"),colore );
	}
	
	public Pezzi getPezzo(){
		return Pezzi.PEDONE;
	}
	
	//getX()=colonne
	//getY()=righe
	public Point[] getMovimento(boolean movimento_down){
		Point[] punti;
		punti=new Point[3];
		if(movimento_down){
				punti[0].setLocation(getY()+1,getX());
				if(getX()+1<=7){
					punti[1].setLocation(getY()+1,getX()+1);
				}
				else{
					punti[1].setLocation(null);
				}
				if(getX()-1>=7){
					punti[2].setLocation(getY()+1,getX()-1);
				}
				else{
					punti[2].setLocation(null);
				}
		}
		else{
			punti[0].setLocation(getY()-1,getX());
			if(getX()+1<=7){
				punti[1].setLocation(getY()-1,getX()+1);
			}
			else{
				punti[1].setLocation(null);
			}
			if(getX()-1>=7){
				punti[2].setLocation(getY()-1,getX()-1);
			}
			else{
				punti[2].setLocation(null);
			}
		}
		return punti;
	}
}
