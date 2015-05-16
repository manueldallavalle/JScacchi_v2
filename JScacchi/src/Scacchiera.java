import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Scacchiera extends JFrame{
	private static final long serialVersionUID=1L;
	private StrutturaScacchiera scacchiera;
	private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem nuovaPartita;
    private JMenuItem esciPartita;
	
	public Scacchiera(){
		menuBar=new JMenuBar();
        menu=new JMenu("Menu");
        menu.setMnemonic(KeyEvent.VK_M); // HOTKEY M
        menuBar.add(menu);
        nuovaPartita=new JMenuItem("Nuova Partita", KeyEvent.VK_N);  // HOTKEY N
        esciPartita=new JMenuItem("Esci", KeyEvent.VK_E);  // HOTKEY E
        menu.add(nuovaPartita);
        menu.add(esciPartita);
        this.setJMenuBar(menuBar);
		scacchiera=new StrutturaScacchiera();
		add(scacchiera);
		pack();
	}
	
	protected void resetScacchiera(){
		scacchiera.removeAll();
	}
}
