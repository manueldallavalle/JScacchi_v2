package scacchiera;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import struttura.*;

/**
 * <p>Title: StrutturaScacchiera</p>
 * <p>Description: classe che serve per la costruzione delle varie parti dell'interfaccia della scacchiera</p>
 * @author Dalla Valle Manuel, Leone Davide, Benedetti Gianmarco
 * @version 1.0
 */

public class StrutturaScacchiera extends JPanel {

	private static final long serialVersionUID = 1L;
	private Pezzo[][] scacchiera = new Pezzo[8][8];
	private JPanel tavolo = new JPanel();
	private JLabel coordinate_col[] = new JLabel[8];
	private JPanel coordinateColonna = new JPanel();
	private JLabel coordinate_rig[] = new JLabel[9];
	private JPanel coordinateRiga = new JPanel();
	private JLabel spazio[] = new JLabel[16];
	private JPanel bordoDx = new JPanel();
	private JLabel mossa = new JLabel();
	private JPanel contatoreMosse = new JPanel();
	final StrutturaScacchiera obj = this;
	private int cont_mosse = 0;
	private Info stato;
	private Pezzo pezzo_attesa;
	/**
	 * questo metodo è il costruttore della classe StrutturaScacchiera
	 */
	public StrutturaScacchiera() {
		this.setLayout(new BorderLayout());
		setScacchiera();
		struttura();
		stato = Info.TURNO_BIANCHI; // 1Ã‚Â° TURNO DEI BIANCHI
	}
	/**
	 * questo metodo costruisce varie parti della scacchiera
	 */
	private void struttura() {

		//coordinate colonna

		coordinateColonna.setLayout(new FlowLayout());
		JLabel vuoto = new JLabel("");
		vuoto.setHorizontalAlignment(2);
		vuoto.setForeground(java.awt.Color.decode("#ffffb3"));
		vuoto.setPreferredSize(new Dimension(57, 30));
		coordinateColonna.add(vuoto);
		for (int i = 0; i < 8; i++) {
			coordinate_col[i] = new JLabel("" + (char)(i + 65));
			coordinate_col[i].setHorizontalAlignment(JLabel.CENTER);
			coordinate_col[i].setHorizontalAlignment(2);
			coordinate_col[i].setPreferredSize(new Dimension(70, 30));
			coordinate_col[i].setForeground(java.awt.Color.decode("#ffffb3"));
			coordinateColonna.add(coordinate_col[i]);
			coordinateColonna.setBackground(java.awt.Color.decode("#762825"));
		}

		//coordinate riga

		coordinateRiga.setLayout(new GridLayout(8, 1));
		coordinateRiga.setPreferredSize(new Dimension(40, 70));
		for (int i = 0; i < 8; i++) {
			coordinate_rig[i] = new JLabel("" + (i + 1));
			coordinate_rig[i].setHorizontalAlignment(JLabel.CENTER);
			coordinate_rig[i].setForeground(java.awt.Color.decode("#ffffb3"));
			coordinateRiga.add(coordinate_rig[i]);
			coordinateRiga.setBackground(java.awt.Color.decode("#762825"));
		}

		// bordo a destra

		bordoDx.setLayout(new GridLayout(8, 1));
		bordoDx.setPreferredSize(new Dimension(40, 70));
		for (int i = 0; i < 8; i++) {
			spazio[i] = new JLabel(" ");
			spazio[i].setHorizontalAlignment(JLabel.CENTER);
			bordoDx.add(spazio[i]);
			bordoDx.setBackground(java.awt.Color.decode("#762825"));
		}

		// contatore mosse

		contatoreMosse.setLayout(new FlowLayout(FlowLayout.LEADING, 42, 0));
		mossa.setText("MOSSE PARTITA: " + cont_mosse);
		mossa.setPreferredSize(new Dimension(200, 45));
		mossa.setForeground(java.awt.Color.decode("#ffffb3"));
		contatoreMosse.add(mossa);
		contatoreMosse.setBackground(java.awt.Color.decode("#762825"));

		// aggiunta elementi a pannello

		add(coordinateColonna, BorderLayout.NORTH);
		add(coordinateRiga, BorderLayout.WEST);
		add(bordoDx, BorderLayout.EAST);
		add(contatoreMosse, BorderLayout.SOUTH);
	}
	/**
	 * questo metodo serve a settare la scacchiera a inizio partita
	 */
	private void setScacchiera() {
		tavolo.setLayout(new GridLayout(8, 8));
		Colore tmp_colore;
		int riga, colonna;
		for (riga = 0; riga < 8; riga++) {
			for (colonna = 0; colonna < 8; colonna++) {
				tmp_colore = (riga >= 6) ? Colore.BIANCO : Colore.NERO;
				if (riga == 0 || riga == 7) {
					if (colonna == 0 || colonna == 7) {
						(scacchiera[riga][colonna]) = new Torre(tmp_colore);
					} else if (colonna == 1 || colonna == 6) {
						(scacchiera[riga][colonna]) = new Cavallo(tmp_colore);
					} else if (colonna == 2 || colonna == 5) {
						(scacchiera[riga][colonna]) = new Alfiere(tmp_colore);
					} else if (colonna == 3) {
						(scacchiera[riga][colonna]) = new Regina(tmp_colore);
					} else if (colonna == 4) {
						(scacchiera[riga][colonna]) = new Re(tmp_colore);
					}
				} else if (riga == 1 || riga == 6) {
					(scacchiera[riga][colonna]) = new Pedone(tmp_colore);
				} else {
					scacchiera[riga][colonna] = new Vuoto(tmp_colore);
				}
				// INVERTITO COLONNA - RIGA
				scacchiera[riga][colonna].setLocation(colonna, riga);
				// MOVIMENTI
				scacchiera[riga][colonna].addActionListener(new MonitorAzioni(obj));

				tavolo.add(scacchiera[riga][colonna]);
				if (riga % 2 == 0) {
					if (colonna % 2 == 0) {
						scacchiera[riga][colonna].setBackground(Color.decode("#f6d5a5"));
					} else {
						scacchiera[riga][colonna].setBackground(Color.decode("#c46f38"));
					}
				} else {
					if (colonna % 2 != 0) {
						scacchiera[riga][colonna].setBackground(Color.decode("#f6d5a5"));
					} else {
						scacchiera[riga][colonna].setBackground(Color.decode("#c46f38"));
					}
				}
			}
		}
		add(tavolo);
	}
	/**
	 * questo metodo serve a resettare la scacchiera
	 */
	protected void resetScacchiera() {
		remove(tavolo);
		tavolo.removeAll();
		tavolo.updateUI();
		setScacchiera();
		revalidate();
		repaint();
		cont_mosse = 0;
		pezzo_attesa = null;
		stato = Info.TURNO_BIANCHI;
		mossa.setText("MOSSE PARTITA: " + cont_mosse);
	}
	/**
	 * questo metodo serve a invrementare il contatore mosse
	 */
	protected void incrementaMosse() {
		cont_mosse++;
		mossa.setText("MOSSE PARTITA: " + cont_mosse);
	}
	/**
	 * questo metodo ritorna il numero di mosse
	 * @return il numero di mosse effettuate fino a quel momento
	 */
	protected int getMosse() {
		return cont_mosse;
	}
	/**
	 * questo metodo ritorna la scacchiera
	 * @return la situazione della scacchiera in quel momento
	 */
	public Pezzo[][] getTavolo() {
		return scacchiera;
	}
	/**
	 * questo metodo mi ritorna lo stato del gioco, ovvero chi tocca a muovere
	 * @return di chi è il turno di muovere
	 */
	public Info getStato() {
		return stato;
	}
	/**
	 * questo metodo setta lo stato del gioco, ovvero chi tocca a muovere
	 * @param stato rappresenta chi tocca a muovere
	 */
	protected void setStato(Info stato) {
		this.stato = stato;
	}
	/**
	 * questo metodo ritorna il pezzo cliccato in attesa di venir mosso
	 * @return ilpezzo in attesa del movimento
	 */
	protected Pezzo getPzAttesa() {
		return pezzo_attesa;
	}
	/**
	 * questo metodo setta il pezzo in attesa di movimento
	 */
	protected void setPzAttesa(Pezzo pezzo_attesa) {
		this.pezzo_attesa = pezzo_attesa;
	}
	/**
	 * questo metodo serve per reimpostare il colore di sfondo delle caselle, il bordo dopo lo spostamento dei pezzi e ricaricare i vari pezzi 
	 */
	protected void aggiornaScacchiera() {
		tavolo.removeAll();
		tavolo.updateUI();
		int riga, colonna;
		for (riga = 0; riga < 8; riga++) {
			for (colonna = 0; colonna < 8; colonna++) {
				// MOVIMENTI
				if (scacchiera[riga][colonna].getActionListeners().length == 0) scacchiera[riga][colonna].addActionListener(new MonitorAzioni(obj));
				tavolo.add(scacchiera[riga][colonna]);
				if (riga % 2 == 0) {
					if (colonna % 2 == 0) {
						scacchiera[riga][colonna].setBackground(Color.decode("#f6d5a5"));
					} else {
						scacchiera[riga][colonna].setBackground(Color.decode("#c46f38"));
					}
				} else {
					if (colonna % 2 != 0) {
						scacchiera[riga][colonna].setBackground(Color.decode("#f6d5a5"));
					} else {
						scacchiera[riga][colonna].setBackground(Color.decode("#c46f38"));
					}
				}
				//RESET BORDO
				scacchiera[riga][colonna].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
			}
		}
		tavolo.updateUI();
		tavolo.revalidate();
		revalidate();
		repaint();
	}
	/**
	 * questo metodo controlla de è avvenuto uno scacco matto
	 * @return il pezzo che ha causato lo scacco matto
	 */
	protected Pezzi isScaccoMatto() {
		// false = RE SALVO
		// true  = SCACCO MATTO!
		Colore giocatore = ((stato.equals(Info.TURNO_BIANCHI)) ? Colore.BIANCO : Colore.NERO);
		Colore avversario = ((stato.equals(Info.TURNO_BIANCHI)) ? Colore.NERO : Colore.BIANCO);
		boolean matto = false;
		Pezzi chiMangia = Pezzi.VUOTO;

		for (int riga = 0; riga < 8 && !matto; riga++) {
			for (int colonna = 0; colonna < 8 && !matto; colonna++) {
				// CONTROLLO SOLO I PEZZI DEL GIOCATORE ATTUALE SE MANGIANO RE AVVERSARIO
				if ((scacchiera[riga][colonna].getColore()).equals(avversario)) {
					ArrayList < Point > listaMovimenti = scacchiera[riga][colonna].getMovimento(scacchiera);
					// CONTROLLO PER OGNI PUNTO IN CUI SI SPOSTA SE E' PRESENTE IL RE AVVERSARIO
					for (Point p: listaMovimenti) {
						if ((scacchiera[p.x][p.y].getPezzo()).equals(Pezzi.RE) && (scacchiera[p.x][p.y].getColore()).equals(giocatore)) {
							// CONTROLLO AGGIUNTIVO PEDONE CHE MANGI SOLO IN DIAGONALE
							if ((scacchiera[riga][colonna].getPezzo()).equals(Pezzi.PEDONE)) {
								if (p.y != colonna) {
									matto = true;
									chiMangia = scacchiera[riga][colonna].getPezzo();
								}
							} else {
								matto = true;
								chiMangia = scacchiera[riga][colonna].getPezzo();
							}
						}
					}
				}
			}
		}
		return chiMangia;
	}
}