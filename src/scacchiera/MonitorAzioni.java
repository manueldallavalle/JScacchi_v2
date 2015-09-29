package scacchiera;
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
import javax.swing.border.LineBorder;
import struttura.*;

/**
 * <p>Title: MonitorAzioni</p>
 * <p>Description: classe che gestisce le meccaniche del gioco</p>
 * @author Dalla Valle Manuel, Leone Davide, Benedetti Gianmarco
 * @version 1.0
 */
public class MonitorAzioni implements ActionListener {
	private StrutturaScacchiera scacchiera;
	/**
	 * costruttore della classe MonitorAzioni
	 * @param scacchiera un oggetto di classe StrutturaScacchiera
	 */
	public MonitorAzioni(StrutturaScacchiera scacchiera) {
		this.scacchiera = scacchiera;
	}
	/**
	 * metodo che gestisce l'evento (click del mouse)
	 * @param e rappresenta l'evento (click del mouse)
	 */
	public void actionPerformed(ActionEvent e) {

		if ((e.getActionCommand()).equals("esciPartita")) {
			System.exit(0);
		} else if ((e.getActionCommand()).equals("nuovaPartita")) {
			scacchiera.resetScacchiera(); // RESET SCACCHIERA
		} else {
			gestisciSpostamento(e); // GESTIONE SPOSTAMENTO
		}
	}
	/**
	 * metodo che gestisce lo spostamento dei pezzi
	 * @param e rappresenta l'evento (click del mouse)
	 */
	private void gestisciSpostamento(ActionEvent e) {
		Pezzo p_click = (Pezzo) e.getSource();
		Info stato = scacchiera.getStato();

		if (stato.equals(Info.TURNO_BIANCHI) || stato.equals(Info.TURNO_NERI)) {
			if (p_click.getPezzo().equals(Pezzi.VUOTO)) {
				JOptionPane.showMessageDialog(null, Messaggi.ERR_PEZZONULL.getMsg(), "Errore!", JOptionPane.ERROR_MESSAGE);
			} else if ((p_click.getColore().equals(Colore.BIANCO) && stato.equals(Info.TURNO_NERI)) || (p_click.getColore().equals(Colore.NERO) && stato.equals(Info.TURNO_BIANCHI))) {
				String turno_avversari = ((stato.equals(Info.TURNO_BIANCHI)) ? Messaggi.MSG_TRBIANCHI.getMsg() : Messaggi.MSG_TRNERI.getMsg());
				JOptionPane.showMessageDialog(null, turno_avversari, "Info", JOptionPane.WARNING_MESSAGE);
			} else {
				scacchiera.setPzAttesa(p_click);
				evidenziaCaselle(p_click);
				// AGGIORNAMENTO STATO
				if (mosseDisponibili()) {
					scacchiera.setStato((stato.equals(Info.TURNO_BIANCHI)) ? Info.ATTESA_BIANCHI : Info.ATTESA_NERI);
				} else {
					JOptionPane.showMessageDialog(null, Messaggi.ERR_NOMOSSE.getMsg(), "Errore!", JOptionPane.ERROR_MESSAGE);
				}
			}
		} else if (stato.equals(Info.ATTESA_BIANCHI) || stato.equals(Info.ATTESA_NERI)) {
			Colore p_attesa = (scacchiera.getPzAttesa()).getColore();
			// VOGLIO CAMBIARE PEZZO
			if(p_attesa.equals(p_click.getColore())){
				scacchiera.aggiornaScacchiera(); // RESET BORDO
				scacchiera.setPzAttesa(p_click);
				evidenziaCaselle(p_click);
				// MSG ERRORE
				if (!mosseDisponibili()) {
					JOptionPane.showMessageDialog(null, Messaggi.ERR_NOMOSSE.getMsg(), "Errore!", JOptionPane.ERROR_MESSAGE);
				}
			}else if (spostaPedina(p_click.getLocation()) == 1) {
				scacchiera.incrementaMosse(); // Incrementa contatore
				scacchiera.setStato((stato.equals(Info.ATTESA_BIANCHI)) ? Info.TURNO_NERI : Info.TURNO_BIANCHI); // AGGIORNAMENTO STATO
			} else {
				JOptionPane.showMessageDialog(null, Messaggi.ERR_MOSSAVALIDA.getMsg(), "Errore!", JOptionPane.ERROR_MESSAGE);
			}
		}

		// CONTROLLO SCACCO MATTO
		Pezzi chiMangiaRe = scacchiera.isScaccoMatto();
		if (!chiMangiaRe.equals(Pezzi.VUOTO)) {
			//JOptionPane.showMessageDialog(null, "Possibile scacco matto sul re avversario, utilizzando il pezzo: " + chiMangiaRe.toString(), "Scacco matto", JOptionPane.WARNING_MESSAGE);
			String vincitore = ((stato.equals(Info.ATTESA_BIANCHI)) ? "Bianco" : "Nero");
			JOptionPane.showMessageDialog(null, "" + vincitore + " vince in: " + scacchiera.getMosse() + " mosse");
			scacchiera.resetScacchiera(); // RESET SCACCHIERA
		}
	}
	/**
	 * metodo che mi dice se la pedina selezionata ha mosse disponibili
	 * @return un booleano che mi dice se ho mosse disponibili o no
	 */
	private boolean mosseDisponibili() {
		Pezzo[][] tavolo = scacchiera.getTavolo();
		boolean flag = false;
		for (int riga = 0; riga < 8 && !flag; riga++) {
			for (int colonna = 0; colonna < 8 && !flag; colonna++) {
				if (tavolo[riga][colonna].getBorder() instanceof LineBorder) {
					Color tmp = ((LineBorder) tavolo[riga][colonna].getBorder()).getLineColor();
					if ((tmp.equals(Color.decode("#00cc00"))) || (tmp.equals(Color.red))) flag = true;
				}
			}
		}
		return flag;
	}
	/**
	 * metodo che mi dice se la casella di destinazione è vuota o è occupata da avversari o alleati
	 * @param newPezzo rappresenta il pezzo nella casella di destinazione, che può essere anche un pezzo vuoto
	 * @return un valore numerico che differenzia i vari casi
	 */
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
		} else if (!(old.getColore()).equals(newPezzo.getColore())) {
			return 1;
		}
		return -1;
	}
	/**
	 * metodo che serve per evidenziare le caselle raggiungibili dal pezzo che attende di essere mosso
	 * @param p_click rappresenta il pezzo che attende di muoversi
	 */
	private void evidenziaCaselle(Pezzo p_click) {
		Pezzo[][] tavolo = scacchiera.getTavolo();
		Colore colore_pezzo = p_click.getColore();
		ArrayList < Point > listaPezzi = p_click.getMovimento(scacchiera.getTavolo());
		Pezzo attesa = scacchiera.getPzAttesa();

		if (colore_pezzo.equals(Colore.BIANCO)) {
			Collections.sort(listaPezzi, new Comparator < Point > () {
				public int compare(Point p1, Point p2) {
					int sum1 = Math.abs(p1.x) + Math.abs(p1.y);
					int sum2 = Math.abs(p2.x) + Math.abs(p2.y);
					return (sum2 - sum1);
				}
			});
		} else {
			Collections.sort(listaPezzi, new Comparator < Point > () {
				public int compare(Point p1, Point p2) {
					int sum1 = Math.abs(p1.x) + Math.abs(p1.y);
					int sum2 = Math.abs(p2.x) + Math.abs(p2.y);
					return (sum1 - sum2);
				}
			});
		}

		for (Point punto: listaPezzi) {
			int sx = (int) attesa.getLocation().getX() - 1;
			int dx = (int) attesa.getLocation().getX() + 1;
			int dw = (int) attesa.getLocation().getY() - 1;
			int up = (int) attesa.getLocation().getY() + 1;

			if (checkColore(tavolo[punto.x][punto.y]) == 1) {
				//colore diverso
				if (attesa.getPezzo().equals(Pezzi.PEDONE)) {
					if ((punto.x == dw || punto.x == up) && (punto.y == sx || punto.y == dx)) {
						tavolo[punto.x][punto.y].setBorder(BorderFactory.createLineBorder(Color.red, 2));
					}
				} else tavolo[punto.x][punto.y].setBorder(BorderFactory.createLineBorder(Color.red, 2));
			} else if (checkColore(tavolo[punto.x][punto.y]) == -1) {
				//colore uguale
				if (!(attesa.getPezzo().equals(Pezzi.CAVALLO))) return;
			} else {
				//casella vuota
				if (!(attesa.getPezzo().equals(Pezzi.PEDONE) && (punto.y == sx || punto.y == dx))) tavolo[punto.getLocation().x][(punto.getLocation().y)].setBorder(BorderFactory.createLineBorder(Color.decode("#00cc00"), 2));
			}
		}
	}
	/**
	 * metodo che gestisce lo spostamento delle pedine sotto l'aspetto di cancellazione icone, aggiornamento icone etc..
	 * @param newLoc rappresenta il punto dove il pezzo si è mosso
	 * @return un generico valore intero che mi rappresenta vari casi
	 */
	protected int spostaPedina(Point newLoc){
		return spostaPedina(scacchiera.getPzAttesa(), newLoc, false);
	}
	/**
	 * metodo che gestisce lo spostamento delle pedine sotto l'aspetto di cancellazione icone, aggiornamento icone etc..
	 * @param oldLoc rappresenta il punto del pezzo da spostare
	 * @param newLoc rappresenta il punto dove il pezzo si è mosso
	 * @return un generico valore intero che mi rappresenta vari casi
	 */
	public int spostaPedina(Point oldLoc, Point newLoc){
		Pezzo[][] tavolo = scacchiera.getTavolo();
		return spostaPedina(tavolo[oldLoc.y][oldLoc.x], newLoc, true);
	}
	/**
	 * metodo che gestisce lo spostamento delle pedine sotto l'aspetto di cancellazione icone, aggiornamento icone etc..
	 * @param newLoc rappresenta il punto dove il pezzo si è mosso
	 * @param toMove rappresenta il pezzo da spostare in newLoc
	 * @param ignoreBorder valore booleano che se messo a 'vero', forza lo spostamento di qualsiasi pezzo in qualsiasi punto (anche se non potrebbe)
	 * @return un generico valore intero che mi rappresenta vari casi
	 */
	public int spostaPedina(Pezzo toMove, Point newLoc, boolean ignoreBorder) {
		// 0 = NO MANGIATA
		// 1 = MANGIATA

		Pezzo[][] tavolo = scacchiera.getTavolo();
		Colore colore_attesa = toMove.getColore();
		Point old = toMove.getLocation();

		int Xold = old.y,
		Yold = old.x;

		int Xnew = newLoc.y,
		Ynew = newLoc.x;

		if (ignoreBorder || tavolo[Xnew][Ynew].getBorder() instanceof LineBorder) {
			Color tmp = ((ignoreBorder) ? null : ((LineBorder) tavolo[Xnew][Ynew].getBorder()).getLineColor());
			if (ignoreBorder || (tmp.equals(Color.decode("#00cc00"))) || (tmp.equals(Color.red))) {
				// AGGIORNAMENTO ICONE
				Icon img_pezzo = toMove.getIcon();
				tavolo[Xold][Yold].aggiornaIcona(null);
				tavolo[Xnew][Ynew].aggiornaIcona(img_pezzo);

				// AGGIORNAMENTO OGGETTI
				tavolo[Xold][Yold] = new Vuoto();

				switch (toMove.getPezzo()) {
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
					case VUOTO:
						tavolo[Xnew][Ynew] = new Vuoto(colore_attesa);
						break;
				}
				// AGGIORNAMENTO COORDINATE
				tavolo[Xold][Yold].setLocation(Yold, Xold);
				tavolo[Xnew][Ynew].setLocation(newLoc);
				// AGGIORNAMENTO DESIGN
				scacchiera.aggiornaScacchiera();
				return 1;
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}
}