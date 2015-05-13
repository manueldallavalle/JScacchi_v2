import javax.swing.ImageIcon;

import struttura.Colore;
import struttura.Pezzi;

public class Pedone extends Pezzo{
	private static final long serialVersionUID = 1L;

	public Pedone(Colore colore){
		super((colore.equals(Colore.BIANCO)) ? new ImageIcon("immagini/pedone_bianca.gif") : new ImageIcon("immagini/pedone_nera.gif"),colore );
	}
	
	public Pezzi getPezzo(){
		return Pezzi.PEDONE;
	}
}
