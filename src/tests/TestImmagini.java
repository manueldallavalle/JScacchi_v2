package tests;
import scacchiera.*;
import org.junit.*;

/**
 * <p>Title: TestImmagini</p>
 * <p>Description: Classe Test che verifica le corrette immagini dei pezzi posizionati</p>
 * @author Dalla Valle Manuel, Leone Davide, Benedetti Gianmarco
 * @version 1.0
 */

public class TestImmagini {
	
	StrutturaScacchiera scacchiera = new StrutturaScacchiera();
	Pezzo[][] tavolo = scacchiera.getTavolo();
	/**
	 * metodo che controlla che le varie icone corrispondano alle pedine
	 */
	@Test
	public void testIcone() {
		Assert.assertEquals(Torre.class.getResource("/torre_nera.gif").toString(), (tavolo[0][0].getIcon()).toString());
		Assert.assertEquals(Cavallo.class.getResource("/cavallo_nera.gif").toString(), (tavolo[0][1].getIcon()).toString());
		Assert.assertEquals(Alfiere.class.getResource("/alfiere_nera.gif").toString(), (tavolo[0][2].getIcon()).toString());
		Assert.assertEquals(Regina.class.getResource("/regina_nera.gif").toString(), (tavolo[0][3].getIcon()).toString());
		Assert.assertEquals(Re.class.getResource("/re_nera.gif").toString(), (tavolo[0][4].getIcon()).toString());
		Assert.assertEquals(Alfiere.class.getResource("/alfiere_nera.gif").toString(), (tavolo[0][5].getIcon()).toString());
		Assert.assertEquals(Cavallo.class.getResource("/cavallo_nera.gif").toString(), (tavolo[0][6].getIcon()).toString());
		Assert.assertEquals(Torre.class.getResource("/torre_nera.gif").toString(), (tavolo[0][0].getIcon()).toString());
		Assert.assertEquals(Pedone.class.getResource("/pedone_nera.gif").toString(), (tavolo[1][0].getIcon()).toString());
		Assert.assertEquals(Pedone.class.getResource("/pedone_nera.gif").toString(), (tavolo[1][1].getIcon()).toString());
		Assert.assertEquals(Pedone.class.getResource("/pedone_nera.gif").toString(), (tavolo[1][2].getIcon()).toString());
		Assert.assertEquals(Pedone.class.getResource("/pedone_nera.gif").toString(), (tavolo[1][3].getIcon()).toString());
		Assert.assertEquals(Pedone.class.getResource("/pedone_nera.gif").toString(), (tavolo[1][4].getIcon()).toString());
		Assert.assertEquals(Pedone.class.getResource("/pedone_nera.gif").toString(), (tavolo[1][5].getIcon()).toString());
		Assert.assertEquals(Pedone.class.getResource("/pedone_nera.gif").toString(), (tavolo[1][6].getIcon()).toString());
		Assert.assertEquals(Pedone.class.getResource("/pedone_nera.gif").toString(), (tavolo[1][7].getIcon()).toString());

		Assert.assertEquals(Torre.class.getResource("/torre_bianca.gif").toString(), (tavolo[7][0].getIcon()).toString());
		Assert.assertEquals(Cavallo.class.getResource("/cavallo_bianca.gif").toString(), (tavolo[7][1].getIcon()).toString());
		Assert.assertEquals(Alfiere.class.getResource("/alfiere_bianca.gif").toString(), (tavolo[7][2].getIcon()).toString());
		Assert.assertEquals(Regina.class.getResource("/regina_bianca.gif").toString(), (tavolo[7][3].getIcon()).toString());
		Assert.assertEquals(Re.class.getResource("/re_bianca.gif").toString(), (tavolo[7][4].getIcon()).toString());
		Assert.assertEquals(Alfiere.class.getResource("/alfiere_bianca.gif").toString(), (tavolo[7][5].getIcon()).toString());
		Assert.assertEquals(Cavallo.class.getResource("/cavallo_bianca.gif").toString(), (tavolo[7][6].getIcon()).toString());
		Assert.assertEquals(Torre.class.getResource("/torre_bianca.gif").toString(), (tavolo[7][7].getIcon()).toString());
		Assert.assertEquals(Pedone.class.getResource("/pedone_bianca.gif").toString(), (tavolo[6][0].getIcon()).toString());
		Assert.assertEquals(Pedone.class.getResource("/pedone_bianca.gif").toString(), (tavolo[6][1].getIcon()).toString());
		Assert.assertEquals(Pedone.class.getResource("/pedone_bianca.gif").toString(), (tavolo[6][2].getIcon()).toString());
		Assert.assertEquals(Pedone.class.getResource("/pedone_bianca.gif").toString(), (tavolo[6][3].getIcon()).toString());
		Assert.assertEquals(Pedone.class.getResource("/pedone_bianca.gif").toString(), (tavolo[6][4].getIcon()).toString());
		Assert.assertEquals(Pedone.class.getResource("/pedone_bianca.gif").toString(), (tavolo[6][5].getIcon()).toString());
		Assert.assertEquals(Pedone.class.getResource("/pedone_bianca.gif").toString(), (tavolo[6][6].getIcon()).toString());
		Assert.assertEquals(Pedone.class.getResource("/pedone_bianca.gif").toString(), (tavolo[6][7].getIcon()).toString());
	}
}