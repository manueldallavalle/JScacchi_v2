import java.awt.Point;

import javax.swing.ImageIcon;

import struttura.Colore;
import struttura.Pezzi;

public class Cavallo extends Pezzo{
	private static final long serialVersionUID = 1L;
	private final int[] posix_riga={2,-2,1,-1};
	private final int[] posix_colonna={1,-1,2,-2};
	public Cavallo(Colore colore){
		super((colore.equals(Colore.BIANCO)) ? new ImageIcon("immagini/cavallo_bianca.gif") : new ImageIcon("immagini/cavallo_nera.gif"),colore );
	}
	
	public Pezzi getPezzo(){
		return Pezzi.CAVALLO;
	}
	
	public Point[] getMovimento(){
		int cont=0,tmp=0;
		Point punti[];
		punti=new Point[8];
			for(int i=0;i<4;i++){
				for(int j=0;j<2;j++){
						if(getY()+posix_riga[i]>=8 || getY()+posix_riga[i]<=-1 || getX()+posix_colonna[j]>=8 || getX()+posix_colonna[j]<=-1){
							punti[cont]=null;
							cont++;
						}
						else{
							punti[cont].setLocation(getY()+posix_riga[i],getX()+posix_colonna[j]);
							cont++;
						}
					}
				}
		return punti;
	}
}

/*
int colonna=getX();
int riga=getY();
colonna=colonna+1;
riga=riga-2;
if(colonna>=8 || colonna<=-1 || riga>=8 || riga <=-1){
	punti[0]=null;
}
else{
	punti[0].setLocation(riga,colonna);
}
*/