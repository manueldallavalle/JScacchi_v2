import struttura.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public abstract class Pezzo extends JButton {
	private static final long serialVersionUID = 1L;
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
	
	public final void setLocation(Point loc){
		this.location = loc;
	}
	
	public final Point getLocation(){
		return this.location;
	}
	
}
