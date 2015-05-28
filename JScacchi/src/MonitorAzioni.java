import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import struttura.*;

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
		Pezzo p_click_update = scacchiera.getTavolo()[(int) p_click.getLocation().getY()][(int) p_click.getLocation().getX()];
		p_click = p_click_update;
	
		JOptionPane.showMessageDialog(null, "ICONA CLICK = " + p_click.getIcon());
		if(stato.equals(Info.TURNO_BIANCHI) || stato.equals(Info.TURNO_NERI)){
			if(p_click.getPezzo().equals(Pezzi.VUOTO)){
				JOptionPane.showMessageDialog(null, Messaggi.ERR_PEZZONULL.getMsg(), "Errore!", JOptionPane.ERROR_MESSAGE);
			}else if((p_click.getColore().equals(Colore.BIANCO) && stato.equals(Info.TURNO_NERI)) ||
					(p_click.getColore().equals(Colore.NERO) && stato.equals(Info.TURNO_BIANCHI))){
				String turno_avversari = ((stato.equals(Info.TURNO_BIANCHI)) ? Messaggi.MSG_TRBIANCHI.getMsg() : Messaggi.MSG_TRNERI.getMsg());
				JOptionPane.showMessageDialog(null, turno_avversari, "Info", JOptionPane.WARNING_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(null,"1° CLICK");			
				JOptionPane.showMessageDialog(null,"PEZZO = " + p_click.getPezzo() + "\nLOC = " + p_click.getLocation().toString());
				//evidenziaCaselle(p_click);
				// AGGIORNAMENTO STATO
				scacchiera.setPzAttesa(p_click);
				scacchiera.setStato((stato.equals(Info.TURNO_BIANCHI)) ? Info.ATTESA_BIANCHI : Info.ATTESA_NERI);
			}
		}else if(stato.equals(Info.ATTESA_BIANCHI) || stato.equals(Info.ATTESA_NERI)){
			JOptionPane.showMessageDialog(null,"2° CLICK");
			JOptionPane.showMessageDialog(null,"PEZZO = " + p_click.getPezzo() + "\nLOC = " + p_click.getLocation().toString());
			spostaPedina(p_click.getLocation());
			scacchiera.incrementaMosse(); // Incrementa contatore
		}
	}
	
    protected int checkSpostamento(Pezzo newPezzo) {
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
	
	public void evidenziaCaselle(Pezzo p_click){
		Pezzo[][] tavolo = scacchiera.getTavolo();		
		for(Point punto: p_click.getMovimento()){
			tavolo[(int)(punto.getLocation().getX())][(int)(punto.getLocation().getY())].setBorder(BorderFactory.createLineBorder(Color.green, 2));
		}
	}
	
	private void spostaPedina(Point newLoc){
		Pezzo[][] tavolo = scacchiera.getTavolo();
		Pezzo attesa = scacchiera.getPzAttesa();
		Colore colore_attesa = attesa.getColore();
		Point old = attesa.getLocation();
		
		int Xold = (int) old.getY(),
			Yold = (int) old.getX();
		
		int Xnew = (int) newLoc.getY(),
			Ynew = (int) newLoc.getX();
						
		// AGGIORNAMENTO ICONE
	
		JOptionPane.showMessageDialog(null, "PEZZO DA MANGIARE = " + tavolo[Xnew][Ynew].getPezzo() + "\nX,Y =" + Ynew + "," + Xnew + "\nLOCATION = " + tavolo[Xnew][Ynew].getLocation().toString());
		tavolo[Xnew][Ynew].aggiornaIcona(attesa.getIcon());
		tavolo[Xold][Yold].aggiornaIcona(null);
		tavolo[Xold][Yold].invalidate();
		
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
		//tavolo[Xnew][Ynew] = attesa;

		// AGGIORNAMENTO COORDINATE
		tavolo[Xold][Yold].setLocation(Yold,Xold);
		tavolo[Xnew][Ynew].setLocation(newLoc); 

		
		JOptionPane.showMessageDialog(null, "PEZZO OLD = " + tavolo[Xold][Yold].getPezzo());
		JOptionPane.showMessageDialog(null, "PEZZO AGGIORNATO = " + tavolo[Xnew][Ynew].getPezzo());
		aggiornaVuoti();
		scacchiera.aggiornaScacchiera();
		scacchiera.setStato(Info.TURNO_BIANCHI);
	}
	
	private void aggiornaVuoti(){
		Pezzo[][] tavolo = scacchiera.getTavolo();
			for(int riga=0;riga<8;riga++){
				for(int colonna=0;colonna<8;colonna++){
					if((tavolo[riga][colonna].getPezzo()).equals(Pezzi.VUOTO)){
						//JOptionPane.showMessageDialog(null, "ICONA = " + tavolo[riga][colonna].getIcon());
						//JOptionPane.showMessageDialog(null, "PEZZO = " + tavolo[0][7] + "\nICONA = " + tavolo[0][7].getIcon());
						tavolo[riga][colonna].revalidate();
						tavolo[riga][colonna].repaint();
					}
				}
			}
			scacchiera.aggiornaScacchiera();
	}
}
