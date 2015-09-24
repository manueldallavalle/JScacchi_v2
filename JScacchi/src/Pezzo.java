import struttura.*;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.JButton;

public abstract class Pezzo extends JButton {
	private static final long serialVersionUID=1L;
	private Colore colore;
	private Point location;
	protected ArrayList<Point> movimenti;
	
	protected Pezzo(Icon img){
		this(img, Colore.VUOTO);
		setPreferredSize(new Dimension(70,70));
	}
	
	protected Pezzo(Icon img, Colore col){
		super(img);
		setPreferredSize(new Dimension(70,70));
		this.colore=col;
	}
	
	public final Colore getColore(){
		return this.colore;
	}
	
	public final void setLocation(int x, int y){
		this.location=new Point(x,y);
	}
	
	public final void setLocation(Point p){
		this.location=p;
	}
	
	public final Point getLocation(){
		return this.location;
	}
	
	public Pezzi getPezzo(){
		return Pezzi.VUOTO;
	}
	
	public ArrayList<Point> getMovimento(Pezzo[][] scacchiera){
		return new ArrayList<Point>();
	}
	
	public void aggiornaIcona(Icon img){
		this.setIcon(img);
	}
	
    protected int impostaPunto(Pezzo[][] scacchiera, Point setP){
    	// CONTROLLO LIMITI SCACCHIERA
    	if(setP.x < 0 || setP.x > 7 || setP.y < 0 || setP.y > 7){
    		return -1;
    	}else if((!this.getColore().equals(scacchiera[setP.x][setP.y].getColore()) && !(scacchiera[setP.x][setP.y].getColore().equals(Colore.VUOTO)))){
			// TROVO AVVERSARIO
			movimenti.add(new Point(setP.x,setP.y));
			return -1;	
		}else if(this.getColore().equals(scacchiera[setP.x][setP.y].getColore())){
			// TROVO MIO ALLEATO
			return -1;			
		}else{
			movimenti.add(new Point(setP.x,setP.y));
			return 0;
		}
    }
	
}
