import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import struttura.Colore;
import struttura.Pezzi;

public class Regina extends Pezzo{
	private static final long serialVersionUID = 1L;
	private Torre torre=new Torre(Colore.VUOTO);
	private Alfiere alfiere=new Alfiere(Colore.VUOTO);

	public Regina(Colore colore){
		super((colore.equals(Colore.BIANCO)) ? new ImageIcon("immagini/regina_bianca.gif") : new ImageIcon("immagini/regina_nera.gif"),colore );
	}
	@Override
	public Pezzi getPezzo(){
		return Pezzi.REGINA;
	}
	
	@Override
	public ArrayList<Point> getMovimento(){
		ArrayList<Point> punti = new ArrayList<>();		
		punti.addAll(torre.getMovimento());
		punti.addAll(alfiere.getMovimento());
		return punti;
	}
	
	
}
