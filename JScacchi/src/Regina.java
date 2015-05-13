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
}
