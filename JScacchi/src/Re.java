import javax.swing.ImageIcon;

import struttura.Colore;
import struttura.Pezzi;

public class Re extends Pezzo{
	private static final long serialVersionUID = 1L;

	public Re(Colore colore){
		super((colore.equals(Colore.BIANCO)) ? new ImageIcon("immagini/re_bianca.gif") : new ImageIcon("immagini/re_nera.gif"),colore );
	}
	
	public Pezzi getPezzo(){
		return Pezzi.RE;
	}
}
