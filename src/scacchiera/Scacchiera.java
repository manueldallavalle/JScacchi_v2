package scacchiera;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * <p>Title: Scacchiera</p>
 * <p>Description: classe che serve per l'assemblaggio delle varie parti dell'interfaccia della scacchiera</p>
 * @author Dalla Valle Manuel, Leone Davide, Benedetti Gianmarco
 * @version 1.0
 */

public class Scacchiera extends JFrame {
	private static final long serialVersionUID = 1L;
	private StrutturaScacchiera scacchiera;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem nuovaPartita;
	private JMenuItem esciPartita;
	/**
	 * questo metodo è il costruttore della classe Scacchiera
	 */
	public Scacchiera() {
		scacchiera = new StrutturaScacchiera();

		menuBar = new JMenuBar();
		menu = new JMenu("Menu");
		menu.setMnemonic(KeyEvent.VK_M); // HOTKEY M
		menuBar.add(menu);
		nuovaPartita = new JMenuItem("Nuova Partita", KeyEvent.VK_N); // HOTKEY N
		esciPartita = new JMenuItem("Esci", KeyEvent.VK_E); // HOTKEY E
		menu.add(nuovaPartita);
		menu.add(esciPartita);

		MonitorAzioni monitor_menu = new MonitorAzioni(scacchiera);
		nuovaPartita.addActionListener(monitor_menu);
		nuovaPartita.setActionCommand("nuovaPartita");
		esciPartita.addActionListener(monitor_menu);
		esciPartita.setActionCommand("esciPartita");

		this.setJMenuBar(menuBar);
		add(scacchiera);
		pack();
	}
}