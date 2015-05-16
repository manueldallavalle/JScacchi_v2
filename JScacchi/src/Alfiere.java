import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import struttura.Colore;
import struttura.Pezzi;

public class Alfiere extends Pezzo{
	private static final long serialVersionUID=1L;

	public Alfiere(Colore colore){
		super((colore.equals(Colore.BIANCO)) ? new ImageIcon("immagini/alfiere_bianca.gif") : new ImageIcon("immagini/alfiere_nera.gif"),colore );
	}
	@Override
	public Pezzi getPezzo(){
		return Pezzi.ALFIERE;
	}
	
	//getX()=colonne
	//getY()=righe
	@Override
	public ArrayList<Point> getMovimento(){
		ArrayList<Point> punti=new ArrayList<>();
		for(int i=(int)getLocation().getY(),j=(int)getLocation().getX();(i<=7 && j<=7);i++,j++){
			if(j-i==((int)getLocation().getY())-((int)getLocation().getX())){
				punti.add(new Point(i+1,j+1));
			}			
		}
		for(int i=(int)getLocation().getY(),j=(int)getLocation().getX();(i>=0 && j<=7);i--,j++){
			if(j+i==((int)getLocation().getY())+((int)getLocation().getX())){
				punti.add(new Point(i-1,j+1));
			}			
		}
		for(int i=(int)getLocation().getY(),j=(int)getLocation().getX();(i>=0 && j>=0);i--,j--){
			if(j-i==((int)getLocation().getY())-((int)getLocation().getX())){
				punti.add(new Point(i-1,j-1));
			}			
		}
		for(int i=(int)getLocation().getY(),j=(int)getLocation().getX();(i<=7 && j>=0);i++,j--){
			if(j+i==((int)getLocation().getY())+((int)getLocation().getX())){
				punti.add(new Point(i+1,j-1));
			}
		}
		return punti;
	}
}
