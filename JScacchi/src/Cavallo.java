import javax.swing.ImageIcon;

import struttura.Colore;
import struttura.Pezzi;

public class Cavallo extends Pezzo{
	private static final long serialVersionUID = 1L;

	public Cavallo(Colore colore){
		super((colore.equals(Colore.BIANCO)) ? new ImageIcon("immagini/cavallo_bianca.gif") : new ImageIcon("immagini/cavallo_nera.gif"),colore );
	}
	
	public Pezzi getPezzo(){
		return Pezzi.CAVALLO;
	}
}
