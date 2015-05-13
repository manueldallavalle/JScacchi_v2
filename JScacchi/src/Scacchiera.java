import javax.swing.JFrame;

public class Scacchiera extends JFrame{
	private static final long serialVersionUID = 1L;
	private StrutturaScacchiera scacchiera;
	
	public Scacchiera(){
		scacchiera=new StrutturaScacchiera();
		add(scacchiera);
		pack();
	}
}
