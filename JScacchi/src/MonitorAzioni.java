import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import struttura.*;

public class MonitorAzioni implements ActionListener {
	private StrutturaScacchiera scacchiera;
	private static Info stato;
	
	public MonitorAzioni(StrutturaScacchiera scacchiera){
		this.scacchiera = scacchiera;
		this.stato = Info.TURNO_BIANCHI;
	}
	
	public void actionPerformed(ActionEvent e) {
		Pezzo p_click = (Pezzo) e.getSource();

		// 1° CLICK
		if(stato.equals(Info.TURNO_BIANCHI) || stato.equals(Info.TURNO_NERI)){
			if(p_click.getPezzo().equals(Pezzi.VUOTO)){
				JOptionPane.showMessageDialog(null, Messaggi.ERR_PEZZONULL.getMsg(), "Errore!", JOptionPane.ERROR_MESSAGE);
			}else{
				evidenziaCaselle();
				// AGGIORNAMENTO STATO
				stato = ((stato.equals(Info.TURNO_BIANCHI)) ? Info.ATTESA_BIANCHI : Info.ATTESA_NERI);
			}
		}else if(stato.equals(Info.ATTESA_BIANCHI) || stato.equals(Info.ATTESA_NERI)){
			
		}
	}
	
    protected int checkSpostamento(Pezzo old, Pezzo nw) {
        /**
         * STESSO COLORE -- MOSSA NON VALIDA
         * COLORE DIVERSO -- MOSSA VALIDA
         * -1 = STESSO COLORE
         * 0 = MANGIATA VUOTA
         * 1 = PEZZO MANGIATO
         */
        
        if ((old.getColore()).equals(nw.getColore())) {
            return -1;
        } else if (nw.getColore().equals(Colore.VUOTO)) {
            return 0;
        }else if (!(old.getColore()).equals(nw.getColore())){
        	return 1;
        }
        
        return -1;
    }
	
	public void evidenziaCaselle(){
		
	}
}
