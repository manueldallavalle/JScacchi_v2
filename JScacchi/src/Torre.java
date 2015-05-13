import javax.swing.ImageIcon;

import struttura.*;

public class Torre extends Pezzo{
	private static final long serialVersionUID = 1L;

	public Torre(Colore colore){
		super((colore.equals(Colore.BIANCO)) ? new ImageIcon("immagini/torre_bianca.gif") : new ImageIcon("immagini/torre_nera.gif"),colore );
	}
	
	public Pezzi getPezzo(){
		return Pezzi.TORRE;
	}
}
