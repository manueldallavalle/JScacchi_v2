import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JOptionPane;

import struttura.*;
import javax.swing.border.LineBorder;

public class MonitorAzioni implements ActionListener {
	private StrutturaScacchiera scacchiera;
	
	public MonitorAzioni(StrutturaScacchiera scacchiera){
		this.scacchiera = scacchiera;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if ((e.getActionCommand()).equals("esciPartita")) {
            System.exit(0);
		}else if ((e.getActionCommand()).equals("nuovaPartita")) {
			scacchiera.resetScacchiera(); // RESET SCACCHIERA
        } else {
        	gestisciSpostamento(e); // GESTIONE SPOSTAMENTO
        }
	}
	
	private void gestisciSpostamento(ActionEvent e){
		Pezzo p_click = (Pezzo) e.getSource();
		Info stato = scacchiera.getStato();

		//stato = Info.TURNO_NERI;
		
		if(stato.equals(Info.TURNO_BIANCHI) || stato.equals(Info.TURNO_NERI)){
			if(p_click.getPezzo().equals(Pezzi.VUOTO)){
				JOptionPane.showMessageDialog(null, Messaggi.ERR_PEZZONULL.getMsg(), "Errore!", JOptionPane.ERROR_MESSAGE);
			}else if((p_click.getColore().equals(Colore.BIANCO) && stato.equals(Info.TURNO_NERI)) ||
					(p_click.getColore().equals(Colore.NERO) && stato.equals(Info.TURNO_BIANCHI))){
				String turno_avversari = ((stato.equals(Info.TURNO_BIANCHI)) ? Messaggi.MSG_TRBIANCHI.getMsg() : Messaggi.MSG_TRNERI.getMsg());
				JOptionPane.showMessageDialog(null, turno_avversari, "Info", JOptionPane.WARNING_MESSAGE);
			}else{
				scacchiera.setPzAttesa(p_click);
				evidenziaCaselle(p_click);
				// AGGIORNAMENTO STATO
				if(mosseDisponibili()){
					scacchiera.setStato((stato.equals(Info.TURNO_BIANCHI)) ? Info.ATTESA_BIANCHI : Info.ATTESA_NERI);
				}else{
					JOptionPane.showMessageDialog(null, Messaggi.ERR_NOMOSSE.getMsg(), "Errore!", JOptionPane.ERROR_MESSAGE);
				}
			}
		}else if(stato.equals(Info.ATTESA_BIANCHI) || stato.equals(Info.ATTESA_NERI)){
			if(spostaPedina(p_click.getLocation())){
				scacchiera.incrementaMosse(); // Incrementa contatore
				scacchiera.setStato((stato.equals(Info.ATTESA_BIANCHI)) ? Info.TURNO_NERI : Info.TURNO_BIANCHI); // AGGIORNAMENTO STATO
			}else{
				JOptionPane.showMessageDialog(null, Messaggi.ERR_MOSSAVALIDA.getMsg(), "Errore!", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private boolean mosseDisponibili(){
		Pezzo[][] tavolo = scacchiera.getTavolo();
		boolean flag = false;
		for(int riga=0;riga<8 && !flag;riga++){
			for(int colonna=0;colonna<8 && !flag;colonna++){
				if(tavolo[riga][colonna].getBorder() instanceof LineBorder){
					Color tmp = ((LineBorder) tavolo[riga][colonna].getBorder()).getLineColor();
					if ((tmp.equals(Color.decode("#00cc00"))) || (tmp.equals(Color.red))) flag = true;
				}
			}
		}
		return flag;
	}
	
    protected int checkColore(Pezzo newPezzo) {
        /**
         * STESSO COLORE -- MOSSA NON VALIDA
         * COLORE DIVERSO -- MOSSA VALIDA
         * -1 = STESSO COLORE
         * 0 = MANGIATA VUOTA
         * 1 = PEZZO MANGIATO
         */
    	Pezzo old = scacchiera.getPzAttesa();
        
        if ((old.getColore()).equals(newPezzo.getColore())) {
            return -1;
        } else if (newPezzo.getColore().equals(Colore.VUOTO)) {
            return 0;
        }else if (!(old.getColore()).equals(newPezzo.getColore())){
        	return 1;
        }
        
        return -1;
    }
	
    private void evidenziaCaselle(Pezzo p_click){
    	Pezzo[][] tavolo = scacchiera.getTavolo();
    	Colore colore_pezzo = p_click.getColore();
    	ArrayList<Point> pipi=p_click.getMovimento(scacchiera.getTavolo());
    	Pezzo attesa=scacchiera.getPzAttesa();
    	
    	
    	if(colore_pezzo.equals(Colore.BIANCO)) {
    		Collections.sort(pipi, new Comparator<Point>() {
    			public int compare(Point p1, Point p2) {
    				int sum1 = Math.abs(p1.x) + Math.abs(p1.y);
    				int sum2 = Math.abs(p2.x) + Math.abs(p2.y);
    				return (sum2 - sum1);
    			}
    		});
    	}else {
    		Collections.sort(pipi, new Comparator<Point>() {
    			public int compare(Point p1, Point p2) {
    				int sum1 = Math.abs(p1.x) + Math.abs(p1.y);
    				int sum2 = Math.abs(p2.x) + Math.abs(p2.y);
    				return (sum1 - sum2);
    			}
    		});
    	}
    	    	
    	for(Point punto: pipi){
    		if(checkColore(tavolo[punto.x][punto.y])==1){
    			//colore diverso
    			tavolo[punto.x][punto.y].setBorder(BorderFactory.createLineBorder(Color.red, 2));
			} else if (checkColore(tavolo[punto.x][punto.y])==-1){
				if(!(attesa.getPezzo().equals(Pezzi.CAVALLO))) return;
			} else {
				//casella vuota
				tavolo[punto.getLocation().x][(punto.getLocation().y)].setBorder(BorderFactory.createLineBorder(Color.decode("#00cc00"), 2));
			}
    	}

    }
    
    
    private boolean spostaPedina(Point newLoc){
		Pezzo[][] tavolo = scacchiera.getTavolo();
		Pezzo attesa = scacchiera.getPzAttesa();
		Colore colore_attesa = attesa.getColore();
		Point old = attesa.getLocation();
		
		int Xold = old.y,
			Yold = old.x;
		
		int Xnew = newLoc.y,
			Ynew = newLoc.x;
		
		if(tavolo[Xnew][Ynew].getBorder() instanceof LineBorder){
			Color tmp = ((LineBorder) tavolo[Xnew][Ynew].getBorder()).getLineColor();
			if ((tmp.equals(Color.decode("#00cc00"))) || (tmp.equals(Color.red))){
				// AGGIORNAMENTO ICONE
				Icon img_pezzo = attesa.getIcon();
				tavolo[Xold][Yold].aggiornaIcona(null);
				tavolo[Xnew][Ynew].aggiornaIcona(img_pezzo);
		
				// AGGIORNAMENTO OGGETTI
				tavolo[Xold][Yold] = new Vuoto();
			
				switch(attesa.getPezzo()){
					case TORRE:
						tavolo[Xnew][Ynew] = new Torre(colore_attesa);
						break;
					case CAVALLO:
						tavolo[Xnew][Ynew] = new Cavallo(colore_attesa);
						break;
					case REGINA:
						tavolo[Xnew][Ynew] = new Regina(colore_attesa);
						break;
					case RE:
						tavolo[Xnew][Ynew] = new Re(colore_attesa);
						break;
					case ALFIERE:
						tavolo[Xnew][Ynew] = new Alfiere(colore_attesa);
						break;
					case PEDONE:
						tavolo[Xnew][Ynew] = new Pedone(colore_attesa);
						break;
					// NON PUO ENTRARE NEL CASO VUOTO
				}
				// AGGIORNAMENTO COORDINATE
				tavolo[Xold][Yold].setLocation(Yold,Xold);
				tavolo[Xnew][Ynew].setLocation(newLoc); 
				// AGGIORNAMENTO DESIGN
				scacchiera.aggiornaScacchiera();
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
    
}
