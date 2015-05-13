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
}
