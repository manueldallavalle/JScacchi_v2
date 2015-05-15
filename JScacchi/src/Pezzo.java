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
	
	protected Pezzo(Icon img){
		this(img, Colore.VUOTO);
		setPreferredSize(new Dimension(70,70));
	}
	
	protected Pezzo(Icon img, Colore col){
		super(img);
		setPreferredSize(new Dimension(70,70));
		this.colore = col;
	}
	
	public final Colore getColore(){
		return this.colore;
	}
	
	public final void setLocation(int x, int y){
		this.location = new Point(x,y);
	}
	
	public final Point getLocation(){
		return this.location;
	}
	
	public Pezzi getPezzo(){
		return Pezzi.VUOTO;
	}
	
	public ArrayList<Point> getMovimento(){
		return new ArrayList<Point>();
	}	
	
}
