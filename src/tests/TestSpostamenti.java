package tests;
import org.junit.*;
import java.awt.Point;
import scacchiera.*;
import struttura.*;

/**
 * <p>Title: TestSpostamenti</p>
 * <p>Description: Classe Test che effettua una simulazione di una partita e verifica il corretto spostamento</p>
 * @author Dalla Valle Manuel, Leone Davide, Benedetti Gianmarco
 * @version 1.0
 */

public class TestSpostamenti {
	
	StrutturaScacchiera scacchiera = new StrutturaScacchiera();
	MonitorAzioni gestoreMovimenti = new MonitorAzioni(scacchiera);
	Pezzo[][] tavolo = scacchiera.getTavolo();
	/**
	 * metodo che simula dei movimenti delle pedine
	 */
	@Test
	public void testMatch() {
		gestoreMovimenti.spostaPedina(new Point(7, 6), new Point(7, 4));
		Assert.assertEquals(Pezzi.PEDONE, (tavolo[4][7].getPezzo()));
		Assert.assertEquals(Colore.BIANCO, (tavolo[4][7].getColore()));

		gestoreMovimenti.spostaPedina(new Point(1, 1), new Point(1, 3));
		Assert.assertEquals(Pezzi.PEDONE, (tavolo[3][1].getPezzo()));
		Assert.assertEquals(Colore.NERO, (tavolo[3][1].getColore()));

		gestoreMovimenti.spostaPedina(new Point(1, 7), new Point(2, 5));
		Assert.assertEquals(Pezzi.CAVALLO, (tavolo[5][2].getPezzo()));
		Assert.assertEquals(Colore.BIANCO, (tavolo[5][2].getColore()));

		gestoreMovimenti.spostaPedina(new Point(6,1), new Point(6, 2));
		Assert.assertEquals(Pezzi.PEDONE, (tavolo[2][6].getPezzo()));
		Assert.assertEquals(Colore.NERO, (tavolo[2][6].getColore()));

		gestoreMovimenti.spostaPedina(new Point(7, 7), new Point(7, 5));
		Assert.assertEquals(Pezzi.TORRE, (tavolo[5][7].getPezzo()));
		Assert.assertEquals(Colore.BIANCO, (tavolo[5][7].getColore()));

		gestoreMovimenti.spostaPedina(new Point(5, 0), new Point(7, 2));
		Assert.assertEquals(Pezzi.ALFIERE, (tavolo[2][7].getPezzo()));
		Assert.assertEquals(Colore.NERO, (tavolo[2][7].getColore()));

		gestoreMovimenti.spostaPedina(new Point(4, 7), new Point(5, 6));
		Assert.assertEquals(Pezzi.RE, (tavolo[6][5].getPezzo()));
		Assert.assertEquals(Colore.BIANCO, (tavolo[6][5].getColore()));
		
		gestoreMovimenti.spostaPedina(new Point(0, 0), new Point(3, 3));
		Assert.assertEquals(Pezzi.TORRE, (tavolo[3][3].getPezzo()));
		Assert.assertEquals(Colore.NERO, (tavolo[3][3].getColore()));
	}
}