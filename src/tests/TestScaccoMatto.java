package tests;
import org.junit.*;

import java.awt.Point;

import scacchiera.*;
import struttura.*;

/**
 * <p>Title: TestScaccoMatto</p>
 * <p>Description: Classe Test che effettua una simulazione di una partita vera e propria con scacco matto</p>
 * @author Dalla Valle Manuel, Leone Davide, Benedetti Gianmarco
 * @version 1.0
 */

public class TestScaccoMatto {
	
	StrutturaScacchiera scacchiera = new StrutturaScacchiera();
	MonitorAzioni gestoreMovimenti = new MonitorAzioni(scacchiera);
	Pezzo[][] tavolo = scacchiera.getTavolo();
	/**
	 * metodo che simula una breve partita che termina con uno scacco matto
	 */
	@Test
	public void testSottoScacco() {
		Assert.assertEquals(scacchiera.isScaccoMatto(), Pezzi.VUOTO);
		
		// SPOSTO PEDONE BIANCO
		gestoreMovimenti.spostaPedina(new Point(6, 6), new Point(6, 5));
		Assert.assertEquals(Pezzi.PEDONE, tavolo[5][6].getPezzo());
		
		// SPOSTO PEDONE NERO
		Assert.assertEquals(Pezzi.PEDONE, tavolo[1][4].getPezzo());
		Assert.assertEquals(Colore.NERO, tavolo[1][4].getColore());
		gestoreMovimenti.spostaPedina(new Point(4, 1), new Point(4, 2));
		
		// SPOSTO PEDONE BIANCO
		Assert.assertEquals(Pezzi.PEDONE, tavolo[5][6].getPezzo());
		gestoreMovimenti.spostaPedina(new Point(6, 5), new Point(6, 4));
		
		// SPOSTO PEDONE NERO
		gestoreMovimenti.spostaPedina(new Point(4, 2), new Point(4, 3));
		Assert.assertEquals(Pezzi.PEDONE, tavolo[3][4].getPezzo());
		
		// SPOSTO PEDONE BIANCO
		Assert.assertEquals(Pezzi.PEDONE, tavolo[6][5].getPezzo());
		Assert.assertEquals(Colore.BIANCO, tavolo[6][5].getColore());
		gestoreMovimenti.spostaPedina(new Point(5, 6), new Point(5, 5));
		
		// SPOSTO REGINA
		Assert.assertEquals(Pezzi.REGINA, tavolo[0][3].getPezzo());
		Assert.assertEquals(Colore.NERO, tavolo[0][3].getColore());
		gestoreMovimenti.spostaPedina(new Point(3, 0), new Point(7, 4));
			
		// SCACCO MATTO CON REGINA
		Assert.assertEquals(scacchiera.isScaccoMatto(), Pezzi.REGINA);
	}	
}