import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import struttura.Colore;
import struttura.Pezzi;

public class Regina extends Pezzo{
	private static final long serialVersionUID=1L;
	private Torre torre;
	private Alfiere alfiere;
	

	public Regina(Colore colore){
		super((colore.equals(Colore.BIANCO)) ? new ImageIcon("immagini/regina_bianca.gif") : new ImageIcon("immagini/regina_nera.gif"),colore );

	}
	@Override
	public Pezzi getPezzo(){
		return Pezzi.REGINA;
	}
	
	@Override
	public ArrayList<Point> getMovimento(Pezzo[][] scacchiera){
		movimenti=new ArrayList<Point>();	
		
		torre = new Torre(this.getColore());
		alfiere = new Alfiere(this.getColore());
		
		alfiere.setLocation(this.getLocation());
		torre.setLocation(this.getLocation());
				
		movimenti.addAll(torre.getMovimento(scacchiera));
		movimenti.addAll(alfiere.getMovimento(scacchiera));
		return movimenti;
	}
	
	
}