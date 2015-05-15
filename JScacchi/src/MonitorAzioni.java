import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import struttura.*;

public class MonitorAzioni implements ActionListener {
	private StrutturaScacchiera scacchiera;

	public MonitorAzioni(StrutturaScacchiera scacchiera){
		this.scacchiera = scacchiera;
	}
	
	public void actionPerformed(ActionEvent e) {
		Pezzo p_click = (Pezzo) e.getSource();
		Info stato = scacchiera.getStato();

		if(stato.equals(Info.TURNO_BIANCHI) || stato.equals(Info.TURNO_NERI)){
			if(p_click.getPezzo().equals(Pezzi.VUOTO)){
				JOptionPane.showMessageDialog(null, Messaggi.ERR_PEZZONULL.getMsg(), "Errore!", JOptionPane.ERROR_MESSAGE);
			}else if((p_click.getColore().equals(Colore.BIANCO) && stato.equals(Info.TURNO_NERI)) ||
					(p_click.getColore().equals(Colore.NERO) && stato.equals(Info.TURNO_BIANCHI))){
				String turno_avversari = ((stato.equals(Info.TURNO_BIANCHI)) ? Messaggi.MSG_TRBIANCHI.getMsg() : Messaggi.MSG_TRNERI.getMsg());
				JOptionPane.showMessageDialog(null, turno_avversari, "Info", JOptionPane.WARNING_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(null, p_click.getLocation().getX() + " - " + p_click.getLocation().getY());
				evidenziaCaselle(p_click);
				// AGGIORNAMENTO STATO
				scacchiera.setPzAttesa(p_click);
				scacchiera.setStato((stato.equals(Info.TURNO_BIANCHI)) ? Info.ATTESA_BIANCHI : Info.ATTESA_NERI);
			}
		}else if(stato.equals(Info.ATTESA_BIANCHI) || stato.equals(Info.ATTESA_NERI)){
			
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
		Pezzo[][] t = scacchiera.getTavolo();
	}
}
