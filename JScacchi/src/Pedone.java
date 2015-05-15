import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import struttura.Colore;
import struttura.Pezzi;

public class Pedone extends Pezzo{
	private static final long serialVersionUID = 1L;

	public Pedone(Colore colore){
		super((colore.equals(Colore.BIANCO)) ? new ImageIcon("immagini/pedone_bianca.gif") : new ImageIcon("immagini/pedone_nera.gif"),colore );
	}
	@Override
	public Pezzi getPezzo(){
		return Pezzi.PEDONE;
	}
	
	//getX()=colonne
	//getY()=righe
	public ArrayList<Point> getMovimento(boolean movimento_down){
		ArrayList<Point> punti = new ArrayList<>();
		if(movimento_down){
			punti.add(new Point(getY()+1,getX()));
				if(getX()+1<=7){
					punti.add(new Point(getY()+1,getX()+1));
				}
				if(getX()-1>=7){
					punti.add(new Point(getY()+1,getX()-1));
				}
		}
		else{
			punti.add(new Point(getY()-1,getX()));
			if(getX()+1<=7){
				punti.add(new Point(getY()-1,getX()+1));
			}
			if(getX()-1>=7){
				punti.add(new Point(getY()-1,getX()-1));
			}
		}
		return punti;
	}
}
