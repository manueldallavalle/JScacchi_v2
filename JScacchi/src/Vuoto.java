import struttura.Colore;
import struttura.Pezzi;

public class Vuoto extends Pezzo{
	private static final long serialVersionUID = 1L;

	public Vuoto(Colore colore){
		super(new javax.swing.ImageIcon(""));
	}
	
	public Pezzi getPezzo(){
		return Pezzi.VUOTO;
	}
}
