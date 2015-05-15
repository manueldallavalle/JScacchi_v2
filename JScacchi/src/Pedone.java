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
	
	@Override
	public ArrayList<Point> getMovimento(){
		ArrayList<Point> punti = new ArrayList<>();
		if(getColore().equals(Colore.NERO)){
			punti.add(new Point((int)(getLocation().getY()+1),(int)(getLocation().getX())));
				if((int)getLocation().getX()+1<=7){
					punti.add(new Point((int)(getLocation().getY()+1),(int)(getLocation().getX()+1)));
				}
				if((int)getLocation().getX()-1>=7){
					punti.add(new Point((int)(getLocation().getY()+1),(int)(getLocation().getX()-1)));
				}
		}
		else{
			punti.add(new Point((int)(getLocation().getY()-1),(int)(getLocation().getX())));
			if((int)getLocation().getX()+1<=7){
				punti.add(new Point((int)(getLocation().getY()-1),(int)(getLocation().getX()+1)));
			}
			if((int)getLocation().getX()-1>=7){
				punti.add(new Point((int)(getLocation().getY()-1),(int)(getLocation().getX()-1)));
			}
		}
		return punti;
	}
}
